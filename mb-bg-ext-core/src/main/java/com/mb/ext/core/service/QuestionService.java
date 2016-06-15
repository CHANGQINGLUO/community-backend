package com.mb.ext.core.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mb.ext.core.service.spec.BodyDTO;
import com.mb.ext.core.service.spec.HeaderDTO;
import com.mb.ext.core.service.spec.QuestionDTO;
import com.mb.ext.core.service.spec.RequestDTO;
import com.mb.framework.exception.BusinessException;

@Transactional
public interface QuestionService<T extends BodyDTO> {

	public List<QuestionDTO> getAllQuestions() throws BusinessException;

	public List<QuestionDTO> getMyQuestions(HeaderDTO header) throws BusinessException;

	public QuestionDTO createQuestion(RequestDTO<QuestionDTO> request) throws BusinessException;

}
