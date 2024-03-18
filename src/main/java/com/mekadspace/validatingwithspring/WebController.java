package com.mekadspace.validatingwithspring;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.validation.Valid;

@Controller
public class WebController implements WebMvcConfigurer{
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results");
	}
	
	@GetMapping("/")
	public String showForm(PersonForm personForm) {
		return "form";
	}

	@GetMapping("/test")
	public String Test() {
		return "results";
	}
	
	@PostMapping("/")
	public String checkPersonInfo(@Valid PersonForm personform, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "form";
		}
		return "redirect:/results";
	}
}