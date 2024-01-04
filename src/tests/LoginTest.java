package tests;

import org.testng.annotations.Test;

import Data.Datafile;
import utilities.Xls_Reader;
import pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class LoginTest {
	
	LoginPage lp= new LoginPage();
	
	Datafile df = new Datafile();
	
	@Test
	  public void loginWithSpecialCharEmail() throws InterruptedException {
			lp.login(df.SpcCharEmail,df.pass);
			String actualError=lp.readEmailErr();
			Assert.assertEquals(actualError, df.SpecialCharError);  
	  }
	  
	  @Test
	  public void loginWithEmptyemail() throws InterruptedException {
		  	lp.login(df.EmptyEmail,df.pass);
			Thread.sleep(2000);
			String actualError=lp.readEmailErr();
			Assert.assertEquals(actualError, df.emailError);
	  }
	  
	  @Test
	  public void loginWithEmptyPwd() throws InterruptedException {
		  	lp.login(df.wrongEmail,df.EmptyPass);
		  	Thread.sleep(2000);
			String actualError=lp.readPwdErr();
			Assert.assertEquals(actualError, df.passError);
	  }
	  
	  @Test
	  public void loginWithWronEmailandWronPWD() throws InterruptedException {
		  		lp.login(df.wrongEmail,df.pass);
				Thread.sleep(2000);
				String actualError=lp.readGlblErr();
				Assert.assertEquals(actualError, df.globalErr);
	  }
  
	  @BeforeMethod
	  public void beforeMethod() throws IOException {
	 
		  lp.openbrowser();
		  lp.openPage();
	 }
	  
	  @AfterMethod
	  public void afterMethod() {
	  
	  lp.closebrowser();
 }
} 
  
  
 


