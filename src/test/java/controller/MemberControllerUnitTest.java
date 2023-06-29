package controller;

import ityeji.hello.spring4.controller.IndexController;
import ityeji.hello.spring4.controller.MemberController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/servlet-context.xml","classpath:spring/root-context.xml"})
@WebAppConfiguration
public class MemberControllerUnitTest {
    //여기 있는 실행 버튼을 누르면 포함하고 있는 하위 2개의 메서드가 실행된다
    @Autowired WebApplicationContext wctx;
  private MockMvc mockMvc;

    @Before
    public void setUp(){
        this.mockMvc= MockMvcBuilders.webAppContextSetup(this.wctx).build();
        //indexcontroller와 다르게 여러개가 같이 연결되어있기 때문에 standaloneSetup이 아니라
        // webAppContextSetup로 써야함
    }

    @Test
    public void joinTest() throws Exception {
        //get으로 불러옴
        mockMvc.perform(get("/member/join"))
                .andExpect(status().isOk())
                .andExpect(view().name("member/join.tiles"));
    }
    @Test
    @Transactional
    public void joinokTest() throws Exception {
        //post 방법으로 불러옴
        //param을 통해 실제 적을 값을 넣어준다.
        mockMvc.perform(post("/member/join")
                        .param("userid", "abc123a")
                        .param("passwd", "987xyz")
                        .param("name", "abc123a")
                        .param("email", "abc123a@987xzy.co.kr"))
                .andExpect(redirectedUrl("/member/login"));
        //MemberController를 보면 joinok는 return="redirect:/member/login"값이다.
    }
}
