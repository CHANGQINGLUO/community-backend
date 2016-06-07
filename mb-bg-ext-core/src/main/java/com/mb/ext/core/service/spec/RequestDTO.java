/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 23 Jun, 2014 3:22:46 pm
 * @author SPA
 * @mb-bg-ext-core
 *
 */
package com.mb.ext.core.service.spec;

import com.mb.framework.service.spec.AbstractBaseDTO;

public class RequestDTO<T> extends AbstractBaseDTO
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5069755318813643726L;

	private HeaderDTO header;

	private T body;

	/**
	 * @return the header
	 */
	public HeaderDTO getHeader()
	{
		return header;
	}

	/**
	 * @param header
	 *            the header to set
	 */
	public void setHeader(HeaderDTO header)
	{
		this.header = header;
	}

	/**
	 * @return the body
	 */
	public T getBody()
	{
		return body;
	}

	/**
	 * @param body
	 *            the body to set
	 */
	public void setBody(T body)
	{
		this.body = body;
	}

}
