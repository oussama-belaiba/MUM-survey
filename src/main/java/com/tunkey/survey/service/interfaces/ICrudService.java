package com.tunkey.survey.service.interfaces;

import com.tunkey.survey.model.Result;
import com.tunkey.survey.model.ResultData;

import java.util.List;

public interface ICrudService<TDto> extends IBaseService {

    Result save(TDto tDto);
    ResultData<List<TDto>> getAll();
    Result deleteById(Long id);
    //Result delete(TDto taskDto);
    ResultData<TDto> getById(Long id);
    Result update(TDto tDto);

}
