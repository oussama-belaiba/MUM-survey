package com.tunkey.survey.controller.abstracts;

import com.tunkey.survey.dto.abstracts.BaseDto;
import com.tunkey.survey.model.Result;
import com.tunkey.survey.model.ResultData;
import com.tunkey.survey.service.interfaces.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public abstract class BaseController<TDto extends BaseDto, TService extends ICrudService> {


    @Autowired
    private TService service;


    @PostMapping
    public Result save(@RequestBody TDto tDto) {
        return service.save(tDto);
    }

    @GetMapping
    public ResultData<TDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResultData<TDto> getById(@PathVariable long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable long id){
        return service.deleteById(id);
    }

    @PutMapping
    public Result update(@RequestBody TDto tDto){
        return service.update(tDto);
    }

}
