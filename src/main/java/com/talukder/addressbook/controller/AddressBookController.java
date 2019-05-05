package com.talukder.addressbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.talukder.addressbook.vo.ContactVO;

@Controller
public class AddressBookController {

	@RequestMapping(value = {"/", "/home"})
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = {"/addContact"})
	public String addContact(@RequestBody ContactVO contact) {
		System.out.println(contact);
		//write some code to save into db
		return "Success";
	}
}
