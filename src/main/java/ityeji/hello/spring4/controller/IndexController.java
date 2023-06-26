package ityeji.hello.spring4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

//    사용자가 "/"이렇게 쓰면 얘가 호출돼서 실행
//    http://localhose:8080/
    @RequestMapping("/")
    public String index(Model m){

        //m.addAttribute(변수명, 대상객체)
        //view를 호출하면 jsp에서 ${변수명}호출. 저장된 객체 출력
        m.addAttribute("sayHello", "Hello World! from Controller");
        return "index";
    }

}
