package hello.core.repository;

import hello.core.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    void save(Member member);
    Optional<Member> findById(Long memberId);
    Optional<List<Member>>findAll();
}
