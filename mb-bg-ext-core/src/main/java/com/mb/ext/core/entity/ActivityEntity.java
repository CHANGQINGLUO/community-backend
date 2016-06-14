package com.mb.ext.core.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.mb.framework.entity.AbstractBaseEntity;

@Entity
@Table(name = "Activity")
public class ActivityEntity extends AbstractBaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "uuid")
	@Column(name = "UUID", nullable = false, length = 100)
	private String uuid;

	@Column(name = "title")
	private String title;

	@Column(name = "datetime")
	private Date datetime;

	@Column(name = "address")
	private String address;

	@Column(name = "initiator")
	private String initiatorUuid;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getInitiatorUuid() {
		return initiatorUuid;
	}

	public void setInitiatorUuid(String initiatorUuid) {
		this.initiatorUuid = initiatorUuid;
	}

}