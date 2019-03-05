package com.tunkey.survey.dto.abstracts;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

public abstract class BaseDto<TEntity,TDto extends BaseDto > {


    @Getter
    @Setter
    private Long id;

    protected Class<TEntity> typeTEntity;
    protected Class<TDto> typeTdto;

    public TEntity toEntity() {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, typeTEntity);

    }

    public TDto toDto(TEntity entity){

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity,typeTdto);

    }

}
