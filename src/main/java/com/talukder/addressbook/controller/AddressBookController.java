package com.talukder.addressbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.talukder.addressbook.entity.AddressBook;
import com.talukder.addressbook.repository.AddressBookRepository;
import com.talukder.addressbook.vo.ContactVO;

@Controller
public class AddressBookController {
	
	@Autowired
	private AddressBookRepository addressBookRepo;

	@RequestMapping(value = {"/", "/home"})
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = {"/addContact"})
	public AddressBook addContact(@RequestBody ContactVO contact) {
		
		AddressBook newContact = new AddressBook();
		
		newContact.setFirstName(contact.getFirstName());
		newContact.setLastName(contact.getLastName());
		newContact.setMobile(contact.getMobile());
		newContact.setEmail(contact.getEmail());
		newContact.setAddress(contact.getAddress());
		
		AddressBook savedEntity = addressBookRepo.save(newContact);
		
		return savedEntity;
	}
}
