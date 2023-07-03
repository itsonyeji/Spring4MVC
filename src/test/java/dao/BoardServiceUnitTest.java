package dao;

import ityeji.hello.spring4.dao.BoardDAO;
import ityeji.hello.spring4.model.Board;
import ityeji.hello.spring4.service.BoardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

//자동으로 불러오기
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/servlet-context.xml","classpath:spring/root-context.xml"})
@WebAppConfiguration
public class BoardServiceUnitTest {
    //테스트할 대상 객체를 주입받음
    @Autowired BoardService bsrv;

    @Test
    public void readBoard() throws Exception{
        int cpage=10;
        List<Board> results = bsrv.readBoard(cpage);    //start num
        assertEquals(results.size(), 15);
        System.out.println(results);
    }
    @Test
    public void readOneBoard() throws Exception{
        String bno="450";
        Board result = bsrv.readOneBoard(bno);    //start num
        assertNotNull(result);
        System.out.println(result);
    }
}
