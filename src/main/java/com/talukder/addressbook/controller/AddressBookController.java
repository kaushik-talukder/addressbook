package com.talukder.addressbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddressBookController {

	@RequestMapping(value = {"/", "/home"})
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}
}
