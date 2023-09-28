package com.cairiton.mega.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CepValidator implements ConstraintValidator<ValidaCep, String>{

	@Override
	public boolean isValid(String conteudo, ConstraintValidatorContext context) {
		String regex = "(^\\d{2}.\\d{3}-\\d{3}$)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(conteudo);
		return matcher.matches();
	}

}
