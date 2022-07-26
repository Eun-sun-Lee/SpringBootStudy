package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); //동시성 이슈 발생 가능
    //저장소이므로 필요

    @Override
    public void save(Member member) {
        store.put(member.getId(), member); //DB에 저장
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId); //DB에서 회원 찾기
    }
}
