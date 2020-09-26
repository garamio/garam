package io.garam.examples.member.service;

import io.garam.examples.member.domain.Member;
import io.garam.examples.member.dto.CreateMemberDto;

import java.util.HashMap;
import java.util.Map;

public class MemberService {

    private Map<Long, Member> memberDb = new HashMap<>();

    public Member createMember(CreateMemberDto dto) {
        final long id = System.currentTimeMillis();
        final Member member = new Member(id, dto.getEmail(), dto.getPassword());
        memberDb.put(id, member);
        return member;
    }
}
