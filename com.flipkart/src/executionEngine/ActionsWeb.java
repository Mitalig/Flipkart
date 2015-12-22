package executionEngine;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import config.*;
import utility.*;
public class ActionsWeb 
{
	public static boolean bResult;

public static void execute_Actions() throws Exception {

			
			if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Open Browser"))
			{
				ActionKeywords.openBrowser(WebApplicationTest.sLocatorValue, WebApplicationTest.sValue, WebApplicationTest.sBrowserName, WebApplicationTest.sBrowserVersion, WebApplicationTest.sOperatingSystem, WebApplicationTest.sIpAddress, WebApplicationTest.sSauceUserName,WebApplicationTest.sSauceLabAccessKey,  WebApplicationTest.sCloudRunMode );
			}
			
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Navigate"))
			{
				ActionKeywords.navigate(WebApplicationTest.sLocatorValue, WebApplicationTest.sValue, WebApplicationTest.sBrowserName);
			}
			
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Click"))
			{
				ActionKeywords.click(WebApplicationTest.sLocatorValue);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Submit"))
			{
				ActionKeywords.submit(WebApplicationTest.sLocatorValue);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Submit Page Load"))
			{
				ActionKeywords.submit_PageLoad(WebApplicationTest.sLocatorValue);
			}
			
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Double Click"))
			{
				ActionKeywords.doubleClick(WebApplicationTest.sLocatorValue);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Wait For"))
			{
				ActionKeywords.waitFor(WebApplicationTest.sLocatorValue);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Wait"))
			{
				ActionKeywords.wait(WebApplicationTest.sValue);
				
			}
			
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Input"))
			{
				ActionKeywords.input(WebApplicationTest.sLocatorValue, WebApplicationTest.sValue, WebApplicationTest.sBrowserName);
			}
					
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Refresh Page"))
			{
				ActionKeywords.refreshPage();
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Navigate Backward"))
			{
				ActionKeywords.forwardPage();
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Navigate Forward"))
			{
				ActionKeywords.backwardPage();
			}
			
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Scroll Down"))
			{
				ActionKeywords.scrollDown(WebApplicationTest.sValue);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Scroll Up"))
			{
				ActionKeywords.scrollUp(WebApplicationTest.sValue);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Clear Text"))
			{
				ActionKeywords.clearText(WebApplicationTest.sLocatorValue);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Assert Text"))
			{
				ActionKeywords.assert_Text(WebApplicationTest.sLocatorValue, WebApplicationTest.sValue);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("AddPrice Text"))
			{
				ActionKeywords.addPriceText(WebApplicationTest.sLocatorValue);
			}
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("AssertPrice Text"))
			{
				ActionKeywords.assertPriceText(WebApplicationTest.sLocatorValue);
			}
			
			else if(WebApplicationTest.sActionKeyword.equalsIgnoreCase("Stop Window Load"))
			{
				ActionKeywords.stopWindowLoad();
			}
			else
			{
				ActionKeywords.closeApplication(WebApplicationTest.sLocatorValue, WebApplicationTest.sValue, WebApplicationTest.sBrowserName);
			}
				
					
				if(bResult==true)
				{
					ExcelUtils.setCellData(Constants.Keyword_Pass, WebApplicationTest.iTestStep, Constants.Col_TestStepResult, Constants.Sheet_TestSteps);
				}			
				if(bResult==false)
				{

					File scrFile = ((TakesScreenshot) ActionKeywords.driver).getScreenshotAs(OutputType.FILE);

					int stepno=(WebApplicationTest.iTestStep)+1;
					
					FileUtils.copyFile(scrFile, new File(VerifyingExcel.screenShotsPath+"//"+WebApplicationTest.sTestCaseID+"//"+stepno+".jpg"));

					ExcelUtils.setCellData(Constants.Keyword_Fail, WebApplicationTest.iTestStep, Constants.Col_TestStepResult, Constants.Sheet_TestSteps);


				}
				

			}
			
			}