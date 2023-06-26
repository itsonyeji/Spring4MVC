package ityeji.hello.spring4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

//    사용자가 "/"이렇게 쓰면 얘가 호출돼서 실행
//    http://localhose:8080/
    @RequestMapping("/")
    public String index(){
        return "index";
    }

}
