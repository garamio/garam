package io.garam.examples.member.dto;

public class CreateMemberDto {
    private String email;
    private String password;

    public CreateMemberDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
