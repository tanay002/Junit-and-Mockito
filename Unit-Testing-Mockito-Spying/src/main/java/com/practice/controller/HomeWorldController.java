package com.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeWorldController {

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
}
