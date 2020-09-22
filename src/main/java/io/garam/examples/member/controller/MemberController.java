package io.garam.examples.member.controller;

import io.garam.examples.member.dto.CreateMemberDto;
import io.garam.examples.member.service.MemberService;
import io.garam.web.Garam;
import io.garam.web.http.Request;

public class MemberController {

    private final MemberService memberService = new MemberService();

    public MemberController() {
        addCreateMemberHandler();
        addReadMemberHandler();
    }

    private void addReadMemberHandler() {
        Garam.get("/user", ctx -> {
            final Request request = ctx.request();
            final String id = request.parameter("id");
        });
    }

    private void addCreateMemberHandler() {
        Garam.post("/user", ctx -> {
            final Request request = ctx.request();

            final String email = request.parameter("email");
            final String password = request.parameter("password");

            final CreateMemberDto createMemberDto = new CreateMemberDto(email, password);
            memberService.createMember(createMemberDto);

            ctx.response().redirect("/");
        });
    }
}
