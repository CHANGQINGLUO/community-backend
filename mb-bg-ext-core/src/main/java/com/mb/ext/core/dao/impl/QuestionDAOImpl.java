package com.mb.ext.core.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mb.ext.core.dao.ActivityDAO;
import com.mb.ext.core.dao.QuestionDAO;
import com.mb.ext.core.entity.ActivityDetailsEntity;
import com.mb.ext.core.entity.ActivityEntity;
import com.mb.ext.core.entity.QuestionEntity;
import com.mb.ext.core.entity.UserActivityEntity;
import com.mb.ext.core.entity.UserEntity;
import com.mb.framework.dao.AbstractDAO;
import com.mb.framework.exception.BusinessException;
import com.mb.framework.util.log.LogHelper;

@Repository("questionDAO")
@Qualifier("QuestionDAO")
public class QuestionDAOImpl extends AbstractDAO<QuestionEntity> implements QuestionDAO {
	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	public QuestionDAOImpl() {
		super();
		this.setEntityClass(QuestionEntity.class);
	}

	@Override
	public List<QuestionEntity> getAllQuestions() throws BusinessException {
		List<QuestionEntity> list =  em.createQuery("SELECT e FROM QuestionEntity e", QuestionEntity.class).getResultList();
		return list;
	}

	@Override
	public List<QuestionEntity> getMyQuestions(String username) throws BusinessException {
		List<QuestionEntity> list =  em.createQuery("SELECT e FROM QuestionEntity e where e.user.name =:username", QuestionEntity.class).setParameter("username", username).getResultList();
		return list;
	}

	@Override
	public QuestionEntity createQuestion(String username, QuestionEntity question) throws BusinessException {
		UserEntity user = em.createQuery("select e from UserEntity e where e.name =:username", UserEntity.class).setParameter("username", username).getResultList().get(0);
		question.setUser(user);
		em.persist(question);
		return question;
	}

	
}
