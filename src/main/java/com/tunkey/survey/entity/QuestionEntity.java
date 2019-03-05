package com.tunkey.survey.entity;


import com.tunkey.survey.enums.QuestionType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String questionText;
    private double rating;
    private int numberOfRates;

    @OneToMany(mappedBy = "questionEntity")
    private List<PotentialChoiceEntity> potentialChoiceEntities;

    @ManyToOne
    private SurveyEntity surveyEntity;

    @Enumerated(EnumType.STRING)
    private QuestionType questionType;


}
