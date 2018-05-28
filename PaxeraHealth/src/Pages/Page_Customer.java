package Pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page_Customer {

	WebDriver driver;
	WebDriverWait wait;

	public Page_Customer(WebDriver driver) {
		// super();
		this.driver = driver;
		wait = new WebDriverWait(driver, 60, 250);
	}

	// Locators
	By Page_assert_Loca = By.xpath("//*[@id='ctl00_ContentPlaceHolder1_lbl_custList']");
	By LinkAddCustomer_Loca=By.partialLinkText("Add New Customer");
	By ListCustomer_loca=By.id("ctl00_ContentPlaceHolder1_ddl_AddCustomerName");
	By ButtonAddCustomer_Loca=By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btn_Add']");
	By MSGSuccess_Loca= By.xpath("//*[@id='ctl00_ContentPlaceHolder1_lbl_Add']/div/span");
	By linkHome_Loca= By.partialLinkText("Home");
	
	public void Assert_CurrentPage_is_Customer() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Page_assert_Loca));
	}
	
	public void Add_NewCustomer(String Customer_Name){
		
		driver.findElement(LinkAddCustomer_Loca).click();
		
		WebElement Customerlist = driver.findElement(ListCustomer_loca);
		
		Select SelectCustomer= new Select(Customerlist);
		
		SelectCustomer.selectByVisibleText(Customer_Name);
	
		driver.findElement(ButtonAddCustomer_Loca).click();
	}
		
	public void Assert_AddedCustomer (){
		wait.until(ExpectedConditions.visibilityOfElementLocated(MSGSuccess_Loca));
		String Message= driver.findElement(MSGSuccess_Loca).getText();
		
		assertTrue(Message.contains("successfully"));
	}
		
	public void GoTOHome(){
		driver.findElement(linkHome_Loca).click();
	}
		
	}
	
	// Rename customer name.

	//Delete Customer
	
	//Add customer logo.
	
	//delete customer logo.
	
	//Add customer banner.
	
	//Delete customer banner.	

