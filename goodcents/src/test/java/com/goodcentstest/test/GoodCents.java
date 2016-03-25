package com.goodcentstest.test;

import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.goodcentstest.test.GoodCentsSearchpage;
import com.goodcentstest.test.WebDriverManager;

@Listeners({ com.goodcentstest.test.ScreenShotOnFailure.class })
public class GoodCents {
		
  @BeforeClass
  @Parameters ("browser_type")
  public void oneTimeSetUp(String browser_type) {
	  WebDriverManager.startDriver(browser_type);
  }
  
  @AfterClass
  public void oneTimeTearDown() {
	  WebDriverManager.stopDriver();
  }
  
  @DataProvider(name = "dataset1")
  public Object [][] create_dataset1() {
	  return new Object[][] {
			  {"RG5 4NF", "1, Concorde Way", "F"},
			  {"RG5 4NF", "2, Concorde Way", "C"}
	  };
  }
  
  @DataProvider(name = "dataset2")
  public Object [][] create_dataset2() {
	  return new Object[][] {
			  {"jitendra.wadle@newvisionsoftware.in", "Test@1234"}
	  };
  }
  
  
/*  @Test(dataProvider = "dataset1")
  public void testCTaxBands(String postcode, String addr_first_line, String expected_band) {
	  WebDriver d = WebDriverManager.getDriverInstance();
	  d.get("http://www.voa.gov.uk/cti/InitS.asp");
	  GoodCentsSearchpage search_page = new GoodCentsSearchpage(d);
	  String band = search_page.search(postcode, addr_first_line);
	  Assert.assertEquals(expected_band, band);
	 
  
  }*/
  @Test(dataProvider = "dataset2")
  public void testGetalent(String uname, String pass) {
	  WebDriver driver = WebDriverManager.getDriverInstance();
	  driver.get("http://gettalent.com/");
	  driver.manage().window().maximize();
	  GoodCentsSearchpage loginobj = new GoodCentsSearchpage(driver);
	  System.out.println(loginobj);
	  loginobj.loginGettalent(uname, pass);
	  System.out.println("Login sussefully");
  }
}
