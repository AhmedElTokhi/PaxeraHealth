package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page_BranchControl {
	WebDriver driver;
	WebDriverWait wait;
	
	public Page_BranchControl(WebDriver driver) {
		//super();
		this.driver = driver;
		wait = new WebDriverWait(driver, 60, 250);
	}
	
	//Locators
	By Page_assert_Loca = By.xpath("//*[@id='ctl00_ContentPlaceHolder1_lbl_branchList']");
	By LinkAddBranch_Loca =By.partialLinkText("Add New Branch");
	
	
	
	public void Assert_CurrentPage_is_BranchControl() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Page_assert_Loca));
	}

	//Add Branch
	public void ClickAdd(){
		driver.findElement(LinkAddBranch_Loca).click();
	}
	
	
	//Edit Branch
	
	//Delete Branch
}
