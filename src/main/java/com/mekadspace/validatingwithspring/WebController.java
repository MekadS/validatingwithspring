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

	@PostMapping("/")
	public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "form";
		}
		System.out.println("Name: " + personForm.getName());
		System.out.println("Age: " + personForm.getAge());
		personForm.setName("Gemini");
		personForm.setAge(30);
		System.out.println("Name: " + personForm.getName());
		System.out.println("Age: " + personForm.getAge());
		System.out.println("To String: " + personForm.toString());
		return "redirect:/results";
	}
}