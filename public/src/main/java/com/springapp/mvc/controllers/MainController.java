package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeCategoryInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Контроллер главной страницы
 */
@Controller
public class MainController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome() {
		return "main/main";
	}
}