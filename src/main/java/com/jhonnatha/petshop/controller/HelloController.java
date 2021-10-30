package com.jhonnatha.petshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping(value = "/teste")
	public String getPage() {
		return "Hello World!!!";
	}

}
