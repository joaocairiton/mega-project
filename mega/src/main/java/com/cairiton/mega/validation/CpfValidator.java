package com.cairiton.mega.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class CpfValidator implements ConstraintValidator<ValidaCpf, String>{

	@Override
	public boolean isValid(String conteudo, ConstraintValidatorContext context) {
		String regex = "([0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}-[0-9]{2})|([0-9]{11})";
				/*+ "^(?:(?!000\\.?000\\.?000-?00).)*$,"
				+ "^(?:(?!111\\.?111\\.?111-?11).)*$,"
				+ "^(?:(?!222\\.?222\\.?222-?22).)*$,"
				+ "^(?:(?!333\\.?333\\.?333-?33).)*$,"
				+ "^(?:(?!444\\.?444\\.?444-?44).)*$,"
				+ "";*/
		
			
	
		
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(conteudo);
		return matcher.matches();
	}

}
