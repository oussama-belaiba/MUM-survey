package com.tunkey.survey.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserJwt {

    private String email;
    private String password;

    public UserJwt() {
    }

    public UserJwt(String email, String password) {
        this.email = email;
        this.password = password;
    }




}
