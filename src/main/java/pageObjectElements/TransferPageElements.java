package pageObjectElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TransferPageElements {
	WebDriver driver;
	
	
	public TransferPageElements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ul[@class=\"sidebar\"]//li[3]//a")
	WebElement TransferFunds;
	
	@FindBy(id = "fromAccount")
	WebElement FromAccount;
	
	@FindBy(id = "toAccount" )
	WebElement ToAccount;
	
	@FindBy(id = "transferAmount")
	WebElement TransferAmount;
	
	@FindBy(id = "transfer")
	WebElement TransferButton;
	
	@FindBy(id = "_ctl0__ctl0_Content_Main_postResp")
	WebElement SpanMsgTransfer;
	
	public void TransferFunds() {
		System.out.println("Entering Tranfer Funds Page ");
		TransferFunds.click();
	}
	
	public void AmountTransfer() {
		System.out.println("Entering Transfer Amount Page");
		Select sc1= new Select(FromAccount);
		sc1.selectByValue("800002");
		Select sc2 = new Select(ToAccount);
		sc2.selectByValue("800003");
		TransferAmount.sendKeys("100");
		TransferButton.click();
		System.out.println("Success::"+SpanMsgTransfer.getText());
		
	}

}
