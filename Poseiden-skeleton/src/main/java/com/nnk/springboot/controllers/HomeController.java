package com.nnk.springboot.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	private static Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String home(Model model) {
		logger.info("Response : Home was found");
		return "home";
	}

	@RequestMapping("/admin/home")
	public String adminHome(Model model) {
		logger.info("Response : Admin home was found");
		return "redirect:/bidList/list";
	}


}
