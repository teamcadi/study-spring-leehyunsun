package cadispring.exercisespring1.repository;

import cadispring.exercisespring1.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository =  new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();

    }
    //메소드가 실행이 끝날 때마다 동작
    //Test 할 때마다 중복되는 데이터가 생기므로, 테스트 끝나면 clear 해주기ㅣ

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();

        //Assertions.assertThat(member).isEqualTo(result); <-이걸 쓰기도 함
        //assertThat 의 memeber가 result와 같으면
        Assertions.assertEquals(member, result);

        //같은 표현
        // System.out.println("result= "+(result == member));

    }

    //회원가입 상황
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
        //result가 memeber1(spring. 미리 설정한 값)인지 검사하는 것 -> 일치하지 않으면 오류남


        }
    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
//모든 테스트는 순서가 보장이 되지 않음. 순서대로가 아니라 메소드별로 따로 동작
