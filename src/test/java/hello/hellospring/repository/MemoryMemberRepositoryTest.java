package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("springhi");
        repository.save(member);

        Member resultMember = repository.findById(member.getId()).get();
        assertThat(resultMember).isEqualTo(member);

    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("springhi1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("springhi2");
        repository.save(member2);

        Member findResult = repository.findByName("springhi1").get();
        assertThat(findResult).isEqualTo(member1);

    }

    @Test
    public void findAll(){
        Member member1= new Member();
        member1.setName("member1");
        repository.save(member1);

        Member member2= new Member();
        member2.setName("member2");
        repository.save(member2);

        List<Member> memberList = repository.findAll();
        assertThat(memberList.size()).isEqualTo(2);
    }
}
