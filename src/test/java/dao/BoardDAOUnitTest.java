package dao;

import ityeji.hello.spring4.dao.BoardDAO;
import ityeji.hello.spring4.dao.MemberDAO;
import ityeji.hello.spring4.model.Board;
import ityeji.hello.spring4.model.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

//자동으로 불러오기
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/servlet-context.xml","classpath:spring/root-context.xml"})
@WebAppConfiguration
public class BoardDAOUnitTest {
    //테스트할 대상 객체를 주입받음
    @Autowired
    BoardDAO bdao;

    @Test
    public void selectBoard() throws Exception{
        int cpage=3;
        int snum = (cpage-1) * 15;
        List<Board> results = bdao.selectBoard(snum);    //start num
        assertEquals(results.size(), 15);
        System.out.println(results);
    }
    @Test
    public void selectOneBoard() throws Exception{
        String bno = "450";
        Board result = bdao.selectOneBoard(bno);    //start num
        assertNotNull(result);
        System.out.println(result);
    }
}
