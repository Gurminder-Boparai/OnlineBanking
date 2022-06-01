package utilities;



import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class DataDrivenFile {
	/*
	 * protected String loginURL; protected String userName; protected String
	 * password;
	 */
	String ConfigFilePath = System.getProperty("user.dir")+("\\resources\\config.properties");
	Properties propObj; 
	
	public DataDrivenFile() {
		propObj = new Properties();
		FileReader FRobj;
		try {
			FRobj = new FileReader(ConfigFilePath);
			propObj.load(FRobj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * loginURL = propObj.getProperty("LoginURL"); System.out.println(loginURL);
		 * userName = propObj.getProperty("username"); System.out.println(userName);
		 * password = propObj.getProperty("password"); System.out.println(password);
		 */		
	}
	public String getURL() {
		String url = propObj.getProperty("LoginURL");
		return url;
	}
	
	public String getUsername() {
	String username = propObj.getProperty("username");
	return username;
	}
	
	public String getPassword() {
		String password = propObj.getProperty("password");
		return password;	
	}
	
	public String getHomeURL() {
		String homeURL = propObj.getProperty("HomeURL");
		return homeURL;
	}

}
