package com.goodcentstest.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoodCentsSearchpage
{
	private WebDriver driver;
	private Properties prop = new Properties();
	
	public GoodCentsSearchpage(WebDriver d) {
		this.driver = d;
		if(!driver.getTitle().equals("getTalent")) {
			throw new IllegalStateException("This is not gettalent. It title is: " + driver.getTitle());
		}
		try {
			prop.load(getClass().getClassLoader().getResourceAsStream("ui_mapping.properties"));
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}
	public String search(String postcode, String first_addr_line) {
	    driver.findElement(By.id(prop.getProperty("ctband.postcode_search"))).clear();
	    driver.findElement(By.id(prop.getProperty("ctband.postcode_search"))).sendKeys(postcode);
	    driver.findElement(By.xpath(prop.getProperty("ctband.search_button_xpath"))).click();
	    driver.findElement(By.partialLinkText(first_addr_line.toUpperCase())).click();
	    WebElement e = driver.findElement(By.xpath(prop.getProperty("ctband.result_table_xpath")));
	    return e.getText();
	}
	
	public void loginGettalent(String in_username, String in_password){
		System.out.println("Inn function");
		driver.findElement(By.linkText(prop.getProperty("home.login_link"))).click();
		WebElement username = driver.findElement(By.name(prop.getProperty("login.username")));
		username.clear();
		username.sendKeys(in_username);
		WebElement password = driver.findElement(By.name(prop.getProperty("login.password")));
		password.clear();
		password.sendKeys(in_password);
		driver.findElement(By.xpath(prop.getProperty("login.submit"))).click();
	}
}