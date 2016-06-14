package com.mb.ext.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.mb.framework.entity.AbstractBaseEntity;

@Entity
@Table(name = "UserActivity")
public class UserActivityEntity extends AbstractBaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "uuid")
	@Column(name = "UUID", nullable = false, length = 100)
	private String uuid;

	@Column(name = "activity_uuid")
	private String activityUuid;

	@Column(name = "user_uuid")
	private String userUuid;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getActivityUuid() {
		return activityUuid;
	}

	public void setActivityUuid(String activityUuid) {
		this.activityUuid = activityUuid;
	}

	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

}