package com.tunkey.survey.dto;


import com.tunkey.survey.dto.abstracts.BaseDto;
import com.tunkey.survey.entity.PotentialChoiceEntity;
import com.tunkey.survey.entity.QuestionEntity;
import com.tunkey.survey.entity.SurveyEntity;
import com.tunkey.survey.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class SurveyDto  extends BaseDto<SurveyEntity,SurveyDto> {

    public SurveyDto() {

        super.typeTdto=SurveyDto.class;
        super.typeTEntity=SurveyEntity.class;
    }

    private String title;
    private LocalDateTime deadline;

    private List<QuestionEntity> questionEntities;
    private UserEntity surveyCreator;

}
