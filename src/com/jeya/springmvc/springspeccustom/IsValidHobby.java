package com.jeya.springmvc.springspeccustom;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = HobbyValidator.class) // use this class to validate user input
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidHobby { // name of the annotation
	String listOfValidHobbies() default "Music|Football|Cricket|Hockey";
	// type of parameter to accept is String
	// if we don't put default, parameter to specify inside isValidHobby annotation is mandatory
	// Having default makes that parameter as optional
	
	String message() default "Please provide a valid Hobby; "
			+ "accepted hobbies are - Music, Football, Cricket and Hockey (choose anyone)";
	// message to show
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}