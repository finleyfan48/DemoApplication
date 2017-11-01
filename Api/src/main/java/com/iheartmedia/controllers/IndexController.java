package com.iheartmedia.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
		
	/**
	 * Renders the HTML, Spring Boot format 
	 *
	 * @param  empty 
	 * @return html format to present to the browser
	 * @see    String
	 */
	@RequestMapping("/")
	public String index() {
		return "index";
	}

}
