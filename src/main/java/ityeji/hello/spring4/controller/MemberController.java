package ityeji.hello.spring4.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MemberController {

    private Logger logger= LogManager.getLogger(MemberController.class);

    @RequestMapping(value = "/member/join", method = RequestMethod.GET)
    public String join(Model m){

        logger.info("member/join 호출!");

        return "member/join.tiles";         //tiles
    }
    @RequestMapping(value = "/member/join", method = RequestMethod.POST)
    public String joinok(Model m){

        logger.info("member/joinok 호출!");

        return "redirect:/member/login";         //member/login 호출
    }

    @RequestMapping(value = "/member/login", method=RequestMethod.GET)
    public String login(Model m){

        logger.info("member/login 호출!");

        return "member/login.tiles";         //tiles
    }
    @RequestMapping(value = "/member/login", method=RequestMethod.POST)
    public String loginok(Model m){

        logger.info("member/loginok 호출!");

        return "redirect:/member/myinfo";         //tiles
    }
    @RequestMapping("/member/myinfo")
    public String myinfo(Model m){

        logger.info("member/myinfo 호출!");

        return "member/myinfo.tiles";         //tiles
    }

}
