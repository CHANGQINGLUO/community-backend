/**
 * Copyright (C) 2013 Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since Jul 14, 2013 8:27:56 PM
 * @author SPA

 *
 */
package com.mb.framework.util;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.codehaus.jackson.map.ObjectMapper;

import com.mb.framework.util.log.LogHelper;

public class ObjectUtil
{
	private LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	/**
	 * This method is used for converting object to string
	 * 
	 * @param obj
	 * @return
	 */
	public static String objectToString(Object obj)
	{
		return ReflectionToStringBuilder.toString(obj);
	}

	/**
	 * 
	 * This method is used for converting the object to json string.
	 * 
	 * @param obj
	 * @return
	 */
	public static String objectToJsonString(Object obj)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		String resp = null;
		try
		{

			resp = objectMapper.writeValueAsString(obj);

		}
		catch (Exception e)
		{

		}
		return resp;
	}

}
