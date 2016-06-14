/**
 * Copyright (C) 2014 My Company. All Rights Reserved. 
 * 
 * This software is the proprietary information of Company . 
 * Use is subjected to license terms. 
 *
 * @since 23 Jun, 2014 6:04:01 pm
 * @author SPA
 * @mb-bg-ext-web
 *
 */
package com.mb.ext.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mb.ext.core.service.ExampleService;
import com.mb.ext.core.service.spec.BodyDTO;
import com.mb.ext.core.service.spec.CaseHeaderDTO;
import com.mb.ext.core.service.spec.HeaderDTO;
import com.mb.ext.core.service.spec.RequestDTO;
import com.mb.ext.core.service.spec.UserDTO;
import com.mb.ext.web.controller.ExampleController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestRestServiceWebConfig.class})
public class ExampleControllerTest
{

	private MockMvc mockMvc;

	@InjectMocks
	private ExampleController epController;

	
	@Mock
	private ExampleService<BodyDTO> exampleService;

	/**
	 * 
	 * This method is used for initializing the mock controller
	 */
	@Before
	public void setUp()
	{

		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(epController).build();

	}

	/**
	 * 
	 * This method is used for testing controller post method.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCreate() throws Exception
	{
		RequestDTO request = createRequest();

		this.mockMvc.perform(post("/example").contentType(MediaType.APPLICATION_JSON).content(TestUtil.fromJavaToJson(request))).andExpect(status().isCreated());

	}

	/**
	 * 
	 * This method is used to create mock request.
	 * 
	 * @return
	 */
	private RequestDTO createRequest()
	{
		String userName = "testUser";

		RequestDTO request = new RequestDTO();
/*
		HeaderDTO header = new HeaderDTO();
		header.setAppName("test");
		header.setCustomerEmailToSend("testUser.gmail.com");
		header.setRequestType("save");
		header.setUser(userName);
		request.setHeader(header);

		BodyDTO body = new BodyDTO();

		CaseHeaderDTO caseHeader = new CaseHeaderDTO();
		caseHeader.setIsChineseLang("false");
		caseHeader.setReferenceNumber("5657");
		caseHeader.setKeyApplicantIndex("0");

		body.setCaseHeader(caseHeader);
*/
		/*CustomerDTO customerDetails = new CustomerDTO();
		customerDetails.setContactNoHome("567-7658");
		customerDetails.setContactNoHp("5676-8077");
		customerDetails.setContactNoOffice("5670-9879");
		customerDetails.setDateOfBirth("02-02-1989");
		customerDetails.setEmailAddress("testUser@gmail.com");
		customerDetails.setGender("M");
		//customerDetails.setMaritalStatus("M");
		customerDetails.setRace("IND");
		customerDetails.setIdentityCardNo("G5675765");
		//customerDetails.setIncomeTotal("5657.89");
		customerDetails.setName("Test");
		customerDetails.setNationality("Indian");
		customerDetails.setSalutation("MR");*/

		//body.setCustomerDetails(customerDetails);

		UserDTO userDetails = new UserDTO();
		userDetails.setContactNoHp("5678-5769");
		userDetails.setContactNoOffice("5768-7890");
		userDetails.setEmailAddress("testUser@gmail.com");
		userDetails.setName("TestUser");

		//body.setUserDetails(userDetails);

		

		
		//body.setYrcOutput(yrcOutput);
		//request.setBody(body);

		return request;
	}

}
