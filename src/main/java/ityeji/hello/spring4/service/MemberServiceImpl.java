package ityeji.hello.spring4.service;

import ityeji.hello.spring4.dao.MemberDAO;
import ityeji.hello.spring4.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//spring container가 이 객체를 관리하고 주입을 해줌
//msrv=MemberServiceImpl
@Service("msrv")
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberDAO mdao;
    @Override
    public boolean saveMember(Member m) {
        boolean isSaved=false;
        //기본값을 false로 주고 시작하면 코드를 줄여쓸수있다.
        if (mdao.insertMember(m)>0) isSaved=true;

        return isSaved;
    }

    @Override
    public boolean loginMember(Member m) {
        boolean isLogin=false;

        if(mdao.loginMember(m) != null) isLogin=true;
        return isLogin;
    }
}
