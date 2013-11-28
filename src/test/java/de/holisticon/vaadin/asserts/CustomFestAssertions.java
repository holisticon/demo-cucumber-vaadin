package de.holisticon.vaadin.asserts;

import de.holisticon.vaadin.pageobject.VaadinFormPageObject;
import org.fest.assertions.Assertions;
import org.openqa.selenium.WebDriver;

/**
 * Aggregation of all implementations of {@link org.fest.assertions.GenericAssert} so they can be used as a static
 * import with the standard assertions.
 */
public class CustomFestAssertions extends Assertions {



    public static WebDriverAssert assertThat(WebDriver actual){
        return new WebDriverAssert(actual);
    }

    public static VaadinFormAssert assertThat(VaadinFormPageObject pageObject) {
        return new VaadinFormAssert(pageObject);
    }


}
