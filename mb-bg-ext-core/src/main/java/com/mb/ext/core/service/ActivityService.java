package com.mb.ext.core.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mb.ext.core.service.spec.ActivityDTO;
import com.mb.ext.core.service.spec.BodyDTO;
import com.mb.ext.core.service.spec.HeaderDTO;
import com.mb.ext.core.service.spec.RequestDTO;
import com.mb.framework.exception.BusinessException;

@Transactional
public interface ActivityService<T extends BodyDTO> {

	public List<ActivityDTO> getAllActivies(HeaderDTO header) throws BusinessException;

	public List<ActivityDTO> getInitiateActivities(HeaderDTO header) throws BusinessException;

	public List<ActivityDTO> getJoinedActivities(HeaderDTO header) throws BusinessException;

	public ActivityDTO getActivityDetails(RequestDTO<ActivityDTO> request) throws BusinessException;

	public ActivityDTO createActivity(RequestDTO<ActivityDTO> request) throws BusinessException;

	public ActivityDTO modifyActivity(RequestDTO<ActivityDTO> request) throws BusinessException;

	public ActivityDTO deleteActivity(RequestDTO<ActivityDTO> request) throws BusinessException;

	public ActivityDTO joinActivity(RequestDTO<ActivityDTO> request) throws BusinessException;

}
