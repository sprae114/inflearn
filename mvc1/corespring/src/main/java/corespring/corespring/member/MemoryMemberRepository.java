package corespring.corespring.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>();   //private인것, 형태(store) 뺴먹음, HashMap<>() 형태

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long Id) {
        return store.get(Id);
    }
}
