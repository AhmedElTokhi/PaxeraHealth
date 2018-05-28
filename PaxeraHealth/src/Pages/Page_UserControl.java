package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Page_UserControl {

	WebDriver driver;
	WebDriverWait wait;
	
	public Page_UserControl(WebDriver driver) {
		//super();
		this.driver = driver;
		wait = new WebDriverWait(driver, 60, 250);
	}
	
	//Locators
	By Page_assert_Loca = By.xpath("//*[@id='ctl00_ContentPlaceHolder1_lbl_custList']");
	By ListCustomer_Loca =By.xpath("//select[@name='ctl00$ContentPlaceHolder1$ddl_CustomerNameSearch']");
	By TextUserName_Loca=By.xpath("//input[@name='ctl00$ContentPlaceHolder1$txt_UserName']");
	By ButtonSearch_loca = By.xpath("//input[@name='ctl00$ContentPlaceHolder1$btn_Search']");
	By ButtonEdit_Loca =By.xpath("//*[@id='ctl00_ContentPlaceHolder1_grid_Admins']//tr[2]/td[4]/a");
	
	public void Assert_CurrentPage (){		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Page_assert_Loca));
		
//		System.out.println("The page contain: "+TextValue);  							//for tester output in console
//	//OR	
//		String TextValue = driver.findElement(Page_assert_Loca).getText();     
//		Assert.assertTrue(TextValue.contains("Users List"));  					//Valid check
		
	//OR	
//		String TextValue = driver.findElement(Page_assert_Loca).getText(); 
//		Assert.assertEquals(TextValue, "Users List");   						//Valid check
	}
	
	public void NavigateToAddUser (){
		driver.findElement(By.partialLinkText("Add New User")).click();
	} 
	
	
	public void SearchForUser (String CustomerName, String searchkey){
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(ListCustomer_Loca));

		// Select Customer.
		WebElement Customer_List=driver.findElement(ListCustomer_Loca);
		Select SelectCustomer=new Select(Customer_List);
				
		SelectCustomer.selectByVisibleText(CustomerName);
		driver.findElement(TextUserName_Loca).sendKeys(searchkey);;
		
		driver.findElement(ButtonSearch_loca).click();		
	}
	
	public void AssertForSearchResult (String searchkey) {
		
		// 1) Create the object of the first table.
		WebElement elemTable = driver.findElement(By.xpath("//table[@id='ctl00_ContentPlaceHolder1_grid_Admins']"));

		// 2) Get all the Rows of table from this elemTable variable.
		List<WebElement> trlist = elemTable.findElements(By.tagName("tr"));

		// String variable for search keyword
		//String searchkey = "Facebook.com";

		// String variable to be used in Assertion
		String Assetwith = null;
		
		//for tester check on console
//		System.out.println("Row number " + trlist.size());
		for (WebElement elemTr : trlist) {

			// Fetch the columns from a particular row (for each row)
			List<WebElement> tdlist = elemTr.findElements(By.xpath("td"));

			//for tester check on console
//			System.out.println("Column size" + tdlist.size());

			for (WebElement w : tdlist) {

				String S = w.getText();
				
				//for tester check on console
//				System.out.println("Current cell Value: " + S);

				if (S.contains(searchkey)) {
					Assetwith = S;
					
					break;
				}
			}
		}
		// Assert for table contain (Search keyword)
		Assert.assertTrue(Assetwith.contains(searchkey));
		System.err.println("list contain value: " + searchkey);
	}

	public void EditUser(){
		
		driver.findElement(ButtonEdit_Loca).click();
		
	}
}
