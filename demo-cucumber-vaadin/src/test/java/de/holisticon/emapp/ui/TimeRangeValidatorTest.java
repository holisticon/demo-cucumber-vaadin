package de.holisticon.emapp.ui;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.internal.matchers.TypeSafeMatcher;

import de.holisticon.emapp.ui.TimeTrackingForm.TimeRangeValidator;

public class TimeRangeValidatorTest {

	@Test
	public void shouldReturnTrueForValidTimeRange() throws Exception {
		String from = "08:00";
		String until = "16:30";

		TimeRangeValidator validator = givenValidatorForTimeFieldValues(from, until);
		boolean result = whenValidatingWith(validator);
		assertThat(result, evaluatesToTrueFor(from, until));
	}

	@Test
	public void shouldReturnFalseForInvalidTimeRange() throws Exception {
		String from = "08:00";
		String until = "07:00";

		TimeRangeValidator validator = givenValidatorForTimeFieldValues(from, until);
		boolean result = whenValidatingWith(validator);
		assertThat(result, evaluatesToFalseFor(from, until));
	}

	private static Matcher<? super Boolean> evaluatesToTrueFor(final String from, final String until) {
		return new TimeRangeResultMatcher(until, from, true);
	}

	private static Matcher<? super Boolean> evaluatesToFalseFor(final String from, final String until) {
		return new TimeRangeResultMatcher(until, from, false);
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

	static class TimeRangeResultMatcher extends TypeSafeMatcher<Boolean> {
		private final String until;
		private final String from;
		private final boolean expected;
		private Boolean actual;
	
		private TimeRangeResultMatcher(String until, String from, boolean expected) {
			this.until = until;
			this.from = from;
			this.expected = expected;
		}
	
		public void describeTo(Description description) {
			description.appendText(String.format("time range from %s to %s evaluates to ", from, until)).appendText(Boolean.toString(expected));
		}
	
		@Override
		public void describeMismatch(Object item, Description description) {
			description.appendText("evaluated to ").appendText(Boolean.toString(actual));
		}
	
		@Override
		public boolean matchesSafely(Boolean actual) {
			this.actual = actual;
			return actual == expected;
		}
	}

}
