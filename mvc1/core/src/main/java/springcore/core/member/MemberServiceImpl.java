package springcore.core.member;

public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository; //private final이다 why? db는 한번만 생성하야되므로

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long Id) {
        return memberRepository.findById(Id);
    }
}
