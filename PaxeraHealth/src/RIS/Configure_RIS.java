
package RIS;

import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Configure_RIS {
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait;
	String ip = "176";
	String branchname;
	String username = "test";
	String userpassword = "Test1234";
	Select selecteditem;
	String s;

@BeforeMethod
	public void setup() throws URISyntaxException {

	}

	// user login
	public void userlogin() {
		driver.get("http://192.0.0." + ip + "/ris");
		driver.findElement(By.id("Username")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(userpassword);
		driver.findElement(By.id("btn_Login")).click();
	}

//@Test
	// user first login
	public void risfirstlogin() {
		userlogin();
		driver.findElement(By.id("txt_Answer")).sendKeys("0");
		driver.findElement(By.id("txt_Answer2")).sendKeys("0");
		driver.findElement(By.id("btn_Login")).click();
	}

@Test
	public void addmachine() throws InterruptedException {
		userlogin();
		driver.findElement(By.id("usernameFont")).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector(".dropdown-menu-default > .dropdown-submenu:nth-of-type(3) "))).build().perform();
		action.moveToElement(driver.findElement(By.cssSelector(".garyBackGround:nth-child(2) [href=\"javascript\\:\\;\"]"))).build().perform();
		driver.findElement(By.id("HeaderOpenPopUp_Procedures")).click();

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@onload='CheckDialogFrameLoaded(`HeaderPOP`,`IFRMAEPOP`)']")));
		Thread.sleep(1000);
		//
		driver.findElement(By.xpath("//a[@onclick='MachineGridAdd();']")).click();
		driver.findElement(By.cssSelector("[class=\"dx-datagrid-edit-form-item dx-first-row dx-first-col dx-field-item dx-field-item-required dx-col-0 dx-flex-layout dx-label-h-align\"] [autocomplete]")).sendKeys("CT Machine");
		driver.findElement(By.xpath("//*[@id=\"body\"]/div[10]/div/div[2]/div/div/div/div[1]/div/div/div/div[1]/div/div[2]/div/div/div")).click();
		driver.findElement(By.cssSelector(".dx-scrollview-content [role=\"option\"]:nth-of-type(2) .dx-list-item-content")).click();
		driver.findElement(By.cssSelector(".dx-toolbar-button:nth-of-type(1) .dx-button-text")).click();
	}

@AfterMethod
	public void teardown() {
		// driver.quit();
	}
}
