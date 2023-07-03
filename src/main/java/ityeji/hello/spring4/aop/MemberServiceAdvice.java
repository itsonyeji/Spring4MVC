package ityeji.hello.spring4.aop;

import ityeji.hello.spring4.controller.BoardController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Aspect
@Component
public class MemberServiceAdvice {
    private Logger logger= LogManager.getLogger(MemberServiceAdvice.class);

    @Around("execution(* ityeji.hello.spring4.controller.MemberController.myinfo(..))") //advice(pointcut 적용 위치) 매개변수는 생략
    public Object myinfoAOPPrecess(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("myinfoAOPPrecess 호출!");
        HttpSession sess=null;
        // join point에서 넘겨준 매개변수에서 원하는 객체 추출
        for(Object o : pjp.getArgs()){
            if(o instanceof HttpSession)
                sess=(HttpSession) o;
        }
        // 포인트컷 대상 메서드 실행
        if (sess.getAttribute("member")==null)
            return "redirect:/member/login";
        Object obj = pjp.proceed();     // 나머지 코드 실행해라(MemberController myinfo에 주석처리한 부분 이후)
        return obj;
    }//정해진 형식대로 쓰면 됨


}
