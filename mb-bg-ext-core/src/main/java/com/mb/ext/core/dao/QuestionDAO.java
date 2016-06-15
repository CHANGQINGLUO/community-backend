package com.mb.ext.core.dao;

import java.util.List;

import com.mb.ext.core.entity.ActivityDetailsEntity;
import com.mb.ext.core.entity.ActivityEntity;
import com.mb.ext.core.entity.QuestionEntity;
import com.mb.ext.core.entity.UserEntity;
import com.mb.framework.exception.BusinessException;

public interface QuestionDAO {
	public List<QuestionEntity> getAllQuestions() throws BusinessException;

	public List<QuestionEntity> getMyQuestions(String username) throws BusinessException;

	public QuestionEntity createQuestion(String username, QuestionEntity question) throws BusinessException;
}
