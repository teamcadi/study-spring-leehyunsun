package cadispring.exercisespring1.repository;

import cadispring.exercisespring1.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //id로 찾는 것
    Optional<Member> findByName(String name);
    List<Member> findAll(); //지금까지 저장된 모든 리스트를 반환

    //findByName, findById로 저장소에서 찾아올 수 있음

}
