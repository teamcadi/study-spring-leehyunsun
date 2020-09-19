package cadispring.exercisespring1.service;

import cadispring.exercisespring1.domain.Member;
import cadispring.exercisespring1.repository.MemberRepository;
import cadispring.exercisespring1.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//컴포넌트 스캔과 자동 의존관계 설정으로 스프링 빈 등록하기
//@Service //spring에 memberService가 올라올 때 스프링 컨테이너에 멤버서비스를 등록시킴

//자바코드로 직접 스프링 빈 등록하기


public class MemberService {
    private final MemberRepository memberRepository;

    //컴포넌트 스캔과 자동 의존관계 설정으로 스프링 빈 등록하기
    //@Autowired //멤버서비스를 스프링이 생성할때 스프링 컨테이너에 멤버 리포지터리 넣어줌,
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    //memberRepository를 직접 생성하는 것이 아니라 외부에서 넣어주고, 바꿀 수 있게 해주는 것

    /**회원가입
     *
     */

    public Long join(Member member) {
        //같은 이름이 있는 아이디는 안 되게 하고 싶을 때. 즉, 중복을 허용하지 않을 때
        Optional<Member> result = memberRepository.findByName(member.getName());
        //Optional 안에 여러 메모리가 있음.
        result.ifPresent(m-> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }); //member 값이 있으면.
        memberRepository.save(member);
        return member.getId();
    }
    //회원가입하면 ID를 반환해줌

    //전체회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();

    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
