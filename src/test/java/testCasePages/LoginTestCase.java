package testCasePages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageObjectElements.AccountInfoPageElements;

import pageObjectElements.HomePageElements;
import pageObjectElements.LoginPageElements;
import pageObjectElements.TransferPageElements;
import utilities.BaseDriverClass;
import utilities.DataDrivenFile;




public class LoginTestCase extends BaseDriverClass {
	WebDriver driver;
	LoginPageElements LPE;
	HomePageElements HPE;
	TransferPageElements TPE;
	AccountInfoPageElements AIPE;
	DataDrivenFile dd;
	
	static Logger Log = Logger.getLogger(LoginTestCase.class);
			
	@Test(priority=1)
	public void ValidLogin() throws IOException {
		PropertyConfigurator.configure("C:\\Users\\Boparai\\eclipse-workspace\\OnlineBanking\\resources\\log4j.properties");
		driver=Driver_Init();
		driver.get("http://demo.testfire.net/login.jsp");
		Log.info("Demo has been Launched!!");
		LPE=new LoginPageElements(driver);
		//Login using valid username and password
		LPE.AddUsername(username);	
		LPE.AddPassword(password);
		LPE.BtnClick();  
		Log.info("Login info verified!!");
		//Validate URL for Home Page
		LPE.ValidHomePage(driver,homeURL);	
	}
	
	@Test(enabled = false)
	public void InvalidLogin() {
		
		driver.get(loginURL);
		LPE= new LoginPageElements(driver);
		//Using invalid Username and password
		LPE.AddUsername("WrongUsername");
		LPE.AddPassword("WrongPassword");
		LPE.BtnClick();
		Log.info("Testing Wrong Username and Password!!");
		LPE.SpanMessage();	
	}
	
	@Test(priority=2)
	public void AccountInfo() {
		Log.info("Home page has been Opened!!");
		//System.out.println("Home Page ");
		HPE = new HomePageElements(driver);
		System.out.println("Account Info");
		HPE.AccountSelect();
		HPE.VerifyAccountInfo(driver);
		HPE.CurrentDate();
		
	}
	
	@Test(priority=3)
	public void TransferFunds() {
		Log.info("Trasfer Fund Page has been Opened!!!");
		//Transfer Fund page
		TPE = new TransferPageElements(driver);
		TPE.TransferFunds();
		TPE.AmountTransfer();
	}
	
	@Test(priority=4)
	public void AccountSummary() {
		Log.info("Account Summary page has been Opened!!");
		AIPE = new AccountInfoPageElements(driver);
		AIPE.GetAccountSummary();
		HPE.AccountSelect();
	}
	
	@Test(priority = 5)
	public void LogOff() {
		Log.info("LogOff done!!");
		HPE = new HomePageElements(driver);
		HPE.LogOut(driver);
		
		
	}

}
