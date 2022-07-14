package com.tact.contact.domain.service;

import org.springframework.stereotype.Service;

import com.tact.contact.domain.model.Contact;
import com.tact.contact.domain.repository.ContactRepository;
import com.tact.core.domain.model.PageList;
import com.tact.core.domain.model.QueryParam;

@Service
public class ContactService {

	private ContactRepository contactRepository;

	public ContactService(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

	public PageList<Contact> findAllPaged(QueryParam params) {
		return contactRepository.findAllPaged(params);
	}
}
