package com.mb.ext.core.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.mb.framework.entity.AbstractBaseEntity;

/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name = "USERS")
@NamedQuery(name = "UserEntity.findAll", query = "SELECT u FROM UserEntity u")
public class UserEntity extends AbstractBaseEntity
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "USER_UUID")
	@GenericGenerator(name = "USER_UUID", strategy = "uuid")
	@Column(name = "USER_UUID", nullable = false, length = 100)
	private String userUuid;

	@Column(name = "CONTACT_HM", length = 20)
	private String contactHm;

	@Column(name = "CONTACT_OFF", length = 20)
	private String contactOff;

	@Column(length = 100)
	private String email;

	@Column(nullable = false, length = 100)
	private String name;

	
	/**
	 * @return the userUuid
	 */
	public String getUserUuid()
	{
		return userUuid;
	}

	/**
	 * @param userUuid
	 *            the userUuid to set
	 */
	public void setUserUuid(String userUuid)
	{
		this.userUuid = userUuid;
	}

	/**
	 * @return the contactHm
	 */
	public String getContactHm()
	{
		return contactHm;
	}

	/**
	 * @param contactHm
	 *            the contactHm to set
	 */
	public void setContactHm(String contactHm)
	{
		this.contactHm = contactHm;
	}

	/**
	 * @return the contactOff
	 */
	public String getContactOff()
	{
		return contactOff;
	}

	/**
	 * @param contactOff
	 *            the contactOff to set
	 */
	public void setContactOff(String contactOff)
	{
		this.contactOff = contactOff;
	}

	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

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

	

	
}