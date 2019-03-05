package com.tunkey.survey.model;


import com.tunkey.survey.enums.ResultCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {

    private ResultCode resultCode;

    public Result makeSuccess() {
        this.setResultCode(ResultCode.SUCCESS);
        return this;
    }

}
