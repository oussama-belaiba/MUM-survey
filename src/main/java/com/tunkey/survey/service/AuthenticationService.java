package com.tunkey.survey.service;

import com.tunkey.survey.dto.UserLogInDto;
import com.tunkey.survey.dto.UserSignUpDto;
import com.tunkey.survey.entity.UserEntity;
import com.tunkey.survey.enums.ResultCode;
import com.tunkey.survey.model.Result;
import com.tunkey.survey.model.ResultData;
import com.tunkey.survey.repository.AuthenticationRepo;
import com.tunkey.survey.repository.UserRepo;
import com.tunkey.survey.security.JwtUtil;
import com.tunkey.survey.security.UserJwt;
import com.tunkey.survey.service.interfaces.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService implements IAuthenticationService {

    @Autowired
    private AuthenticationRepo authenticationRepo;

    @Autowired
    private UserRepo userRepo;


    @Override
    public Result logIn(UserLogInDto userLogInDto) {

        ResultData<String> resultData = new ResultData<>();
        Optional<UserEntity> optionalUserEntity=authenticationRepo.findByEmail(userLogInDto.getEmail());

        if(optionalUserEntity.isPresent()){
            UserEntity userEntity= optionalUserEntity.get();
            if(userEntity.getPassword().equals(userLogInDto.getPassword())){
                //all is well, log him in

                UserJwt userJwt = new UserJwt(userEntity.getEmail(),userEntity.getPassword());

                resultData.setData(JwtUtil.generate(userJwt));
                resultData.makeSuccess();
            }else{
                //wrong password
                resultData.setResultCode(ResultCode.WRONG_PASSWORD);
            }
        }else{
            //no such user
            resultData.setResultCode(ResultCode.NO_SUCH_USER);
        }

        return resultData;
    }

    @Override
    public Result signUp(UserSignUpDto userDto) {

        Result result = new Result();

        try {
            userRepo.save(userDto.toEntity());
            result.makeSuccess();
        }catch (DataIntegrityViolationException e){
            //todo implement more detailed unique email fail
            result.setResultCode(ResultCode.EMAIL_EXIST);

        }

        catch (Exception e) {
            e.printStackTrace();
            result.setResultCode(ResultCode.DATABASE_ERROR);

        }

        return result;

    }
}
