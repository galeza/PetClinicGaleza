package com.galeza.petclinic.pageobjects.base;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface BasePageInterface {

	boolean urlContains(String url);
	boolean titleContains(String title);
	boolean urlIs(String url);
	boolean titleIs(String title);
	String getTitle();
	String getUrl();
	void reload();
	void clickOnCellInTable(List<WebElement> rows, String value);
	
}
