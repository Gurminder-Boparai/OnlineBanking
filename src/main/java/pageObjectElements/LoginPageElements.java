package pageObjectElements;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.DataDrivenFile;



public class LoginPageElements extends DataDrivenFile {
	
	WebDriver driver;
	
	public LoginPageElements(WebDriver driver) {
		PageFactory.initElements(driver, this);	
		
	}
	
	@FindBy(xpath = "//input[@id=\"uid\"]")
	WebElement Username;
	
	@FindBy(xpath = "//input[@id=\"passw\"]")
	WebElement Password;
	
	@FindBy(xpath = "//input[@name=\"btnSubmit\"]")
	WebElement BtnSubmit;
	
	@FindBy(xpath = "//span[@id = \"_ctl0__ctl0_Content_Main_message\"]")
	WebElement SpanMsg;
	
	public void AddUsername(String Uname) {
		Username.sendKeys(Uname);	
	}
	public void AddPassword(String password) {
		Password.sendKeys(password);
	}
	public void BtnClick() {
		BtnSubmit.click();
	}
	
	public void ValidHomePage(WebDriver driver,String ExpURL) {
		
		Assert.assertEquals(driver.getCurrentUrl(), ExpURL, "Not the matching URL");
		
		/*
		 * boolean result=false; if (ActURL.equalsIgnoreCase(ExpURL)) { result=true; }
		 * return result;
		 */	
	}
	public void SpanMessage() {
		System.out.println(SpanMsg.getText());
	}

}
