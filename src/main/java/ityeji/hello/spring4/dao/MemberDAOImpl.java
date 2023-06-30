package ityeji.hello.spring4.dao;

import ityeji.hello.spring4.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.TestExecutionListeners;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("mdao")
public class MemberDAOImpl implements MemberDAO{
    //sql.properties에 작성한 sql 불러오기
    //value의 값을 변수에 집어넣는다
    @Value("#{sql['insertMember']}") private String insertSQL;
    @Value("#{sql['loginMember']}") private String loginSQL;
    @Value("#{sql['selectOneMember']}") private String selectOneSQL;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int insertMember(Member m) {
        //매개변수 정의
        Object[] params=new Object[] {
                m.getUserid(), m.getPasswd(), m.getName(), m.getEmail()
                //sql문의 ?에 하나씩 순서대로 들어감
        };

        //쿼리 실행 : update(sql문, 매개변수)
        return jdbcTemplate.update(insertSQL, params);
    }
    public Member loginMember(Member m) {
        //매개변수 정의
        Object[] params=new Object[] {
                m.getUserid(), m.getPasswd()
        };
        // 로그인 매퍼 선언 - 콜백 함수
        //spring이 mapper를 호출. 우리가 아니라
        RowMapper<Member> mapper=new LoginMapper();

        //쿼리 실행 : queryForObject(sql문, 매개변수, 매퍼) - 단일값 반환(결과가 하나)
        //단, 결과가 없거나 둘 이상인 경우 예외 발생! - 다루기 번거로움
        // => JDK8 기능 중 Optional을 활용하거나
        // => query(sql문, 매개변수, 매퍼) - 리스트 기반 다중값 반환 (select 문에서 많이 쓰임)
        //m=jdbcTemplate.queryForObject(loginSQL, params, mapper);
        List<Member> results=jdbcTemplate.query(loginSQL, params, mapper);
        m=results.isEmpty() ? null : results.get(0);        // 첫번째 거 대입
        return m;
        //하나를 고치면 다른 곳에서도 이것저것 고쳐야하니까 어떤게 효율적인지 잘 생각해서 해야함
    }

    private class LoginMapper implements RowMapper<Member> {
        @Override
        public Member mapRow(ResultSet rs, int num) throws SQLException {
            Member m = new Member();
            m.setUserid(rs.getString(1));
            m.setName(rs.getString(2));
            return m;
            //알바 지원하고 계속 전화해서 됐냐고 묻는게 아니라 되면 연락오는거
            //계란 삶을때 계속 보고있는게 아니라 타이머 맞춰두고 시간 되면 알려주는거.
            //콜하면 백하는거
            //함수에서 확인하는게 아니라 좀 더 높은 곳에서 관제하는거
        }
    }

    public Member selectOneMember(String userid) {
        Object[] params=new Object[] {userid};

        RowMapper<Member> mapper=new MemberMapper();

        return jdbcTemplate.queryForObject(selectOneSQL, params, mapper);

    }

    private class MemberMapper implements RowMapper<Member> {
        @Override
        public Member mapRow(ResultSet rs, int num) throws SQLException {
            Member m = new Member(
                    rs.getString(1), rs.getString(2), null,
                    rs.getString(4), rs.getString(5), rs.getString(6)
            );
            return m;
        }
    }
}
