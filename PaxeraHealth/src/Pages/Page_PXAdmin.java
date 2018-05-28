package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page_PXAdmin {

	WebDriver driver;
	WebDriverWait wait;
	
	public Page_PXAdmin(WebDriver driver) {
		//super();
		this.driver = driver;
		wait = new WebDriverWait(driver, 60, 250);
	}
	
	//Locators
	By Text_User_Loca = By.id("txt_UserName");
	By Text_Pass_Loca = By.id("txt_Password");
	By Button_Login_Loca = By.id("btn_Login");
	By PageCustomer_Loca= By.xpath("//*[@id='ctl00_ContentPlaceHolder1_lbl_cust']");
	By PageUsers_Loca =By.xpath("//*[@id='ctl00_ContentPlaceHolder1_div_users']//div[2]");
	By PageBranch_Loca= By.xpath("//*[@id='ctl00_ContentPlaceHolder1_lbl_branch']");
	
	
	public void login (WebDriver driver, String username, String password){
		
		
		driver.findElement(Text_User_Loca).sendKeys(username);
		driver.findElement(Text_Pass_Loca).sendKeys(password);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Button_Login_Loca));	
		driver.findElement(Button_Login_Loca).click();
		}
	
	public void NavigateToCustomer(){
		driver.findElement(PageCustomer_Loca).click();
	}
	
	public void NaviagetToBranchControl(){
		driver.findElement(PageBranch_Loca).click();
	}
	
	public void NavigateToUserControl (){
		driver.findElement(PageUsers_Loca).click();
	}

	
}
