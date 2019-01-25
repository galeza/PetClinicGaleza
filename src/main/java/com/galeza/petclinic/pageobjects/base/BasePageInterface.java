package com.galeza.petclinic.pageobjects.base;


public interface BasePageInterface {

	boolean urlContains(String url);
	boolean titleContains(String title);
	boolean urlIs(String url);
	boolean titleIs(String title);
	String getTitle();
	String getUrl();
	void reload();
	
}
