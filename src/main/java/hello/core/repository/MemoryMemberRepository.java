package hello.core.repository;

import hello.core.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class MemoryMemberRepository implements MemberRepository {

    /*
    그러면 static은 왜쓰는 건가
    정적 멤버는 클래스에 고정된 멤버고 객체를 생성하지 않고 사용할 수 있는 필드와 메서드
    그러므로 static을 붙여 각 서비스가 new memberRepository로 객체를 생성하더라도 
    HashMap store 객체는 각 서비스마다 생성되는게 아닌 공통된 Repository HashMap 객체를 공유한다
    즉, 같은 DB를 공유한다
     */
    private static final HashMap<Long,Member> store = new HashMap<>();
    long sequence = 0L;

    @Override
    public Member save(Member member) {
        sequence++;
        member.setId(sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long memberId) {
        return Optional.ofNullable(store.get(memberId));
    }

    //구현해야함
    @Override
    public List<Member> findAll() {
        List<Member> members = new ArrayList<>(store.values());
        return members;
    }


}
