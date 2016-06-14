package com.mb.ext.core.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mb.ext.core.dao.ActivityDAO;
import com.mb.ext.core.entity.ActivityDetailsEntity;
import com.mb.ext.core.entity.ActivityEntity;
import com.mb.ext.core.entity.UserActivityEntity;
import com.mb.ext.core.entity.UserEntity;
import com.mb.framework.dao.AbstractDAO;
import com.mb.framework.exception.BusinessException;
import com.mb.framework.util.log.LogHelper;

@Repository("activityDAO")
@Qualifier("activityDAO")
public class ActivityDAOImpl extends AbstractDAO<ActivityEntity> implements ActivityDAO {
	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	public ActivityDAOImpl() {
		super();
		this.setEntityClass(ActivityEntity.class);
	}

	@Override
	public List<ActivityEntity> getAllActivies() throws BusinessException {
		List<ActivityEntity> list = null;
		list = em.createQuery("SELECT e FROM ActivityEntity e", ActivityEntity.class).getResultList();
		return list;
	}

	@Override
	public List<ActivityEntity> getInitiateActivities(String username) throws BusinessException {
		List<ActivityEntity> list = null;
		list = em.createQuery("SELECT e FROM ActivityEntity e, UserEntity e1 where e.initiatorUuid = e1.userUuid and e1.name = :username", ActivityEntity.class).setParameter("username", username).getResultList();
		return list;
	}

	@Override
	public List<ActivityEntity> getJoinedActivities(String username) throws BusinessException {
		List<ActivityEntity> list = null;
		list = em.createQuery("SELECT e FROM ActivityEntity e, UserActivityEntity e1, UserEntity e2 where e.uuid = e1.activityUuid and e1.userUuid = e2.userUuid and e2.name = :username", ActivityEntity.class).setParameter("username", username).getResultList();
		return list;
	}

	@Override
	public ActivityDetailsEntity getActivityDetails(String username, ActivityDetailsEntity activity) throws BusinessException {
		ActivityDetailsEntity entity = em.createQuery("SELECT e FROM ActivityDetailsEntity e where e.uuid =:uuid", ActivityDetailsEntity.class).setParameter("uuid", activity.getUuid()).getResultList().get(0);
		return entity;
	}

	@Override
	public ActivityDetailsEntity createActivity(String username, ActivityDetailsEntity activity) throws BusinessException {
		UserEntity user = em.createQuery("select e from UserEntity e where e.name =:username", UserEntity.class).setParameter("username", username).getResultList().get(0);
		activity.setInitiator(user);
		em.persist(activity);
		
		return activity;
	}

	@Override
	public ActivityDetailsEntity modifyActivity(String username, ActivityDetailsEntity activity) throws BusinessException {
		ActivityDetailsEntity entity = em.createQuery("SELECT e1 FROM ActivityDetailsEntity e1, UserEntity e2 where e1.initiator.userUuid = e2.userUuid and e2.name = :username and e1.uuid =:uuid", ActivityDetailsEntity.class).setParameter("uuid", activity.getUuid()).setParameter("username", username).getResultList().get(0);
		entity.setTitle(activity.getTitle());
		entity.setDatetime(activity.getDatetime());
		entity.setAddress(activity.getAddress());
		entity.setVenue(activity.getVenue());
		entity.setDescription(activity.getDescription());
		
		activity = em.merge(entity);
		return entity;
	}

	@Override
	public ActivityEntity deleteActivity(String username, ActivityEntity activity) throws BusinessException {
		 
		ActivityEntity entity = em.createQuery("SELECT e1 FROM ActivityEntity e1, UserEntity e2 where e1.initiatorUuid = e2.userUuid and e2.name = :username and e1.uuid =:uuid", ActivityEntity.class).setParameter("uuid", activity.getUuid()).setParameter("username", username).getResultList().get(0);
		List<UserActivityEntity> list =em.createQuery("SELECT e from UserActivityEntity e where e.activityUuid =:activityUuid", UserActivityEntity.class).setParameter("activityUuid", entity.getUuid()).getResultList();
		for(int i=0; list!=null && i <list.size(); i++){
			em.remove(list.get(i));
		}
		em.remove(entity);
		return activity;
	}

	@Override
	public ActivityEntity joinActivity(String username, ActivityEntity activity) throws BusinessException {
		UserEntity user = em.createQuery("select e from UserEntity e where e.name =:username", UserEntity.class).setParameter("username", username).getResultList().get(0);
		List<UserActivityEntity> list = em.createQuery("SELECT e1 FROM ActivityEntity e, UserActivityEntity e1 where e.uuid = e1.activityUuid and e.uuid =:uuid and e1.userUuid =:userUuid", UserActivityEntity.class).setParameter("uuid", activity.getUuid()).setParameter("userUuid", user.getUserUuid()).getResultList();
		if(list ==null || list.isEmpty()){
			UserActivityEntity entity = new UserActivityEntity();
			entity.setActivityUuid(activity.getUuid());
			entity.setUserUuid(user.getUserUuid());
			em.persist(entity);
		}
		
		
		return activity;
	}

}
