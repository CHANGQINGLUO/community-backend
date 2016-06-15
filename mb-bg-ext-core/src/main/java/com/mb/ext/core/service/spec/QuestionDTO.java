package com.mb.ext.core.service.spec;

public class QuestionDTO extends BodyDTO {

	private static final long serialVersionUID = 1L;

	private String uuid;
	private String question;
	private UserDTO user;
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

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public int getTotalAnswer() {
		return totalAnswer;
	}

	public void setTotalAnswer(int totalAnswer) {
		this.totalAnswer = totalAnswer;
	}

}
