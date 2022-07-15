package com.tact.contact.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.tact.WrapperConfiguration;
import com.tact.contact.domain.model.Contact;
import com.tact.contact.domain.service.ContactService;
import com.tact.core.domain.model.PageList;
import com.tact.helper.WrapperHelper;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@Import(WrapperConfiguration.class)
public class ContactControllerTest {

	@Autowired
	private MockMvc controller;

	@Autowired
	private WrapperHelper wrapperHelper;

	@MockBean
	private ContactService contactService;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void getContacts_empty() throws Exception {
		when(contactService.findAllPaged(any())).thenReturn(null);

		MvcResult response = this.controller
				.perform(get("/contact/paged/"))
				.andExpect(status().isOk())
		.andReturn();

		@SuppressWarnings("unchecked")
		PageList<Contact> pageListReturned = wrapperHelper.unwrapper(response.getResponse().getContentAsString(), PageList.class);

		 assertEquals(0, pageListReturned.getCurrentPage());
		 assertEquals(0, pageListReturned.getTotalPages());
		 assertEquals(0, pageListReturned.getTotalRecords());
		 assertNull(pageListReturned.getContent());
	}

	@Test
	public void getContacts_values() throws Exception {
		PageList<Contact> pageList = getMockPageList();

		when(contactService.findAllPaged(any())).thenReturn(pageList);

		MvcResult response = this.controller
				.perform(get("/contact/paged/"))
				.andExpect(status().isOk())
		.andReturn();

		@SuppressWarnings("unchecked")
		PageList<Contact> pageListReturned = wrapperHelper.unwrapper(response.getResponse().getContentAsString(), PageList.class);

		 assertEquals(pageList.getCurrentPage(), pageListReturned.getCurrentPage());
		 assertEquals(pageList.getTotalPages(), pageListReturned.getTotalPages());
		 assertEquals(pageList.getTotalRecords(), pageListReturned.getTotalRecords());
		 assertNotNull(pageListReturned.getContent());

		 Contact contact = getMockContact();
		 Contact contactReturned = pageList.getContent().stream().findFirst().get();

		 assertNotNull(contactReturned);
		 assertEquals(contact.getId(), contactReturned.getId());
		 assertEquals(contact.getName(), contactReturned.getName());
		 assertEquals(contact.getImagePath(), contactReturned.getImagePath());
	}

	private PageList<Contact> getMockPageList() {
		return new PageList<Contact>()
			.inPage(1)
			.withTotalPages(2)
			.withTotalRecords(35)
			.withContent(List.of(getMockContact()));
	}

	private Contact getMockContact() {
		Contact contact = new Contact();
		contact.setId(Long.valueOf(15));
		contact.setName("Name");
		contact.setImagePath("Image_path");

		return contact;
	}

}
