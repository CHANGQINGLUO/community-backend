/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
* @since 27 Apr, 2015 
 * @author SPA
 * @mb-bg-ext-web
 *
 */
/**
 * 
 */
package com.mb.ext.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mb.ext.core.entity.UserEntity;
import com.mb.ext.core.message.ErrorCode;
import com.mb.ext.core.service.ExampleService;
import com.mb.ext.core.service.spec.BodyDTO;
import com.mb.ext.core.service.spec.HeaderDTO;
import com.mb.ext.core.service.spec.RequestDTO;
import com.mb.ext.core.service.spec.ResultDTO;
import com.mb.ext.core.service.spec.SaveResultDTO;
import com.mb.framework.exception.BusinessException;
import com.mb.framework.util.log.LogHelper;
import com.mb.framework.util.property.PropertyRepository;
import com.mb.framework.web.common.RestPreconditions;

/**
 * @author SPA
 * 
 */

@Controller
@RequestMapping("/sgEduPlanner")
public class ExampleController
{
	private LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	@Autowired
	@Qualifier("ExampleService")
	private ExampleService<BodyDTO> exampleService;

	@Autowired
	private PropertyRepository propertyRepository;

	/**
	 * 
	 * This method is used for saving
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/example",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	// http://localhost:8080/mb-bg-ext-web/rest/example
	public SaveResultDTO create(@RequestBody
	RequestDTO request)
	{
		SaveResultDTO result = null;
		String accesinfoId = "";
		try
		{
			RestPreconditions.checkRequestElementNotNull(request.getBody());
			HeaderDTO header = request.getHeader();
			// check if for sending mail
			if (!header.getRequestType().isEmpty() && "save".equals(request.getHeader().getRequestType()))
			{
				logger.debug("added for" + request.getHeader().getCustomerName());

				accesinfoId = exampleService.addEPDetails(request.getBody(), request.getHeader());
				result = new SaveResultDTO(ErrorCode.SUCCESS_CD,accesinfoId, ErrorCode.SUCCESS_MSG);
				
			}
			else
			{
				result = new SaveResultDTO(ErrorCode.WRNG_RQST_CD,accesinfoId, ErrorCode.WRNG_RQST_MSG);
			}
			logger.info("Status of request for saving  is"+result.getCode()+result.getMessage());
		}
		catch (BusinessException e)
		{
			logger.error("Exception occurred in saving the details", e);
			result = new SaveResultDTO(e.getMessage(),accesinfoId, propertyRepository.getProperty(ErrorCode.ERROR_RC_INSERT_MSG));
			logger.info("Status of request for saving is"+result.getCode()+result.getMessage());
		}

		return result;
	}

}
