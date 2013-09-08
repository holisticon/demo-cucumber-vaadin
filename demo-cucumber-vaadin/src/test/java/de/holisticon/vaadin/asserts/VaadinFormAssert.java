package de.holisticon.vaadin.asserts;

import de.holisticon.vaadin.pageobject.VaadinFormPageObject;
import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;

public class VaadinFormAssert extends GenericAssert<VaadinFormAssert, VaadinFormPageObject> {
    /**
     * Creates a new <code>{@link VaadinFormAssert}</code>.
     *
     * @param actual the actual value to verify.
     */
    protected VaadinFormAssert(VaadinFormPageObject actual) {
        super(VaadinFormAssert.class, actual);
    }

    public VaadinFormAssert displaysValidationError(String errorMsg) {
        isNotNull().describedAs("no error message displayed");
        Assertions.assertThat(actual.formError()).isEqualTo(errorMsg).describedAs("error message differs");
        return this;

    }


}
