package com.talukder.addressbook.vo;

import lombok.Data;

@Data
public class ContactVO {
	private Long id;
	private String firstName;
	private String lastName;
	private Long mobile;
	private String email;
	private String address;
}
