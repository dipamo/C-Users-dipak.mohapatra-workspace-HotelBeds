package Script;


import org.testng.annotations.Test;

import Genric.Excel;

import POM.LoginPage;

@Test
public class InvalidLogin extends BaseTest {
	
	
	public void testInvalidLogin() throws Exception{
		
		LoginPage l = new LoginPage(driver);
		 
		for(int r = 1;r<=3;r++){
		//Invalid Username
		String Uname = Excel.getCellValue(XL_XPATH, "InvalidLogin", r, 0);
		l.Setusername(Uname);
		//invalid password
		String Pword = Excel.getCellValue(XL_XPATH, "InvalidLogin", r, 1);
		l.Setpassword(Pword);
//		click on login button
		l.Clickbutton();
		
		String expectederror = Excel.getCellValue(XL_XPATH, "InvalidLogin", r, 2);
		String []status = l.GetErrormsg(expectederror);
		Excel.setResult(XL_XPATH, "InvalidLogin", r, 3, status[0]);
		Excel.setResult(XL_XPATH, "InvalidLogin", r, 4, status[1]);
		
		}
		
		
		
	}
	

}
