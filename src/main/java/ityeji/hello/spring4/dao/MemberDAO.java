package ityeji.hello.spring4.dao;

import ityeji.hello.spring4.model.Member;

public interface MemberDAO {
    int insertMember(Member m);
    Member loginMember(Member m);
    Member selectOneMember(String userid);


}
