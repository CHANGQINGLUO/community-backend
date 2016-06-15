package com.mb.ext.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mb.ext.core.service.QuestionService;
import com.mb.ext.core.service.spec.BodyDTO;
import com.mb.ext.core.service.spec.QuestionDTO;
import com.mb.ext.core.service.spec.RequestDTO;
import com.mb.ext.core.service.spec.ResponseDTO;
import com.mb.ext.core.service.spec.StatusDTO;
import com.mb.framework.util.log.LogHelper;

@Controller
public class QuestionController {
	private LogHelper logger = LogHelper.getInstance(this.getClass().getName());
	
	@Autowired
	@Qualifier("QuestionService")
	private QuestionService<BodyDTO> questionService;

	@RequestMapping(value = "/getAllQuestions", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseDTO<List<QuestionDTO>> getAllQuestions(@RequestBody RequestDTO<String> request) {
		ResponseDTO<List<QuestionDTO>> response = new ResponseDTO<List<QuestionDTO>>();
		response.setHeader(request.getHeader());
		StatusDTO status = new StatusDTO();
		status.setStatuscode("0");
		status.setStatusdesc("Success");
		response.setStatus(status);
		try {
			List<QuestionDTO> list=questionService.getAllQuestions();
			response.setBody(list);
		} catch (Exception e) {
			logger.error("Exception occurred in getAllQuestions", e);
			response.getStatus().setStatuscode("2");
			response.getStatus().setStatusdesc("Failed");
		}

		return response;
	}
	
	@RequestMapping(value = "/getMyQuestions", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseDTO<List<QuestionDTO>> getMyQuestions(@RequestBody RequestDTO<String> request) {
		ResponseDTO<List<QuestionDTO>> response = new ResponseDTO<List<QuestionDTO>>();
		response.setHeader(request.getHeader());
		StatusDTO status = new StatusDTO();
		status.setStatuscode("0");
		status.setStatusdesc("Success");
		response.setStatus(status);
		try {
			List<QuestionDTO> list=questionService.getMyQuestions(request.getHeader());
			response.setBody(list);
		} catch (Exception e) {
			logger.error("Exception occurred in getMyQuestions", e);
			response.getStatus().setStatuscode("2");
			response.getStatus().setStatusdesc("Failed");
		}

		return response;
	}
	
	@RequestMapping(value = "/createQuestion", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseDTO<QuestionDTO> createQuestion(@RequestBody RequestDTO<QuestionDTO> request) {
		ResponseDTO<QuestionDTO> response = new ResponseDTO<QuestionDTO>();
		response.setHeader(request.getHeader());
		StatusDTO status = new StatusDTO();
		status.setStatuscode("0");
		status.setStatusdesc("Success");
		response.setStatus(status);
		try {
			QuestionDTO question=questionService.createQuestion(request);
			response.setBody(question);
		} catch (Exception e) {
			logger.error("Exception occurred in createQuestion", e);
			response.getStatus().setStatuscode("2");
			response.getStatus().setStatusdesc("Failed");
		}

		return response;
	}
	


}
