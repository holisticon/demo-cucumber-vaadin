package de.holisticon.demo.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Lists;

public class VaadinPageObject {

    private final WebDriver driver;

    public VaadinPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> allButtons() {
        try {
            return driver.findElements(By.className("v-button"));
        }
        catch (NoSuchElementException e) {
            return Lists.newArrayList();
        }
    }

    public List<WebElement> allButtonsDefault() {
        try {
            return driver.findElements(By.className("v-button-default"));
        }
        catch (NoSuchElementException exception) {
            return Lists.newArrayList();
        }
    }

    public List<WebElement> allDatePickers() {
        try {
            return driver.findElements(By.className("v-datefield-textfield"));
        }
        catch (NoSuchElementException exception) {
            return Lists.newArrayList();
        }
    }

    public List<WebElement> allDropDownButtons() {
        try {
            return driver.findElements(By.className("v-filterselect-button"));
        }
        catch (NoSuchElementException exception) {
            return Lists.newArrayList();
        }
    }

    public List<WebElement> allDropDownItems() {
        try {
            return driver.findElements(By.className("gwt-MenuItem"));
        }
        catch (NoSuchElementException exception) {
            return Lists.newArrayList();
        }
    }

    public List<WebElement> allDropDownTextBoxes() {
        try {
            return driver.findElements(By.className("v-filterselect-input"));
        }
        catch (NoSuchElementException exception) {
            return Lists.newArrayList();
        }
    }

    public List<WebElement> allModalDialogs() {
        try {
            return driver.findElements(By.className("v-window-modalform"));
        }
        catch (NoSuchElementException exception) {
            return Lists.newArrayList();
        }
    }

    public List<WebElement> allTextBoxes() {
        try {
            return driver.findElements(By.className("v-textfield"));
        }
        catch (NoSuchElementException exception) {
            return Lists.newArrayList();
        }
    }

    public List<WebElement> buttonsIn(WebElement fromParent) {
        try {
            return fromParent.findElements(By.className("v-button"));
        }
        catch (NoSuchElementException exception) {
            return Lists.newArrayList();
        }
    }

    public WebElement buttonIn(WebElement fromParent, String caption) {
        for (WebElement button : buttonsIn(fromParent)) {
            if (caption.equals(button.getText())) {
                return button;
            }
        }
        return null;
    }

    public VaadinPageObject doRightClickOn(WebElement item) {
        new Actions(driver()).contextClick(item).perform();
        return this;
    }

    public WebDriver driver() {
        return this.driver;
    }

    protected boolean not(boolean actual) {
        return !actual;
    }

    public VaadinPageObject setText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
        return this;
    }

    public WebElement textboxIn(WebElement fromParent) {
        try {
            return fromParent.findElement(By.className("v-textfield-prompt"));
        }
        catch (NoSuchElementException ex) {
            return null;
        }
    }

    public WebDriverWait wait(int seconds) {
        return new WebDriverWait(driver(), seconds);
    }

}
