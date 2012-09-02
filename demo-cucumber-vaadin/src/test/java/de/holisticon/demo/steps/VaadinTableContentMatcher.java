package de.holisticon.demo.steps;

import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

final class VaadinTableContentMatcher extends TypeSafeMatcher<List<List<String>>> {
	private final List<List<String>> expected;
	private String message;

	VaadinTableContentMatcher(List<List<String>> expected) {
		this.expected = expected;
	}

	public void describeTo(Description descr) {
		descr.appendText("a table with ");
	}

	@Override
	protected void describeMismatchSafely(List<List<String>> item, Description descr) {
		descr.appendText(message);
	}

	@Override
	public boolean matchesSafely(List<List<String>> actual) {

		if (actual.size() != expected.size()) {
			message = "wrong numbers of rows";
			return false;
		}

		for (int rowIdx = 0; rowIdx < expected.size(); rowIdx++) {
			for (int fieldIdx = 0; fieldIdx < expected.get(rowIdx).size(); fieldIdx++) {
				String actualValue = actual.get(rowIdx).get(fieldIdx);
				String expectedValue = expected.get(rowIdx).get(fieldIdx);
				boolean asExpected = actualValue.equals(expectedValue);
//				System.out.println(actualValue + " = " + expectedValue + " : " + asExpected);
				if (!asExpected) {
					message = "table contents are not as expected";
					return false;
				}
			}
		}

		return true;
	}
}