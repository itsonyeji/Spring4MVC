/*join*/
let joinbtn=document.querySelector("#joinbtn");
// 한페이지에 두개 같이 쓰면 하나는 못찾아서 null이 들어가서 오류남.
// try-catch를 쓰거나 optional chaining을 적용
joinbtn?.addEventListener('click', ()=>{
    // 삼항연산자처럼 앞에 값이 참이면 뒤를 실행.null일떈 실행 안한다
    let frm=document.forms.joinfrm;
    if(frm.userid.value=== '')  alert('아이디를 직성하세요.');
    else if(frm.passwd.value === '') alert('비밀번호를 작성하세요.');
    else if(frm.repwd.value != frm.passwd.value) alert('비밀번호 확인을 작성하세요.');
    else if(frm.name.value === '') alert('이름을 작성하세요.');
    else if(frm.email.value === '') alert('이메일을 작성하세요.');
    else{
        frm.method='post';
        frm.action='/member/join';
        frm.submit();
    }
});
let loginbtn=document.querySelector("#loginbtn");
loginbtn?.addEventListener('click', ()=>{
    let frm=document.forms.loginfrm;
    if(frm.userid.value === '') alert('아이디를 입력하세요.');
    else if(frm.passwd.value === '') alert('비밀번호를 입력하세요.');
    else{
        frm.method='post';
        frm.action='/member/login'
        frm.submit();
    }
});

/*login*/