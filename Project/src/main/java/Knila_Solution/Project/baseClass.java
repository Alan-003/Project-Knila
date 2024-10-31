package Knila_Solution.Project;

import java.awt.AWTException;


public class baseClass extends baseMethods {
	
	String projectDir = System.getProperty("user.dir");
	String excelPath = projectDir + "/resources/Test_Data.xlsx";
	String imgPath = projectDir + "\\resources\\upload_datas\\333.jpg";
    String sheetName = "Sheet1";
    ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
    
   
	public void Login_App() {
		openbrowser("https://demo.openmrs.org/openmrs/login.htm");
	}
	
	public void enter_credential() {
		enter_login("username", "Admin", "password", "Admin123");
		String element = driver.findElement(username).getAttribute("value");
		String alan = element;
		if (alan.equals("Admin")) {
			System.out.println("User can enter username and password");
		} else {
			System.out.println("User cannot enter username and password");
		}
			
	}
	
	public void enter_app() {
		login("username", "Admin", "password", "Admin123", "Registration Desk", "loginButton");
	}

	public void Click_Register_Menu() {
		click(Register_Patient);
	}
	
	public void fill_form() {
		String name = excel.getCellData(1, 1);  
        String  fam_name = excel.getCellData(2, 1);
        String Day = excel.getCellData(3, 1);
        String Year = generateRandomYear();
        String Add1 = excel.getCellData(5, 1);
        String Add2 = excel.getCellData(6, 1);
        String city = excel.getCellData(7, 1);
        String state = excel.getCellData(8, 1);
        String country = excel.getCellData(9, 1);
        String postal = excel.getCellData(10, 1);
        String phone = excel.getCellData(11, 1);
        phone = String.format("%.0f", Double.parseDouble(phone));
        postal = String.format("%.0f", Double.parseDouble(postal));
        String relation = excel.getCellData(12, 1);
        String Con_Name = name + " " +generateRandomNumber(3, 5);
        EnterText(First_Name, Con_Name);
        EnterText(Family_Name, fam_name);
        click(Next_Button);
        selectoption(Gender, "Male");
        click(Next_Button);
        EnterText(D_Day, Day);
        String Random_Month = generateRandomMonth();
        selectoption(D_Month, Random_Month);
        EnterText(D_Year, Year);
        click(Next_Button);
        EnterText(Address1, Add1);
        EnterText(Address2, Add2);
        EnterText(City, city);
        EnterText(State, state);
        EnterText(Country, country);
        EnterText(Postal, postal);
        click(Next_Button);
        EnterText(PhoneNumber, phone);
        click(Next_Button);
        selectoption(Relation, "Doctor");
        EnterText(Relation_Name, relation);
        click(Next_Button);	
	}
	
