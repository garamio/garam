package io.garam.examples.member.controller;

import io.garam.examples.member.domain.Member;
import io.garam.examples.member.dto.CreateMemberDto;
import io.garam.examples.member.service.MemberService;
import io.garam.core.Garam;
import io.garam.core.http.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemberController {

    private Logger log = LoggerFactory.getLogger(MemberController.class);

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
        Garam.post("/v1/user", ctx -> {
            final Request request = ctx.request();

            final String email = request.parameter("usermail");
            final String password = request.parameter("userpass");
            log.info("email: {}", email);
            log.info("password: {}", password);

            final CreateMemberDto createMemberDto = new CreateMemberDto(email, password);
            final Member member = memberService.createMember(createMemberDto);
            ctx.response().header("Location", "/v1/user/" + member.getId());
        });
    }
}
