package com.mb.ext.core.dao;

import java.util.List;

import com.mb.ext.core.entity.ActivityDetailsEntity;
import com.mb.ext.core.entity.ActivityEntity;
import com.mb.framework.exception.BusinessException;

public interface ActivityDAO {
	public List<ActivityEntity> getAllActivies() throws BusinessException;

	public List<ActivityEntity> getInitiateActivities(String username) throws BusinessException;

	public List<ActivityEntity> getJoinedActivities(String username) throws BusinessException;

	public ActivityDetailsEntity getActivityDetails(String username, ActivityDetailsEntity activity) throws BusinessException;

	public ActivityDetailsEntity createActivity(String username, ActivityDetailsEntity actiActivityDetailsEntityvity) throws BusinessException;

	public ActivityDetailsEntity modifyActivity(String username, ActivityDetailsEntity activity) throws BusinessException;

	public ActivityEntity deleteActivity(String username, ActivityEntity activity) throws BusinessException;

	public ActivityEntity joinActivity(String username, ActivityEntity activity) throws BusinessException;
}
