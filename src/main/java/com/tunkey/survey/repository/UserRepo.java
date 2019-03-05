package com.tunkey.survey.repository;

import com.tunkey.survey.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<UserEntity,Long> {



}
