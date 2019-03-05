package com.tunkey.survey.controller;


import com.tunkey.survey.dto.UserLogInDto;
import com.tunkey.survey.dto.UserSignUpDto;
import com.tunkey.survey.model.Result;
import com.tunkey.survey.service.interfaces.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthenticationController {


    @Autowired
    private IAuthenticationService authenticationService;


    @PostMapping("/sUp")
    public Result signUp(@RequestBody UserSignUpDto userSignUpDto) {

        return authenticationService.signUp(userSignUpDto);
    }

    @PostMapping("/logIn")
    public Result logIn(@RequestBody UserLogInDto userLogInDto) {
        return authenticationService.logIn(userLogInDto);
    }

}
