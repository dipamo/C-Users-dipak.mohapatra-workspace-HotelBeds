package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
	@FindBy(id = "username") private WebElement username;
	@FindBy(id = "password") private WebElement password;
	@FindBy(xpath = "//button[.='Submit']") private WebElement loginbutton;
	@FindBy(xpath = "//div[@class='error-message show']") private WebElement errormessage;
	
	
	public LoginPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);	
	}
	public void Setusername(String Uname){
		username.clear();
		username.sendKeys(Uname);
	}
	public void Setpassword(String Pword){
		password.sendKeys(Pword);
	}
	public void Clickbutton(){
		loginbutton.click();
	}
	public String[] GetErrormsg(String expected){
		String[] error = new String[2];
		String acctual = errormessage.getText();
		try{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.textToBePresentInElement(errormessage, expected));
		error[0] = acctual;
		error[1] = "pass";
		
		return error;
		}

		catch(Exception e){
			error[0] = acctual;
			error[1] = "fail";
			
			return error;
			
		}
		
		
	}
	
	
	
	

}
