package cadispring.exercisespring1.repository;

import cadispring.exercisespring1.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;
//컴포넌트 스캔과 자동 의존관계 설정으로 스프링 빈 등록하기
//@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //key값 생성


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member); //Id 세팅 후 store에 저장
        return member;
        //name: 고객이 정한 이름, id는 시스템이 저장할 때 등록되는 이름

    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //저장된 id store에서 꺼내기
        //Optional.ofNullable로 감싸면 클라이언트 측에서도 동작을 할 수 있음
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
                //루프를 돌면서 map에서 같은 값 하나라도 있으면 반환. 없으면 optional에 null이 포함되어 반환
                //결과가 optional로 반환됨
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //리스트로 반환
        //store.values : member들
    }
    //값이 중복되지 않도록 함수가 끝나면 clear 해주는 함수
    public void clearStore() {
        store.clear();
    }
}
//리포지토리와 클래스를 생성하는 이유, sequence가 무엇인지.....