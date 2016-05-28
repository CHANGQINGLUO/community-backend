/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 27 Apr, 2015 
 * @author SPA
 * @mb-bg-ext-core
 *
 */
/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 27 Apr, 2015 
 * @author SPA
 * @mb-bg-ext-core
 * UserDAOImpl.java
 *
 */
package com.mb.ext.core.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.mb.ext.core.dao.UserDAO;
import com.mb.ext.core.entity.UserEntity;
import com.mb.framework.dao.AbstractDAO;
import com.mb.framework.exception.DAOException;
import com.mb.framework.util.log.LogHelper;

/**
 * @author SPA
 * 
 */
@Repository("userDAO")
@Qualifier("userDAO")
public class UserDAOImpl extends AbstractDAO<UserEntity> implements UserDAO
{
	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	/**
	 * Initializing Entity.
	 */
	public UserDAOImpl()
	{
		super();
		this.setEntityClass(UserEntity.class);
	}

	/**
	 * This method is used for inserting user information.
	 * 
	 * @param user
	 */
	@Override
	public void addUser(UserEntity user)
	{
		save(user);
		logger.debug("The user added is " + user.getUserUuid());
	}
	
	/**
	 * @param email
	 * @return 
	 * @throws Exception
	 */
	@Override
	public UserEntity getUser(String email) throws DAOException {
		logger.debug("UserDAOImpl - retrieve user according email address.");
		UserEntity entity = null;
		try {
			entity = (UserEntity)em.createQuery("select b from UserEntity b where b.email = :EMAIL and b.isDeleted=:isDeleted",UserEntity.class).setParameter("EMAIL", email).setParameter("isDeleted", Boolean.FALSE).getSingleResult();
		} catch (NoResultException e) {
			logger.info("No record found for user.");
		}
		return entity;
	}

}
