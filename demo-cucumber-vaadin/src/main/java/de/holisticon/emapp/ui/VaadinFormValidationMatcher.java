package de.holisticon.emapp.ui;

import static org.apache.commons.lang3.StringUtils.isEmpty;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import de.holisticon.vaadin.pageobject.VaadinFormPageObject;

public class VaadinFormValidationMatcher extends TypeSafeMatcher<VaadinFormPageObject> {

	private String actualFormError;
	private String expectedFormError;

	public VaadinFormValidationMatcher(String expectedFormError) {
		super();
		this.expectedFormError = expectedFormError;
	}

	public void describeTo(Description description) {
		description
				.appendText("FormError: ")
				.appendText(expectedFormError);
	}

	@Override
	protected void describeMismatchSafely(VaadinFormPageObject form, Description description) {
		description.appendText(actualFormError);
	}

	@Override
	protected boolean matchesSafely(VaadinFormPageObject form) {
		actualFormError = form.formError();
		if (!isEmpty(actualFormError)) {
			return actualFormError.equals(expectedFormError);
		} else {
			actualFormError = "no form error displayed";
			return false;
		}
	}

}
