package RIS;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.Page_AddBranch;
import Pages.Page_AddUser;
import Pages.Page_BranchControl;
import Pages.Page_Customer;
import Pages.Page_PXAdmin;
import Pages.Page_UserControl;

public class PXadmin_TestCase {

	WebDriver driver;
	WebDriverWait wait;


	@DataProvider(name = "JobType")
	public Object[][] UsersJobType() {

			String[][] Data = {
						{"Doctor", "Test1", "Test1234", "1", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
						{"Administrator", "Test2", "Test1234", "2", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
						{"Receptionist", "Test3", "Test1234", "3", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
						{"Technician", "Test4", "Test1234", "4", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
						{"Accountant", "Test5", "Test1234", "5", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
						{"Secretary", "Test6", "Test1234", "6", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
						{"Typist", "Test7", "Test1234", "7", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
						{"Nurse", "Test8", "Test1234", "8", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
						{"warehouser", "Test9", "Test1234", "9", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
						{"Engineer", "Test10", "Test1234", "10", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
						{"system Administrator", "Test11", "Test1234", "11", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
						{"Researcher", "Test12", "Test1234", "12", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
						{"Referring Physician", "Test13", "Test1234", "13", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
						{"Radiologist", "Test14", "Test1234", "14", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
					  //{"Test15", "Test15", "Test1234", "15", "0", "Tokhi Customer", "1", "0"},		// cannot create patient user from PXadmin
						{"CareAdmin", "Test16", "Test1234", "16", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
						{"Call Center", "Test17", "Test1234", "17", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
						{"Sales", "Test18", "Test1234", "18", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
						};
		
// =================================		
//	//add multi user for same type	
//			String[][] Data = {
//			{"rad1", "rad1", "Test1234", "14", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
//			{"rad2", "rad2", "Test1234", "14", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
//			{"rad2", "rad3", "Test1234", "14", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
//			{"rad4", "rad4", "Test1234", "14", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
//			{"rad5", "rad5", "Test1234", "14", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
//			{"rad6", "rad6", "Test1234", "14", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
//			{"rad7", "rad7", "Test1234", "14", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
//			{"rad8", "rad8", "Test1234", "14", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
//			{"rad9", "rad9", "Test1234", "14", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
//			{"rad10", "rad10", "Test1234", "14", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
//			{"rad11", "rad11", "Test1234", "14", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
//			{"rad12", "rad12", "Test1234", "14", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
//			{"rad13", "rad13", "Test1234", "14", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
//			{"rad14", "rad14", "Test1234", "14", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
//			{"rad15", "rad15", "Test1234", "14", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
//			{"rad16", "rad16", "Test1234", "14", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
//			{"rad17", "rad17", "Test1234", "14", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
//			{"rad18", "rad18", "Test1234", "14", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
//			{"rad19", "rad19", "Test1234", "14", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
//			{"rad20", "rad20", "Test1234", "14", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
//			{"rad21", "rad21", "Test1234", "14", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
//			{"rad22", "rad22", "Test1234", "14", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
//			{"rad23", "rad23", "Test1234", "14", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
//			{"rad24", "rad24", "Test1234", "14", "0", "Tokhi Customer", "Tokhi Branch1", "0"},
//			};
			return Data;
			
		
	}

//	@Test (priority=1)
	public void Addcustomer () throws IOException{
		utils.ReadingPropertiesFile data = new utils.ReadingPropertiesFile("./ReadFrom/UltimaConfig.properties");
	
		Page_PXAdmin adminP=new Page_PXAdmin(driver);
		Page_Customer CustomerP= new Page_Customer(driver);
		
		adminP.login(driver, data.GetUserName_Pxadmin(), data.GetPassword_PXadmin());
		adminP.NavigateToCustomer();
		CustomerP.Assert_CurrentPage_is_Customer();
		
		CustomerP.Add_NewCustomer(data.GetCustomer_Name());
		CustomerP.Assert_AddedCustomer();	
		
		System.err.println("Customer '"+ data.GetCustomer_Name() +"' Added successfully");
	}
	
	
//	@Test (priority=2)
	public void AddBranches () throws Exception{
		utils.ReadingPropertiesFile data = new utils.ReadingPropertiesFile("./ReadFrom/UltimaConfig.properties");
		
		Page_PXAdmin adminP=new Page_PXAdmin(driver);
		adminP.login(driver, data.GetUserName_Pxadmin(), data.GetPassword_PXadmin());
		adminP.NaviagetToBranchControl();
	
		for (int i = 1; i < 10; i++) {
			
		//Add Branch
		Page_BranchControl BranchCP=new Page_BranchControl(driver);
		BranchCP.Assert_CurrentPage_is_BranchControl();
		BranchCP.ClickAdd();
		
		Page_AddBranch AddBranchP=new Page_AddBranch(driver);
		AddBranchP.Assert_CurrentPage_is_AddBranch();
		
		AddBranchP.AddnewBranch(data.GetCustomer_Name(), data.GetBranch(i), data.GetCountry(), data.GetZone(), data.GetIP(),i, data.GetUser_DB(), data.GetPassword_DB());
		Thread.sleep(1500);
	
		AddBranchP.AssertAddedBranch(data.GetBranch(i));
		
		//Go to Branch control
		AddBranchP.BackToBranchControl();
		BranchCP.Assert_CurrentPage_is_BranchControl();
		}
	}

	
	@Test(priority=3, dataProvider = "JobType")
	public void AddUser_TestCase(String FName, String UName, String Pass, String JobTypeIndex, String AccountIndex, String CusName, String BranchName, String DefaultLang) throws Exception {
		System.out.println(":@Test");
		utils.ReadingPropertiesFile data = new utils.ReadingPropertiesFile("./ReadFrom/UltimaConfig.properties");
		
		Page_PXAdmin adminP=new Page_PXAdmin(driver);
		adminP.login(driver, data.GetUserName_Pxadmin(), data.GetPassword_PXadmin());
		
		Page_UserControl ctrluserP = new Page_UserControl(driver);
		Page_AddUser addUser = new Page_AddUser(driver);


		adminP.NavigateToUserControl();
		ctrluserP.Assert_CurrentPage();

		ctrluserP.NavigateToAddUser();
		
		//Convert String value to integer
//		int x=Integer.valueOf(DefaultB);
//		int y=Integer.parseInt(DefaultLang);
		addUser.AddNewUser(FName, UName, Pass, JobTypeIndex, AccountIndex, CusName, BranchName, Integer.parseInt(DefaultLang));
		Thread.sleep(2000);
		addUser.Assert_AddedUser(FName);
	
	}

	// @Test
	public void SearchForUser() throws IOException {
		utils.ReadingPropertiesFile data = new utils.ReadingPropertiesFile("./ReadFrom/UltimaConfig.properties");
		
		Page_PXAdmin adminP = new Page_PXAdmin(driver);
		Page_UserControl ctrluserP = new Page_UserControl(driver);

		adminP.login(driver, data.GetUserName_Pxadmin(), data.GetPassword_PXadmin());
		adminP.NavigateToUserControl();

		ctrluserP.SearchForUser("Tokhi Customer", "Ahmed33");
		ctrluserP.AssertForSearchResult("Ahmed33");
	}

	// @Test 
	public void EditUser() throws IOException {
		utils.ReadingPropertiesFile data = new utils.ReadingPropertiesFile("./ReadFrom/UltimaConfig.properties");
		
		Page_PXAdmin adminP = new Page_PXAdmin(driver);
		Page_UserControl ctrluserP = new Page_UserControl(driver);

		adminP.login(driver, data.GetUserName_Pxadmin(), data.GetPassword_PXadmin());
		adminP.NavigateToUserControl();

		ctrluserP.SearchForUser("Tokhi Customer", "Ahmed33");
		ctrluserP.AssertForSearchResult("Ahmed33");

		ctrluserP.EditUser();
	}

	@BeforeMethod
	public void Setup() throws IOException {
		System.out.println(":@BeforeMethod");
		
		utils.ReadingPropertiesFile data = new utils.ReadingPropertiesFile("./ReadFrom/UltimaConfig.properties");

		// Read (Browser) from property file throw method in [utils] Package and add it in String variable [browser].
		String browser = data.GetBrowser();

		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		if (browser.equals("IE")){
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		// Read URL from property file throw method in [utils] Package
		driver.get(data.GetURL());
	//OR			
//		driver.get("http://192.0.0." + data.GetIP() + "/pxadmin");
	}

	@AfterMethod
	public void TearDown(ITestResult Result) throws IOException {
		System.out.println(":@AfterMethod");
		
		//	=================here add time stamp=================================
				long TimeStamp = System.currentTimeMillis();
		// ====================here add take Screen capture in case of============= 
				
				if(Result.isSuccess())
					utils.ScreenCapture.getFullScreenShot(driver, "./screenshot/myImage"+TimeStamp+".png");
				else
					utils.ScreenCapture.getFullScreenShot(driver, "./screenshot/MyFailImage"+TimeStamp+".png");
		
		 driver.quit();
	}
}
