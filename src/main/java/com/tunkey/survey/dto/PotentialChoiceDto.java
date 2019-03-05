package com.tunkey.survey.dto;


import com.tunkey.survey.dto.abstracts.BaseDto;
import com.tunkey.survey.entity.PotentialChoiceEntity;
import com.tunkey.survey.entity.QuestionEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PotentialChoiceDto extends BaseDto<PotentialChoiceEntity,PotentialChoiceDto> {

    private String response;
    private boolean isDefault;
    private QuestionEntity questionEntity;

    public PotentialChoiceDto() {

        super.typeTdto=PotentialChoiceDto.class;
        super.typeTEntity=PotentialChoiceEntity.class;

    }
}
