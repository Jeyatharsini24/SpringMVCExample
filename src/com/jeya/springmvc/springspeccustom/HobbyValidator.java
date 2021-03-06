package com.jeya.springmvc.springspeccustom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbyValidator implements ConstraintValidator<IsValidHobby, String> {
	// a custom annotation class uses isValid method to validate input. before
	// call
	// isValid function, it calls initialize method

	private String listOfValidHobbies;

	@Override
	public void initialize(IsValidHobby isValidHobby) {
		listOfValidHobbies = isValidHobby.listOfValidHobbies();
	}

	@Override
	public boolean isValid(String studentHobby, ConstraintValidatorContext ctx) {
		if (studentHobby == null) {
			return false;
		}
		if (studentHobby.matches(listOfValidHobbies)) {
			return true;
		} else
			return false;
	}
}