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
 * UserDTO.java
 *
 */
package com.mb.ext.core.service.spec;

import com.mb.framework.service.spec.AbstractBaseDTO;

/**
 * @author SPA
 * 
 */
public class UserDTO extends AbstractBaseDTO
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1370446594187372075L;

	private String name;

	private String contactNoHp;

	private String contactNoOffice;

	private String emailAddress;

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the contactNoHp
	 */
	public String getContactNoHp()
	{
		return contactNoHp;
	}

	/**
	 * @param contactNoHp
	 *            the contactNoHp to set
	 */
	public void setContactNoHp(String contactNoHp)
	{
		this.contactNoHp = contactNoHp;
	}

	/**
	 * @return the contactNoOffice
	 */
	public String getContactNoOffice()
	{
		return contactNoOffice;
	}

	/**
	 * @param contactNoOffice
	 *            the contactNoOffice to set
	 */
	public void setContactNoOffice(String contactNoOffice)
	{
		this.contactNoOffice = contactNoOffice;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress()
	{
		return emailAddress;
	}

	/**
	 * @param emailAddress
	 *            the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}

}
