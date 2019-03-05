package com.tunkey.survey.service.interfaces;

import com.tunkey.survey.dto.UserLogInDto;
import com.tunkey.survey.dto.UserSignUpDto;
import com.tunkey.survey.model.Result;

public interface IAuthenticationService extends IBaseService {

    Result logIn(UserLogInDto userLogInDto);

    Result signUp(UserSignUpDto userSignUpDto);


}
