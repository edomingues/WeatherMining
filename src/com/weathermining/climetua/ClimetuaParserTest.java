package com.weathermining.climetua;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class ClimetuaParserTest {

	private static final String DOUBLE_REGEX = "[0-9]+(\\.[0-9]+)?";
	
	@Test
	public void test() {
		Pattern measurePattern = Pattern.compile("("+DOUBLE_REGEX+")[ ]*([^ ]*)");
		
		String text = "0.0 mm";
		String unit = "mm";
		
		Matcher matcher = measurePattern.matcher(text);	
		assertTrue(matcher.matches());
		assertTrue(matcher.group(3).equals(unit));
		assertEquals("0.0", matcher.group(1));
		
	}

}
