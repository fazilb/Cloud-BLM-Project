package CloudBLM.GitHub;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

class ExtentReport{
	
	String nullpointerexp ="org.openqa.selenium.NullPointerException";
	String nullpointerexp_text ="<b>No Element is not Found</b>";
	
	String notclickexp ="org.openqa.selenium.NOTCLICK";
	String notclickexp_text ="<b>Unable to click the Button</b>";
	
	String nosuchelementexp="org.openqa.selenium.NoSuchElementException";
	String nosuchelementexp_text ="<b>Excepted Button or Element is not Found</b>";
	
	String e_text ="<b>Unknown Exception</b>";

//	------------------------------ Cloud BLM Inputs------------------------------
	
	// Create Project
	String UserName = "fazil@srinsofttech.com";
	String Password = "sst12345";
	String ProjectName = "AUTOMATION_TEST";
	String ProjectType = "Industrial";
	String LifecycleTemplate = "Plan";
	String ConstructionType = "New";
	String ContractType = "Private";
	String Startdate = "09/16/2019";
	String Enddate = "9/30/2020";
	String Address = "Bear Hill St., North Ring Road, CA-028 001";
	
	// Property based issue
	 String PropertybasedissueName = "Property Based Issue";
	 String Expectedvalue = "NONE";
     String propertystartdate = " 09-09-2017";
     String propertyenddate = "10-23-2017";
	 String propertydescription = "Test description for Property Based Issue";
		
	 // Element based issue
     String ElementbasedissueName = "Element Based Issue";
	 String Elementstartdate = "8/20/2019";
	 String Elementenddate = "9/4/2019";
	 String Elementdescription = "Test description for Element Based Issue";
	 
	// Standalone based issue
	 String StandalonebasedissueName = "Standalone Based Issue";
	 String StandalonebasedissueName_1 = "Standalone Based Issue_1";
	 String Assingeename = "Fazil";
	 String Severity = "Low";
	 String IssueStatus = "In-Progress";
	 String Standalonestartdate = "8/20/2019";
	 String Standaloneenddate = "9/4/2019";
	 String Standalonedescription = "Test description for Standalone Based Issue";
	
	// OrganizationName
	 String OrganizationName = " QC Test ";
     String Status = "Active";
     String description = "Test";
     
	// User creation
     String Name = "Ajith";
	 String Username = "AjithkumaR";
     String Email = "ajithkuma.gopal@srinsofttech.com";
     
	// Manager RFI, clashes
	String ManageRFI = "No records to display";

}

public class CloudBLM extends ExtentReport {

		public WebDriver driver;
		public Logger logger;
		public Actions actions;
		public ExtentTest test;
		public ExtentReports report;
		public Robot press;
		
		@BeforeTest
		public void Start()  {
			System.out.println("Start Test...");
			report = new ExtentReports("C:\\Users\\fazil\\Desktop\\Test Report\\Cloud BLM Test Report.html");
			test = report.startTest("CloudBLM Report");
		}

