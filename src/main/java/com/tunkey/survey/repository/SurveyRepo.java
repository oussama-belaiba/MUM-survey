package com.tunkey.survey.repository;

import com.tunkey.survey.entity.SurveyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepo extends CrudRepository<SurveyEntity,Long> {



}
