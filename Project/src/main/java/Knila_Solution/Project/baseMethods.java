package Knila_Solution.Project;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Random;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.base.Function;


public class baseMethods extends baseLocators {
	protected static WebDriver driver;

    // WebDriver initialization method
    public static void initializeDriver() {
        if (driver == null) { 

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized"); 
            options.addArguments("--incognito"); 

            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
        }
    }

    
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;  
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
	 ExtentReports extentReports;
    ExtentTest extentTest;
    protected void openbrowser(String url) {
        driver.get(url);
    }
	 protected void enter_login(String emailplaceholder,String email,String passwordplaceholder,String pass) {
		 By emailid=By.xpath("//input[@name='"+emailplaceholder+"']");
		 driver.findElement(emailid).sendKeys(email);
		 By password=By.xpath("//input[@name='"+passwordplaceholder+"']");
		 driver.findElement(password).sendKeys(pass);
		 
	 }
	 public String generateRandomYear() {
		    Random random = new Random();
		    int minYear = 1975;
		    int maxYear = 2024;
		    int randomYear = random.nextInt((maxYear - minYear) + 1) + minYear;
		    return String.valueOf(randomYear);
		}
	 
	 protected void login(String emailplaceholder,String email,String passwordplaceholder,String pass,String location, String button) {
		 By emailid=By.xpath("//input[@name='"+emailplaceholder+"']");
		 driver.findElement(emailid).sendKeys(email);
		 By password=By.xpath("//input[@name='"+passwordplaceholder+"']");
		 driver.findElement(password).sendKeys(pass);
		 By visit_location = By.xpath("//li[@id='"+location+"']");
		 click(visit_location);
		 By login=By.xpath("//input[@id='"+button+"']");
		 click(login);
		 
	 }
	 
