package service;

import ityeji.hello.spring4.dao.MemberDAO;
import ityeji.hello.spring4.model.Member;
import ityeji.hello.spring4.service.MemberService;
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
public class MemberServiceUnitTest {
    //테스트할 대상 객체를 주입받음
    @Autowired MemberService msrv;

    @Test
    @Transactional
    public void saveMember() throws Exception{
        Member m=new Member(null, "abc123a","987xyz","abc123","abc123@987xyz.co.kr",null);
        /* assertEquals(테스트메서드, 검증값) */
        assertEquals(msrv.saveMember(m),true);
    }

    @Test
    public void loginMember() throws Exception{
        Member m=new Member();
        m.setUserid("abc123");
        m.setPasswd("987xyz");
        /* assertEquals(테스트메서드, 검증값) */
        assertEquals(msrv.loginMember(m),true);
    }

    @Test
    public void readOneMember() throws Exception{
        String userid="abc123";
        /* assertEquals(테스트메서드, 검증값) */
        assertNotNull(msrv.readOneMember(userid));
    }
}
