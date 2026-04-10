package hello.core.controller;

import hello.core.domain.Member;
import hello.core.dto.MemberForm;
import hello.core.repository.MemberRepository;
import hello.core.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    public MemberController (MemberService memberService, MemberRepository memberRepository) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }

    //회원 리스트
    @GetMapping("/memberList")
    public String members(Model model) {
        List<Member> members = memberRepository.findAll().orElse(List.of());
        model.addAttribute("members", members);
        return "members/memberList";
    }

    //회원 등록 페이지
    @GetMapping("/members/createMembers")
    public String createMember(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    //회원 등록
    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getMemberName());
        member.setGrade(form.getGrade());
        memberService.join(member);
        return "redirect:/";
    }

}