		@Test(priority = 0)
		public void ChromeBrowser() throws InterruptedException, SecurityException, IOException {
		 try {
			
			logger = Logger.getLogger("CloudBLMLog");
			FileHandler file;
			file = new FileHandler("C:\\Users\\fazil\\Desktop\\CloudBLMLogFile.log");
			logger.addHandler(file);
			SimpleFormatter formatter = new SimpleFormatter();
			file.setFormatter(formatter);
			// System.setProperty("webdriver.chrome.driver", "Z:\\git\\CloudBLM1\\Jar
			// Files\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium files\\Jars\\chromedriver.exe");
			driver = new ChromeDriver();
			logger.info("Launched Chrome Browser");
			System.out.println("----------------------------------Launched Chrome Browser Passed----------------------------------");
			
			test.log(LogStatus.PASS,"ChromeBrowser");
		    }catch (Exception e ) {
			
			String expstr =e.toString();
			  if(expstr.contains(nullpointerexp))
			  {
				  test.log(LogStatus.FAIL,"ChromeBrowser"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nullpointerexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
				  Assert.fail(expstr);
			  }else if(expstr.contains(notclickexp))
			  {
				  test.log(LogStatus.FAIL,"ChromeBrowser"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+notclickexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
				  Assert.fail(expstr);
			  }else if(expstr.contains(nosuchelementexp))
			  {
				  test.log(LogStatus.FAIL,"ChromeBrowser"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nosuchelementexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
				  Assert.fail(expstr);
			  }else
			  {
				  test.log(LogStatus.FAIL,"ChromeBrowser"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+e_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+e.toString());
				  Assert.fail(expstr);
			  }
			  System.out.println(e);
			}
		}

		@Test(priority = 1)
		public void CloudBLMURL() throws SecurityException {
			try {
			
			// Launched the Cloud BLM URL
			driver.manage().window().maximize();
			driver.get("http://192.168.1.154/blm/projects");
			logger.info("Cloud BLM URL Launched");
			System.out.println("----------------------------------Cloud BLM URL Passed----------------------------------");
			
		test.log(LogStatus.PASS,"CloudBLMURL");	
	    }catch (Exception e ) {
		
		String expstr =e.toString();
		  if(expstr.contains(nullpointerexp))
		  {
			  test.log(LogStatus.FAIL,"CloudBLMURL"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nullpointerexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else if(expstr.contains(notclickexp))
		  {
			  test.log(LogStatus.FAIL,"CloudBLMURL"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+notclickexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else if(expstr.contains(nosuchelementexp))
		  {
			  test.log(LogStatus.FAIL,"CloudBLMURL"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nosuchelementexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else
		  {
			  test.log(LogStatus.FAIL,"CloudBLMURL"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+e_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+e.toString());
			  Assert.fail(expstr);
		  }
		  System.out.println(e);
		}
		}

		@Test(priority = 2)
		public void LoginPage() throws InterruptedException {
			try {
				
			// invalid UserName and valid Password
			WebElement element = driver.findElement(By.xpath("//*[@id='login-email']"));
			element.sendKeys("qcdsdsd@sst");
			Thread.sleep(2000);
			WebElement element1 = driver.findElement(By.id("login-password"));
			element1.sendKeys("sst12345");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[text() ='Sign In']")).click();
			Thread.sleep(2000);
			String validategettext = driver.findElement(By.xpath("//p[text()='Invalid Credentials!!']")).getText();
			String Validategettext2 = "Invalid Credentials!!";
			Assert.assertEquals(validategettext, Validategettext2);
			element.clear();
			element1.clear();
			Thread.sleep(3000);
			logger.info("Login - invalid UserName and valid Password");

			// valid UserName and invalid Password
			WebElement element2 = driver.findElement(By.xpath("//*[@id='login-email']"));
			element2.sendKeys("qc@sst.com");
			Thread.sleep(2000);
			WebElement element3 = driver.findElement(By.id("login-password"));
			element3.sendKeys("sstfdfsfdsfds12345");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[text() ='Sign In']")).click();
			Thread.sleep(2000);
			element2.clear();
			element3.clear();
			Thread.sleep(2000);
			logger.info("Login - valid UserName and invalid Password");

			// invalid UserName and invalid Password
			WebElement element4 = driver.findElement(By.xpath("//*[@id='login-email']"));
			element4.sendKeys("dfdqc@sst.com");
			Thread.sleep(2000);
			WebElement element5 = driver.findElement(By.id("login-password"));
			element5.sendKeys("sst1dfd2345");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[text() ='Sign In']")).click();
			Thread.sleep(2000);
			element4.clear();
			element5.clear();
			Thread.sleep(2000);
			logger.info("Login - invalid UserName and invalid Password");

			// valid UserName and valid Password
			driver.findElement(By.xpath("//*[@id='login-email']")).sendKeys(UserName);
			driver.findElement(By.id("login-password")).sendKeys(Password);
			driver.findElement(By.xpath("//*[text() ='Sign In']")).click();
			Thread.sleep(2000);
			logger.info("Login - valid UserName and valid Password");
			System.out.println("----------------------------------Login Page Passed----------------------------------");
			
			test.log(LogStatus.PASS,"LoginPage");
	    }catch (Exception e ) {
		
		String expstr =e.toString();
		  if(expstr.contains(nullpointerexp))
		  {
			  test.log(LogStatus.FAIL,"LoginPage"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nullpointerexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else if(expstr.contains(notclickexp))
		  {
			  test.log(LogStatus.FAIL,"LoginPage"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+notclickexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else if(expstr.contains(nosuchelementexp))
		  {
			  test.log(LogStatus.FAIL,"LoginPage"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nosuchelementexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else
		  {
			  test.log(LogStatus.FAIL,"LoginPage"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+e_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+e.toString());
			  Assert.fail(expstr);
		  }
		  System.out.println(e);
		}
		}

		@Test(priority = 3)
		public void CreateProject() throws InterruptedException {
			try {
				
			// Create the project name
			driver.findElement(By.xpath("//button[@class='blm-btn-create']")).click();
			Thread.sleep(4000);
			logger.info("Create Project - Create the project name");

			// Without entered the project name
			driver.findElement(By.xpath("//button[@blmtooltip='Create']")).click();
			Thread.sleep(2000);
			logger.info("Create Project - Without entered the project name");

			// Validate the validation message
			String validationmessage = "Project Name is required";
			String Validusername = driver.findElement(By.xpath("//*[text() ='Project Name is required']")).getText();
			System.out.println(Validusername);
			if (validationmessage.contains(Validusername)) {
				System.out.println("projectname validation message are same");
			} else {
				System.out.println("projectname validation message are different");
			}
			Thread.sleep(2000);
			logger.info("Create Project - Validate the validation message");

			// Enter the invalid username and validate the validation message		
			WebElement Projectname = driver.findElement(By.xpath("//*[@id='projectName']"));
			Projectname.sendKeys("abcdegfjhgfggjfghijklmnopqrst");
			Thread.sleep(2000);
			String Invalidname = "Project Name allowed 16 characters only";
			String projectnamevalidationmessage = driver
					.findElement(By.xpath("//div[text() =' Project Name allowed 16 characters only.']")).getText();
			if (Invalidname.equals(projectnamevalidationmessage)) {
				System.out.println(" projectname validation message are same");
			} else {
				System.out.println("projectname valisation message are different");
			}
			Projectname.clear();
			Thread.sleep(4000);
			logger.info("Create Project - Enter the invalid username and validate the validation message");
			
			// Enter the invalid username and validate the validation message
			WebElement Projectnameinvalid = driver.findElement(By.xpath("//*[@id='projectName']"));
			Projectnameinvalid.sendKeys("%$%^$^%$#%^#%^#%^$&^$%#&@&");
			String validateprojectnameinavlid = driver.findElement(By.xpath("//div[text()='Project Name is Invalid']")).getText();
			Assert.assertEquals("Project Name is Invalid", validateprojectnameinavlid);
			Projectnameinvalid.clear();
			Thread.sleep(2000);
			logger.info("Create Project - Enter the invalid username and validate the validation message");

			// Enter the valid Project Name and validate
			driver.findElement(By.xpath("//*[@id='projectName']")).sendKeys(ProjectName);
			Thread.sleep(2000);
			logger.info("Create Project - Enter the valid Project Name and validate");

			// click the project type field and Select the respective project type
			WebElement projecttype = driver.findElement(By.xpath("//*[@formcontrolname='ProjectTypeID']"));
			projecttype.sendKeys(ProjectType);
			Thread.sleep(2000);
			logger.info("Create Project - click the project type field and Select the respective project sub type");

			// click the project sub type field and Select the respective project sub type
			driver.findElement(By.xpath("//*[@formcontrolname ='ProjectSubTypeID']")).click();
			WebElement projectsubtype = driver.findElement(By.xpath("//*[@formcontrolname='ProjectSubTypeID']"));
			Select sel = new Select(projectsubtype);
			sel.selectByIndex(1);
			String text3 = projectsubtype.getText();
			{
			System.out.println(text3);
			}
			Thread.sleep(2000);
			logger.info("Create Project - click the project sub type field and Select the respective project sub type");

			// Validate the Life cycle template and select the value
			WebElement lifecycletemplate = driver.findElement(By.xpath("//*[@formcontrolname='LifecycleTemplate']"));
			lifecycletemplate.sendKeys(LifecycleTemplate);
			logger.info("Create Project - Validate the Life cycle template and select the value");

			// Validate the Construction type and select the value
			WebElement Construction = driver.findElement(By.xpath("//*[@formcontrolname='ConstructionTypeID']"));
			Construction.sendKeys(ConstructionType);
			Thread.sleep(2000);
			logger.info("Create Project - Validate the Construction type and select the value");

			// Validate the contract type and select the value
			WebElement contract = driver.findElement(By.xpath("//*[@formcontrolname='ContractTypeID']"));
			contract.sendKeys(ContractType);
			Thread.sleep(2000);
			logger.info("Create Project - Validate the contract type and select the value");

			// Validate the start date and validate the validation message
			String startvalid = "Start date is required";
			String dates = driver.findElement(By.xpath("//*[text() =' Start date is required']")).getText();
			if (dates.equals(startvalid)) {
				System.out.println("startdate both validations are same");
			} else {
				System.out.println("startdate Both validations are different");
			}
			Thread.sleep(2000);
			logger.info("Create Project - Validate the start date and validate the validation message");

			// Validate the start date and enter the value
			driver.findElement(By.xpath("(//*[@class ='e-input e-lib e-keyboard'])[1]")).sendKeys(Startdate);
			Thread.sleep(2000);
			logger.info("Create Project - Validate the start date and enter the value");

			// Validate the End date and not select the value
			String ProjectEnddate = "Start date is required";
			String end = driver.findElement(By.xpath("//*[text() =' End date is required']")).getText();
			if (ProjectEnddate.equals(end)) {
				System.out.println("Enddate Both validations are same");
			} else {
				System.out.println("Enddate Both validations are different");
			}
			Thread.sleep(2000);
			logger.info("Create Project - Validate the End date and not select the value");

			// Validate the validation message in end date
			WebElement validenddate = driver.findElement(By.xpath("(//*[@class ='e-input e-lib e-keyboard'])[2]"));
			validenddate.sendKeys("08-08-2011");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@formcontrolname ='ProjectAddress']")).click();
			String greatherdate = "End date must be greater than Start date";
			String validmessage = driver.findElement(By.xpath("//*[text() = ' End date must be greater than Start date ']"))
					.getText();
			if (greatherdate.equals(validmessage)) {
				System.out.println("Enddate both validations are same");

			} else {
				System.out.println("Enddate Both validations are different");
			}
			Thread.sleep(2000);
			validenddate.clear();
			logger.info("Create Project - Validate the validation message in end date");

			// Validate the End date and enter the Value
			driver.findElement(By.xpath("(//*[@class ='e-input e-lib e-keyboard'])[2]")).sendKeys(Enddate);
			Thread.sleep(2000);
			logger.info("Create Project - Validate the End date and enter the Value");

			// Enter the valid data in project Address field
			driver.findElement(By.xpath("//*[@formcontrolname ='ProjectAddress']")).sendKeys(Address);
			Thread.sleep(2000);
	//		press.keyPress(KeyEvent.VK_PAGE_DOWN);
	//		press.keyRelease(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(2000);
			logger.info("Create Project - Enter the valid data in project Address field");

			// Validate the description field but not enter the value		
	//		String description2 = "Description is required";
	//		String description = driver.findElement(By.xpath("//*[text()='Description is required']")).getText();
	//		if (description.equals(description2)) {
				System.out.println("description Both validations are same");
	//		} else {
				System.out.println("description Both validations are different");
	//		}
	//		driver.findElement(By.xpath("(//input[@class ='e-input e-lib e-keyboard'])[1]")).click();
			Thread.sleep(2000);
			logger.info("Create Project - Validate the description field but not enter the value");

			// Validate the description field and the enter the value
			driver.findElement(By.id("Description_rte-edit-view")).sendKeys("Test Description to the Project");
			Thread.sleep(2000);
			logger.info("Create Project - Validate the description field and the enter the value");

			// Create the project
	//		driver.findElement(By.xpath("//span[text()='CREATE']")).click();
			Thread.sleep(2000);
			logger.info("Create Project - Create the project");

			// cancel the project		
			driver.findElement(By.xpath("//button[@blmtooltip='Cancel']")).click();
			Thread.sleep(2000);
			logger.info("Create Project - cancel the project");
			System.out.println("----------------------------------Create Project Passed----------------------------------");
			
			test.log(LogStatus.PASS,"CreateProject");
	    }catch (Exception e ) {
		
		String expstr =e.toString();
		  if(expstr.contains(nullpointerexp))
		  {
			  test.log(LogStatus.FAIL,"CreateProject"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nullpointerexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else if(expstr.contains(notclickexp))
		  {
			  test.log(LogStatus.FAIL,"CreateProject"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+notclickexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else if(expstr.contains(nosuchelementexp))
		  {
			  test.log(LogStatus.FAIL,"CreateProject"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nosuchelementexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else
		  {
			  test.log(LogStatus.FAIL,"CreateProject"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+e_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+e.toString());
			  Assert.fail(expstr);
		  }
		  System.out.println(e);
		}
		}
		
		@Test(priority = 4)
		public void ProjectGridView() throws Exception {
			try {	
				
				// click on the Grid icon
				driver.findElement(By.xpath("//i[@class='blm-icon-grid']")).click();
				Thread.sleep(2000);
				logger.info("Project Grid View - click on the Grid icon");
				
				// mouse over to projectname
				WebElement elementactions1 = driver.findElement(By.xpath("//span[text()='Project Name']"));
				Actions act = new Actions(driver);
				act.moveToElement(elementactions1).perform();
				Thread.sleep(2000);
				
				// click the filter icon
				driver.findElement(By.xpath("(//div[@class='e-filtermenudiv e-icons e-icon-filter'])[1]")).click();
				Thread.sleep(2000);

				WebElement ele = driver.findElement(By.xpath("(//span[@role='listbox'])[2]"));
				ele.click();
				ele.sendKeys("Starts With");
				ele.click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@placeholder='Enter the value']")).sendKeys(ProjectName);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[text()='Filter']")).click();
				
				// check the project name in grid view mode
				WebElement ProjectName_Grid = driver.findElement(By.xpath("(//span[@placement='bottom'])[1]"));

				String Gridprojectname = ProjectName_Grid.getText();
				System.out.println(Gridprojectname);
				if (ProjectName_Grid.isDisplayed()) {
					System.out.println("Project Name is displayed");
				} else {
					System.out.println("Project Name is not displayed");
				}
		//		Assert.assertEquals(ProjectName, Gridprojectname);
				Thread.sleep(2000);
				
				// check the project type
				WebElement ProjectType_Grid = driver.findElement(By.xpath("(//span[@placement='bottom'])[2]"));
				String GridProjectType = ProjectType_Grid.getText();
				System.out.println(GridProjectType);
				if (ProjectType_Grid.isDisplayed()) {
					System.out.println("Project Type is displayed");
				} else {
					System.out.println("Project Type is not displayed");
				}
				Assert.assertEquals(ProjectType, GridProjectType);
				Thread.sleep(2000);
				
				// check the project subtype
				WebElement Projectsubtype_Grid = driver.findElement(By.xpath("(//span[@placement='bottom'])[3]"));
				String Gridprojectsuntype = Projectsubtype_Grid.getText();
				System.out.println(Gridprojectsuntype);
				if (Projectsubtype_Grid.isDisplayed()) {
					System.out.println("Project sub Type is displayed");
				} else {
					System.out.println("Project sub Type is not displayed");
				}
		//		Assert.assertEquals(ProjectSubtype, Gridprojectsuntype);
				Thread.sleep(2000);
				
				// check the construction type
				WebElement Constructiontype_Grid = driver.findElement(By.xpath("(//span[@placement='bottom'])[4]"));
				String Gridconstructiontype = Constructiontype_Grid.getText();
				System.out.println(Gridconstructiontype);
				if (Constructiontype_Grid.isDisplayed()) {
					System.out.println("Construction Type is displayed");
				} else {
					System.out.println("Construction Type is not displayed");
				}
				Assert.assertEquals(ConstructionType, Gridconstructiontype);
				Thread.sleep(2000);

				// check the Start date
				WebElement Startdate_Grid = driver.findElement(By.xpath("(//span[@placement='bottom'])[5]"));
				String GridStartdate_Grid = Startdate_Grid.getText();
				System.out.println(GridStartdate_Grid);
				if (Startdate_Grid.isDisplayed()) {
					System.out.println("Startdate_Grid is displayed");
				} else {
					System.out.println("Startdate_Grid is not displayed");
				}
				// Assert.assertEquals(Startdate, GridStartdate_Grid);
				Thread.sleep(2000);
				
				// check the End date
				WebElement Enddate_Grid = driver.findElement(By.xpath("(//span[@placement='bottom'])[6]"));
				String GridEnddate_Grid = Enddate_Grid.getText();
				System.out.println(GridEnddate_Grid);
				if (Enddate_Grid.isDisplayed()) {
					System.out.println("Enddate_Grid is displayed");
				} else {
					System.out.println("Enddate_Grid is not displayed");
				}
				// Assert.assertEquals(ProjectEnddate, GridEnddate_Grid);
				Thread.sleep(2000);
				
				// click the Action icon
				driver.findElement(By.xpath("(//span[@placement='bottom'])[7]")).click();

			logger.info("Project Grid View - Search the project in the filter");
			System.out.println("----------------------------------Project Grid View Passed----------------------------------");
			
			test.log(LogStatus.PASS,"ProjectGridView");
	    }catch (Exception e ) {
		
		String expstr =e.toString();
		  if(expstr.contains(nullpointerexp))
		  {
			  test.log(LogStatus.FAIL,"ProjectGridView"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nullpointerexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else if(expstr.contains(notclickexp))
		  {
			  test.log(LogStatus.FAIL,"ProjectGridView"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+notclickexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else if(expstr.contains(nosuchelementexp))
		  {
			  test.log(LogStatus.FAIL,"ProjectGridView"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nosuchelementexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else
		  {
			  test.log(LogStatus.FAIL,"ProjectGridView"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+e_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+e.toString());
			  Assert.fail(expstr);
		  }
		  System.out.println(e);
		}
		}

		@Test(priority = 5)
		public void SearchProject() throws Exception {
			try {	
			
			// Select the Back to Project
			driver.findElement(By.xpath("//i[@class='blm-icon-back']")).click();
			Thread.sleep(4000);
			logger.info("Search Project - Select the Back to Project");
			
			// Search the project
			driver.findElement(By.id("facog")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(ProjectName);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//i[@class='blm-icon-hamburger'])[3]")).click();
			Thread.sleep(2000);
			logger.info("Search Project - Search the project in the filter");
			System.out.println("----------------------------------Search Project Passed----------------------------------");
			
			test.log(LogStatus.PASS,"SearchProject");
	    }catch (Exception e ) {
		
		String expstr =e.toString();
		  if(expstr.contains(nullpointerexp))
		  {
			  test.log(LogStatus.FAIL,"SearchProject"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nullpointerexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else if(expstr.contains(notclickexp))
		  {
			  test.log(LogStatus.FAIL,"SearchProject"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+notclickexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else if(expstr.contains(nosuchelementexp))
		  {
			  test.log(LogStatus.FAIL,"SearchProject"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nosuchelementexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else
		  {
			  test.log(LogStatus.FAIL,"SearchProject"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+e_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+e.toString());
			  Assert.fail(expstr);
		  }
		  System.out.println(e);
		}
		}

		@Test(priority = 6)
		public void ManageProject() throws Exception {
			try {
				
			// it should display the List of projects
			List<WebElement> listofprojects = driver.findElements(By.xpath("//*[@class ='card-item-title']"));
			int ssq = listofprojects.size();
			for (int i = 0; i < ssq; i++) {
				String projects = listofprojects.get(i).getText();
				System.err.println(projects);
			}
			System.out.println(ssq);
			Thread.sleep(2000);
			logger.info("Manage Project - it should display the List of projects");

			// check the project name is displayed or not in cardview
			String Getprojectname = driver.findElement(By.xpath("//span[@placement='bottom']")).getText();
			System.out.println(Getprojectname);
			Assert.assertEquals(ProjectName, Getprojectname);
			Thread.sleep(4000);
			logger.info("Manage Project - check the project name is displayed or not in cardview");
			
			// check the project type is displayed or not in card view			
			String getprojecttype = driver.findElement(By.xpath("//p[text()='Project Type ']/following::td[2]")).getText();
			System.out.println(getprojecttype);
			Assert.assertEquals(getprojecttype, ProjectType);
			Thread.sleep(3000); 
			logger.info("Manage Project - check the project type is displayed or not in card view");
			
			// check the project subtype is displayed or not
			String projectsubtype = driver.findElement(By.xpath("//p[text()='Project Subtype ']/following::td[2]")).getText();
			Assert.assertEquals(projectsubtype, projectsubtype);
			Thread.sleep(2000); 
			logger.info("Manage Project - check the project subtype is displayed or not");
			
			// check the Construction type is displayed or not
			String Constructiontype = driver.findElement(By.xpath("//p[text()='Construction Type ']/following::td[2]")).getText();
			Assert.assertEquals(ConstructionType, Constructiontype);
			Thread.sleep(3000);

			logger.info("Manage Project - check the Construction type is displayed or not");
			System.out.println("----------------------------------Manage Project Passed----------------------------------");
			
			test.log(LogStatus.PASS,"ManageProject");
	    }catch (Exception e ) {
		
		String expstr =e.toString();
		  if(expstr.contains(nullpointerexp))
		  {
			  test.log(LogStatus.FAIL,"ManageProject"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nullpointerexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else if(expstr.contains(notclickexp))
		  {
			  test.log(LogStatus.FAIL,"ManageProject"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+notclickexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else if(expstr.contains(nosuchelementexp))
		  {
			  test.log(LogStatus.FAIL,"ManageProject"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nosuchelementexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else
		  {
			  test.log(LogStatus.FAIL,"ManageProject"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+e_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+e.toString());
			  Assert.fail(expstr);
		  }
		  System.out.println(e);
		}
		}

		
		@Test(priority = 7)
		public void ProjectInfo() throws InterruptedException {
			try {
				
			// Click the Info icon in project card view
			driver.findElement(By.id("icon_0")).click();
			Thread.sleep(3000);
			logger.info("Project Info - Click the Info icon in project card view");
		
			// Check the image upload
			
		//	  WebElement clickuploadbuttoninfo = driver.findElement(By.id("edit"));
		//	  clickuploadbuttoninfo.click(); Screen scr = new Screen();
		//	  scr.type("W:\\Fazil\\Ajith\\Inputs\\images.png"); Robot robot = new Robot();
		//	  robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		//	  Thread.sleep(2000);
			 			
			// check the image in dialod box
			driver.findElement(By.id("fullscreen")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[text()='X']")).click();
			Thread.sleep(3000); 
			logger.info("Project Info - check the image in dialod box");
			
			// Clear the image
			driver.findElement(By.id("remove")).click();
			Thread.sleep(3000);
			logger.info("Project Info - Clear the image");
			
			// Check the project id);
			String getprojectid = driver.findElement(By.xpath("//td[text()='Project ID']/following-sibling::td[2]")).getText();
			System.out.println(getprojectid);
			Thread.sleep(2000);
			logger.info("Project Info - Check the project id");
			
			// Check the project version		
			String getprojectversioninfo = driver.findElement(By.xpath("//td[text()='Version #']/following-sibling::td[2]")).getText();
			System.out.println(getprojectversioninfo);
			Thread.sleep(2000);
			logger.info("Project Info - Check the project version");
			
			// Check the project type
			String checkprojecttype = driver.findElement(By.xpath("//td[text()='Project Type']/following-sibling::td[2]")).getText();
			Assert.assertEquals(ProjectType, checkprojecttype);
			Thread.sleep(2000);
			logger.info("Project Info - Check the project type");
			
			// Check the startdate
			String startdate = driver.findElement(By.xpath("//td[text()='Start Date']/following::td[2]")).getText();
			Assert.assertEquals(Startdate, startdate);
			Thread.sleep(2000);
			logger.info("Project Info - Check the startdate");
			
			// Check the enddate
			String enddate = driver.findElement(By.xpath("//td[text()='End Date']/following::td[2]")).getText();
			Assert.assertEquals(Enddate, enddate);
			Thread.sleep(2000); 
			logger.info("Project Info - Check the enddate");
			
			// Check the project status
			String checkstatusinfo = "Active";
			WebElement checkprojectstatusinfo = driver.findElement(By.xpath("//td[text()='Status']/following-sibling::td[2]"));
			if (checkprojectstatusinfo.isDisplayed()) {
				System.out.println("Project status  is displayed");
				if (checkstatusinfo.equals(checkprojectstatusinfo.getText())) {
					System.out.println("Both status is matched");
				} else {
					System.out.println("Both status is not matched");
				}
			} else {
				System.out.println("Project status is not  displayed");
			}
			Thread.sleep(2000);
			logger.info("Project Info - Check the project status");
			
			// Check the description
			String checkprojectdescription = "Test Description to the Project";
			WebElement checkprojectdescriptioninfo = driver.findElement(By.xpath("//td[text()='Status']/following-sibling::td[2]"));
			if (checkprojectdescriptioninfo.isDisplayed()) {
				System.out.println("Project Description  is displayed");
				if (checkprojectdescription.equals(checkprojectdescriptioninfo.getText())) {
					System.out.println("Both Description is matched");
				} else {
					System.out.println("Both Description is not matched");
				}
			} else {
				System.out.println("Project Description is not  displayed");
			}
			Thread.sleep(2000);
			logger.info("Project Info - Check the description");
			System.out.println("----------------------------------Project Info Passed----------------------------------");
			
			test.log(LogStatus.PASS,"ProjectInfo");
	    }catch (Exception e ) {
		
		String expstr =e.toString();
		  if(expstr.contains(nullpointerexp))
		  {
			  test.log(LogStatus.FAIL,"ProjectInfo"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nullpointerexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else if(expstr.contains(notclickexp))
		  {
			  test.log(LogStatus.FAIL,"ProjectInfo"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+notclickexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else if(expstr.contains(nosuchelementexp))
		  {
			  test.log(LogStatus.FAIL,"ProjectInfo"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nosuchelementexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else
		  {
			  test.log(LogStatus.FAIL,"ProjectInfo"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+e_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+e.toString());
			  Assert.fail(expstr);
		  }
		  System.out.println(e);
		}
		}		

		@Test(priority = 9)
		public void ProjectInfo_Team() throws Exception {
			try {
				
			// click the Team buton in project info page
			driver.findElement(By.xpath("//a[text()='Team']")).click();
			Thread.sleep(3000);
			logger.info("Project Info Team - click the Team buton in project info page");
			
		    // check the role count under the team and get the Role Name
			List<WebElement> rulecount = driver.findElements(By.xpath("//td[@class='e-detailrowcollapse']/following-sibling::td[1]"));
			System.out.println("Role Name Count- " + rulecount.size());
			for (int i = 0; i < rulecount.size(); i++) {
				System.out.println("Role Name- " + rulecount.get(i).getText());
			}
			Thread.sleep(3000);
			logger.info("Project Info Team - check the role count under the team and get the Role Name");

			// check the role count under the team and get the Role Description		
			List<WebElement> ruledescription = driver.findElements(By.xpath("//td[@class='e-detailrowcollapse']/following-sibling::td[2]"));
			System.out.println("Rule Description Count- " + ruledescription.size());
			for (int i = 0; i < rulecount.size(); i++) {
				System.out.println("Role Description- " + ruledescription.get(i).getText());
				Thread.sleep(3000);
			}
			logger.info("Project Info Team - check the role count under the team and get the Role Description");

	    	// Click on Add user in Team page
			driver.findElement(By.xpath("(//a[@class='userMapping-enable'])[3]")).click();
			Thread.sleep(2000);
			logger.info("Project Info Team - Click on Add user in Team page");
			
			// User list in the Team page
			List<WebElement> Userlist = driver.findElements(By.xpath("//tr[@class='ng-star-inserted']"));
			System.out.println("Add UserCout- " + Userlist.size());	
			Thread.sleep(2000);		
			 for (int i = 0; i < Userlist.size(); i++) {
			 System.out.println("Add UserCout- " + Userlist.get(i).getText());
			 // (//input[@type='checkbox'])[1]
			 }
			 Thread.sleep(5000);
			 logger.info("Project Info Team - User list in the Team page");
			 
			 // Search User in the list at Team
			driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(Name);
			Thread.sleep(2000);
			List<WebElement> listelement = driver.findElements(By.xpath("//tr[@class='ng-star-inserted']"));
			System.out.println("Search usercout- " + listelement.size());	
			Thread.sleep(2000);
			logger.info("Project Info Team - Search User in the list at Team");
			
			// Select the User in the list at Team
			 for (int i = 0; i < listelement.size(); i++) 
			 {
			 listelement.get(i).click();
		     driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
			 System.out.println("Search user Name- " + listelement.get(i).getText());
			 }
			 Thread.sleep(2000);
			 logger.info("Project Info Team - Select the User in the list at Team");
			 
			// Send an Email Invite to the selected Users
			driver.findElement(By.xpath("//label[text()=' Send an Email Invite to the selected Users ']")).click();
			Thread.sleep(2000);
			logger.info("Project Info Team - Send an Email Invite to the selected Users");
			
			// Cancel the add user list in team
			driver.findElement(By.xpath("//button[@blmtooltip='Cancel']")).click();
			Thread.sleep(2000);
			logger.info("Project Info Team - Cancel the add user list in team");
			
			// Back to Project Info page
			driver.findElement(By.xpath("//*[text()=' Overview']")).click();
			Thread.sleep(5000);
			logger.info("Project Info Team - Back to Project Info page");
			System.out.println("----------------------------------Project Info Team Passed----------------------------------");
			
			test.log(LogStatus.PASS,"ProjectInfo_Team");
	    }catch (Exception e ) {
		
		String expstr =e.toString();
		  if(expstr.contains(nullpointerexp))
		  {
			  test.log(LogStatus.FAIL,"ProjectInfo_Team"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nullpointerexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else if(expstr.contains(notclickexp))
		  {
			  test.log(LogStatus.FAIL,"ProjectInfo_Team"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+notclickexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else if(expstr.contains(nosuchelementexp))
		  {
			  test.log(LogStatus.FAIL,"ProjectInfo_Team"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nosuchelementexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else
		  {
			  test.log(LogStatus.FAIL,"ProjectInfo_Team"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+e_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+e.toString());
			  Assert.fail(expstr);
		  }
		  System.out.println(e);
		}
		}

		@Test(priority = 10)
		public void ManageIssue() throws Exception {
			try {
				
			// click the manage issue link		
			driver.findElement(By.xpath("//span[text()='Manage Issues']")).click();
			Thread.sleep(2000);
			logger.info("Manage Issue - click the manage issue");

			// Check the create button
			driver.findElement(By.xpath("//button[@class='blm-btn-create']")).click();
			Thread.sleep(2000);
			logger.info("Manage Issue - Check the create button");
			
			// click the issue name and validate the validation message
			driver.findElement(By.xpath("(//button[@class='blm-btn-create'])[1]")).click();
			Thread.sleep(2000);
			String issuenamevalidation = driver.findElement(By.xpath("//*[text()='Issue Name is required']")).getText();
			System.out.println(issuenamevalidation);
			Assert.assertEquals("Issue Name is required", issuenamevalidation);
			Thread.sleep(2000);
			logger.info("Manage Issue - click the issue name and validate the validation message");
			
			// click the issue name and validate the validation message
			driver.findElement(By.xpath("//*[@placeholder='Issue Name']")).sendKeys("^&&^$*^$$#*^%");
			Thread.sleep(2000);
			String issue2validationmessage = "Issue Name is Invalid";
			WebElement stingissename = driver.findElement(By.xpath("//div[text()='Issue Name is Invalid']"));
			Assert.assertEquals(issue2validationmessage, stingissename.getText());
			logger.info("Manage Issue - click the issue name and validate the validation message");
			
			// Enter the valid name
			WebElement IssueName = driver.findElement(By.xpath("//*[@placeholder='Issue Name']"));
			IssueName.clear();
			Thread.sleep(2000);
			IssueName.sendKeys(StandalonebasedissueName_1);
			Thread.sleep(2000);
			logger.info("Manage Issue - Enter the valid name");
			
			// Check the validation message in Assingee field
			WebElement assigneenameget = driver.findElement(By.xpath("//div[text()='Assignee is required']"));
			String Assognenamesa = "Assignee is required";
			Assert.assertEquals(Assognenamesa, assigneenameget.getText());
			Thread.sleep(2000);
			logger.info("Manage Issue - Check the validation message in Assingee field");
			
			// Select the get the assign name
			WebElement assignee = driver.findElement(By.xpath("//*[@formcontrolname='assignee']"));
			assignee.sendKeys(Assingeename);
			Thread.sleep(2000);
			logger.info("Manage Issue - Select the get the assign name");
			
			// Check the validation message in severity field
			WebElement severityvalidationmessage = driver.findElement(By.xpath("//div[text()='Severity is required']"));
			String validationmessageseverity = "Severity is required";
			Assert.assertEquals(validationmessageseverity, severityvalidationmessage.getText());
			logger.info("Manage Issue - Check the validation message in severity field");
			
			// Select the Severity
			WebElement severity = driver.findElement(By.xpath("//*[@formcontrolname='severity']"));
			severity.sendKeys(Severity);
			logger.info("Manage Issue - Select the Severity");
			
			// select the start date end date
			driver.findElement(By.xpath("(//*[@class='e-input e-lib e-keyboard'])[1]")).sendKeys(Standalonestartdate);
			Thread.sleep(2000);
			driver.findElement(By.id("DueDate_input")).sendKeys(Standaloneenddate);
			Thread.sleep(2000);
			logger.info("Manage Issue - select the start date end date");
			
			// select the status
			WebElement status = driver.findElement(By.xpath("//*[@formcontrolname='status']"));
			status.sendKeys(IssueStatus);
			Thread.sleep(2000);
			logger.info("Manage Issue - select the status");

			// Check the validation message
			driver.findElement(By.id("description_rte-edit-view")).click();
			driver.findElement(By.id("DueDate_input")).click();
			Thread.sleep(2000);
			WebElement descriptionstatusvalid = driver.findElement(By.xpath("//div[text()=' Description is required']"));
			String validmessagedes = "Description is required";
			Assert.assertEquals(validmessagedes, descriptionstatusvalid.getText());
			Thread.sleep(2000);
			logger.info("Manage Issue - Check the validation message");
			
			// Enter the Description
			driver.findElement(By.id("description_rte-edit-view")).sendKeys("Test Description for Issue");
			Thread.sleep(2000);
			logger.info("Manage Issue - Enter the Description");
			
			// click the create button
	//		WebElement createbutton = driver.findElement(By.xpath("//button[@blmtooltip='Create']"));
	//		createbutton.click();
	//		Thread.sleep(2000);
	//		logger.info("Manage Issue - click the create button");
			
			// click the clear button
			WebElement clearbutton = driver.findElement(By.xpath("//button[@blmtooltip='Clear']"));
			Actions clearb = new Actions(driver);
			clearb.doubleClick(clearbutton).perform();
			logger.info("Manage Issue - click the clear button");

			// click the cancel button
			WebElement Cancelbutton = driver.findElement(By.xpath("//button[@blmtooltip='Cancel']"));
			Actions Cancelxx = new Actions(driver);
			Cancelxx.doubleClick(Cancelbutton).perform();
			Thread.sleep(2000);
			logger.info("Manage Issue - click the cancel button");
			System.out.println("----------------------------------Manage Issue Passed----------------------------------");
			
			test.log(LogStatus.PASS,"ManageIssue");
	     }
		catch (Exception e ) {
		
		String expstr =e.toString();
		  if(expstr.contains(nullpointerexp))
		  {
			  test.log(LogStatus.FAIL,"ManageIssue"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nullpointerexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else if(expstr.contains(notclickexp))
		  {
			  test.log(LogStatus.FAIL,"ManageIssue"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+notclickexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else if(expstr.contains(nosuchelementexp))
		  {
			  test.log(LogStatus.FAIL,"ManageIssue"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nosuchelementexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else
		  {
			  test.log(LogStatus.FAIL,"ManageIssue"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+e_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+e.toString());
			  Assert.fail(expstr);
		  }
		  System.out.println(e);
		}			
	}
		
		@Test(priority = 11)
		public void ManageIssue_Count() throws Exception {
			try {
				
			// Check the issue count in the card view
			List<WebElement> checkprojectsize = driver.findElements(By.xpath("//h2[@class='card-item-title']"));
			System.out.println("Issue Count- "+checkprojectsize.size());
			Thread.sleep(2000);
			logger.info("Manage Issue_Count- Check the issue count in the card view");

			// Check the issue name in the card view
			 for(int i=0;i<checkprojectsize.size();i++) 
			 { 
			 String text = checkprojectsize.get(i).getText(); 
			 System.out.println("Issue Name- "+text);
			 }
			 logger.info("Manage Issue_Count- Check the issue count in the card view");
			 
			// check the isssue name
			String IssueName = driver.findElement(By.xpath("//h2[@class='card-item-title']")).getText();
			System.out.println(IssueName);
	//		Assert.assertEquals("AUTOMATION_TEST", IssueName);
			Thread.sleep(2000);			
			logger.info("Manage Issue_Count - check the isssue name");
			System.out.println("---------------------------------Manage Issue_Count Passed----------------------------------");
			
			test.log(LogStatus.PASS,"ManageIssue");
	     }
		catch (Exception e ) {
		
		String expstr =e.toString();
		  if(expstr.contains(nullpointerexp))
		  {
			  test.log(LogStatus.FAIL,"ManageIssue_Count"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nullpointerexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else if(expstr.contains(notclickexp))
		  {
			  test.log(LogStatus.FAIL,"ManageIssue_Count"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+notclickexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else if(expstr.contains(nosuchelementexp))
		  {
			  test.log(LogStatus.FAIL,"ManageIssue_Count"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nosuchelementexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else
		  {
			  test.log(LogStatus.FAIL,"ManageIssue_Count"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+e_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+e.toString());
			  Assert.fail(expstr);
		  }
		  System.out.println(e);
		}		
		}

		// Check the issue values in grid view
		@Test(enabled=false)
		public void issuegridview() throws Exception {
			// click the grid buttton
			driver.findElement(By.xpath("(//a[@class='dropdown-nav dropdown-toggle add-project'])[2]")).click();
			Thread.sleep(2000);
			// check the issue name in gridview
			WebElement issuenamegrid = driver.findElement(By.xpath("//span[text()='Autamation']"));
			if (issuenamegrid.isDisplayed()) {
				System.out.println("Issue Name is dispalyed");
				Assert.assertEquals("Autamation", issuenamegrid.getText());
			} else {
				System.out.println("Issue Name is not dispalyed");
			}
			Thread.sleep(2000);

			// check the issue id in gridview
			WebElement issueidgrid = driver
					.findElement(By.xpath("//span[text()='68063cc0-ca39-11e9-a1dd-90b11c61d394']"));
			if (issueidgrid.isDisplayed()) {
				System.out.println("Issue id is dispalyed");
				Assert.assertEquals("68063cc0-ca39-11e9-a1dd-90b11c61d394", issueidgrid.getText());
			} else {
				System.out.println("Issue id is not dispalyed");
			}
			Thread.sleep(2000);
			// Check the Issue type
			WebElement issuetypegrid = driver.findElement(By.xpath("//span[text()='Standalone']"));
			if (issuetypegrid.isDisplayed()) {
				System.out.println("Issue type is dispalyed");
				Assert.assertEquals("Standalone", issuetypegrid.getText());
			} else {
				System.out.println("Issue type is not dispalyed");
			}
			Thread.sleep(2000);
			// Check the Assigned to
			WebElement Assignedto = driver.findElement(By.xpath("//span[text()='Fazil_Babu']"));
			if (Assignedto.isDisplayed()) {
				System.out.println("Assigned to is dispalyed");
				Assert.assertEquals("Fazil_Babu", Assignedto.getText());
			} else {
				System.out.println("Assigned to is not dispalyed");
			}
			Thread.sleep(2000);
			// Check the Due date
			WebElement Duedateissue = driver.findElement(By.xpath("//span[text()='08/29/2019']"));
			if (Duedateissue.isDisplayed()) {
				System.out.println("Due date is dispalyed");
				Assert.assertEquals("08/29/2019", Duedateissue.getText());
			} else {
				System.out.println("Due date is not dispalyed");
			}
			Thread.sleep(2000);
		}

		// check the column chooser in Grid view
		@Test(enabled=false)
		public void coloumchoosertype() throws Exception {
			driver.findElement(By.xpath("(//a[@class='dropdown-nav dropdown-toggle add-project'])[1]")).click();
			driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("issue");
			Thread.sleep(2000);
			List<WebElement> getclicksearch = driver.findElements(By.xpath("//li[@class='e-cclist e-cc']"));
			System.out.println(getclicksearch.size());

			// for (int i = 1; i <= getclicksearch.size(); i++) {
			// System.out.println(getclicksearch.get(i).getText());

			driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
			Thread.sleep(2000);
		}

		
		@Test(priority = 14)		
		public void ManageRule() throws Exception {
			try {
				
			// click the Manage rule and create the rule		
			driver.findElement(By.id("ManageRule")).click();
			Thread.sleep(2000);
			logger.info("Manage Rule - click the Manage rule");
			
			// click the create button
			driver.findElement(By.xpath("//button[@class='blm-btn-create']")).click();
			Thread.sleep(2000);
			logger.info("Manage Rule - click the Manage rule");
			
			// check the rule name field validation message
			WebElement dbclick = driver.findElement(By.xpath("(//button[@class='blm-btn-create'])[1]"));
			dbclick.click();
			Thread.sleep(2000);
			WebElement Rulenamevalidate = driver.findElement(By.xpath("//div[text()='Rule Name is required']"));
			String validaterulename = "Rule Name is required";
			Assert.assertEquals(validaterulename, Rulenamevalidate.getText());
			logger.info("Manage Rule - check the rule name field validation message");
			
			// Enter the Rule name
			driver.findElement(By.id("rule_name")).sendKeys("Automation Rule_1");
			Thread.sleep(2000);
			logger.info("Manage Rule - Enter the Rule name");
			
			// check the validation message in Rule type
			WebElement ruletypesvalidate = driver.findElement(By.xpath("//div[text()='Rule Type is required']"));
			Assert.assertEquals("Rule Type is required", ruletypesvalidate.getText());
			Thread.sleep(2000);
			logger.info("Manage Rule - check the validation message in Rule type");
			
			// Select the rule type
			WebElement ruletype = driver.findElement(By.id("rule_type_select"));
			System.out.println(ruletype.getSize());
			Select rule = new Select(ruletype);
			rule.selectByIndex(1);
			Thread.sleep(2000);
			logger.info("Manage Rule - Select the rule type");
			
			// select the check box
			driver.findElement(By.xpath("(//*[text()='Enable Issue Creation'])[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//*[text()='Enable Issue Creation'])[1]")).click();
			Thread.sleep(2000);
			logger.info("Manage Rule - select the check box");
			
			// Select the Severity
			WebElement selectseverity = driver.findElement(By.id("rule_severity"));
			System.err.println(selectseverity.getText());
			Select sev = new Select(selectseverity);
			sev.selectByIndex(2);
			Thread.sleep(2000);
			logger.info("Manage Rule - Select the Severity");
			
			// Validate the description validation message
			WebElement desvalidate = driver.findElement(By.xpath("//*[text()='Description is required']"));
			Assert.assertEquals("Description is required", desvalidate.getText());
			logger.info("Manage Rule - Validate the description validation message");
			
			// Enter the description
			driver.findElement(By.id("rule_description")).sendKeys("Automation test");
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[@class='blm-btn-create'])[1]")).click();
			Thread.sleep(4000);
			logger.info("Manage Rule - Enter the description");
			
			// select the rule category
			WebElement Category = driver.findElement(By.xpath("//div[@class='e-multiselect e-input-group e-checkbox']"));
			Category.click();
			Thread.sleep(2000);
			Actions builder = new Actions(driver);
			builder.sendKeys("Walls").perform();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='e-checkbox-wrapper e-css']")).click();
			Category.click();
			Thread.sleep(2000);
			logger.info("Manage Rule - select the rule category");
			
			// select the property
			WebElement Property = driver.findElement(By.id("param_type"));
			Property.click();
			Thread.sleep(3000);
			Property.sendKeys("Type");
			Property.click();
			Thread.sleep(2000);
			logger.info("Manage Rule - select the property");
			
			// select the Add group
		     driver.findElement(By.xpath("//span[@class='e-btn-icon e-icons e-add-icon']")).click();
	         Thread.sleep(2000);       
	         driver.findElement(By.xpath("//li[text()='Add Group']")).click();
	         Thread.sleep(2000);
	         logger.info("Manage Rule - select the Add group");
	         
	         // search the group
	         WebElement Search = driver.findElement(By.xpath("//span[@class='e-input-group e-control-wrapper e-ddl e-lib e-keyboard']"));
	         Search.click();
	         Search.sendKeys("Family Name");
	         Search.click();
	         Thread.sleep(4000);
	         logger.info("Manage Rule - search the group");
	         
	         // Filter the Rule
	         WebElement Filter = driver.findElement(By.xpath("(//span[@role='listbox'])[2]"));
	 		 Thread.sleep(2000);
	 		 Filter.sendKeys("Starts With");
	 		 Filter.click();
	 		 Thread.sleep(2000);
			 logger.info("Manage Rule - Filter the Rule");
	         
	         // Enter the value
	         WebElement Value = driver.findElement(By.xpath("//input[@class='e-control e-textbox e-lib e-input']"));
	         Value.click();
	         Value.sendKeys("Basic Walls");
	         Value.click();
	         Thread.sleep(2000);
	         logger.info("Manage Rule - Enter the value");
			
			// click the create button
	   //    driver.findElement(By.xpath("//button[text()='Create']")).click();
	         Thread.sleep(2000);
			 logger.info("Manage Rule - click the create button");
			
			// Click the back button
	//		driver.findElement(By.xpath("(//button[@id='back_button'])[1]")).click();
			Thread.sleep(2000);
	//		logger.info("Manage Rule - Click the back button");
			
			// click the cancel button
	//		driver.findElement(By.xpath("(//input[@id='btn_Cancel'])[1]")).click();
			Thread.sleep(2000);
	//		logger.info("Manage Rule - click the cancel button");
			System.out.println("----------------------------------Manage Rule Passed----------------------------------");
			
			test.log(LogStatus.PASS,"ManageRule");
	    }catch (Exception e ) {
		
		String expstr =e.toString();
		  if(expstr.contains(nullpointerexp))
		  {
			  test.log(LogStatus.FAIL,"ManageRule"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nullpointerexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else if(expstr.contains(notclickexp))
		  {
			  test.log(LogStatus.FAIL,"ManageRule"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+notclickexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else if(expstr.contains(nosuchelementexp))
		  {
			  test.log(LogStatus.FAIL,"ManageRule"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nosuchelementexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else
		  {
			  test.log(LogStatus.FAIL,"ManageRule"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+e_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+e.toString());
			  Assert.fail(expstr);
		  }
		  System.out.println(e);
		}
		}

		
		@Test(priority = 15)
		public void ModelViewer() throws Exception {
			try {
				
			// check the model viewer
			driver.findElement(By.id("ModelViewer")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("(//span[@class='e-frame e-icons'])[3]")).click();
			Thread.sleep(2000);
	//		driver.findElement(By.xpath("(//span[@class='e-frame e-icons'])[4]")).click();
			Thread.sleep(2000);
			logger.info("Model Viewer - check the model viewer");
			
			// click the view button
			driver.findElement(By.xpath("//button[@blmtooltip='View']")).click();
			logger.info("Model Viewer - click the view button");

			// check the Progress bar
			WebElement ProgressBar = driver.findElement(By.xpath("//div[@class='progress']"));
			while (true) {
				try {
					if (ProgressBar.isDisplayed())
						System.out.println("Progress is displayed");
					// return;
				} catch (Exception e) {
					System.out.println("Progress is not displayed");
					return;
				}
				logger.info("Model Viewer - check the Progress bar");
				
				// click on the menu bar
				driver.findElement(By.id("3d-pulse")).click();
				Thread.sleep(2000);
				logger.info("Model Viewer - click on the menu bar");
				
				// click on the full screen button
				driver.findElement(By.id("nav-fullScreen")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("nav-fullScreen")).click();
				Thread.sleep(2000);
				logger.info("Model Viewer - click on the full screen button");

				// click on the section clipping
				WebElement Clip = driver.findElement(By.id("iconSectionClipping"));
				Clip.click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//li[@title='xplane']")).click();
				Thread.sleep(2000);
				Clip.click();
				Thread.sleep(2000);
				Clip.click();
				Thread.sleep(2000);
				logger.info("Model Viewer - click on the section clipping");
				
				// click on the fit to screen
				driver.findElement(By.id("nav-fitToScreen")).click();
				Thread.sleep(2000);
				logger.info("Model Viewer - click on the fit to screen");

				// select the model in the viewer
				driver.findElement(By.id("appViewer")).click();
				System.out.println("image is clicked");
				logger.info("Model Viewer - select the model in the viewer");

				// click on the hide by category
				driver.findElement(By.id("hideByCategory")).click();
				Thread.sleep(2000);
				logger.info("Model Viewer - click on the hide by category");

				// click on the unhide
				driver.findElement(By.id("unHide")).click();
				Thread.sleep(2000);
				logger.info("Model Viewer - click on the unhide");

				// click on the menu bar
				driver.findElement(By.id("3d-pulse")).click();
				Thread.sleep(2000);
				logger.info("Model Viewer - click on the menu bar");
				
				// Select the Element
				driver.findElement(By.id("appViewer")).click();
				Thread.sleep(4000);
				logger.info("Model Viewer - Select the Element");
				
				// click on the property window
				driver.findElement(By.xpath("(//a[@title='Property Window'])[1]")).click();
				Thread.sleep(2000);
				logger.info("Model Viewer - click on the property window");

				// Get the Type property
				WebElement TypeProperty = driver.findElement(By.xpath("//table[@class='table table-sm']"));
				System.out.println("-----------------------Type Properties-----------------------");
				System.out.println(TypeProperty.getText());
				Thread.sleep(2000);
				logger.info("Model Viewer - Get the Type property");
				
				// Get the Instance property
				driver.findElement(By.id("nav-instance-tab")).click();
				Thread.sleep(2000);
				WebElement InstanceProperty = driver.findElement(By.xpath("//div[@id='collapseOne0']"));
				System.out.println("-----------------------Instance Properties-----------------------");
				System.out.println(InstanceProperty.getText());
				Thread.sleep(2000);
				System.out.println("-----------------------------------------------------------------");
				Thread.sleep(4000);
				logger.info("Model Viewer - Get the Instance property");
				System.out.println("----------------------------------Model Viewer Passed----------------------------------");
				
				test.log(LogStatus.PASS,"ModelViewer");
		    }}
			catch (Exception e ) {
			
			String expstr =e.toString();
			  if(expstr.contains(nullpointerexp))
			  {
				  test.log(LogStatus.FAIL,"ModelViewer"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nullpointerexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
				  Assert.fail(expstr);
			  }else if(expstr.contains(notclickexp))
			  {
				  test.log(LogStatus.FAIL,"ModelViewer"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+notclickexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
				  Assert.fail(expstr);
			  }else if(expstr.contains(nosuchelementexp))
			  {
				  test.log(LogStatus.FAIL,"ModelViewer"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nosuchelementexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
				  Assert.fail(expstr);
			  }else
			  {
				  test.log(LogStatus.FAIL,"ModelViewer"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+e_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+e.toString());
				  Assert.fail(expstr);
			  }
			  System.out.println(e);
			}		
	}
		
		@Test(priority = 16)
		public void Grouping() throws Exception {
		try {
			
			// Click on the Grouping icon
			driver.findElement(By.xpath("//a[@id='navGrouping']")).click();
			Thread.sleep(2000);
			logger.info("Grouping - Click on the Grouping icon");
			
			// Get the Table data
			WebElement Group = driver.findElement(By.xpath("(//table[@class='e-table'])[2]"));
			System.out.println(Group.getText());
			logger.info("Grouping - Get the Table data");
			
			// Select the Walls under Group
			WebElement ele = driver.findElement(By.xpath("//span[text()='Walls']"));
			Actions act1 = new Actions(driver);
			act1.moveToElement(ele).perform();
			Thread.sleep(2000);
			logger.info("Grouping - Select the Walls under Group");
			
			// Hide the Wall under Group
			driver.findElement(By.xpath("(//i[@blmtooltip='Hide/Show'])[2]")).click();
			Thread.sleep(2000);
			logger.info("Grouping - Hide the Wall under Group");
			
			// Show the Wall under Group
			driver.findElement(By.xpath("(//i[@blmtooltip='Hide/Show'])[2]")).click();
			Thread.sleep(2000);
			logger.info("Grouping - Show the Wall under Group");
			
			// Select the colour to the Group
			driver.findElement(By.xpath("(//span[@class='e-btn-icon e-icons e-caret'])[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@title='Switch Mode']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@aria-label='#b71c1cff']")).click();
			Thread.sleep(2000);
			logger.info("Grouping - Select the colour to the Group");
			
			// Apply the colour to the Group
			driver.findElement(By.xpath("//button[@title='Apply']")).click();
			Thread.sleep(4000);
			logger.info("Grouping - Apply the colour to the Group");
			
			  System.out.println("----------------------------------Grouping Passed----------------------------------");
			    
				test.log(LogStatus.PASS,"CreateIssue");	
				}		
				catch (Exception e ) {
				
				String expstr =e.toString();
				  if(expstr.contains(nullpointerexp))
				  {
					  test.log(LogStatus.FAIL,"CreateIssue"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nullpointerexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
					  Assert.fail(expstr);
				  }else if(expstr.contains(notclickexp))
				  {
					  test.log(LogStatus.FAIL,"CreateIssue"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+notclickexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
					  Assert.fail(expstr);
				  }else if(expstr.contains(nosuchelementexp))
				  {
					  test.log(LogStatus.FAIL,"CreateIssue"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nosuchelementexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
					  Assert.fail(expstr);
				  }else
				  {
					  test.log(LogStatus.FAIL,"CreateIssue"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+e_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+e.toString());
					  Assert.fail(expstr);
				  }
				  System.out.println(e);
		 }	
      }
		
		@Test(priority = 17)
		public void CreateIssue() throws Exception {
		try {
			
			 // Click on the Manage issue
			driver.findElement(By.id("navIssues")).click();
			Thread.sleep(2000);
			logger.info("Create Issue - Click on the Manage issue");
			
			// Select the Element
			driver.findElement(By.id("appViewer")).click();
			Thread.sleep(4000);
			logger.info("Create Issue - Select the Element");
			
			// click on the property window
			driver.findElement(By.xpath("(//a[@title='Property Window'])[1]")).click();
			Thread.sleep(2000);
			logger.info("Create Issue - click on the property window");

			// Get the Type property
			WebElement TypeProperty = driver.findElement(By.xpath("//table[@class='table table-sm']"));
			System.out.println("-----------------------Type Properties-----------------------");
			System.out.println(TypeProperty.getText());
			Thread.sleep(2000);
			logger.info("Create Issue - Get the Type property");
			
			// Get the Instance property
			driver.findElement(By.id("nav-instance-tab")).click();
			Thread.sleep(2000);
			WebElement InstanceProperty = driver.findElement(By.xpath("//div[@id='collapseOne0']"));
			System.out.println("-----------------------Instance Properties-----------------------");
			System.out.println(InstanceProperty.getText());
			Thread.sleep(2000);
			System.out.println("-----------------------------------------------------------------");
			Thread.sleep(2000);
			logger.info("Create Issue - Get the Instance property");		
			
			// Click on the issue button on Property window
			WebElement element = driver.findElement(By.xpath("//i[@class='icon-issue-c text-danger instanceHover pointer float-right ng-star-inserted']"));
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", element);
			Thread.sleep(4000);
			logger.info("Create Issue - Click on the issue button on Property window");
			
			// Check the validation message
			WebElement IssueName = driver.findElement(By.xpath("//input[@type='text']"));
			IssueName.click();
			driver.findElement(By.xpath("//select[@formcontrolname='AssignedTo']")).click();
			Thread.sleep(2000);
			WebElement checkissuevalidationmessage = driver.findElement(By.xpath("//div[text()='Issue Name is required']"));
			Thread.sleep(2000);
			Assert.assertEquals("Issue Name is required", checkissuevalidationmessage.getText());
			logger.info("Create Issue - Check the validation message");
			
			// Check the validation message after enter the special characters
			WebElement PROPERTRYbase = driver.findElement(By.xpath("//input[@type='text']"));
			PROPERTRYbase.sendKeys("^&$&^*$#$#");
			Thread.sleep(2000);
			WebElement checkinvalidvalidationmessage = driver.findElement(By.xpath("//div[text()='Issue Name is Invalid']"));
			Assert.assertEquals("Issue Name is Invalid", checkinvalidvalidationmessage.getText());
			PROPERTRYbase.clear();
			logger.info("Create Issue - Check the validation message after enter the special characters");
			
			// Enter the valid issue name
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys(PropertybasedissueName);
			logger.info("Create Issue - Enter the valid issue name");
			
	        //  Check the Property Based Issue is selected		
			if (driver.findElement(By.xpath("//option[text()=' Property Based Issue']")).isSelected()) 
			{
				System.out.println("Issue Type is in Selected");
			} else {
				System.out.println("Issue Type is in Not Selected");
			//	Assert.fail();
			}
			Thread.sleep(2000);
			logger.info("Create Issue - Check the Property Based Issue is selected");

			// Select the Assign Name
			WebElement AssigneeName = driver.findElement(By.xpath("//select[@formcontrolname='AssignedTo']"));
			AssigneeName.click();
			AssigneeName.sendKeys(Assingeename);
			AssigneeName.click();
		    Thread.sleep(2000);
		    logger.info("Create Issue - Select the Assign Name");
		    
		    // Select the Severity
		    WebElement Severity = driver.findElement(By.xpath("//select[@formcontrolname='IssueSeverity']"));
			Severity.click();
			Severity.sendKeys("Critical");
			Severity.click();
			Thread.sleep(2000);
			logger.info("Create Issue - Select the Severity");
			    
			// Select the Status
			WebElement Status = driver.findElement(By.xpath("//select[@formcontrolname='IssueStatus']"));
			Status.click();
			Status.sendKeys("Open");
			Status.click();
			Thread.sleep(2000);
			logger.info("Create Issue - Select the Status");

			// Enter the description
			WebElement Desc = driver.findElement(By.id("description"));
			Desc.click();
			Desc.sendKeys(propertydescription);
			Thread.sleep(2000);
			logger.info("Create Issue - Enter the description");
			
			// Create the Property based issue
	//		driver.findElement(By.xpath("//input[@value='CREATE']")).click();
			logger.info("Create Issue - Create the Property based issue");
			
			// Cancel the Property based issue
			driver.findElement(By.xpath("//button[@class='blm-btn-cancel']")).click();
	        Thread.sleep(2000);
	        logger.info("Create Issue - Cancel the Property based issue");
	
	        // Click on the Manage issue 
	//		driver.findElement(By.xpath("//a[@id='ManageIssues']")).click();
			Thread.sleep(2000);
			logger.info("Create Issue - Select the Manage issue");
		  
		   // Click on the Manage issue
	//	   driver.findElement(By.id("navIssues")).click();
		   Thread.sleep(2000);
		   logger.info("Create Issue - Click on the Manage issue");
		   
		   // Click on the create issue on Element Based Issue
		   driver.findElement(By.xpath("(//i[@class='blm-icon-issue'])[2]")).click();
		   Thread.sleep(4000);  
		   logger.info("Create Issue - Click on the create issue on Element Based Issue");
		   
		   // Enter the issue name
			WebElement IssueName1 = driver.findElement(By.xpath("//input[@type='text']"));
			IssueName1.click();
			IssueName1.sendKeys(ElementbasedissueName);
			Thread.sleep(2000);
			logger.info("Create Issue - Enter the issue name");
			
		    // Check the Element Based Issue is selected		
				if (driver.findElement(By.xpath("//option[text()=' Element Based Issue']")).isSelected()) 
				{
					System.out.println("Issue Type is in Selected");
				} else {
					System.out.println("Issue Type is in Not Selected");
				//	Assert.fail();
				}
				Thread.sleep(2000);
				logger.info("Create Issue - Check the Element Based Issue is selected");
				
				// Select the Assignee Name
				WebElement AssigneeName1 = driver.findElement(By.xpath("//select[@formcontrolname='AssignedTo']"));
				AssigneeName1.click();
				AssigneeName1.sendKeys(Assingeename);
				AssigneeName1.click();
			    Thread.sleep(2000);
			    logger.info("Create Issue - Select the Assignee Name");
			    
			    // Select the Severity
			    WebElement Severity1 = driver.findElement(By.xpath("//select[@formcontrolname='IssueSeverity']"));
				Severity1.click();
				Severity1.sendKeys("Major");
				Severity1.click();
				Thread.sleep(2000);
				logger.info("Create Issue - Select the Severity");
				
				// Select the Status
				WebElement Status1 = driver.findElement(By.xpath("//select[@formcontrolname='IssueStatus']"));
				Status1.click();
				Status1.sendKeys("In-Progress");
				Status1.click();
				Thread.sleep(2000);
				logger.info("Create Issue - Select the Status");
				
				// Enter the Description
				WebElement Desc1 = driver.findElement(By.id("description"));
				Desc1.click();
				Desc1.sendKeys(Elementdescription);
				Thread.sleep(2000);
				logger.info("Create Issue - Enter the Description");
				
				// Create the Element based issue
		//		driver.findElement(By.xpath("//input[@value='CREATE']")).click();
				logger.info("Create Issue - Create the Element based issue");
				
				// Cancel the issue
				driver.findElement(By.xpath("//button[@class='blm-btn-cancel']")).click();
		        Thread.sleep(2000);
		        logger.info("Create Issue - Cancel the issue");
		        
		        // Select the Manage issue
				driver.findElement(By.xpath("//a[@id='ManageIssues']")).click();
				Thread.sleep(2000);
				logger.info("Create Issue - Select the Manage issue");
				
				      
				// Cancel the Manage issue
		//	   driver.findElement(By.xpath("//span[text()='Cancel']")).click();
			   Thread.sleep(2000);
			   logger.info("Create Issue - Cancel the Manage issue");
			   
			   // Select the Model in the viewer
			    driver.findElement(By.id("ModelViewer")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//span[@class='e-frame e-icons'])[1]")).click();
				Thread.sleep(2000);
				logger.info("Create Issue - Select the Model in the viewer");
				
				// Click on the View button
			   driver.findElement(By.xpath("//button[text()='VIEW']")).click();
			   logger.info("Create Issue - Click on the View button");
			   
			   // Click on the Progress Bar
			   WebElement ProgressBar1 = driver.findElement(By.xpath("//div[@class='progress']"));
				while (true) {
					try {
						if (ProgressBar1.isDisplayed())
							System.out.println("Progress is displayed");
					} catch (Exception e) {
						System.out.println("Progress is not displayed");
						return;
					}
					logger.info("Create Issue - Click on the Progress Bar");
					
					// Click on the Manage issue
					driver.findElement(By.id("navIssues")).click();
				    Thread.sleep(2000);
				    logger.info("Create Issue - Click on the Manage issue");
				    
				    // Click on the create issue button
					 driver.findElement(By.xpath("(//i[@class='blm-icon-issue'])[2]")).click();
					 Thread.sleep(4000);   
					 logger.info("Create Issue - Click on the create issue button");
				
					 // Enter the issue Name
				WebElement IssueName2 = driver.findElement(By.xpath("//input[@type='text']"));
				IssueName2.click();
				IssueName2.sendKeys(StandalonebasedissueName);
				Thread.sleep(2000);
				logger.info("Create Issue - Enter the issue Name");
			
	   //   Check the Standalone Issue is selected		
			if (driver.findElement(By.xpath("//option[text()=' Standalone']")).isSelected()) 
			{
				System.out.println("Issue Type is in Selected");
			} else {
				System.out.println("Issue Type is in Not Selected");
			//	Assert.fail();
			}
			Thread.sleep(2000);
			logger.info("Create Issue - Check the Standalone Issue is selected");
			
			// Select the Assignee Name
			WebElement AssigneeName2 = driver.findElement(By.xpath("//select[@formcontrolname='AssignedTo']"));
			AssigneeName2.click();
			AssigneeName2.sendKeys(Assingeename);
			AssigneeName2.click();
		    Thread.sleep(2000);
		    logger.info("Create Issue - Select the Assignee Name");
		    
		    // Select the Severity
		    WebElement Severity2 = driver.findElement(By.xpath("//select[@formcontrolname='IssueSeverity']"));
			Severity2.click();
			Severity2.sendKeys("Low");
			Severity2.click();
			Thread.sleep(2000);
			logger.info("Create Issue - Select the Severity");
			
			// Select the Status
			WebElement Status2 = driver.findElement(By.xpath("//select[@formcontrolname='IssueStatus']"));
			Status2.click();
			Status2.sendKeys("In-Progress");
			Status2.click();
			Thread.sleep(2000);
			logger.info("Create Issue - Select the Status");
			
			// Enter the Description
			WebElement Desc2 = driver.findElement(By.id("description"));
			Desc2.click();
			Desc2.sendKeys(Standalonedescription);
			Thread.sleep(2000);
			logger.info("Create Issue - Enter the Description");
			
			// Create the Standalone issue
	   // 	driver.findElement(By.xpath("//input[@value='CREATE']")).click();
			logger.info("Create Issue - Create the Standalone issue");
			
			// Cancel the Standalone issue
		 	driver.findElement(By.xpath("//button[@class='blm-btn-cancel']")).click();
	        Thread.sleep(2000);
	        logger.info("Create Issue - Click on the issue button on Property window");
	        
			driver.findElement(By.xpath("//a[@id='ManageIssues']")).click();
			Thread.sleep(2000);
			logger.info("Create Issue - Cancel the Standalone issue");
			
			WebElement SearchIssues = driver.findElement(By.xpath("//h2[@class='card-item-title']"));
			System.out.println(SearchIssues.getText());
			Thread.sleep(2000);
			  
		 // Cancel the Manage issue
	//	   driver.findElement(By.xpath("//span[text()='Cancel']")).click();
		   Thread.sleep(2000);
		   logger.info("Create Issue - Cancel the Manage issue");
		   System.out.println("----------------------------------Create Issue Passed----------------------------------");
		    
		test.log(LogStatus.PASS,"CreateIssue");	
		}		}
		catch (Exception e ) {
		
		String expstr =e.toString();
		  if(expstr.contains(nullpointerexp))
		  {
			  test.log(LogStatus.FAIL,"CreateIssue"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nullpointerexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else if(expstr.contains(notclickexp))
		  {
			  test.log(LogStatus.FAIL,"CreateIssue"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+notclickexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else if(expstr.contains(nosuchelementexp))
		  {
			  test.log(LogStatus.FAIL,"CreateIssue"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+nosuchelementexp_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+expstr);
			  Assert.fail(expstr);
		  }else
		  {
			  test.log(LogStatus.FAIL,"CreateIssue"+"<br />"+"<b style='color:#FF0000';>Reason: </b>"+e_text+"<br />"+"<b style='color:#FF0000';>Exception: </b>"+e.toString());
			  Assert.fail(expstr);
		  }
		  System.out.println(e);
		}	
		}

		@AfterTest
		public void End() {
			System.out.println("End Test...");
			test.log(LogStatus.PASS,"Quit");
			report.endTest(test);
			report.flush();
		}
}
