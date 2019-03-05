package com.tunkey.survey.repository;

import com.tunkey.survey.entity.QuestionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends CrudRepository<QuestionEntity,Long> {



}
