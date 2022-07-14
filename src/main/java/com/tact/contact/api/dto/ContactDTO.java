package com.tact.contact.api.dto;

import java.util.Objects;

import com.tact.contact.domain.model.Contact;

public class ContactDTO {

	private Long id;
	private String name;
	private String imagePath;

	public static ContactDTO valueOf(Contact contact) {
		ContactDTO contactDTO = new ContactDTO();

		if (Objects.nonNull(contact)) {
			contactDTO.setId(contact.getId());
			contactDTO.setName(contact.getName());
			contactDTO.setImagePath(contact.getImagePath());
		}

		return contactDTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Contact toEntity() {
		Contact contact = new Contact();
		contact.setId(getId());
		contact.setName(getName());
		contact.setImagePath(getImagePath());

		return contact;
	}

}
