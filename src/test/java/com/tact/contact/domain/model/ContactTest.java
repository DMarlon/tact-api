package com.tact.contact.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class ContactTest {
	private static final String NAME = "name";
	private static final String IMAGE_PATH = "image_path";

	@Test
	public void setName_null_value() {
		Contact contact = new Contact();
		contact.setName(null);

		assertNull(contact.getName());
	}

	@Test
	public void setDescription_trim_value() {
		Contact contact = new Contact();
		contact.setName(" "+NAME+" ");

		assertEquals(contact.getName(), NAME);
	}

	@Test
	public void setImagePath_null_value() {
		Contact contact = new Contact();
		contact.setImagePath(null);

		assertNull(contact.getImagePath());
	}

	@Test
	public void setImagePath_trim_value() {
		Contact contact = new Contact();
		contact.setImagePath(" "+IMAGE_PATH+" ");

		assertEquals(contact.getImagePath(), IMAGE_PATH);
	}
}
