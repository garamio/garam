package io.garam.examples.member.domain;

public class Member {

    private Long id;

    private String email;

    private String password;

    public Member(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
