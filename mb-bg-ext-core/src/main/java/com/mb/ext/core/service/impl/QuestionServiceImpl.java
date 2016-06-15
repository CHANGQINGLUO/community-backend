package com.mb.ext.core.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mb.ext.core.dao.ActivityDAO;
import com.mb.ext.core.dao.QuestionDAO;
import com.mb.ext.core.entity.ActivityDetailsEntity;
import com.mb.ext.core.entity.ActivityEntity;
import com.mb.ext.core.entity.QuestionEntity;
import com.mb.ext.core.service.ActivityService;
import com.mb.ext.core.service.QuestionService;
import com.mb.ext.core.service.spec.ActivityDTO;
import com.mb.ext.core.service.spec.BodyDTO;
import com.mb.ext.core.service.spec.HeaderDTO;
import com.mb.ext.core.service.spec.QuestionDTO;
import com.mb.ext.core.service.spec.RequestDTO;
import com.mb.ext.core.service.spec.UserDTO;
import com.mb.ext.core.util.EPMapperUtil;
import com.mb.framework.exception.BusinessException;
import com.mb.framework.service.AbstractService;
import com.mb.framework.util.log.LogHelper;

@Service
@Qualifier("QuestionService")
public class QuestionServiceImpl extends AbstractService implements QuestionService<BodyDTO> {
	@Autowired
	@Qualifier("questionDAO")
	private QuestionDAO questionDAO;

	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	@Override
	public List<QuestionDTO> getAllQuestions() throws BusinessException {
		List<QuestionEntity> entities = questionDAO.getAllQuestions();
		List<QuestionDTO> list = new ArrayList<QuestionDTO>();
		for(int i=0;entities!=null && i<entities.size(); i++){
			QuestionDTO question = new QuestionDTO();
			question.setUuid(entities.get(i).getUuid());
			question.setQuestion(entities.get(i).getQuestion());
			question.setTotalAnswer(entities.get(i).getTotalAnswer());
			
			UserDTO user= new UserDTO();
			user.setName(entities.get(i).getUser().getName());
			user.setContactNoHp(entities.get(i).getUser().getContactHm());
			user.setContactNoOffice(entities.get(i).getUser().getContactOff());
			user.setEmailAddress(entities.get(i).getUser().getEmail());	
			question.setUser(user);
			
			list.add(question);
		}
		return list;
	}

	@Override
	public List<QuestionDTO> getMyQuestions(HeaderDTO header) throws BusinessException {
		List<QuestionEntity> entities = questionDAO.getMyQuestions(header.getUser());
		List<QuestionDTO> list = new ArrayList<QuestionDTO>();
		for(int i=0;entities!=null && i<entities.size(); i++){
			QuestionDTO question = new QuestionDTO();
			question.setUuid(entities.get(i).getUuid());
			question.setQuestion(entities.get(i).getQuestion());
			question.setTotalAnswer(entities.get(i).getTotalAnswer());
			
			UserDTO user= new UserDTO();
			user.setName(entities.get(i).getUser().getName());
			user.setContactNoHp(entities.get(i).getUser().getContactHm());
			user.setContactNoOffice(entities.get(i).getUser().getContactOff());
			user.setEmailAddress(entities.get(i).getUser().getEmail());	
			question.setUser(user);
			
			list.add(question);
		}
		return list;
	}

	@Override
	public QuestionDTO createQuestion(RequestDTO<QuestionDTO> request) throws BusinessException {
		QuestionDTO question = request.getBody();
		QuestionEntity entity = new QuestionEntity();
		entity.setQuestion(question.getQuestion());	
		entity = questionDAO.createQuestion(request.getHeader().getUser(), entity);
		
		question.setUuid(entity.getUuid());
		return question;
	}

	

}
