package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {
	@GetMapping("/myHello")
	public String hello(Model model, @RequestParam(value = "name", defaultValue = "World") String name) {
		model.addAttribute("myData", "Good Morning!");
		model.addAttribute("name", name);
		return "NewFile.html"; 
	}
}
