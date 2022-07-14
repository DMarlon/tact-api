package com.tact.core.domain.utilitary;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ValidatorUtilsTest {

	@Test
	public void isNullOrEmpty_with_string_null() {
		String value = null;
		assertTrue(ValidatorUtils.isNullOrEmpty(value));
	}

	@Test
	public void isNullOrEmpty_with_string_empty() {
		assertTrue(ValidatorUtils.isNullOrEmpty(""));
	}

	@Test
	public void isNullOrEmpty_with_string_black() {
		assertFalse(ValidatorUtils.isNullOrEmpty(" "));
		assertFalse(ValidatorUtils.isNullOrEmpty("     "));
	}

	@Test
	public void isNullOrEmpty_with_string_value() {
		assertFalse(ValidatorUtils.isNullOrEmpty("a"));
	}

	@Test
	public void isNullOrEmpty_with_collection_null() {
		Collection<String> value = null;
		assertTrue(ValidatorUtils.isNullOrEmpty(value));
	}

	@Test
	public void isNullOrEmpty_with_collection_empty() {
		assertTrue(ValidatorUtils.isNullOrEmpty(Collections.emptyList()));
	}

	@Test
	public void isNullOrEmpty_with_collection_null_values() {
		List<String> list = new ArrayList<String>();
		list.add(null);

		assertFalse(ValidatorUtils.isNullOrEmpty(list));

	}

	@Test
	public void isNullOrEmpty_with_collection_with_values() {
		assertFalse(ValidatorUtils.isNullOrEmpty(List.of("a")));
	}
}
