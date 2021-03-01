package com.example.demo;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {
	@GetMapping("/myHello.html")
	public String hello(Model model, @RequestParam(value = "name", defaultValue = "World") String name) {
		var tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
		
		model.addAttribute("myData", "Good Morning!");
		model.addAttribute("name", name);
		model.addAttribute("tasks", tasks);
		
		String a = "";
		if( false ) {
			a = null;
			if( a.length() > 0 ) {
				int i = 0;
			}
		}
		
		return "myHello.html";
	}
}
