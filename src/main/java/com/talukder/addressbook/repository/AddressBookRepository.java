package com.talukder.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talukder.addressbook.entity.AddressBook;

public interface AddressBookRepository extends JpaRepository<AddressBook, Long> {

}
