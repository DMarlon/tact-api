package com.tact.core.domain.utilitary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FormatterUtilsTest {

	@Test
	public void remove_accentuation() {
		assertEquals(FormatterUtils.removeAccentuation("àáâãäå"), "aaaaaa");
	}
}
