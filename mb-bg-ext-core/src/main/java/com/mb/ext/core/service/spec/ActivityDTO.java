package com.mb.ext.core.service.spec;

public class ActivityDTO extends BodyDTO {

	private static final long serialVersionUID = 1L;

	private String uuid;
	private String time;
	private String title;
	private String desription;
	private UserDTO initiator;
	private String address;
	private String venue;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesription() {
		return desription;
	}

	public void setDesription(String desription) {
		this.desription = desription;
	}

	public UserDTO getInitiator() {
		return initiator;
	}

	public void setInitiator(UserDTO initiator) {
		this.initiator = initiator;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

}
