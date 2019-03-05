package com.tunkey.survey.dto;


import com.tunkey.survey.dto.abstracts.BaseDto;
import com.tunkey.survey.entity.PotentialChoiceEntity;
import com.tunkey.survey.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLogInDto extends BaseDto<UserEntity,UserLogInDto> {

    public UserLogInDto() {

        super.typeTdto=UserLogInDto.class;
        super.typeTEntity= UserEntity.class;
    }

    private String email;
    private String password;

}
