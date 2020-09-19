package cadispring.exercisespring1.service;

import cadispring.exercisespring1.domain.Member;
import cadispring.exercisespring1.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    //test 실행시마다 각각 생성해줌(test는 독립적으로 돌아가야하므로)
    //외부에서 memberRepository를 넣어줌 =DI(dependency exception



    //실행되었던 것들 제거. -> 실행시 각 함수 값 중복 피하는 함수
    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();

    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then (검증단계)
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
        //member이름이 findbyMember와 같은가.
    }
    //중복회원 예외 테스트
    public void duplicate_exception(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member1.setName("spring");

        //->이름 중복 상황

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, ()-> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");//Error 문구 출력하기
        //밑의 try-catch문 간결하게 표현

        /*
        try {
            memberService.join(member2);
            fail("예외가 발생해야 합니다.");
        }catch (IllegalStateException e) {
            //member1과 member2의 값이 중복되는 상황에 대한 예외 처리
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }

         */


        //then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}