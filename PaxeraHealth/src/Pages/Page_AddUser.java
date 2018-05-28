package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Page_AddUser {

	WebDriver driver;
	WebDriverWait wait;

	public Page_AddUser(WebDriver driver) {
		// super();
		this.driver = driver;
		wait = new WebDriverWait(driver, 60, 250);
	}

	// Locators
	By Page_assert_Loca = By.xpath("//*[@id='ctl00_ContentPlaceHolder1_lbl_AddUser']");
	By textFullName_Loca = By.id("ctl00_ContentPlaceHolder1_txt_FullName");
	By textUserName_Loca = By.id("ctl00_ContentPlaceHolder1_txt_UserName");
	By textPassword_Loca = By.id("ctl00_ContentPlaceHolder1_txt_Password");
	By textPasswordConfirm_Loca = By.id("ctl00_ContentPlaceHolder1_txt_Confirm");

	By CheckBoxChangePass_Loca = By.xpath("//div[@id='FirstLogin']//ins[@class='iCheck-helper']");
	By CheckBoxRenewal_Loca = By.xpath("//div[@id='Renewal']//ins[@class='iCheck-helper']");

	By ListJobType_Loca = By.xpath("//div[@id='mainTD']//select[@name='ctl00$ContentPlaceHolder1$ddl_JobType']");

	By ListAccountType_Loca = By.id("ctl00_ContentPlaceHolder1_ddl_AccountType");

	By CheckBoxPartial_Loca = By.xpath(
			"//div[@id='mainTD']//div[@class='col-md-5 col-sm-6 col-xs-12']/table[@class='ListControl']//tr[1]/td[1]//ins[@class='iCheck-helper']");
	By CheckBoxCompleteNotVerified_Loca = By.xpath(
			"//div[@id='mainTD']//div[2]/div[@class='col-md-5 col-sm-6 col-xs-12']/table[@class='ListControl']/tbody/tr[1]/td[2]//ins[@class='iCheck-helper']");
	By CheckBoxVerified_Loca = By.xpath(
			"//div[@id='mainTD']//div[2]/div[@class='col-md-5 col-sm-6 col-xs-12']/table[@class='ListControl']/tbody/tr[2]/td[1]//ins[@class='iCheck-helper']");

	By ListCustomer_Loca = By.xpath("//*[@id='ctl00_ContentPlaceHolder1_ddl_CustomerName']");
	By ListBranch_Loca = By.xpath("//div[@id='mainTD']//select[@name='ctl00$ContentPlaceHolder1$ddl_BranchName']");
	By ListLanguage_Loca= By.xpath("//div[@id='mainTD']//select[@name='ctl00$ContentPlaceHolder1$ddl_DefaultLanguage']");

	By CheckBoxAllBranches_Loca = By.xpath("//*[@id='ctl00_ContentPlaceHolder1_grid_Branches']/tbody/tr[1]/th[1]//div");

	By ButtonSave_Loca = By.id("ctl00_ContentPlaceHolder1_btn_Add");

	By MSGSuccess_Loca = By.xpath("//*[@id='ctl00_ContentPlaceHolder1_lbl_Add']//span");
	By MSGErro_Loca = By.xpath("//div[@class='col-xs-12 text-center']/span[@class='con-label']//span");

	public void Assert_CurrentPage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Page_assert_Loca));
	}

	public void AddNewUser(String FullName, String UserName, String PassWord, String JobTypeValue,
			String AccountTypeValue, String CustomerName, String BranchName, int LanguageIndex) throws Exception {

		// Enter FullName
		driver.findElement(textFullName_Loca).sendKeys(FullName);
		// Enter UserName
		driver.findElement(textUserName_Loca).sendKeys(UserName);
		// Enter Password
		driver.findElement(textPassword_Loca).sendKeys(PassWord);
		// Enter Password
		driver.findElement(textPasswordConfirm_Loca).sendKeys(PassWord);

		// CheckBox ( must be changed PassWord)
		driver.findElement(CheckBoxChangePass_Loca).click();
		// CheckBox2 (Renew PassWord after period)
		driver.findElement(CheckBoxRenewal_Loca).click();

		// select Job Type
		WebElement JobType_List = driver.findElement(ListJobType_Loca);
		Select SelectJobType = new Select(JobType_List);

		SelectJobType.selectByValue(JobTypeValue);

		// select Account Type
		WebElement AccountType_List = driver.findElement(ListAccountType_Loca);
		Select SelectAccountType = new Select(AccountType_List);

		SelectAccountType.selectByValue(AccountTypeValue);

		// Check Report Status (Partial)
		driver.findElement(CheckBoxPartial_Loca).click();
		// Check Report Status (Completed Not Verified)
		driver.findElement(CheckBoxCompleteNotVerified_Loca).click();
		// Check Report Status (Verified)
		driver.findElement(CheckBoxVerified_Loca).click();

		// Select Customer.
		WebElement Customer_List = driver.findElement(ListCustomer_Loca);
		Select SelectCustomer = new Select(Customer_List);

		SelectCustomer.selectByVisibleText(CustomerName);
		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(ListBranch_Loca));
		// ==========================
		// Select Default Branch.
		WebElement Branch_List = driver.findElement(ListBranch_Loca);
		Select SelectDefaultBranch = new Select(Branch_List);

		SelectDefaultBranch.selectByVisibleText(BranchName);
		System.out.println("Branch Selected");
		// //OR
		// driver.findElement(ListBranch_Loca).click();
		// Thread.sleep(2000);
		// driver.findElement(ListBranch_Loca).sendKeys(Keys.DOWN);
		// Thread.sleep(2000);
		// driver.findElement(ListBranch_Loca).sendKeys(Keys.ENTER);
		// Thread.sleep(2000);
		// ==========================
		// Scroll to control
		WebElement AllBranchChB = driver.findElement(CheckBoxAllBranches_Loca);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", AllBranchChB);

		// OR
		// ((JavaScriptExecutor)driver).ExecuteScript("arguments[0].scrollIntoView(true);",AllBranchChB);
		// AllBranchChB);
		// ==========================

		//Select Default Language
		
		WebElement Language_List=driver.findElement(ListLanguage_Loca);
		
		Select SelectDefaultLanguage= new Select(Language_List);
		
		SelectDefaultLanguage.selectByIndex(LanguageIndex);
		
		
		// Select All Branches
		driver.findElement(CheckBoxAllBranches_Loca).click();
		Thread.sleep(2000);
		
		
		//Refer to Role up to user type.

		// Click Save.
		driver.findElement(ButtonSave_Loca).click();
	}

	public void Assert_AddedUser(String UserFullName) {

		WebElement AllBranchChB = driver.findElement(CheckBoxAllBranches_Loca);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AllBranchChB);

		String SuccessMSG = driver.findElement(MSGSuccess_Loca).getText();

		Assert.assertTrue(SuccessMSG.contains("successfully"));
		System.err.println("The User '"+ UserFullName +"' added successfully");
	}
}
