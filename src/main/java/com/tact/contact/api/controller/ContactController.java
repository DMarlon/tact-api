package com.tact.contact.api.controller;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tact.contact.api.dto.ContactDTO;
import com.tact.contact.domain.model.Contact;
import com.tact.contact.domain.service.ContactService;
import com.tact.core.domain.model.PageList;
import com.tact.core.domain.model.QueryParam;
import com.tact.core.domain.utilitary.ValidatorUtils;

@RestController
@RequestMapping("/contact")
public class ContactController {

	private ContactService contactService;

	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}

	@GetMapping("/paged")
	public PageList<ContactDTO> list(QueryParam queryParam) {
		return convertPageList(contactService.findAllPaged(queryParam));
	}

	private PageList<ContactDTO> convertPageList(PageList<Contact> contacts) {
		PageList<ContactDTO> contactsDTO =  new PageList<ContactDTO>();

		if (Objects.nonNull(contacts)) {
			contactsDTO
				.inPage(contacts.getCurrentPage())
				.withTotalPages(contacts.getTotalPages())
				.withTotalRecords(contacts.getTotalRecords())
				.withContent(convertObjectsToDTOs(contacts.getContent()));
		}

		return contactsDTO;
	}

	private List<ContactDTO> convertObjectsToDTOs(List<Contact> contacts) {
		return ValidatorUtils.isNullOrEmpty(contacts) ? Collections.emptyList() : contacts.stream().map(ContactDTO::valueOf).collect(Collectors.toList());
	}

}
