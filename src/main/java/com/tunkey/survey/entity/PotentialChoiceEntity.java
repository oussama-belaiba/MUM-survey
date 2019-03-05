package com.tunkey.survey.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class PotentialChoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String response;
    private boolean isDefault;

    @ManyToOne
    private QuestionEntity questionEntity;

}
