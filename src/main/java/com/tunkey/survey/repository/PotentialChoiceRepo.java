package com.tunkey.survey.repository;

import com.tunkey.survey.entity.PotentialChoiceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PotentialChoiceRepo extends CrudRepository<PotentialChoiceEntity,Long> {



}
