package com.tunkey.survey.service;

import com.tunkey.survey.dto.PotentialChoiceDto;
import com.tunkey.survey.entity.PotentialChoiceEntity;
import com.tunkey.survey.enums.ResultCode;
import com.tunkey.survey.model.Result;
import com.tunkey.survey.model.ResultData;
import com.tunkey.survey.repository.PotentialChoiceRepo;
import com.tunkey.survey.service.interfaces.IPotentialChoiceService;
import com.tunkey.survey.service.interfaces.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PotentialChoiceService implements IPotentialChoiceService {

    @Autowired
    private PotentialChoiceRepo potentialChoiceRepo;


    @Override
    public Result save(PotentialChoiceDto potentialChoiceDto) {

        Result result = new Result();

        try {
            PotentialChoiceEntity potentialChoiceEntity = potentialChoiceDto.toEntity();
            potentialChoiceRepo.save(potentialChoiceEntity);
            result.makeSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            result.setResultCode(ResultCode.DATABASE_ERROR);
        }

        return result;


    }

    @Override
    public ResultData<List<PotentialChoiceDto>> getAll() {
        ResultData<List<PotentialChoiceDto>> resultData = new ResultData<>();


        try {
            Iterable<PotentialChoiceEntity> potentialChoiceEntities = potentialChoiceRepo.findAll();
            List<PotentialChoiceDto> potentialChoiceDtos = new ArrayList<>();

            PotentialChoiceDto potentialChoiceDto = new PotentialChoiceDto();

            for (PotentialChoiceEntity potentialChoiceEntity : potentialChoiceEntities) {
                potentialChoiceDtos.add(potentialChoiceDto.toDto(potentialChoiceEntity));
            }
            resultData.setData(potentialChoiceDtos);
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
            potentialChoiceRepo.deleteById(id);

        } catch (Exception e) {
            e.printStackTrace();
            result.setResultCode(ResultCode.DATABASE_ERROR);
            return result;
        }

        return result.makeSuccess();
    }


    @Override
    public ResultData<PotentialChoiceDto> getById(Long id) {

        ResultData<PotentialChoiceDto> resultData = new ResultData<>();
        PotentialChoiceDto potentialChoiceDto = new PotentialChoiceDto();
        Optional<PotentialChoiceEntity> optionalPotentialChoiceEntity;
        try {
            optionalPotentialChoiceEntity=potentialChoiceRepo.findById(id);
            if(optionalPotentialChoiceEntity.isPresent()){
                resultData.setData(potentialChoiceDto.toDto(optionalPotentialChoiceEntity.get()));
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
    public Result update(PotentialChoiceDto potentialChoiceDto) {

        Result result = new Result();

        try {
            potentialChoiceRepo.save(potentialChoiceDto.toEntity());
            result.makeSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            result.setResultCode(ResultCode.DATABASE_ERROR);
        }

        return result;
    }
}
