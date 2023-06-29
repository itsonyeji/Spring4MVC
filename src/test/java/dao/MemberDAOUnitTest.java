package dao;

import ityeji.hello.spring4.dao.MemberDAO;
import ityeji.hello.spring4.model.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

//자동으로 불러오기
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/servlet-context.xml","classpath:spring/root-context.xml"})
@WebAppConfiguration
public class MemberDAOUnitTest {
    //테스트할 대상 객체를 주입받음
    @Autowired MemberDAO mdao;

    @Test
    @Transactional  // 실행 후 rollback이 되므로 여러번 같은 것으로 실행할 수 있다.  //데이터 입력 후 자동삭제
    public void insertMember() throws Exception{
        //웹브라우저를 띄워 값을 넣어서 테스트 하는 것이 아닌 직접 넣어서 테스트를 하여 훨씬 빠르고 편리
        Member m=new Member(null, "abc123a","987xyz","abc123","abc123@987xyz.co.kr",null);
        /* assertEquals(테스트메서드, 검증값) */
        assertEquals(mdao.insertMember(m),1);
        //실행 결과가 1이 넘어오는지 체크
    }
    @Test
    public void loginMember() throws Exception{
        //웹브라우저를 띄워 값을 넣어서 테스트 하는 것이 아닌 직접 넣어서 테스트를 하여 훨씬 빠르고 편리
        Member m=new Member();
        m.setUserid("abc123");
        m.setPasswd("987xyz");

        //sout은 확인하기 편하게 쓴거고 실제 검사는 밑에걸로 한다.
        //System.out.println(mdao.loginMember(m));
        assertNotNull(mdao.loginMember(m)); //null이 아닌지 묻는거
    }
    @Test
    public void selectOneMember() throws Exception{
        //웹브라우저를 띄워 값을 넣어서 테스트 하는 것이 아닌 직접 넣어서 테스트를 하여 훨씬 빠르고 편리
        String userid="abc123";

        //sout은 확인하기 편하게 쓴거고 실제 검사는 밑에걸로 한다.
        System.out.println(mdao.selectOneMember(userid));
        assertNotNull(mdao.selectOneMember(userid)); //null이 아닌지 묻는거
    }
}
