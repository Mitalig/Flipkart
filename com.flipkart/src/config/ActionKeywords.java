package config;


import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.io.*;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;








import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

import executionEngine.*;
import utility.Log;

public class ActionKeywords extends JFrame {
	public static WebDriver driver;
	public static File scrFile;
	public static JOptionPane jop;
	public static JDialog k;
	public static JPanel contentPane;
    public static JFrame frame1=new JFrame();
    public static String UrlName;
    public static String testName;
    public static int price=0;
    
    
    public static void openBrowser(String sLocators, String sValue,String sBrowserName, String sBrowserVersion, String sOperatingSystem, String sIpAddress, String sSauceUserName, String sSauceAccessKey, String sCloudRunMode )
	{			
    	
    	if(sCloudRunMode.equalsIgnoreCase("No"))
	   {
						
		try
		{
			if(sBrowserName.equals("Firefox"))
			{
												
				try
				{
	  				execute_WaitPopup();
					Log.info("Opening Firefox Browser");
					driver=new FirefoxDriver();
					driver.manage().window().maximize();
					frame1.dispose();
				}
			        catch (Exception e) {

						Log.info("Not able to open Firefox browser"+e.getMessage());
						ActionsWeb.bResult=false;			
 

						}
			}
			else if(sBrowserName.equals("Chrome"))
			{
				try
				{
										
					System.setProperty("webdriver.chrome.driver","Log4jConfiguration/chromedriver.exe");					 
					execute_WaitPopup();
					Log.info("Opening Chrome Browser");
					driver=new ChromeDriver();	
					//driver.manage().window().maximize();
					Dimension d = new Dimension(1024,768);
					//Resize the current window to the given dimension
					driver.manage().window().setSize(d);
					frame1.dispose();					
					//scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

				}
				catch(Exception e)
				{
					Log.info("Not able to open Chrome Browser "+e.getMessage());
					ActionsWeb.bResult=false;
  	    			 

				}

			}
			else if(sBrowserName.equals("Safari"))
			{
				try
				{
					System.setProperty("webdriver.safari.driver","C:/safaridriver.exe");
					
					execute_WaitPopup();
					Log.info("Opening Safari Browser");
				    driver=new SafariDriver();	 
					driver.manage().window().maximize();
					frame1.dispose();					

				}
				catch(Exception e)
				{
					Log.info("Not able to open Safari Browser "+e.getMessage());
					ActionsWeb.bResult=false;
  	    			 

				}
			}
			else
			{
				try
				{
					System.setProperty("webdriver.ie.driver","Log4jConfiguration/IEDriverServer.exe");

					
					execute_WaitPopup();
					Log.info("Opening IE Browser");
					driver=new InternetExplorerDriver();	
					driver.manage().window().maximize();
					frame1.dispose();					

				}
				catch(Exception e)
				{
					Log.info("Not able to open IE Browser "+e.getMessage());
					ActionsWeb.bResult=false;
  	    			 

				}
			}
		}

		catch(Exception e)
		{
			Log.info("Not able to open browser "+e.getMessage());
			ActionsWeb.bResult=false;
  			 

		}
	   }

	
	}	
    
   

	public static void navigate(String sLocators, String sValue,String sBrowserName){	
		try
		{
			Log.info("Saving the Url Name");
			URL name = new URL(sValue);
			UrlName=name.getHost();			
			Log.info("Url Name Saved");
	
			Log.info("Navigating to URL: "+sValue);
			driver.get(sValue);
		}
		catch(Exception e)
		{
			Log.info("Failed to nagivate to "+ sValue + e.getMessage() );
			ActionsWeb.bResult=false;



		}
	}

	    
	
