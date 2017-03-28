package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@Controller
public class ShoppingCartUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartUiApplication.class, args);
	}

	@RequestMapping("/")
	public String home(){
		return "index";
	}
}
