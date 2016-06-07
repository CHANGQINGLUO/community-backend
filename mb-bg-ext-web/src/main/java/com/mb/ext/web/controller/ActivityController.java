package com.mb.ext.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mb.ext.core.service.ExampleService;
import com.mb.ext.core.service.spec.ActivityDTO;
import com.mb.ext.core.service.spec.BodyDTO;
import com.mb.ext.core.service.spec.RequestDTO;
import com.mb.ext.core.service.spec.ResponseDTO;
import com.mb.ext.core.service.spec.StatusDTO;
import com.mb.ext.core.service.spec.UserDTO;
import com.mb.framework.util.log.LogHelper;
import com.mb.framework.util.property.PropertyRepository;
import com.mb.framework.web.common.RestPreconditions;

@Controller
public class ActivityController {
	private LogHelper logger = LogHelper.getInstance(this.getClass().getName());

	@RequestMapping(value = "/getAllActivies", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseDTO<List<ActivityDTO>> getAllActivies(@RequestBody RequestDTO<String> request) {
		ResponseDTO<List<ActivityDTO>> response = new ResponseDTO<List<ActivityDTO>>();
		response.setHeader(request.getHeader());
		StatusDTO status = new StatusDTO();
		status.setStatuscode("0");
		status.setStatusdesc("Success");
		response.setStatus(status);
		try {
			ActivityDTO activity = new ActivityDTO();
			activity.setUuid("12345");
			activity.setAddress("address");
			activity.setTime("2016-06-07 19:00");
			UserDTO user= new UserDTO();
			user.setName("stan");
			user.setContactNoHp("123456");
			user.setContactNoOffice("23456");
			user.setEmailAddress("abc@gmail.com");
			activity.setInitiator(user);
			activity.setTitle("aaaaaaaa");
			activity.setVenue("googog");
			List<ActivityDTO> list=new ArrayList<ActivityDTO>();
			list.add(activity);
			response.setBody(list);
		} catch (Exception e) {
			logger.error("Exception occurred in getAllActivies", e);
			response.getStatus().setStatuscode("2");
			response.getStatus().setStatusdesc("Failed");
		}

		return response;
	}
	
	@RequestMapping(value = "/getInitiateActivities", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseDTO<List<ActivityDTO>> getInitiateActivities(@RequestBody RequestDTO<String> request) {
		ResponseDTO<List<ActivityDTO>> response = new ResponseDTO<List<ActivityDTO>>();
		response.setHeader(request.getHeader());
		StatusDTO status = new StatusDTO();
		status.setStatuscode("0");
		status.setStatusdesc("Success");
		response.setStatus(status);
		try {
			ActivityDTO activity = new ActivityDTO();
			activity.setUuid("12345");
			activity.setAddress("address");
			activity.setTime("2016-06-07 19:00");
			UserDTO user= new UserDTO();
			user.setName("stan");
			user.setContactNoHp("123456");
			user.setContactNoOffice("23456");
			user.setEmailAddress("abc@gmail.com");
			activity.setInitiator(user);
			activity.setTitle("aaaaaaaa");
			activity.setVenue("googog");
			List<ActivityDTO> list=new ArrayList<ActivityDTO>();
			list.add(activity);
			response.setBody(list);
		} catch (Exception e) {
			logger.error("Exception occurred in getInitiateActivities", e);
			response.getStatus().setStatuscode("2");
			response.getStatus().setStatusdesc("Failed");
		}

		return response;
	}
	
	@RequestMapping(value = "/getJoinedActivities", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseDTO<List<ActivityDTO>> getJoinedActivities(@RequestBody RequestDTO<String> request) {
		ResponseDTO<List<ActivityDTO>> response = new ResponseDTO<List<ActivityDTO>>();
		response.setHeader(request.getHeader());
		StatusDTO status = new StatusDTO();
		status.setStatuscode("0");
		status.setStatusdesc("Success");
		response.setStatus(status);
		try {
			ActivityDTO activity = new ActivityDTO();
			activity.setUuid("12345");
			activity.setAddress("address");
			activity.setTime("2016-06-07 19:00");
			UserDTO user= new UserDTO();
			user.setName("stan");
			user.setContactNoHp("123456");
			user.setContactNoOffice("23456");
			user.setEmailAddress("abc@gmail.com");
			activity.setInitiator(user);
			activity.setTitle("aaaaaaaa");
			activity.setVenue("googog");
			List<ActivityDTO> list=new ArrayList<ActivityDTO>();
			list.add(activity);
			response.setBody(list);
		} catch (Exception e) {
			logger.error("Exception occurred in getJoinedActivities", e);
			response.getStatus().setStatuscode("2");
			response.getStatus().setStatusdesc("Failed");
		}

		return response;
	}
	
	@RequestMapping(value = "/getActivityDetails", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseDTO<ActivityDTO> getActivityDetails(@RequestBody RequestDTO<ActivityDTO> request) {
		ResponseDTO<ActivityDTO> response = new ResponseDTO<ActivityDTO>();
		response.setHeader(request.getHeader());
		StatusDTO status = new StatusDTO();
		status.setStatuscode("0");
		status.setStatusdesc("Success");
		response.setStatus(status);
		try {
			ActivityDTO activity = new ActivityDTO();
			activity.setUuid("12345");
			activity.setAddress("address");
			activity.setTime("2016-06-07 19:00");
			UserDTO user= new UserDTO();
			user.setName("stan");
			user.setContactNoHp("123456");
			user.setContactNoOffice("23456");
			user.setEmailAddress("abc@gmail.com");
			activity.setInitiator(user);
			activity.setTitle("aaaaaaaa");
			activity.setVenue("googog");
			activity.setDesription("oooooooooooooooooooooooooooooooooo");
			response.setBody(activity);
		} catch (Exception e) {
			logger.error("Exception occurred in getActivityDetails", e);
			response.getStatus().setStatuscode("2");
			response.getStatus().setStatusdesc("Failed");
		}

		return response;
	}
	
	@RequestMapping(value = "/createActivity", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseDTO<ActivityDTO> createActivity(@RequestBody RequestDTO<ActivityDTO> request) {
		ResponseDTO<ActivityDTO> response = new ResponseDTO<ActivityDTO>();
		response.setHeader(request.getHeader());
		StatusDTO status = new StatusDTO();
		status.setStatuscode("0");
		status.setStatusdesc("Success");
		response.setStatus(status);
		try {
			ActivityDTO activity = new ActivityDTO();
			activity.setUuid("12345");
			activity.setAddress("address");
			activity.setTime("2016-06-07 19:00");
			UserDTO user= new UserDTO();
			user.setName("stan");
			user.setContactNoHp("123456");
			user.setContactNoOffice("23456");
			user.setEmailAddress("abc@gmail.com");
			activity.setInitiator(user);
			activity.setTitle("aaaaaaaa");
			activity.setVenue("googog");
			activity.setDesription("oooooooooooooooooooooooooooooooooo");
			response.setBody(activity);
		} catch (Exception e) {
			logger.error("Exception occurred in createActivity", e);
			response.getStatus().setStatuscode("2");
			response.getStatus().setStatusdesc("Failed");
		}

		return response;
	}
	
	@RequestMapping(value = "/modifyActivity", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseDTO<ActivityDTO> modifyActivity(@RequestBody RequestDTO<ActivityDTO> request) {
		ResponseDTO<ActivityDTO> response = new ResponseDTO<ActivityDTO>();
		response.setHeader(request.getHeader());
		StatusDTO status = new StatusDTO();
		status.setStatuscode("0");
		status.setStatusdesc("Success");
		response.setStatus(status);
		try {
			ActivityDTO activity = new ActivityDTO();
			activity.setUuid("12345");
			activity.setAddress("address");
			activity.setTime("2016-06-07 19:00");
			UserDTO user= new UserDTO();
			user.setName("stan");
			user.setContactNoHp("123456");
			user.setContactNoOffice("23456");
			user.setEmailAddress("abc@gmail.com");
			activity.setInitiator(user);
			activity.setTitle("aaaaaaaa");
			activity.setVenue("googog");
			activity.setDesription("oooooooooooooooooooooooooooooooooo");
			response.setBody(activity);
		} catch (Exception e) {
			logger.error("Exception occurred in modifyActivity", e);
			response.getStatus().setStatuscode("2");
			response.getStatus().setStatusdesc("Failed");
		}

		return response;
	}
	
	@RequestMapping(value = "/deleteActivity", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseDTO<ActivityDTO> deleteActivity(@RequestBody RequestDTO<ActivityDTO> request) {
		ResponseDTO<ActivityDTO> response = new ResponseDTO<ActivityDTO>();
		response.setHeader(request.getHeader());
		StatusDTO status = new StatusDTO();
		status.setStatuscode("0");
		status.setStatusdesc("Success");
		response.setStatus(status);
		try {
			ActivityDTO activity = new ActivityDTO();
			activity.setUuid("12345");
			activity.setAddress("address");
			activity.setTime("2016-06-07 19:00");
			UserDTO user= new UserDTO();
			user.setName("stan");
			user.setContactNoHp("123456");
			user.setContactNoOffice("23456");
			user.setEmailAddress("abc@gmail.com");
			activity.setInitiator(user);
			activity.setTitle("aaaaaaaa");
			activity.setVenue("googog");
			activity.setDesription("oooooooooooooooooooooooooooooooooo");
			response.setBody(activity);
		} catch (Exception e) {
			logger.error("Exception occurred in getActivityList", e);
			response.getStatus().setStatuscode("2");
			response.getStatus().setStatusdesc("Failed");
		}

		return response;
	}
	
	@RequestMapping(value = "/joinActivity", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseDTO<ActivityDTO> joinActivity(@RequestBody RequestDTO<ActivityDTO> request) {
		ResponseDTO<ActivityDTO> response = new ResponseDTO<ActivityDTO>();
		response.setHeader(request.getHeader());
		StatusDTO status = new StatusDTO();
		status.setStatuscode("0");
		status.setStatusdesc("Success");
		response.setStatus(status);
		try {
			ActivityDTO activity = new ActivityDTO();
			activity.setUuid("12345");
			activity.setAddress("address");
			activity.setTime("2016-06-07 19:00");
			UserDTO user= new UserDTO();
			user.setName("stan");
			user.setContactNoHp("123456");
			user.setContactNoOffice("23456");
			user.setEmailAddress("abc@gmail.com");
			activity.setInitiator(user);
			activity.setTitle("aaaaaaaa");
			activity.setVenue("googog");
			activity.setDesription("oooooooooooooooooooooooooooooooooo");
			response.setBody(activity);
		} catch (Exception e) {
			logger.error("Exception occurred in modifyActivity", e);
			response.getStatus().setStatuscode("2");
			response.getStatus().setStatusdesc("Failed");
		}

		return response;
	}
	

}
