package com.tact.core.domain.utilitary;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class FormatterUtils {
	private static final Pattern removeAccentuationPattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

	public static String removeAccentuation(String value) {
		String nfdNormalizedString = Normalizer.normalize(value, Normalizer.Form.NFD);
        return removeAccentuationPattern.matcher(nfdNormalizedString).replaceAll("");
	}

}
