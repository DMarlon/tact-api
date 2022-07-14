package com.tact.core.domain.utilitary;

import java.util.Collection;
import java.util.Objects;

public class ValidatorUtils {

	public static boolean isNullOrEmpty(String value) {
		return Objects.isNull(value) || value.isEmpty();
	}

	public static boolean isNullOrEmpty(Collection<?> value) {
		return Objects.isNull(value) || value.isEmpty();
	}

}
