package de.holisticon.emapp.pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import de.holisticon.vaadin.pageobject.VaadinPageObject;

public class LoginPage extends VaadinPageObject {

    private static final String LOGIN_IFRAME_ID = "PID3";

	public LoginPage(WebDriver browser) {
        super(browser);
    }

    public void loginWith(String username, String password) {
        WebElement loginFrame = loginFrame();
        browser().switchTo().frame(loginFrame);

        WebElement usernameText = browser().findElement(By.name("username"));
        WebElement passwordText = browser().findElement(By.name("password"));

        setText(usernameText, username);
        setText(passwordText, password);

        passwordText.submit();

        browser().switchTo().defaultContent();

    }

    private WebElement loginFrame() {
        try {
            return browser().findElement(By.name(LOGIN_IFRAME_ID));
        }
        catch (NoSuchElementException e) {
            throw new IllegalStateException("couldn't find login frame");
        }
    }


}
