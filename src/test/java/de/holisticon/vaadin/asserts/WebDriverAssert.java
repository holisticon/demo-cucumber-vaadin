package de.holisticon.vaadin.asserts;

import org.fest.assertions.GenericAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static de.holisticon.vaadin.asserts.CustomFestAssertions.assertThat;

public class WebDriverAssert extends GenericAssert<WebDriverAssert, WebDriver>{

    public WebDriverAssert( WebDriver actual) {
        super(WebDriverAssert.class, actual);
    }

    public WebDriverAssert displaysTrayNotification(String expectedNotification) {
        isNotNull();
        WebElement element = actual.findElement(By.className("v-Notification-tray"));
        assertThat(element).overridingErrorMessage("couldn't find tray notification").isNotNull();
        assertThat(element.getText()).contains(expectedNotification);
        return this;
    }
}