	public static void click(String sLocators)
	{
		try
		{
			Log.info("Waiting for few Seconds");
			WebDriverWait wait = new WebDriverWait(driver, 250);
			
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));
			 
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sLocators)));
								
			Log.info("Click action performed");
			driver.findElement(By.xpath(sLocators)).click();
			ActionsWeb.bResult=true;
 
		}
		catch(Exception e)
		{
			Log.info("Failed to click "+e.getMessage());
			ActionsWeb.bResult=false;
  			 


		}
	}
	
	public static void submit(String sLocators)
	{
		try
		{
			Log.info("Waiting for few Seconds");
			WebDriverWait wait = new WebDriverWait(driver, 250);
			
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));
			 
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
			
			Log.info("Submit action performed");
			driver.findElement(By.xpath(sLocators)).submit();
			ActionsWeb.bResult=true;
  			 
		}
		catch(Exception e)
		{
			Log.info("Failed to submit "+e.getMessage());
			ActionsWeb.bResult=false;

		}
	}
	
	public static void submit_PageLoad(String sLocators)
	{
		try
		{
			Log.info("Waiting for few Seconds");
			WebDriverWait wait = new WebDriverWait(driver, 250);
			
	     
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sLocators)));
			
			
			Log.info("Submit Page Load action performed");
			driver.findElement(By.xpath(sLocators)).submit();
			ActionsWeb.bResult=true;
  		}
		catch(Exception e)
		{
			Log.info("Failed to submit "+e.getMessage());
		   ActionsWeb.bResult=false;

		}
	}

	public static void doubleClick(String sLocators)
	{
		try
		{
			Log.info("Waiting for few Seconds");
			WebDriverWait wait = new WebDriverWait(driver, 250);
			
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));
			 
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
			
			Log.info("Double Click action performed");
			Actions action = new Actions(driver);
			
			WebElement element = driver.findElement(By.xpath(sLocators));
			action.doubleClick(element).build().perform();
			ActionsWeb.bResult=true;
		
  			 



		}
		catch(Exception e)
		{
			Log.info("Failed to Double Click "+e.getMessage());
			ActionsWeb.bResult=false;
  			 


		}
	}
	public static void input(String sLocators, String sValue,String sBrowserName)
	{
		try
		{
			Log.info("Waiting for few Seconds");
			WebDriverWait wait = new WebDriverWait(driver, 250);
			
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));
			 
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
			
			Log.info("Value entered "+sValue);
			driver.findElement(By.xpath(sLocators)).sendKeys(sValue); 
			
			ActionsWeb.bResult=true;
  			 


		}
		catch(Exception e)
		{
			Log.info("Failed to input value "+sValue + e.getMessage());
			ActionsWeb.bResult=false;
  			 


		}
	}
	
	

	public static void waitFor(String sLocators) throws Exception
	{
		try
		{
			Log.info("Waiting for few Seconds");
			WebDriverWait wait = new WebDriverWait(driver, 250);
			
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));
			 
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
			ActionsWeb.bResult=true;
  			 


		}
		catch(Exception e)
		{
			Log.info("Failed to wait for few seconds "+e.getMessage());
			ActionsWeb.bResult=false;
  			 


		}

	}
	
	public static void wait(String sValue)
	{
		try
		{
			Log.info("Waiting for "+sValue+ " Seconds");
		    int sleep = Integer.parseInt(sValue);
		    Thread.sleep(sleep);
			ActionsWeb.bResult=true;
  		     


		}
		catch(Exception e)
		{
			Log.info("Failed to wait for " +sValue+ " Seconds "+e.getMessage());
			ActionsWeb.bResult=false;
  		     


		}
	}
	
	
	public static void assert_Text(String sLocators, String sAssert) throws InterruptedException
	{
		try
		{
		
		Log.info("Waiting for few Seconds");
		WebDriverWait wait = new WebDriverWait(driver, 250);
		 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sLocators)));
		
		WebElement element=driver.findElement(By.xpath(sLocators));
		Log.info(element.getText());
		if((element.getText().equals(sAssert)))
		{
			Log.info("Text Assertion Passed");
			ActionsWeb.bResult=true;
  		     


		}
		else
		{
			Log.info("Text Assertion Failed");
			ActionsWeb.bResult=false;
		}
	
		}
		catch(Exception e)
		{
			Log.info("Text Assertion Failed"+e.getMessage());
			ActionsWeb.bResult=false;
  		     


		}
		
		
	
	}
	
	
	public static void refreshPage()
	{
		try
		{
			Log.info("Refreshing the page");
			driver.navigate().refresh();
			ActionsWeb.bResult=true;
  		     


		}
		
		catch(Exception e)
		{
			Log.info("Failed to refresh the page "+e.getMessage());
			ActionsWeb.bResult=false;
  		     

		}
	}
	
	public static void forwardPage()
	{
		try
		{
			Log.info("Navigation forward");
			driver.navigate().forward();
			ActionsWeb.bResult=true;
  		     


		}
		
		catch(Exception e)
		{
			Log.info("Failed to navigate forward "+e.getMessage());
			ActionsWeb.bResult=false;
  		     

		}
	}
	
	public static void backwardPage()
	{
		try
		{
			Log.info("Navigation backward");
			driver.navigate().back();
			ActionsWeb.bResult=true;
 		}
		
		catch(Exception e)
		{
			Log.info("Failed to navigate back "+e.getMessage());
			ActionsWeb.bResult=false;
 		}
	}
	
	
	
	public static void scrollDown(String sValue)
	{
		try
		{
			
			Log.info("Scrolling down");
			JavascriptExecutor jsx = ( JavascriptExecutor)driver;
			int i=Integer.parseInt(sValue);
            jsx.executeScript("scroll(0,"+i+")", "");
            ActionsWeb.bResult=true;
			   							     		
		}
		
		catch(Exception e)
		{
			Log.info("Performing Scroll down action failed"+e.getMessage());
			ActionsWeb.bResult=false;
  		     

		}
		
	}
	
	public static void scrollUp(String sValue)
	{
		try
		{
						
			Log.info("Scrolling up");
			JavascriptExecutor jsx = ( JavascriptExecutor)driver;
			int i=Integer.parseInt(sValue);
			jsx.executeScript("window.scrollBy("+i+",0)", "");
			ActionsWeb.bResult=true;
  		
		}
		
		catch(Exception e)
		{
			Log.info("Scrolling Up action failed"+e.getMessage());
			ActionsWeb.bResult=false;
  		     
		}
	}
	
	
	public static void clearText(String sLocators)
	{
		try
		{      
			Log.info("Waiting for few Seconds");
			WebDriverWait wait = new WebDriverWait(driver, 250);
		
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sLocators)));
		 
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
			
		
			Log.info("Clearing the Text");
            driver.findElement(By.xpath(sLocators)).clear();
    		ActionsWeb.bResult=true;
  		     

		}
		
		catch(Exception e)
		{
			Log.info("Clearing of Text failed"+e.getMessage());
			ActionsWeb.bResult=false;		     

		}
	}
	
	
	public static void addPriceText(String sLocators)
	{
		try
		{
			Log.info("Adding Prices");
			WebDriverWait wait = new WebDriverWait(driver,250);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
			
		    String firstText=driver.findElement(By.xpath(sLocators)).getText();
		    String firstTextReplacement=firstText.substring(4, 10);
		    String entireNumber=firstTextReplacement.replaceAll(",", "");
		    int firstPrice=Integer.parseInt(entireNumber);
		    price=price+firstPrice;

		    	    
    		ActionsWeb.bResult=true;

		}
		catch(Exception e)
		{
			Log.info("Falied to Add prices"+e.getMessage());
			ActionsWeb.bResult=false;

		}
	}
	
	public static void assertPriceText(String sLocators)
	{
		try
		{
		
		Log.info("Checking the estimated price");	
			
	    WebDriverWait wait = new WebDriverWait(driver,250);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sLocators)));
		
		String firstText=driver.findElement(By.xpath(sLocators)).getText();
		String firstTextReplacement=firstText.substring(4, 10);
		String entireNumber=firstTextReplacement.replaceAll(",", "");
		String comparePrice=Integer.toString(price);
		
		if(comparePrice.equals(entireNumber))
		{
			Log.info("Price Assertion Passed");
			ActionsWeb.bResult=true;
		}
		
		else
		{
			Log.info("Price Assertion Failed");
			ActionsWeb.bResult=false;

		}
		}
		catch(Exception e)
		{
			Log.info("Price Assertion Failed"+e.getMessage());
			ActionsWeb.bResult=false;

		}
	}

	
	public static void stopWindowLoad()
	{
		try
		{
			Log.info("Stopping Window from loading");
			
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.ESCAPE);

    		ActionsWeb.bResult=true;

		}
		catch(Exception e)
		{
			Log.info("Falied to stop window load"+e.getMessage());
			ActionsWeb.bResult=false;

		}
	}
	


	public static void closeApplication(String sLocators, String sValue, String sBrowserName)
	{
		try
		{
			Log.info("Closing the Application");
			driver.quit();
			ActionsWeb.bResult=true;
  		     
		
		}
		catch(Exception e)
		{
			Log.info("Failed to close the Application "+e.getMessage());
			ActionsWeb.bResult=false;
  		     
		}

	}
	

	

	public static void execute_WaitPopup()
	{
		
		frame1.setUndecorated(true);
		frame1.setForeground(Color.BLACK);
		frame1.setBackground(Color.BLACK);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setBounds(0, 0, 240, 120);
		frame1.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setOpaque(false);
		contentPane.setLayout(null);
		frame1.setContentPane(contentPane);
		
		Label lblPleaseWaitTill = new Label("    Please wait till browser is up..");
		lblPleaseWaitTill.setForeground(Color.WHITE);
		lblPleaseWaitTill.setBackground(Color.BLACK);
		lblPleaseWaitTill.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPleaseWaitTill.setBounds(0, 0, 240, 120);
		contentPane.add(lblPleaseWaitTill);
		frame1.setVisible(true);

	}

}
