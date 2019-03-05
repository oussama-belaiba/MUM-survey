package com.tunkey.survey.entity;


import com.tunkey.survey.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String country;
    private String maritalStatus;
    private String gender;
    private Date birthday;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    @OneToMany(mappedBy = "surveyCreator")
    private List<SurveyEntity> createdSurveys;

}
