package pageObjectElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountInfoPageElements {
	WebDriver driver;
	
	public AccountInfoPageElements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ul[@class=\"sidebar\"]//li//a")
	WebElement AccountSummary;
	
	@FindBy(xpath = "//select//option[@value=\'800003\']")
	WebElement AccountSelect;
	
	@FindBy(id = "btnGetAccount")
	WebElement AccountBtn;
	
	@FindBy(xpath = "//div[@id=\"recent\"]/table/tbody/tr")
	WebElement RecentEntry;
	
	public void GetAccountSummary() {
		
		System.out.println("Entering Account Summary!!");
		AccountSummary.click();
		AccountSelect.click();
		AccountBtn.click();
		System.out.println("Recent Entry:  "+RecentEntry.getText());
		
	}
	

}
