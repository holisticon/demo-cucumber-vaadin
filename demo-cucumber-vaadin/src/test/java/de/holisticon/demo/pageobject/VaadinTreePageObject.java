package de.holisticon.demo.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

public class VaadinTreePageObject extends VaadinPageObject {

	private static final String CLASS_NAME_TREE_NODE = "v-tree-node";

	public VaadinTreePageObject(WebDriver driver) {
		super(driver);
	}

	public VaadinTreePageObject select(String caption) {
		for (WebElement item : allVisibleItems()) {
			WebElement clickableItem = item.findElement(By.tagName("span"));
			if (caption.equals(clickableItem.getText())) {
				clickableItem.click();
				return this;
			}
		}
		return this;
	}

	public VaadinTreePageObject expand(String caption) {
		for (WebElement item : allVisibleItems()) {
			if (caption.equals(item.getText())) {
				while (!item.getAttribute("class").contains(
						"v-tree-node-expanded")) {
					item.click();
				}
				return this;
			}
		}
		return this;
	}

	public WebElement selection() {
		try {
			return driver().findElement(By.className("v-tree-node-selected"));
		} catch (NoSuchElementException ex) {
			return null;
		}
	}

	public List<WebElement> allVisibleItems() {
		return driver().findElements(By.className(CLASS_NAME_TREE_NODE));
	}

	public List<WebElement> allVisibleItemsBeyond(WebElement webElement) {
		return webElement.findElements(By.className(CLASS_NAME_TREE_NODE));
	}

	public List<WebElement> allVisibleItemsWith(String name) {
		List<WebElement> itemsWithName = Lists.newArrayList();
		List<WebElement> allVisibleItems = allVisibleItems();
		for (WebElement item : allVisibleItems) {
			String text = extractName(item.getText());
			if (name.equals(text)) {
				itemsWithName.add(item);
			}
		}
		return itemsWithName;
	}

	public String extractName(String text) {
		return Splitter.on("\n").omitEmptyStrings().split(text).iterator()
				.next();
	}

}
