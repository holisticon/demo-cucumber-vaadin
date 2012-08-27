package de.holisticon.employeemanager.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.vaadin.data.Validator;


public class TimeValidatorTest {

	@Test
	public void shouldReturnFalseForEmptyString() throws Exception {
		assertFalse(timeValidator().isValid(""));
	}

	@Test
	public void shouldReturnFalseForNullString() throws Exception {
		assertFalse(timeValidator().isValid(null));
	}

	@Test
	public void shouldReturnTrueForFourNumbers() throws Exception {
		assertFalse(timeValidator().isValid("0810"));
	}

	@Test
	public void shouldReturnTrueForMidnight() throws Exception {
		assertTrue(timeValidator().isValid("23:59"));
	}

	@Test
	public void shouldReturnFalseForNonNumbers() throws Exception {
		assertFalse(timeValidator().isValid("a"));
		assertFalse(timeValidator().isValid("."));
		assertFalse(timeValidator().isValid(":"));
		assertFalse(timeValidator().isValid("10_00"));
	}

	private Validator timeValidator() {
		return new TimeValidator();
	}

}
