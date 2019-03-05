package com.tunkey.survey.service;

import com.tunkey.survey.dto.SurveyDto;
import com.tunkey.survey.entity.SurveyEntity;
import com.tunkey.survey.enums.ResultCode;
import com.tunkey.survey.model.Result;
import com.tunkey.survey.model.ResultData;
import com.tunkey.survey.repository.SurveyRepo;
import com.tunkey.survey.repository.UserRepo;
import com.tunkey.survey.service.interfaces.ISurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class SurveyService implements ISurveyService {

    @Autowired
    private SurveyRepo surveyRepo;


    @Override
    public Result save(SurveyDto surveyDto) {

        Result result = new Result();

        try {
            surveyRepo.save(surveyDto.toEntity());
            result.makeSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            result.setResultCode(ResultCode.DATABASE_ERROR);

        }

        return result;


    }

    @Override
    public ResultData<List<SurveyDto>> getAll() {

        ResultData<List<SurveyDto>> resultData = new ResultData<>();

        try {
            Iterable<SurveyEntity> surveyEntities = surveyRepo.findAll();
            List<SurveyDto> surveyDtos = new ArrayList<>();

            SurveyDto surveyDto = new SurveyDto();

            for (SurveyEntity surveyEntity : surveyEntities) {
                surveyDtos.add(surveyDto.toDto(surveyEntity));
            }
            resultData.setData(surveyDtos);
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
            surveyRepo.deleteById(id);

        } catch (Exception e) {
            e.printStackTrace();
            result.setResultCode(ResultCode.DATABASE_ERROR);
            return result;
        }

        return result.makeSuccess();
    }

    @Override
    public ResultData<SurveyDto> getById(Long id) {
        ResultData<SurveyDto> resultData = new ResultData<>();
        SurveyDto surveyDto = new SurveyDto();
        Optional<SurveyEntity> optionalSurveyEntity;
        try {
            optionalSurveyEntity= surveyRepo.findById(id);
            if(optionalSurveyEntity.isPresent()){
                resultData.setData(surveyDto.toDto(optionalSurveyEntity.get()));
                resultData.makeSuccess();


            }else{
                resultData.setData(null);
                resultData.setResultCode(ResultCode.ID_NOT_EXIST);
                return  resultData;
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultData.setData(null);
            resultData.setResultCode(ResultCode.DATABASE_ERROR);
            return  resultData;
        }
        return resultData;
    }

    @Override
    public Result update(SurveyDto surveyDto) {

        Result result = new Result();

        try {
            surveyRepo.save(surveyDto.toEntity());
            result.makeSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            result.setResultCode(ResultCode.DATABASE_ERROR);
        }

        return result;
    }
}
