package com.tunkey.survey.repository;

import com.tunkey.survey.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AuthenticationRepo extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

}
