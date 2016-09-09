package com.wells.giftkart.validator;

import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.wells.giftkart.valueobject.User;

public class RegistrationValidator implements Validator{
	public static Logger logger=Logger.getLogger(RegistrationValidator.class);
	@Override
	public boolean supports(Class userClass) {
		
		return User.class.isAssignableFrom(userClass);
	}
	
	public void validate(Object userForm, Errors errors) 
	{
		logger.info(" validate() started ");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userForm.userId", "errors.userId", "user id is required.");
		logger.info(" validate() end ");
	};
}
