import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


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
    //GET 방식. Get 일때 이 코드가 호출

    @PostMapping(value = "/members/new") //post mapping 해야함
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/"; //끝나면 홈화면으로 보냄
    }
    //POST 방식. POST 일때 이 코드가 호출

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers(); //member를 다 가져오기
        model.addAttribute("members", members); //model을 담아서 commit으로 넘겨주기 members안에는 list형태로 회원정보가 담겨 있음
        return "members/memberList";
    } //이 코드 추가
}