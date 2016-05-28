package com.mb.ext.core.service.impl;


import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mb.ext.core.service.ExampleService;
import com.mb.ext.core.service.spec.UserDTO;
import com.mb.framework.entity.MessageEntity;
import com.mb.framework.service.MessageService;
import com.mb.framework.util.log.LogHelper;


/**
 * 
 * @author SPA
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/00-context-core-index.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExmapleServiceImplTest {

	private final LogHelper logger = LogHelper.getInstance(this.getClass().getName());
	
	@Autowired
	public ExampleService<?> exampleService;
	
	/**
	 * 
	 * This method is used for test add Message entity
	 */
	@Test
	public void test1AddUser()
	{
		try{
			
		UserDTO dto = new UserDTO();
		dto.setContactNoHp("90029605");
		dto.setEmailAddress("abc.gmail.com");
		dto.setName("CPA");
		
		String uuid = exampleService.addUser(dto);
		Assert.assertNotNull(uuid);
		
		}catch(Exception ex){
			logger.error("Failed to add MessageEntity", ex);
		}
	}
	
}
