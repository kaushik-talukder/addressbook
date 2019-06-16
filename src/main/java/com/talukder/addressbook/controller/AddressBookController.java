package com.talukder.addressbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.talukder.addressbook.entity.AddressBook;
import com.talukder.addressbook.repository.AddressBookRepository;
import com.talukder.addressbook.vo.ContactVO;

@Controller
public class AddressBookController {
	
	@Autowired
	private AddressBookRepository addressBookRepo;

	@RequestMapping(value = {"/", "/home", "/addContactPage"})
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("addEditContact");
		return mv;
	}
	
	@RequestMapping(value = {"/viewAll"})
	public ModelAndView viewAllContacts() {
		ModelAndView mv = new ModelAndView("showAllContacts");
		List<AddressBook> allContacts = addressBookRepo.findAll();
		mv.addObject("allContactsList",allContacts);
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = {"/addEditContact"})
	public AddressBook addContact(@RequestBody ContactVO contact) {
		
		AddressBook newContact = new AddressBook();
		
		newContact.setId(contact.getId());
		newContact.setFirstName(contact.getFirstName());
		newContact.setLastName(contact.getLastName());
		newContact.setMobile(contact.getMobile());
		newContact.setEmail(contact.getEmail());
		newContact.setAddress(contact.getAddress());
		
		AddressBook savedEntity = addressBookRepo.save(newContact);
		
		return savedEntity;
	}
	
	@RequestMapping(value = {"/editContactPage"})
	public ModelAndView editContact(@RequestParam(value="id") Long id) {
		ModelAndView mv = new ModelAndView("addEditContact");
		AddressBook existingContact = addressBookRepo.findById(id).get();
		mv.addObject("contactToEdit", existingContact);
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = {"/showAllContacts"})
	public List<AddressBook> showAllContacts() {
		List<AddressBook> allContacts = addressBookRepo.findAll();
		return allContacts;
	}
	
	@ResponseBody
	@RequestMapping(value = {"/deleteContact"})
	public boolean showAllContacts(@RequestParam(value="id") Long id) {
		boolean flag = true;
		try {
			addressBookRepo.deleteById(id);
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}
}
