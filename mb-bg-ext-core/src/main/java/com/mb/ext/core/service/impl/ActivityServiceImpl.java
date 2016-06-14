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
import com.mb.ext.core.entity.ActivityDetailsEntity;
import com.mb.ext.core.entity.ActivityEntity;
import com.mb.ext.core.service.ActivityService;
import com.mb.ext.core.service.spec.ActivityDTO;
import com.mb.ext.core.service.spec.BodyDTO;
import com.mb.ext.core.service.spec.HeaderDTO;
import com.mb.ext.core.service.spec.RequestDTO;
import com.mb.ext.core.service.spec.UserDTO;
import com.mb.ext.core.util.EPMapperUtil;
import com.mb.framework.exception.BusinessException;
import com.mb.framework.service.AbstractService;
import com.mb.framework.util.log.LogHelper;

@Service
@Qualifier("ActivityService")
public class ActivityServiceImpl extends AbstractService implements ActivityService<BodyDTO> {
	@Autowired
	@Qualifier("activityDAO")
	private ActivityDAO activityDAO;

	@Autowired
	private EPMapperUtil epMapperUtil;

	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	@Override
	public List<ActivityDTO> getAllActivies(HeaderDTO header) throws BusinessException {
		List<ActivityEntity> activies = activityDAO.getAllActivies();
		List<ActivityDTO> list = new ArrayList<ActivityDTO>();
		for (int i = 0; activies != null && i < activies.size(); i++) {
			ActivityDTO activity = new ActivityDTO();
			activity.setUuid(activies.get(i).getUuid());
			activity.setTitle(activies.get(i).getTitle());
			activity.setDatetime(formatDate(activies.get(i).getDatetime()));
			activity.setAddress(activies.get(i).getAddress());
			list.add(activity);
		}
		return list;
	}

	@Override
	public List<ActivityDTO> getInitiateActivities(HeaderDTO header) throws BusinessException {
		List<ActivityEntity> activies = activityDAO.getInitiateActivities(header.getUser());
		List<ActivityDTO> list = new ArrayList<ActivityDTO>();
		for (int i = 0; activies != null && i < activies.size(); i++) {
			ActivityDTO activity = new ActivityDTO();
			activity.setUuid(activies.get(i).getUuid());
			activity.setTitle(activies.get(i).getTitle());
			activity.setDatetime(formatDate(activies.get(i).getDatetime()));
			activity.setAddress(activies.get(i).getAddress());
			list.add(activity);
		}
		return list;
	}

	@Override
	public List<ActivityDTO> getJoinedActivities(HeaderDTO header) throws BusinessException {
		List<ActivityEntity> activies = activityDAO.getJoinedActivities(header.getUser());
		List<ActivityDTO> list = new ArrayList<ActivityDTO>();
		for (int i = 0; activies != null && i < activies.size(); i++) {
			ActivityDTO activity = new ActivityDTO();
			activity.setUuid(activies.get(i).getUuid());
			activity.setTitle(activies.get(i).getTitle());
			activity.setDatetime(formatDate(activies.get(i).getDatetime()));
			activity.setAddress(activies.get(i).getAddress());
			list.add(activity);
		}
		return list;
	}

	@Override
	public ActivityDTO getActivityDetails(RequestDTO<ActivityDTO> request) throws BusinessException {
		String username = request.getHeader().getUser();
		ActivityDTO activity = request.getBody();
		ActivityDetailsEntity entity = new ActivityDetailsEntity();
		entity.setUuid(activity.getUuid());
		entity = activityDAO.getActivityDetails(username, entity);

		activity.setUuid(entity.getUuid());
		activity.setTitle(entity.getTitle());
		activity.setDatetime(formatDate(entity.getDatetime()));
		activity.setAddress(entity.getAddress());
		activity.setVenue(entity.getVenue());
		activity.setDesription(entity.getDescription());
		
		UserDTO user = new UserDTO();
		if(entity.getInitiator()!=null){
			user.setName(entity.getInitiator().getName());
			user.setContactNoHp(entity.getInitiator().getContactHm());
			user.setContactNoOffice(entity.getInitiator().getContactOff());
			user.setEmailAddress(entity.getInitiator().getEmail());			
		}
		activity.setInitiator(user);
		

		return activity;
	}

	@Override
	public ActivityDTO createActivity(RequestDTO<ActivityDTO> request) throws BusinessException {
		String username = request.getHeader().getUser();
		ActivityDTO activity = request.getBody();
		ActivityDetailsEntity entity = new ActivityDetailsEntity();

		entity.setTitle(activity.getTitle());
		entity.setDatetime(parseDate(activity.getDatetime()));
		entity.setAddress(activity.getAddress());
		entity.setVenue(activity.getVenue());
		entity.setDescription(activity.getDesription());

		entity = activityDAO.createActivity(username, entity);
		activity.setUuid(entity.getUuid());

		return activity;
	}

	@Override
	public ActivityDTO modifyActivity(RequestDTO<ActivityDTO> request) throws BusinessException {
		String username = request.getHeader().getUser();
		ActivityDTO activity = request.getBody();
		ActivityDetailsEntity entity = new ActivityDetailsEntity();

		entity.setUuid(activity.getUuid());
		entity.setTitle(activity.getTitle());
		entity.setDatetime(parseDate(activity.getDatetime()));
		entity.setAddress(activity.getAddress());
		entity.setVenue(activity.getVenue());
		entity.setDescription(activity.getDesription());

		entity = activityDAO.modifyActivity(username, entity);

		return activity;
	}

	@Override
	public ActivityDTO deleteActivity(RequestDTO<ActivityDTO> request) throws BusinessException {
		String username = request.getHeader().getUser();
		ActivityDTO activity = request.getBody();
		ActivityEntity entity = new ActivityEntity();

		entity.setUuid(activity.getUuid());
		entity = activityDAO.deleteActivity(username, entity);

		return activity;
	}

	@Override
	public ActivityDTO joinActivity(RequestDTO<ActivityDTO> request) throws BusinessException {
		String username = request.getHeader().getUser();
		ActivityDTO activity = request.getBody();
		ActivityEntity entity = new ActivityEntity();

		entity.setUuid(activity.getUuid());
		entity = activityDAO.joinActivity(username, entity);

		return activity;
	}

	private Date parseDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy-MM-dd HH:mm");
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	private String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy-MM-dd HH:mm");
		return sdf.format(date);
	}

}
