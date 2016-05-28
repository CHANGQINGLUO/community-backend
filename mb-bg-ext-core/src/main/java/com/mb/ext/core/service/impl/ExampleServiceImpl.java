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
package com.mb.ext.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mb.ext.core.dao.UserDAO;
import com.mb.ext.core.entity.UserEntity;
import com.mb.ext.core.message.ErrorCode;
import com.mb.ext.core.service.ExampleService;
import com.mb.ext.core.service.spec.BodyDTO;
import com.mb.ext.core.service.spec.HeaderDTO;
import com.mb.ext.core.service.spec.UserDTO;
import com.mb.ext.core.util.EPMapperUtil;
import com.mb.framework.exception.BusinessException;
import com.mb.framework.service.AbstractService;
import com.mb.framework.util.log.LogHelper;


@Service
@Qualifier("ExampleService")
public class ExampleServiceImpl extends AbstractService implements ExampleService<BodyDTO>
{
	@Autowired
	@Qualifier("userDAO")
	private UserDAO userDAO;
	
	
	@Autowired
	private EPMapperUtil epMapperUtil;

	
	
	
	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	/**
	 * This method is used for inserting all the customerdetails
	 * information.
	 * 
	 * @param body
	 */
	@SuppressWarnings("finally")
	@Override
	public String addEPDetails(BodyDTO body, HeaderDTO header) throws BusinessException{
		
		
		UserEntity user = null;
		String accessInfoId = "";
		try
		{
			//check user is present or not 
			user = userDAO.getUser(body.getUserDetails().getEmailAddress());
			if(null == user){
				// map user DTO to entity
				user = epMapperUtil.createUserEntity(body.getUserDetails(), header.getUser());
				// add user details
				userDAO.addUser(user);
			}
			
			
			
		}catch (Exception e){
				logger.error("Exception occurred in saving user details", e);
				throw new BusinessException(ErrorCode.ERROR_RC_INSERT);
		}finally{
			return accessInfoId;
		}
		
	}

	@SuppressWarnings("finally")
	@Override
	public String addUser(UserDTO userDTO) throws BusinessException {
		UserEntity user = null;
		try
		{
			if(null == user){
				user = epMapperUtil.createUserEntity(userDTO, userDTO.getName());
				userDAO.addUser(user);
			}
			
			
		}catch (Exception e){
				logger.error("Exception occurred in saving user details", e);
				throw new BusinessException(ErrorCode.ERROR_RC_INSERT);
		}finally{
			return user!=null?user.getUserUuid():null;
		}
	}
	

}






