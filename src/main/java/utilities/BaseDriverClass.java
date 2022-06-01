package utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;



import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseDriverClass{
	
	WebDriver driver;
	DataDrivenFile DDF = new DataDrivenFile();
	public String loginURL= DDF.getURL();
	public String username = DDF.getUsername();
	public String password = DDF.getPassword();
	public String homeURL = DDF.getHomeURL();
	
	
	public WebDriver Driver_Init() {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		return driver;	
		
		
	}

}
