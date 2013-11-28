package de.holisticon.emapp.ui;

import de.holisticon.emapp.ui.TimeTrackingForm.TimeRangeValidator;
import org.junit.Test;

import static de.holisticon.vaadin.asserts.CustomFestAssertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TimeRangeValidatorTest {

    public static final String CUSTOM_ERROR_MESSAGE = "time range from %s to %s should be %s";

    @Test
	public void shouldReturnTrueForStarttimeBeforeEndtime() throws Exception {
		String from = "08:00";
		String until = "16:30";
		TimeRangeValidator validator = givenValidatorForTimeFieldValues(from, until);
		boolean result = whenValidatingWith(validator);
		assertThat(result).overridingErrorMessage(String.format(CUSTOM_ERROR_MESSAGE,
                from,until,"valid")).isTrue();
	}

	@Test
	public void shouldReturnFalseForStarttimeAfterEndtime() throws Exception {
		String from = "08:00";
		String until = "07:00";
		TimeRangeValidator validator = givenValidatorForTimeFieldValues(from, until);
		boolean result = whenValidatingWith(validator);
		assertThat(result).overridingErrorMessage(String.format(CUSTOM_ERROR_MESSAGE,
                from,until,"invalid")).isFalse();
	}

	@Test
	public void shouldReturnFalseForEqualTimes() throws Exception {
		String from = "08:00";
		String until = "08:00";
		
		TimeRangeValidator validator = givenValidatorForTimeFieldValues(from, until);
		boolean result = whenValidatingWith(validator);
		assertThat(result).overridingErrorMessage(String.format(CUSTOM_ERROR_MESSAGE,
                from,until,"invalid")).isFalse();
	}

	private boolean whenValidatingWith(TimeRangeValidator validator) {
		return validator.validate();
	}

	private TimeRangeValidator givenValidatorForTimeFieldValues(String from, String until) {
		TimeTrackingForm timeTrackingForm = new TimeTrackingForm();
		timeTrackingForm.timeFromField = createTimeField(from);
		timeTrackingForm.timeUntilField = createTimeField(until);
		return timeTrackingForm.new TimeRangeValidator();
	}

	private static TimeField createTimeField(String value) {
		TimeField timeFrom = mock(TimeField.class);
		when(timeFrom.getValue()).thenReturn(value);
		return timeFrom;
	}



}
