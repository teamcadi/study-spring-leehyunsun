//멤버 컨트롤러가 멤버 서비스를 통해서 회원가입, 데이터를 조회.
// ->컨트롤러가 멤버서비스를 의존하는 의존관계에 있다고 함

package cadispring.exercisespring1.controller;

import cadispring.exercisespring1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    //Contoller가 spring 창에 뜰때 스프링 컨테이너가 생김.
    //control enotation이 있으면 MemberController 객체를 생성-> 스프링에 넣어둠-> 스프링이 관리

    //멤버 서비스 가져다 쓰기
    //private final MemberService memberService = new MemberService();-> 여러번 쓰거나 다른 변수가 쓸 수도 있는 문제 발생

    private final MemberService memberService;
    //memberService를 spring container에 넣어두고 한번만 가져다 쓰기
    //->생성자로 연결
    @Autowired //연결시켜주는 것. 스프링에서 관리하는 멤버 서비스를 가져다 스프링에 넣어줌
    //생성자 호출
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
