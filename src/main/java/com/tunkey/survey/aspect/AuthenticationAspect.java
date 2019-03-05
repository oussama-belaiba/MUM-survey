package com.tunkey.survey.aspect;


import com.tunkey.survey.security.JwtUtil;
import com.tunkey.survey.security.UserJwt;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class AuthenticationAspect {


    @Autowired
    private HttpServletRequest request;


    @Around("target(com.tunkey.survey.controller.abstracts.BaseController)")
    public Object checkAuth(ProceedingJoinPoint proceedingJoinPoint){

        Object object = null;

        try {
            UserJwt userJwt = JwtUtil.validateToken(request.getHeader("Authorization"));

            if(userJwt!=null){
                object=proceedingJoinPoint.proceed();


            }else{


            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }


        return object;
    }


}
