package cadispring.exercisespring1.service;
//자바 코드로 직접 스프링 빈 등록하기

import cadispring.exercisespring1.domain.Member;
import cadispring.exercisespring1.repository.MemberRepository;
import cadispring.exercisespring1.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    //memberService와 memberRepository를 둘다 스프링 빈에 등록
    //스프링 빈에 등록되어 있는 memberRepository를 memberSevice에 넣어줌

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());

    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}
