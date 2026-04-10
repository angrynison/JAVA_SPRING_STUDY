package hello.core.repository;

import hello.core.domain.Grade;
import hello.core.domain.Member;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();


    @Test
    public void save() {
        //Given
        Member member1 = new Member(0L,"앵그리", Grade.VIP);

        //When
        repository.save(member1);

        //Then
        Optional<Member> result = repository.findById(member1.getId());
        assertThat(member1.getId()).isEqualTo(result.get().getId());
    }


}
