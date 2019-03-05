package com.tunkey.survey.service;

import com.tunkey.survey.dto.QuestionDto;
import com.tunkey.survey.entity.QuestionEntity;
import com.tunkey.survey.enums.ResultCode;
import com.tunkey.survey.model.Result;
import com.tunkey.survey.model.ResultData;
import com.tunkey.survey.repository.QuestionRepo;
import com.tunkey.survey.service.interfaces.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class QuestionService implements IQuestionService {

    @Autowired
    private QuestionRepo questionRepo;


    @Override
    public Result save(QuestionDto questionDto) {

        Result result = new Result();

        try {
            QuestionEntity questionEntity = questionDto.toEntity();
            questionRepo.save(questionEntity);
            result.makeSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            result.setResultCode(ResultCode.DATABASE_ERROR);
        }

        return result;


    }

    @Override
    public ResultData<List<QuestionDto>> getAll() {
        ResultData<List<QuestionDto>> resultData = new ResultData<>();


        try {
            Iterable<QuestionEntity> questionEntities = questionRepo.findAll();
            List<QuestionDto> questionDtos = new ArrayList<>();

            QuestionDto questionDto = new QuestionDto();

            for (QuestionEntity questionEntity : questionEntities) {
                questionDtos.add(questionDto.toDto(questionEntity));
            }
            resultData.setData(questionDtos);
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
            questionRepo.deleteById(id);

        } catch (Exception e) {
            e.printStackTrace();
            result.setResultCode(ResultCode.DATABASE_ERROR);
            return result;
        }

        return result.makeSuccess();
    }


    @Override
    public ResultData<QuestionDto> getById(Long id) {

        ResultData<QuestionDto> resultData = new ResultData<>();
        QuestionDto questionDto = new QuestionDto();
        Optional<QuestionEntity> optionalQuestionEntity;
        try {
            optionalQuestionEntity=questionRepo.findById(id);
            if(optionalQuestionEntity.isPresent()){
                resultData.setData(questionDto.toDto(optionalQuestionEntity.get()));
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
    public Result update(QuestionDto questionDto) {

        Result result = new Result();

        try {
            questionRepo.save(questionDto.toEntity());
            result.makeSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            result.setResultCode(ResultCode.DATABASE_ERROR);
        }

        return result;
    }
}
