package com.tunkey.survey.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class SurveyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private LocalDateTime deadline;

    @OneToMany(mappedBy = "surveyEntity")
    private List<QuestionEntity> questionEntities;
    @ManyToOne
    private UserEntity surveyCreator;

}
