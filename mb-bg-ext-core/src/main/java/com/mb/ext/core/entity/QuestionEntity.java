package com.mb.ext.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JoinFormula;

import com.mb.framework.entity.AbstractBaseEntity;

@Entity
@Table(name = "Question")
public class QuestionEntity extends AbstractBaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "uuid")
	@Column(name = "UUID", nullable = false, length = 100)
	private String uuid;

	@Column(name = "question")
	private String question;

	@OneToOne
	@JoinColumn(name = "user_uuid")
	private UserEntity user;

	@Formula("(select count(*) from Answer a where a.question_Uuid = uuid)")
	private int totalAnswer;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public int getTotalAnswer() {
		return totalAnswer;
	}

	public void setTotalAnswer(int totalAnswer) {
		this.totalAnswer = totalAnswer;
	}

}