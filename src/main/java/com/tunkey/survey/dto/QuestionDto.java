package com.tunkey.survey.dto;

import com.tunkey.survey.dto.abstracts.BaseDto;
import com.tunkey.survey.entity.PotentialChoiceEntity;
import com.tunkey.survey.entity.QuestionEntity;
import com.tunkey.survey.entity.SurveyEntity;
import com.tunkey.survey.enums.QuestionType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionDto  extends BaseDto<QuestionEntity,QuestionDto> {

    public QuestionDto() {

        super.typeTdto=QuestionDto.class;
        super.typeTEntity=QuestionEntity.class;
    }

    private String questionText;
    private double rating;
    private int numberOfRates;

    private List<PotentialChoiceEntity> potentialChoiceEntities;

    private SurveyEntity surveyEntity;

    private QuestionType questionType;
}
