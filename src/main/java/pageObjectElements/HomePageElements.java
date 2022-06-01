package pageObjectElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class HomePageElements {
	WebDriver driver;
	
	public HomePageElements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//select//option[@value=\'800003\']")
	WebElement AccountSelect;
	
	@FindBy(id = "btnGetAccount")
	WebElement AccountBtn;
	
	@FindBy(tagName = "h1")
	WebElement AccountNo;
	
	@FindBy(xpath = "//div[@class=\"fl\"]//table//tbody//tr//td//table//tbody//tr/td")
	WebElement CurrentDate;
	
	@FindBy(id = "LoginLink")
	WebElement LogOff;
	
	
	public void AccountSelect() {
		AccountSelect.click();
		AccountBtn.click();
	}
	
	public void VerifyAccountInfo(WebDriver driver) { 
		//Verify Account info Page
		System.out.println("Verfiy account info!!!");
		String VerifyAccount="http://demo.testfire.net/bank/showAccount?listAccounts=800003";
		String ExpAccount= driver.getCurrentUrl();
		Assert.assertEquals(ExpAccount, VerifyAccount, "Account Not verified!!");
		
		//Verify Account Number
		String AccountName = AccountSelect.getText().toString();
		//System.out.println(s);
		String Accountdetail=AccountNo.getText().toString();
		//System.out.println(Accountdetail);
		Assert.assertEquals(true, Accountdetail.contains(AccountName),"Not True");
	  }
	
	public void CurrentDate() {
		//Verify Current Date
		System.out.println("Verify Current Date!!");
		String date= CurrentDate.getText();
		System.out.println("Current Date is:  "+date);
	}
	  
	 public void LogOut(WebDriver driver) {
		 //Log OFF page
		 System.out.println("Entering Log OFF!!");
		 LogOff.click();
		 String LogOutURL= driver.getCurrentUrl().toString();
		 String ActLogOutURL="http://demo.testfire.net/index.jsp";
		 Assert.assertEquals(ActLogOutURL, LogOutURL, "Wrong LogOut URL!!");
		 
	 } 
	 
	

}
