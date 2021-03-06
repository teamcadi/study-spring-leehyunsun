# [회원 관리 예제 - 웹 MVC 개발]

+ 회원 웹 기능 - 홈 화면 추가

+ 회원 웹 기능 - 등록

+ 회원 웹 기능 - 조회

+ 회원 웹 기능 - 홈 화면

## 회원 웹 기능 -홈화면 추가


### 홈 컨트롤러 추가
```
package hello.hellospring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

  @GetMapping("/")  
  public String home() {  
    return "home";   
  }  //GET 방식. Get 일때 이 코드가 호출
};
```



### 회원 관리용 홈

-resources/templates/home.html
```
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
```
-index.html 파일이 있지만, 웹브라우저에서 요청이 오면 스프링 컨테이너 먼저 뒤지므로, home.html 먼저 실행됨

## 회원 웹 기능-등록


### 회원 등록 폼 컨트롤러

경로: main/java/cadispring/exercisespring1/controller/MemberController
```
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
   } //이 부분 추가
}
```

### 회원등록 폼 HTML

경로: resources/templates/members/createMemberForm
```
<!DOCTYPE HTML>

<html xmlns:th="http://www.thymeleaf.org">
  <body>
    <div class="container">
      <form action="/members/new" method="post">
        <div class="form-group">
          <label for="name">이름</label>
          <input type="text" id="name" name="name" placeholder="이름을 입력하세요">
        </div>
        <button type="submit">등록</button>
      </form>
    </div> <!-- /container -->
  </body>
</html>
```

### 웹 등록 화면에서 데이터를 전달 받을 폼 객체

main/java/cadispring/exercisespring1/controller/MemberForm

```
package hello.hellospring.controller;

public class MemberForm {
  private String name;

  public String getName() {
    return name;
    }
    
  public void setName(String name) {
    this.name = name;
   }
}
```

### 회원 컨트롤러에서 회원을 실제 등록하는 기능

경로: main/java/cadispring/exercisespring1/controller/MemberController

```
@PostMapping(value = "/members/new") //post mapping 해야함
public String create(MemberForm form) {
  Member member = new Member();
  member.setName(form.getName());
  memberService.join(member);
  return "redirect:/"; //끝나면 홈화면으로 보냄
} //POST 방식. POST 일때 이 코드가 호출
//이 코드 추가
```


## 회원 웹 기능 조회


### 회원 컨트롤러에서 조회 기능

경로: main/java/cadispring/exercisespring1/controller/MemberController

```
@GetMapping(value = "/members")
public String list(Model model) {
  List<Member> members = memberService.findMembers();
  model.addAttribute("members", members);
  return "members/memberList";
} //이 코드 추가
```


### 회원 리스트 HTML

```
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<body>

  <div class="container">
    <div>

    <table>
      <thead>
        <tr>
          <th>#</th>
          <th>이름</th>
        </tr>
      </thead>

      <tbody>
        <tr th:each="member : ${members}"> <!--model 안의 값을 읽어서 member 받아옴 -->
          <td th:text="${member.id}"></td>
          <td th:text="${member.name}"></td>
        </tr>
      </tbody>
    </table>

    </div>
  </div> <!-- /container -->
</body>
</html>
```




*출처: 인프런 스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술
