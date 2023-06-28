package ityeji.hello.spring4.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

    //로거 설정 : getLogger(로깅할 클래스명)
    //로깅: 코드작동확인 메세지 출력
    //로그는 5가지. 원하는 것만 출력할수도, 원할때만 킬수도 있다.
    private Logger logger= LogManager.getLogger(IndexController.class);

//    사용자가 "/"이렇게 쓰면 얘가 호출돼서 실행
//    http://localhose:8080/
    @RequestMapping("/")
    public String index(Model m){

        //m.addAttribute(변수명, 대상객체)
        //view를 호출하면 jsp에서 ${변수명}호출. 저장된 객체 출력
        m.addAttribute("sayHello", "Hello World! from Controller");

        //로거 출력. info는 일상적인 것만 출력
        logger.info("Hello, World! from Logger!");

        //return "index";       //jsp view resolver
        return "index.tiles";         //tiles
    }

}
