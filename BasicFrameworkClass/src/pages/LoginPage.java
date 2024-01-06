package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver; 
	
	@FindBy(name = "usernameInput")
	public WebElement email;
	
	@FindBy(id = "password-input")
	public WebElement password;
	
	@FindBy(id = "signIn")
	public WebElement signIn;
	
	@FindBy(xpath = "//div[@id='UsernameTextField__errors-usernameInput']")
	public WebElement emailError;
	
	@FindBy(xpath = "//div[@id='PasswordTextField__errors-password']")
	public WebElement passError;
	
	@FindBy(xpath = "//div[@id='globalError']")
	public WebElement globalErr;
	
	@FindBy (xpath= "//button[@aria-label=\'Close\']")
	public WebElement popup;
	
	 public void openbrowser() throws IOException {
		
		FileInputStream f = new FileInputStream("/Users/rajvi/Desktop/Testing/Test.properties");
		
		Properties pr = new Properties();	
		pr.load(f);  
		
		String browser=pr.getProperty("browser");
		
		if(browser.equals("Firefox"))
		{
		System.setProperty("webdriver.gecko.driver", "/Users/rajvi/Desktop/SeleniumJars/geckodriver");
		 driver = new FirefoxDriver();
		}
		PageFactory.initElements(driver, this);
	}
	
	public void openPage() {
		driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=qsBtViKhF3I&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL2F1dGguc2NvdGlhb25saW5lLnNjb3RpYWJhbmsuY29tXC8iLCJvYXV0aF9rZXkiOiJxc0J0VmlLaEYzSSIsImNvbnNlbnRfcmVxdWlyZWQiOmZhbHNlLCJyZWRpcmVjdF91cmkiOiJodHRwczpcL1wvd3d3LnNjb3RpYW9ubGluZS5zY290aWFiYW5rLmNvbVwvb25saW5lXC9sYW5kaW5nXC9vYXV0aGxhbmRpbmcuYm5zIiwiZXhwIjoxNzAzODc4MTcwLCJpYXQiOjE3MDM4NzY5NzAsImp0aSI6IjBjNTQwNGI1LTQzYzktNDNlMS05MDhhLTllYzJjN2JjZTQ5MCIsImNsaWVudF9pZCI6IjhlZTkwYzM5LTFjNTItNGZmNC04YWU2LWE3YjU0YzUzOTkzMyIsImNsaWVudF9tZXRhZGF0YSI6eyJDaGFubmVsSUQiOiJTT0wiLCJBcHBsaWNhdGlvbkNvZGUiOiJINyJ9LCJpc3N1ZXIiOiJodHRwczpcL1wvcGFzc3BvcnQuc2NvdGlhYmFuay5jb20ifQ.C7uyeQD_H5fw5BPQZiNRbhyFOcoE3YlphNEveRdMZnZI2-UB6ZFCH2A21HrjrCZxrmirMTeGXKYSx2XKNDsHvABFsPClQDtAzqfl_j4aBKkoZWGzdN5M5Za1nX8hGzZBSlDmIEwLHIXaLFiAnZukVCBNS-cx1E93m7YH8uknciz9Xle141-wrwCvXopQUI6kWIqpz8Ee6LKw9oInogPDhxOLltC48uGBUyht9ApuSk-8jUxMsDRy7DshJw65lawCChDLl1I12EKMNpWJEbl0lUia4FcUf79yg-yb6yzFDCDP_NUpndSpmvsi9kcQvFqk5NBL0qJWmibbwTO5Y8XIfg&preferred_environment=");
			}
	
	public void closebrowser() {
		
		driver.close();

	}
	public void login(String a,String b) throws InterruptedException {
		
		  email.sendKeys(a);
		  password.sendKeys(b);
		  Thread.sleep(2000);
		  popup.click();
		  Thread.sleep(1000);
		  signIn.click();

	}
	public String readGlblErr() {
		
		String actualError = globalErr.getText();
		System.out.println(actualError);
		return actualError;

	}
	public String readEmailErr() {
		
		String actualError = emailError.getText();
		System.out.println(actualError);
		return actualError;


	}
	public String readPwdErr() {

		String actualError = passError.getText();
		System.out.println(actualError);
		return actualError;
	}

}
