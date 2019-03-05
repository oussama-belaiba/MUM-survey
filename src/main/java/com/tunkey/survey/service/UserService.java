package com.tunkey.survey.service;

import com.tunkey.survey.dto.UserDto;
import com.tunkey.survey.entity.UserEntity;
import com.tunkey.survey.enums.ResultCode;
import com.tunkey.survey.model.Result;
import com.tunkey.survey.model.ResultData;
import com.tunkey.survey.repository.UserRepo;
import com.tunkey.survey.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public Result save(UserDto userDto) {

        Result result = new Result();

        try {
            userRepo.save(userDto.toEntity());
            result.makeSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            result.setResultCode(ResultCode.DATABASE_ERROR);

        }

        return result;


    }

    @Override
    public ResultData<List<UserDto>> getAll() {

        ResultData<List<UserDto>> resultData = new ResultData<>();

        try {
            Iterable<UserEntity> userEntities = userRepo.findAll();
            List<UserDto> userDtos = new ArrayList<>();

            UserDto userDto = new UserDto();

            for (UserEntity userEntity : userEntities) {
                userDtos.add(userDto.toDto(userEntity));
            }
            resultData.setData(userDtos);
            resultData.makeSuccess();

        } catch (Exception e) {
            e.printStackTrace();
            resultData.setData(null);
            resultData.setResultCode(ResultCode.DATABASE_ERROR);
        }

        return resultData;
    }

    @Override
    public Result deleteById(Long id) {

        Result result = new Result();


        try {
            userRepo.deleteById(id);

        } catch (Exception e) {
            e.printStackTrace();
            result.setResultCode(ResultCode.DATABASE_ERROR);
            return result;
        }

        return result.makeSuccess();
    }

    @Override
    public ResultData<UserDto> getById(Long id) {
        ResultData<UserDto> resultData = new ResultData<>();
        UserDto userDto = new UserDto();
        Optional<UserEntity> optionalUserEntity;
        try {
            optionalUserEntity = userRepo.findById(id);
            if (optionalUserEntity.isPresent()) {
                resultData.setData(userDto.toDto(optionalUserEntity.get()));
                resultData.makeSuccess();


            } else {
                resultData.setData(null);
                resultData.setResultCode(ResultCode.ID_NOT_EXIST);
                return resultData;
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultData.setData(null);
            resultData.setResultCode(ResultCode.DATABASE_ERROR);
            return resultData;
        }
        return resultData;
    }

    @Override
    public Result update(UserDto userDto) {

        Result result = new Result();

        try {
            userRepo.save(userDto.toEntity());
            result.makeSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            result.setResultCode(ResultCode.DATABASE_ERROR);
        }

        return result;
    }
}