		protected void click(By locator) {
			try {
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5000));
				wait.until(ExpectedConditions.elementToBeClickable(locator));
				driver.findElement(locator).click();
			}catch(Exception e) {
				
				e.printStackTrace();
			}
		}
		protected void EnterText(By locator,String Input) {
			try {
				Thread.sleep(3000);
				driver.findElement(locator).sendKeys(Input);
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
		protected void startreport(String filename,String doctitle,String scrnshotpath) {
	   		 ExtentSparkReporter sparkReporter = new ExtentSparkReporter(filename);
	   	        extentReports = new ExtentReports();
	   	     sparkReporter.config().setTheme(Theme.DARK);
	   	     sparkReporter.config().setDocumentTitle(doctitle);
	   	  
	   	        extentReports.attachReporter(sparkReporter);

	   	        // Create a test in ExtentReports
	   	        
	   	        ExtentTest test = extentReports.createTest("MyTest");
	   	        test.fail("some error",
	   	        		MediaEntityBuilder
	   	        		.createScreenCaptureFromPath(scrnshotpath)
	   	        		.build());
	   		}
		protected void scrolldown() {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		}
		protected String name_assert(String f_name, String l_name) {
			String expectedname = f_name + ", " + l_name;
			return expectedname;
		}
		protected String DOB_assert(String day, String month, String year) {
			String expectedDob = day + ", " + month + ", " + year;
			return expectedDob;
		}
		protected String Address_assert(String Addr1, String Addr2, String city, String State, String Country, String Postal) {
			String expectedAddress = Addr1 + ", " + Addr2 + ", " + city + ", " + State + ", " + Country + ", " + Postal;
			return expectedAddress;
		}
		protected void fileuploadrobot(String filepath) throws AWTException, InterruptedException {
			  	Robot rb = new Robot();
			  
			    
			    StringSelection str = new StringSelection(filepath);
			    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
			    Thread.sleep(2000);
			   
			    rb.keyPress(KeyEvent.VK_CONTROL);
			    rb.keyPress(KeyEvent.VK_V);
			    rb.keyPress(KeyEvent.VK_ENTER);
			   
		}
		protected void selectoption(By selectboxxpath,String optionvalue) {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5000));
			wait.until(ExpectedConditions.elementToBeClickable(selectboxxpath));
			Select objSelect =new Select(driver.findElement(selectboxxpath));
			objSelect.selectByVisibleText(optionvalue);
		}
		public static String extractValueAfterColon(String inputString) {
	        String[] parts = inputString.split(":", 2);

	        if (parts.length < 2) {
	            throw new IllegalArgumentException("Invalid input: No colon found in the string.");
	        }

	      
	        return parts[1].trim();
	    }
		
		protected String extract_text(By Locator) {
			ElementFinder finder = new ElementFinder(driver, 10);
			String extracted_text = finder.findByXPath(Locator).getText();
			return extracted_text;
			
		}
		
		protected void check_assert(By locator) {
			ElementHandler elementHandler = new ElementHandler(driver, 10);
			elementHandler.assertCondition(
				    elementHandler.isElementVisible(locator),
				    "Element is visible.",
				    "Element is not visible.");
		}
		public void waitForToasterAndAssert() {
			String loginStatus = new WebDriverWait(driver, Duration.ofSeconds(5000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'toast-type-success')]//p"))).getText();
		    if (loginStatus.contains("successfully uploaded")) {
		        System.out.println("Login Success " + loginStatus);
		    } else {
		        System.out.println("Login Failed " + loginStatus);
		    }
		}
		protected void fluent_assert(By locator) {
	        // Create FluentWait with a 10-second timeout and polling every 500ms
	        FluentWait<WebDriver> wait = new FluentWait<>(driver)
	                .withTimeout(Duration.ofSeconds(20)) // Max wait time
	                .pollingEvery(Duration.ofMillis(2000)) // Polling frequency
	                .ignoring(NoSuchElementException.class); // Ignore exceptions

	        // Use FluentWait to find the element
	        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	            public WebElement apply(WebDriver driver) {
	                return driver.findElement(locator); // Return the element if found
	            }
	        });

	        // Assert condition
	        if (element != null) {
	            System.out.println("Element found.");
	        } else {
	            System.out.println("Element not found.");
	            throw new AssertionError("Element not found.");
	        }
	    }
		
		public void verifyCurrentDate(By dateLocator) {
	        
	        String expectedDate = new SimpleDateFormat("dd.MMM.yyyy").format(new Date());	        
	        String actualDate = new WebDriverWait(driver, Duration.ofSeconds(5000)).until(ExpectedConditions.elementToBeClickable(dateLocator)).getText();
	        System.out.println("Expected Date: " + expectedDate);
	        System.out.println("Actual Date: " + actualDate);
	        Assert.assertEquals(actualDate, expectedDate, "Date on the page does not match the current date.");
	    }
		public void verifyUploadTag(By textLocator) {
	        
	        String expectedText = "Attachment Upload";
	        String actualText = new WebDriverWait(driver, Duration.ofSeconds(5000)).until(ExpectedConditions.elementToBeClickable(textLocator)).getText();
	        System.out.println("Expected Date: " + expectedText);
	        System.out.println("Actual Date: " + actualText);
	        Assert.assertEquals(actualText, expectedText, "Upload Tag not available on page.");
	    }
		public void waitForImageInPatientRecords(By imageLocator) {
		    try {
		        // Wait until the image element is visible in the patient records
		        WebElement imageElement = new WebDriverWait(driver, Duration.ofSeconds(8))
		                .until(ExpectedConditions.visibilityOfElementLocated(imageLocator));

		        // Verify if the image is displayed
		        if (imageElement.isDisplayed()) {
		            System.out.println("Image successfully uploaded and visible in patient records.");
		        } else {
		            System.out.println("Image is not visible in patient records.");
		            Assert.fail("Image is not visible in patient records.");
		        }
		    } catch (TimeoutException e) {
		        System.out.println("The image did not appear within the timeout period.");
		        Assert.fail("Image did not appear within the given timeout.");
		    } catch (Exception e) {
		        System.out.println("An unexpected error occurred: " + e.getMessage());
		        Assert.fail("An unexpected error occurred: " + e.getMessage());
		    }
		}
		public static String generateRandomMonth() {
	        // Array of all 12 month names
	        String[] months = {
	            "January", "February", "March", "April", 
	            "May", "June", "July", "August", 
	            "September", "October", "November", "December"
	        };

	        // Initialize Random object
	        Random random = new Random();

	        // Generate a random index between 0 and 11 (inclusive)
	        int randomIndex = random.nextInt(months.length);

	        // Return the random month
	        return months[randomIndex];
	    }
	    public static long generateRandomNumber(int minDigits, int maxDigits) {
	        if (minDigits < 1 || maxDigits < 1 || minDigits > maxDigits) {
	            throw new IllegalArgumentException("minDigits and maxDigits must be positive and minDigits must be less than or equal to maxDigits.");
	        }

	        // Calculate the minimum and maximum values for the given digit lengths
	        long minValue = (long) Math.pow(10, minDigits - 1);
	        long maxValue = (long) Math.pow(10, maxDigits) - 1;

	        // Initialize the Random object
	        Random random = new Random();

	        // Generate and return a random number in the specified range
	        return minValue + (long) (random.nextDouble() * (maxValue - minValue + 1));
	    }


		public class ElementHandler {

		    private WebDriver driver;
		    private int waitTimeout;

		    
		    public ElementHandler(WebDriver driver, int i) {
		        this.driver = driver;
		        this.waitTimeout = i;
		    }

		    
		    public void assertCondition(boolean condition, String successMessage, String failureMessage) {
		        if (!condition) {
		            throw new AssertionError("FAILED :: AS UNEXPECTED :: " + failureMessage);
		        }
		        System.out.println("PASSED :: AS EXPECTED :: " + successMessage);
		    }

		    
		    public boolean isElementVisible(By locator) {
		        boolean visibility = false;
		        scrollIntoView(locator);

		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeout));
		        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		        visibility = true;

		        return visibility;
		    }

		    
		    public boolean isElementNotVisible(By locator) {
		        boolean invisibility = false;
		        scrollIntoView(locator);

		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeout));
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		        invisibility = true;

		        return invisibility;
		    }

		    
		    public void scrollIntoView(By locator) {
		        WebElement element = driver.findElement(locator);
		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		    }
		}

	public class ExcelUtils {

		    private Workbook workbook;
		    private Sheet sheet;

		    
		    public ExcelUtils(String excelPath, String sheetName) {
		        try {
		            FileInputStream fis = new FileInputStream(excelPath);
		            workbook = new XSSFWorkbook(fis);  
		            sheet = workbook.getSheet(sheetName);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }

		    
		    public String getCellData(int rowNum, int colNum) {
		        Row row = sheet.getRow(rowNum);
		        Cell cell = row.getCell(colNum);

		        switch (cell.getCellType()) {
		            case STRING:
		                return cell.getStringCellValue();
		            case NUMERIC:
		                return String.valueOf(cell.getNumericCellValue());
		            case BOOLEAN:
		                return String.valueOf(cell.getBooleanCellValue());
		            default:
		                return "";
		        }
		    }

		    
		    public int getRowCount() {
		        return sheet.getLastRowNum() + 1;  
		    }

		    
		    public int getColumnCount(int rowNum) {
		        Row row = sheet.getRow(rowNum);
		        return row.getLastCellNum();
		    }
		}
	public class ElementFinder {

	    private WebDriver driver;
	    private WebDriverWait wait;

	    // Constructor to initialize WebDriver and WebDriverWait
	    public ElementFinder(WebDriver driver, int timeoutInSeconds) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    }

	    // Reusable method to find element by ID
	    public WebElement findById(String id) {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	    }

	    // Reusable method to find element by XPath
	    public WebElement findByXPath(By xpath) {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
	    }

	    // Reusable method to find element by CSS Selector
	    public WebElement findByCssSelector(String cssSelector) {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
	    }

	    // Reusable method to find element by Class Name
	    public WebElement findByClassName(String className) {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
	    }

	    // Reusable method to find element by Link Text
	    public WebElement findByLinkText(String linkText) {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText)));
	    }

	    // Reusable method to find element by Partial Link Text
	    public WebElement findByPartialLinkText(String partialLinkText) {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(partialLinkText)));
	    }

	    // Reusable method to find element by Name
	    public WebElement findByName(String name) {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
	    }

	    // Reusable method to find element by Tag Name
	    public WebElement findByTagName(String tagName) {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(tagName)));
	    }
	}

}
