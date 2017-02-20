package POM;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends BasePage {
	@FindBy(xpath = "//title") private WebElement homepagetitle;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifytitle(String expectedtitle) {
		
		try{
			
			
		String acctualtitle = homepagetitle.getAttribute("innerHTML");
		System.out.println(acctualtitle);
		Assert.assertEquals(expectedtitle, acctualtitle);
	
		Reporter.log("Title matches", true);
		return "pass";
		}
		
		catch(Exception e){
			
			Reporter.log("Title doesn't matches", true);
			return "fail";
		}
	



	}
	
	

}
