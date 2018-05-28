package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page_AddBranch {
	WebDriver driver;
	WebDriverWait wait;

	public Page_AddBranch(WebDriver driver) {
		// super();
		this.driver = driver;
		wait = new WebDriverWait(driver, 60, 250);
	}

	// Locators
	By Page_assert_Loca = By.id("ctl00_ContentPlaceHolder1_lbl_addBranchInfo");
	By CustomerList_Loca= By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ddl_AddCustomerName']");
	By BranchList_Loca= By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ddl_AddBranchName']");
	By CountryList_Loca=By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ddl_Country']");
	By TimeZoneList_Loca= By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ddl_TimeZone']");
	By Text_ServerName_Loca=By.id("ctl00_ContentPlaceHolder1_txt_AddServer_Sql_Name");
	By TextDBUser_Loca=By.id("ctl00_ContentPlaceHolder1_txt_AddBranch_LoginName");
	By TextDBPassword_Loca=By.id("ctl00_ContentPlaceHolder1_txt_AddBranch_LoginPassword");
	By TextDBPasswordconfirm_Loca=By.id("ctl00_ContentPlaceHolder1_txt_ConfirmPassword");
	By TextProfileDirectory_Loca=By.id("ctl00_ContentPlaceHolder1_txt_AddUser_Profile_Directory");
	By TextPatietDirectory_Loca =By.id("ctl00_ContentPlaceHolder1_txt_AddPatient_Directory");
	By TextTemplateDirectory_Loca=By.id("ctl00_ContentPlaceHolder1_txt_AddUserTemplates");
	By TextPACSIP_Loca= By.id("ctl00_ContentPlaceHolder1_txt_AddPACS_IP");
	By TextPACSAE_Loca = By.id("ctl00_ContentPlaceHolder1_txt_AddPACS_AE");
	By TextPACSPort_Loca=By.id("ctl00_ContentPlaceHolder1_txt_AddPACS_Port");
	By TextSender_Loca=By.id("ctl00_ContentPlaceHolder1_txt_sendentity");
	By ButtonAddBranch_Loca=By.id("ctl00_ContentPlaceHolder1_btn_Add");
	By BuutonBack_loca= By.id("ctl00_ContentPlaceHolder1_btn_Back");
	By MSGSuccessfully_Loca=By.xpath("//*[@id='ctl00_ContentPlaceHolder1_lbl_Add']//span");

	
	
	public void Assert_CurrentPage_is_AddBranch() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Page_assert_Loca));
	}

	// Add Branch.
	public void AddnewBranch (String Customer_Name, String BranchName, String Country, String Zone,String ip,int index,String DBUser, String DBPassword ) throws InterruptedException{
		
		//select Customer
		WebElement Cust_List=driver.findElement(CustomerList_Loca);
		Select SelectCust= new Select(Cust_List);
				
		SelectCust.selectByVisibleText(Customer_Name);
		
		//select Branch
		wait.until(ExpectedConditions.visibilityOfElementLocated(BranchList_Loca));
		WebElement Branch_List=driver.findElement(BranchList_Loca);
		Select SelectBranch= new Select(Branch_List);
		
		SelectBranch.selectByVisibleText(BranchName);
		
		//Select Country
		WebElement CountryList=driver.findElement(CountryList_Loca);
		Select SelectCountry= new Select(CountryList);
				
		SelectCountry.selectByVisibleText(Country);
		
		
		//Select TimeZone
		WebElement ZoneList=driver.findElement(TimeZoneList_Loca);
		Select SelectZone= new Select(ZoneList);
				
		SelectZone.selectByVisibleText(Zone);
		
		//
		driver.findElement(Text_ServerName_Loca).sendKeys("192.0.0." + ip + "\\sqlexpress");
		driver.findElement(TextDBUser_Loca).sendKeys(DBUser);
		driver.findElement(TextDBPassword_Loca).sendKeys(DBPassword);
		driver.findElement(TextDBPasswordconfirm_Loca).sendKeys(DBPassword);
		
		// ==========================
		//Scroll Down
		WebElement Scroll = driver.findElement(ButtonAddBranch_Loca);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", Scroll);
		//// ==========================
		Thread.sleep(2000);
		
		driver.findElement(TextProfileDirectory_Loca).sendKeys("C:\\Profile");
		driver.findElement(TextPatietDirectory_Loca).sendKeys("C:\\Patient");
		driver.findElement(TextTemplateDirectory_Loca).sendKeys("C:\\Template");
		driver.findElement(TextPACSIP_Loca).sendKeys("192.0.0."+ ip);
		driver.findElement(TextPACSAE_Loca).sendKeys("PACS"+ip);
		driver.findElement(TextPACSPort_Loca).sendKeys("104");
		driver.findElement(TextSender_Loca).sendKeys("Sender"+ip+"_"+index); // need to handle cases for Sender_1 for branch1 and _2 for branch2 
		driver.findElement(ButtonAddBranch_Loca).click();
	}
	
	public void AssertAddedBranch (String BranchName){
		
		wait.until(ExpectedConditions.attributeContains(MSGSuccessfully_Loca,"innerText", "Addition was done successfully."));
	//OR =======================
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MSGSuccessfully_Loca));
//
//		String Message=driver.findElement(MSGSuccessfully_Loca).getText();
//		Assert.assertTrue(Message.contains("  Addition was done successfully."));
	// =======================
		System.err.println("The Branch '"+BranchName+"' successfully");
	}
	
	public void BackToBranchControl(){
		driver.findElement(BuutonBack_loca).click();
	}
	
	// Edit Branch.

	// Delete Branch.
}
