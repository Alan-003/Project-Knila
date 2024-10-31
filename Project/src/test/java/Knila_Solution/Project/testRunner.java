package Knila_Solution.Project;



import java.awt.AWTException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testRunner extends baseClass {
	
	@BeforeMethod
	public void setup() {
		initializeDriver();
	}


	@Test(priority=1)
	public void Redirect_To_Url() {
		Login_App();
		check_assert(logo);
		
	}
	@Test(priority=2)
	public void Enter_Username_Password() {
		Login_App();
		enter_credential();
		
	}
	
	@Test(priority=3)
	public void Pick_Location_Click_Login() {
		Login_App();
		enter_app();
		check_assert(login_assert);
	}
	
	@Test(priority=4)
	public void Verify_Dashboard_Page_After_Login() {
		Login_App();
		enter_app();
		check_assert(login_assert);
		
	}
	
	@Test(priority=5)
	public void Click_Register_On_Menu() {
		Login_App();
		enter_app();
		Click_Register_Menu();
		check_assert(Nav_Register_Patient);
		
	}
	
	@Test(priority=6)
	public void Enter_Detail_Of_Demographics() {

		Login_App();
		enter_app();
		Click_Register_Menu();
		fill_form();
		check_assert(Filling_Assert);
		}
		
	
	
	@Test(priority=7)
	public void Cross_CheckDetails() {
		Login_App();
		enter_app();
		Click_Register_Menu();
		check_data();															
	}
	
	@Test(priority=8)
	public void Confirm_and_Verify_Details_Page_Redirected() throws InterruptedException{
		Login_App();
		enter_app();
		Click_Register_Menu();
		fill_form();
		Confirm_and_Verify_Patient_Details();	
	}
	
	@Test(priority=9)
	public void Start_Confirm_Visit() throws InterruptedException {
		Login_App();
		enter_app();
		Click_Register_Menu();
		fill_form();
		Start_and_Confirm_Visit();
		check_assert(Confirm_Visit_Assert);
		
	}
	@Test(priority=10)
	public void Upload_Attachment() throws InterruptedException, AWTException {
		Login_App();
		enter_app();
		Click_Register_Menu();
		fill_form();
		Start_and_Confirm_Visit();
		Upload_File();
		
	}
	@Test(priority=11)
	public void Verify_Upload_Attachment_Toaster() throws InterruptedException, AWTException {
		Login_App();
		enter_app();
		Click_Register_Menu();
		fill_form();
		Start_and_Confirm_Visit();
		Upload_File();
		
	}
	@Test(priority=12)
	public void Redirect_To_Patient_Details_Screen() throws InterruptedException, AWTException {
		Login_App();
		enter_app();
		Click_Register_Menu();
		fill_form();
		Start_and_Confirm_Visit();
		Upload_File();
		Redirect_To_Patient_Details();
		
	}
	@Test(priority=13)
	public void Attachment_Section_Has_Attachment() throws InterruptedException, AWTException {
		Login_App();
		enter_app();
		Click_Register_Menu();
		fill_form();
		Start_and_Confirm_Visit();
		Upload_File();
		Redirect_To_Patient_Details();
		Verify_Uploaded_Image();
		
	}
	@Test(priority=14)
	public void Verify_Recent_Visit_And_Uploaded_Attachment() throws InterruptedException, AWTException {
		Login_App();
		enter_app();
		Click_Register_Menu();
		fill_form();
		Start_and_Confirm_Visit();
		Upload_File();
		Redirect_To_Patient_Details();
		Revision_Date_and_Uploaded_Tag();

		
	}
	@Test(priority=15)
	public void Verify_EndVisit() throws InterruptedException, AWTException {
		Login_App();
		enter_app();
		Click_Register_Menu();
		fill_form();
		Start_and_Confirm_Visit();
		End_Visit_Action();

		
	}
	@Test(priority=16)
	public void Delete_Patient_And_Provide_Reason() throws InterruptedException, AWTException {
		Login_App();
		enter_app();
		Click_Register_Menu();
		fill_form();
		Click_Delete_Patient_Provide_Reason();
		

		
	}
	@Test(priority=17)
	public void Delete_Patient_And_Verify_Toaster() throws InterruptedException, AWTException {
		Login_App();
		enter_app();
		Click_Register_Menu();
		fill_form();
		Delete_The_Patient();
		
	}
	@Test(priority=18)
	public void Verify_Deleted_Patient_In_Records() throws InterruptedException, AWTException {
		Login_App();
		enter_app();
		Click_Register_Menu();
		Delete_Patient_In_Records();
		
	}
	@AfterMethod
    public void tearDown() {
		quitDriver();	
		System.out.println("<----Browser gets Teardown---->");

}
}
