package com.alejandro.rest.webservices.restful.web.services.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Rest API Exponer
@RestController
public class HelloWorldController {

	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	//Enviar mensaje en pantalla
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World :D";
	}

	// Enviar json
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}

	// Path Parametros
	// /users/{id}/todos/{id} 
	// /hello-world/path-variable/{name}
	// /hello-world/path-variable/Alejandro

	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s",name));
	}

	//Enviar mensaje en pantalla
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized() {
		
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
		//return "Hello World V2";
	}
	
	


}
