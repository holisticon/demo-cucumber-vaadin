package de.holisticon.demo.pageobject;

import static com.google.common.collect.Lists.newArrayList;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class VaadinTablePageObject extends VaadinPageObject {

    public VaadinTablePageObject(WebDriver driver) {
        super(driver);
    }

    public WebElement table() {
        try {
            return browser().findElement(By.className("v-table"));
        }
        catch (Exception ex) {
            return null;
        }
    }

    public boolean isVisible() {
        return table() != null;
    }

    public int countRows() {
        try {
            return tableContent().findElements(By.tagName("tr")).size();
        }
        catch (Exception ex) {
            return -1;
        }
    }

    public WebElement tableContent() {
        try {
            return table().findElement(By.className("v-table-body")).findElement(By.tagName("tbody"));
        }
        catch (Exception ex) {
            return null;
        }
    }

    public int countColumns() {
        try {
            return table().findElements(By.className("v-table-header-cell")).size();
        }
        catch (Exception ex) {
            return -1;
        }
    }

    public boolean isEmpty() {
        return countRows() == 0;
    }

    public List<List<String>> rows() {
        List<List<String>> rows = new ArrayList<List<String>>();
        List<WebElement> webRows = tableContent().findElements(By.className("v-table-row"));
        for (WebElement webRow : webRows) {
        	List<String> row = new ArrayList<String>();
			List<WebElement> fields = webRow.findElements(By.tagName("td"));
			for (WebElement field : fields) {
				row.add(field.getText());
			}
        	rows.add(row);
		}
		return rows;
    }


    public List<String> values(WebElement row) {
        List<String> cells = newArrayList();
        List<WebElement> cellElemtens = row.findElements(By.className("v-table-cell-content"));
        for (WebElement cellElement : cellElemtens) {
            cells.add(cellElement.getText());
        }
        return cells;
    }

}
