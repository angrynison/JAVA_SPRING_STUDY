package hello.core.service;

import hello.core.domain.Member;
import hello.core.repository.MemberRepository;

import java.util.Optional;

public class MemberService {
    /*
    private은 같은 클래스 내에 사용하고 final은 필드값이 더이상 변경될 필요가 없을때 쓰임
    memberRepository 객체는 Service 내에서만 필요한 객체 외부에서 수정하지 못하도록 사용
     */
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        memberRepository.save(member);
        return member.getId();
    }

    public Optional<Member> findMemberById(Long memberId) {
        return memberRepository.findById(memberId);
    }


}
