package executionEngine;

import java.awt.Desktop;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashSet;

import utility.*;
import config.*;
	
	public class WebApplicationTest 
	{
		public static ActionKeywords actionKeywords;
		public static String sActionKeyword;
		public static String sResult;
		public static String sResult1;
		public static String sLocator;
		public static String sLocatorValue;
		public static String sValue;
		public static Method method[];
		public static int iTestStep;
		public static int iTestLastStep;
		public static int iTestStepResult;
		public static int iTestLastStepResult;
		public static int iTestPlatformCount;
		public static int iTestcase;
		public static int iTotalTestCases;
		public static String sTestCaseID;
		public static int iBrowser;
		public static int iTotalBrowsers;
		public static String sBrowserName;
		public static String sBrowserVersion;
		public static String sOperatingSystem;
		public static String sIpAddress;
		public static String sSauceUserName;
		public static String sSauceLabAccessKey;
		public static String sAppliToolApiKey;
		public static String sBrowserRunMode;
		public static String sCloudRunMode;
		public static int iSequence;
		public static String filePath;
		public static String sRunMode;
		public static String sTestStepRunMode;

		
		HashSet<String> arrayResult = new HashSet<String>();
		HashSet<String> arrayResult1 = new HashSet<String>();

		
		
	public void execute_TestCaseWeb() throws Exception 
	{

		Log.info("Fetching Total Number of Browsers");
		 iTotalBrowsers = ExcelUtils.getRowCount(Constants.Sheet_Browsers);
		Log.info("Total Number of Browsers "+iTotalBrowsers);
		for( iBrowser=1;iBrowser<=iTotalBrowsers;iBrowser++){

			Log.info("Fetching Browser Name");

			sBrowserName = ExcelUtils.getCellData(iBrowser, Constants.Col_Browser, Constants.Sheet_Browsers); 
			Log.info("The Browser name is "+sBrowserName);
			
			Log.info("Fetching Browser Version");

			sBrowserVersion = ExcelUtils.getCellData(iBrowser, Constants.Col_BrowserVersion, Constants.Sheet_Browsers); 
			
			Log.info("The Browser Version is "+sBrowserVersion);
			
			Log.info("Fetching Operating System");

			sOperatingSystem = ExcelUtils.getCellData(iBrowser, Constants.Col_BrowserOperatingSystem, Constants.Sheet_Browsers); 

			Log.info("The Operating System is "+sOperatingSystem);
			
			Log.info("Fetching Ip Address of System");

			sIpAddress = ExcelUtils.getCellData(iBrowser, Constants.Col_BrowserIpAddress, Constants.Sheet_Browsers); 

			Log.info("The IP Address is "+sIpAddress);
			
			Log.info("Fetching Sauce User Name");

			sSauceUserName = ExcelUtils.getCellData(iBrowser, Constants.Col_BrowserSauceUserName, Constants.Sheet_Browsers); 

			Log.info("The Sauce User Name is "+sSauceUserName);
			
			Log.info("Fetching Sauce Lab Access Key");

			sSauceLabAccessKey = ExcelUtils.getCellData(iBrowser, Constants.Col_BrowserSauceLabAccessKey, Constants.Sheet_Browsers); 

			Log.info("The Sauce Lab Access Key is "+sSauceLabAccessKey);
						
			Log.info("Fetching AppliTool Api Key");

			sAppliToolApiKey = ExcelUtils.getCellData(iBrowser, Constants.Col_BrowserAppliToolApiKey, Constants.Sheet_Browsers); 

			Log.info("The AppliTool Api Key is "+sAppliToolApiKey);
			
			Log.info("Fetching Browser Run Mode");

			sBrowserRunMode = ExcelUtils.getCellData(iBrowser, Constants.Col_BrowserRunMode,Constants.Sheet_Browsers);

			Log.info("The Browser Run mode is "+sBrowserRunMode);
			
			Log.info("Fetching Cloud Run Mode");

			sCloudRunMode = ExcelUtils.getCellData(iBrowser, Constants.Col_BrowserCloudRunMode,Constants.Sheet_Browsers);

			Log.info("The Cloud Run mode is "+sCloudRunMode);

			if (sBrowserRunMode.equals("Yes"))
			{
										
						iTotalTestCases = ExcelUtils.getRowCount(Constants.Sheet_TestCases);

						Log.info("The Total Number of Total Cases are "+iTotalTestCases);

						ActionsWeb.bResult=true;
	
						for( iTestcase=1;iTestcase<=iTotalTestCases;iTestcase++)
						{
								  
								int SequenceValue=ExcelUtils.getCellData1(iTestcase, Constants.Col_Sequence, Constants.Sheet_Sequences);
							  
								Log.info("The value of iTestCase is "+iTestcase);
								
								Log.info("The Sequence value is "+SequenceValue);

								Log.info("Fetching the sequence value "+SequenceValue);
								Log.info("The compareValue is "+Constants.CompareValue);
									
								if(SequenceValue==Constants.CompareValue)
									
								{
									Log.info("Sequence value is equal to CompareValue");

									Log.info("Incrementing the Compare Value");
									
									Constants.CompareValue++;
									
									Log.info("The incremented Compare value is "+Constants.CompareValue );
									
							sTestCaseID = ExcelUtils.getCellData(iTestcase, Constants.Col_TestCaseID, Constants.Sheet_TestCases); 
							Log.info("The Test Case id is "+sTestCaseID);

							sRunMode = ExcelUtils.getCellData(iTestcase, Constants.Col_RunMode,Constants.Sheet_TestCases);

							Log.info("The Runmode is "+sRunMode);

							if (sRunMode.equals("Yes"))
							{
								Log.info("Running Test Case "+sTestCaseID);

								iTestStep = ExcelUtils.getRowContains(sTestCaseID,Constants.Col_TestCaseID, Constants.Sheet_TestSteps);

								Log.info("Fetching the Test Step "+iTestStep);

								iTestLastStep = ExcelUtils.getTestStepsCount(Constants.Sheet_TestSteps, sTestCaseID, iTestStep);

								Log.info("Fetching the Test Step Counts for TestCaseID "+iTestLastStep);


								ActionsWeb.bResult=true;
								for (;iTestStep<=iTestLastStep;iTestStep++)
								{
									
									Log.info("Fetching the Action Keyword");
									sActionKeyword = ExcelUtils.getCellData(iTestStep, Constants.Col_ActionKeyword,Constants.Sheet_TestSteps);

									Log.info("The Action Keyword is "+sActionKeyword);

									Log.info("Fetching the locator ID");

									sLocator = ExcelUtils.getCellData(iTestStep, Constants.Col_Locator,Constants.Sheet_TestSteps);

									Log.info("The Locator ID is "+sLocator);

									Log.info(" Fetching the total Number of locators");

									int iTotalLocators=ExcelUtils.getRowCount(Constants.Sheet_Locators);

									Log.info("The total Number of locators are "+iTotalLocators);

									for(int iLocator=1;iLocator<=iTotalLocators;iLocator++)

									{


										if(ExcelUtils.getCellData(iLocator, Constants.Col_LocatorID, Constants.Sheet_Locators).equals(sLocator))
										{

											Log.info("Fetching the Locator Value");

											sLocatorValue=ExcelUtils.getCellData(iLocator, Constants.Col_LocatorValue, Constants.Sheet_Locators);

											Log.info("The Locator Value is "+sLocatorValue);

										}
									}

									Log.info("Fetching the Value");

									sValue = ExcelUtils.getCellData(iTestStep, Constants.Col_Value,Constants.Sheet_TestSteps);

									Log.info("The value is "+sValue);
									
                                    Log.info("Fetching the Run Mode for Test Step");
									sTestStepRunMode=ExcelUtils.getCellData(iTestStep, Constants.Col_TestStep_RunMode, Constants.Sheet_TestSteps);

                                    
                                    
                                    if(sTestStepRunMode.equalsIgnoreCase("Yes"))
                                    {
                                    	Log.info("Running the Test Step "+sTestCaseID);
    									ActionsWeb.execute_Actions();
									
                                    }

								

								}
								
								iTestStepResult = ExcelUtils.getRowContains(sTestCaseID,Constants.Col_TestCaseID, Constants.Sheet_TestSteps);
								
								iTestLastStepResult = ExcelUtils.getTestStepsCount(Constants.Sheet_TestSteps, sTestCaseID, iTestStepResult);
								
								for(;iTestStepResult<=iTestLastStepResult;iTestStepResult++)
								{
									sResult=ExcelUtils.getCellData(iTestStepResult, Constants.Col_TestStepResult,Constants.Sheet_TestSteps);
									arrayResult.add(sResult);
								}
								
								for(String result:arrayResult)
								{
									
									if(result.equals("FAIL"))
									{
										ExcelUtils.setCellData(Constants.Keyword_Fail,iTestcase,Constants.Col_Results,Constants.Sheet_TestCases);
										break;
									}
									else
									{
										ExcelUtils.setCellData(Constants.Keyword_Pass,iTestcase,Constants.Col_Results,Constants.Sheet_TestCases);


									}

										
								}
								
								arrayResult.clear();

								
							}
						}
						
								else
								{
									Log.info("Incrementing the iTotalTestCases");
									
									iTotalTestCases++;
									
									Log.info("Incremented value of iTotalTestCases is "+iTotalTestCases);
								}
								
								if(Constants.CompareValue>ExcelUtils.getRowCount(Constants.Sheet_Sequences))
								{
									Log.info("Initializng the Compare value to 1");
									
									Constants.CompareValue=1;
									
									Log.info("The Compare value is initialized to "+Constants.CompareValue);
									break;
								}
								
								if(iTestcase==ExcelUtils.getRowCount(Constants.Sheet_Sequences))
								{
									Log.info("Initializng the iTestcase to 1");
									
									iTestcase=1;
									
									Log.info("The iTestcase is initialized to "+iTestcase);

								}
								
					}	
						
                          iTestPlatformCount = ExcelUtils.getRowCount(Constants.Sheet_TestCases);
						
						for(int i=1;i<=iTestPlatformCount;i++)
						{
							sResult1=ExcelUtils.getCellData(i, Constants.Col_Results,Constants.Sheet_TestCases);
							arrayResult1.add(sResult1);
						}
						
						for(String result1:arrayResult1)
						{
							
							if(result1.equals("FAIL"))
							{
								ExcelUtils.setCellData(Constants.Keyword_Fail,iBrowser,Constants.Col_BrowserResult,Constants.Sheet_Browsers);
								break;
							}
							else
							{
								ExcelUtils.setCellData(Constants.Keyword_Pass,iBrowser,Constants.Col_BrowserResult,Constants.Sheet_Browsers);


							}
							
						}
						
						arrayResult1.clear();
			    }
			
		    }
		
		if(iBrowser>iTotalBrowsers)
		{
			Log.info("Opening Excel File for viewing results");
		    Desktop.getDesktop().open(new File(VerifyingExcel.excelFilePath));
		    
		    Log.info("Stopping the Web Application");
		    System.exit(0);


		}
		}
	}	