	public void check_data() {

		String name = excel.getCellData(1, 1);  
        String  fam_name = excel.getCellData(2, 1);
        String Day = excel.getCellData(3, 1);
        String Year = generateRandomYear();
        String Add1 = excel.getCellData(5, 1);
        String Add2 = excel.getCellData(6, 1);
        String city = excel.getCellData(7, 1);
        String state = excel.getCellData(8, 1);
        String country = excel.getCellData(9, 1);
        String postal = excel.getCellData(10, 1);
        String phone = excel.getCellData(11, 1);
        phone = String.format("%.0f", Double.parseDouble(phone));
        postal = String.format("%.0f", Double.parseDouble(postal));
        String relation = excel.getCellData(12, 1);
        String gender = excel.getCellData(13, 1);
        String Month = generateRandomMonth();
        String Con_Name = name + " " +generateRandomNumber(3, 5);
        EnterText(First_Name, Con_Name);
        EnterText(Family_Name, fam_name);
        click(Next_Button);
        selectoption(Gender, gender);
        click(Next_Button);
        EnterText(D_Day, Day);
        selectoption(D_Month, Month);
        EnterText(D_Year, Year);
        click(Next_Button);
        EnterText(Address1, Add1);
        EnterText(Address2, Add2);
        EnterText(City, city);
        EnterText(State, state);
        EnterText(Country, country);
        EnterText(Postal, postal);
        click(Next_Button);
        EnterText(PhoneNumber, phone);
        click(Next_Button);
        selectoption(Relation, "Doctor");
        EnterText(Relation_Name, relation);
        click(Next_Button);	
        String Conversion_Name = extract_text(Actual_Name);
        String Converted_Name = extractValueAfterColon(Conversion_Name);
        String Expected_Name = name_assert(Con_Name, fam_name);
        if (Converted_Name.equals(Expected_Name)) {
			System.out.println("Patient name cross verified");
		} else {
			System.out.println("Patient name not as expected");
		}
        String Conversion_Gender = extract_text(Actual_Gender);
        String Converted_Gender = extractValueAfterColon(Conversion_Gender);
        if (Converted_Gender.equals(gender)) {
			System.out.println("Gender cross verified");
		} else {
			System.out.println("Gender not as expected");
		}
        Day = String.format("%.0f", Double.parseDouble(Day));
        Year = String.format("%.0f", Double.parseDouble(Year));
        String Conversion_Dob = extract_text(Actual_Dob);
        String Converted_Dob = extractValueAfterColon(Conversion_Dob);
        String Expected_Dob = DOB_assert(Day, Month, Year);
        if (Converted_Dob.equals(Expected_Dob)) {
			System.out.println("DOB cross verified");
		} else {
			System.out.println("DOB not as expected");
		}
        String Conversion_Address = extract_text(Actual_Address);
        String Converted_Address = extractValueAfterColon(Conversion_Address);
        String Expected_Address = Address_assert(Add1,Add2,city,state,country,postal);
        if (Converted_Address.equals(Expected_Address)) {
			System.out.println("Address cross verified");
		} else {
			System.out.println("Address not as expected");
		}
        String Conversion_PhoneNo = extract_text(Actual_PhoneNumber);
        String Converted_PhoneNo = extractValueAfterColon(Conversion_PhoneNo);
        if (Converted_PhoneNo.equals(phone)) {
			System.out.println("Phone Number cross verified");
		} else {
			System.out.println("Phone Number not as expected");
		}
        
	}
	public void Confirm_and_Verify_Patient_Details() throws InterruptedException{
		click(Confirm_Btn);
		check_assert(Confirm_Assert);
		
	}
	public void Click_Delete_Patient_Provide_Reason() {
		click(Confirm_Btn);
		String Reason = excel.getCellData(15, 1);
		click(Delete_Patient);
		EnterText(Delete_Reason, Reason);
		waitForImageInPatientRecords(Delete_Reason);
		
	}
	public void Start_and_Confirm_Visit() {
		click(Confirm_Btn);
		click(Start_Visit);
		click(Confirm_Visit);
		

	}
	public void Upload_File() throws AWTException, InterruptedException {
		
		String Remarks = excel.getCellData(15, 1);
		click(Attachments);
		click(Upload_Field);
		fileuploadrobot(imgPath);
		EnterText(Caption, Remarks);
		click(Upload_File);
		waitForToasterAndAssert();
		
	}
	public void Redirect_To_Patient_Details() {
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().refresh();
		fluent_assert(Confirm_Assert);
		
	}
	public void Verify_Uploaded_Image() {
		waitForImageInPatientRecords(Uploaded_Image);
	}
	public void Revision_Date_and_Uploaded_Tag() {
		verifyCurrentDate(Recent_Visit_Date);
		verifyUploadTag(Attachment_Upload_Tag);
		
	}
	public void End_Visit_Action() {
		waitForImageInPatientRecords(Start_Visit_Page);
		driver.navigate().back();
		click(EndVisit);
		click(EndVisit_Yes);
	}
	public void Delete_The_Patient() {
		click(Confirm_Btn);
		String Reason = excel.getCellData(15, 1);
		click(Delete_Patient);
		EnterText(Delete_Reason, Reason);
		click(Confirm_Deletion);
		waitForToasterAndAssert();
	}
	public void Delete_Patient_In_Records() {
		String name = excel.getCellData(1, 1);  
        String  fam_name = excel.getCellData(2, 1);
        String Day = excel.getCellData(3, 1);
        String Year = generateRandomYear();
        String Add1 = excel.getCellData(5, 1);
        String Add2 = excel.getCellData(6, 1);
        String city = excel.getCellData(7, 1);
        String state = excel.getCellData(8, 1);
        String country = excel.getCellData(9, 1);
        String postal = excel.getCellData(10, 1);
        String phone = excel.getCellData(11, 1);
        phone = String.format("%.0f", Double.parseDouble(phone));
        postal = String.format("%.0f", Double.parseDouble(postal));
        String relation = excel.getCellData(12, 1);
        String Con_Name = name + " " +generateRandomNumber(3, 5);
        EnterText(First_Name, Con_Name);
        EnterText(Family_Name, fam_name);
        click(Next_Button);
        selectoption(Gender, "Male");
        click(Next_Button);
        EnterText(D_Day, Day);
        String Random_Month = generateRandomMonth();
        selectoption(D_Month, Random_Month);
        EnterText(D_Year, Year);
        click(Next_Button);
        EnterText(Address1, Add1);
        EnterText(Address2, Add2);
        EnterText(City, city);
        EnterText(State, state);
        EnterText(Country, country);
        EnterText(Postal, postal);
        click(Next_Button);
        EnterText(PhoneNumber, phone);
        click(Next_Button);
        selectoption(Relation, "Doctor");
        EnterText(Relation_Name, relation);
        click(Next_Button);	
        click(Confirm_Btn);
		String Reason = excel.getCellData(15, 1);
		click(Delete_Patient);
		EnterText(Delete_Reason, Reason);
		click(Confirm_Deletion);
		waitForToasterAndAssert();
		EnterText(Search_Bar, Con_Name);
		waitForImageInPatientRecords(Empty_Table);
		
		
	}
		
}
