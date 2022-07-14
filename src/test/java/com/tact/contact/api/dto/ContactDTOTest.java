package com.tact.contact.api.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.tact.contact.domain.model.Contact;

public class ContactDTOTest {

	private static final Long ID = Long.valueOf(200);
	private static final String NAME = "name";
	private static final String IMAGE_PATH = "image_path";


	@Test
	public void create_with_null_contact() {
		ContactDTO contactDTO = ContactDTO.valueOf(null);
		assertNotNull(contactDTO);
		assertNull(contactDTO.getId());
		assertNull(contactDTO.getName());
		assertNull(contactDTO.getImagePath());

	}

	@Test
	public void create_with_contact() {
		ContactDTO contactDTO = ContactDTO.valueOf(getContactMock());
		assertNotNull(contactDTO);
		assertEquals(contactDTO.getId(), ID);
		assertEquals(contactDTO.getName(), NAME);
		assertEquals(contactDTO.getImagePath(), IMAGE_PATH);
	}

	private Contact getContactMock() {
		Contact contact = new Contact();
		contact.setId(ID);
		contact.setName(NAME);
		contact.setImagePath(IMAGE_PATH);

		return contact;
	}

}
