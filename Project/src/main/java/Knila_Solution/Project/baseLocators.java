package Knila_Solution.Project;

import org.openqa.selenium.By;

public class baseLocators {
	
	By logo=By.xpath("//div[@class='logo']/child::a/child::img");
	By username=By.xpath("//input[@id='username']");
	By registration_desk=By.xpath("//li[contains(@id,'Registration Desk')]");
	By login_assert=By.xpath("//h4[contains(text(),'Logged in as Super User (admin)')]");
	By Register_Patient=By.xpath("//i[@class='icon-user']/parent::a|(//i[@class='icon-user']/parent::a)[2]");
	By Nav_Register_Patient=By.xpath("//h2[contains(text(),'Register a patient')]");
	By First_Name = By.xpath("//input[@name='givenName']");
	By Family_Name = By.xpath("//input[@name='familyName']");
	By Next_Button = By.xpath("//button[@id='next-button']");
	By Gender = By.xpath("//select[@id='gender-field']");
	By D_Day = By.xpath("//input[@name='birthdateDay']");
	By D_Month = By.xpath("//select[@name='birthdateMonth']");
	By D_Year = By.xpath("//input[@name='birthdateYear']");
	By Address1 = By.xpath("//input[@name='address1']");
	By Address2 = By.xpath("//input[@name='address2']");
	By City = By.xpath("//input[@name='cityVillage']");
	By State = By.xpath("//input[@id='stateProvince']");
	By Country = By.xpath("//input[@id='country']");
	By Postal = By.xpath("//input[@id='postalCode']");
	By PhoneNumber = By.xpath("//input[@name='phoneNumber']");
	By Relation = By.xpath("//select[@id='relationship_type']");
	By Relation_Name = By.xpath("//input[contains(@placeholder,'Person Name')]");
	By Filling_Assert = By.xpath("//div[contains(text(),'Confirm submission?')]");
	By Actual_Name = By.xpath("//span[contains(text(),'Name: ')]/parent::p");
	By Actual_Gender = By.xpath("//span[contains(text(),'Gender:')]/parent::p");
	By Actual_Dob = By.xpath("//span[contains(text(),'Birthdate:')]/parent::p");
	By Actual_Address = By.xpath("//span[contains(text(),'Address:')]/parent::p");
	By Actual_PhoneNumber = By.xpath("//span[contains(text(),'Phone Number:')]/parent::p");
	By Confirm_Btn = By.xpath("//input[@id='submit']");
	By Confirm_Assert = By.xpath("//span[normalize-space(text())='Show Contact Info']");
	By Delete_Patient = By.xpath("//div[contains(text(),'Delete Patient')]");
	By Delete_Reason = By.xpath("//input[@id='delete-reason']");
	By Confirm_Deletion = By.xpath("//input[@id='delete-reason']/parent::div/child::button[@class='confirm right']");
	By Edit_Information = By.xpath("//div[normalize-space(text())='Edit Registration Information']");
	By Start_Visit = By.xpath("//div[normalize-space(text())='Start Visit']");
	By Confirm_Visit = By.xpath("//h3[normalize-space(text())='Start a visit']/parent::div/following-sibling::div/child::button[contains(text(),'Confirm')]");
	By Confirm_Visit_Assert = By.xpath("//span[contains(text(),'Show Contact Info')]");
	By Attachments = By.xpath("//a[contains(@id,'attachments.attachments.visitActions.default')]/child::i[@class='icon-paper-clip']");
	By Upload_Field = By.xpath("//div[contains(text(),'Click or drop a file here.')]");
	By Caption = By.xpath("//h3[contains(text(),'Caption')]/parent::div/child::textarea");
	By Upload_File = By.xpath("//button[contains(text(),'Upload file')]");
	By Uploaded_Image = By.xpath("//img[contains(@class,'ng-isolate-scope')]");
	By Upload_Toaster = By.xpath("//div[contains(@class, 'toast-type-success')]//p");
	By Recent_Visit_Date = By.xpath("//h3[contains(text(),'RECENT VISITS')]/ancestor::div[@class='info-header']/following-sibling::div[@class='info-body']/descendant::a[contains(@class,'ng-binding')]");
	By Attachment_Upload_Tag = By.xpath("//h3[contains(text(),'RECENT VISITS')]/ancestor::div[@class='info-header']/following-sibling::div[@class='info-body']/descendant::div");
	By EndVisit = By.xpath("(//h3[contains(text(),'Current Visit Actions')]/parent::ul/child::li/child::a/child::div/child::div[normalize-space(text())='End Visit'])[2]");
	By EndVisit_Yes = By.xpath("//h3[contains(text(),'End Visit')]/parent::div/following::div/descendant::button[@class='confirm right']");
	By Start_Visit_Page = By.xpath("//i[@class='icon-off']/parent::a");
	By Search_Bar = By.xpath("//input[@id='patient-search']");
	By Empty_Table = By.xpath("//td[@class='dataTables_empty']");

}

