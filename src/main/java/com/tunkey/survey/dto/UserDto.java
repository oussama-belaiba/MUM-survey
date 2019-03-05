package com.tunkey.survey.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tunkey.survey.dto.abstracts.BaseDto;
import com.tunkey.survey.entity.PotentialChoiceEntity;
import com.tunkey.survey.entity.SurveyEntity;
import com.tunkey.survey.entity.UserEntity;
import com.tunkey.survey.enums.UserRole;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Getter
@Setter
public class UserDto  extends BaseDto<UserEntity,UserDto> {

    public UserDto() {

        super.typeTdto=UserDto.class;
        super.typeTEntity=UserEntity.class;
    }

    private String name;
    private String email;
    private String password;
    private String country;
    private String maritalStatus;
    private String gender;

    private Date birthday;
    private UserRole userRole;
    private List<SurveyEntity> createdSurveys;

}
