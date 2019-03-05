package com.tunkey.survey.controller;

import com.tunkey.survey.controller.abstracts.BaseController;
import com.tunkey.survey.dto.SurveyDto;
import com.tunkey.survey.service.SurveyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/survey")
public class SurveyController extends BaseController<SurveyDto, SurveyService> {







}
