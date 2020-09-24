**[회원 관리 예제 - 웹 MVC 개발]**

회원 웹 기능 - 홈 화면 추가

회원 웹 기능 - 등록

회원 웹 기능 - 조회

회원 웹 기능 - 홈 화면

**#회원 웹 기능 -홈화면 추가**



**홈 컨트롤러 추가**

package hello.hellospring.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class HomeController {

  @GetMapping("/")
  
  public String home() {
  
    return "home";
    
  }
  
}




**회원 관리용 홈**

<!DOCTYPE HTML>

<html xmlns:th="http://www.thymeleaf.org">
  
  
<body>
  <div class="container"><div>
    
    <h1>Hello Spring</h1>
    <p>회원 기능</p>
    <p>
    <a href="/members/new">회원 가입</a>
    <a href="/members">회원 목록</a>
    </p>
    </div>
    </div> <!-- /container -->
    </body>
    </html>



**#회원 웹 기능-등록**


**회원 등록 폼 컨트롤러**

@Controller

public class MemberController {

  private final MemberService memberService;
  
  @Autowired
  
  public MemberController(MemberService memberService) {
  
    this.memberService = memberService;
    
    }

  @GetMapping(value = "/members/new")

  public String createForm() {

    return "members/createMemberForm";

   }

}


**회원등록 폼 HTML**

경로: resources/templates/members/createMemberForm

<!DOCTYPE HTML>


<html xmlns:th="http://www.thymeleaf.org">
<body>
<div class="container">
<form action="/members/new" method="post">
<div class="form-group">
<label for="name">이름</label>
<input type="text" id="name" name="name" placeholder="이름을 입력하세
요">
</div>
<button type="submit">등록</button>
</form>
</div> <!-- /container -->
</body>
</html>

























*출처: 인프런 스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술
