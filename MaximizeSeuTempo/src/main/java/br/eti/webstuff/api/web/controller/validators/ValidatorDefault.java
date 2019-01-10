package br.eti.webstuff.api.web.controller.validators;

import org.springframework.validation.BindingResult;

public interface ValidatorDefault {
	
	
	<T> void validarDadosExistentes(T t, BindingResult result);

}
