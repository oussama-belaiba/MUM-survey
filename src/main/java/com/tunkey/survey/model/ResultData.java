package com.tunkey.survey.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultData<T> extends Result {

private T data;

}
