package com.tunkey.survey.dto;

import com.tunkey.survey.dto.abstracts.BaseDto;
import com.tunkey.survey.entity.SurveyEntity;
import com.tunkey.survey.entity.UserEntity;
import com.tunkey.survey.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
public class UserSignUpDto extends BaseDto<UserEntity, UserSignUpDto> {

    public UserSignUpDto() {

        super.typeTdto=UserSignUpDto.class;
        super.typeTEntity= UserEntity.class;
    }

    private String name;
    private String email;
    private String password;
    private String country;
    private String maritalStatus;
    private String gender;

    private Date birthday;
    private UserRole userRole;

}
