package Script;



import org.testng.annotations.Test;

import Genric.Excel;
import POM.HomePage;
import POM.LoginPage;
@Test
public class ValidLogin extends BaseTest{

	public void testLogin() throws Exception{
		
		LoginPage l = new LoginPage(driver);
		HomePage h = new HomePage(driver); 
		//Enter Username
		String Uname = Excel.getCellValue(XL_XPATH, "ValidLogin", 1, 0);
		l.Setusername(Uname);
		//Enter Password
		String Pword = Excel.getCellValue(XL_XPATH, "ValidLogin", 1, 1);
		l.Setpassword(Pword);
		//Enter Submit button
		l.Clickbutton();
		// verify home page title
		String expectedtitle = Excel.getCellValue(XL_XPATH, "ValidLogin", 1, 2);
		String status = h.verifytitle(expectedtitle);
		// Set Status as pass or fail
		Excel.setResult(XL_XPATH, "ValidLogin", 1, 4,status);
		
	}
	

}
