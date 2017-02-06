package com.blogspot.notes.automation.qa.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Hyperlink extends HTMLElement{
	public Hyperlink(final WebDriver driver, final SearchBy elementSearchCriteria, final String elementValue) {
        super(driver, elementSearchCriteria, elementValue);
    }
	
	public void click() {
        waitUntil(ExpectedConditions::elementToBeClickable).click();
    }

}
