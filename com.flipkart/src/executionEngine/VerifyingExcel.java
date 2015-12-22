package executionEngine;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;

import config.Constants;
import utility.*;

public class VerifyingExcel extends DriverScriptTest
{
	public static String workingFolderPath;
	public static String logFolderPath;
	public static String screenShotsPath;
	public static String excelFilePath;





public void execute_TestCase1() throws Exception 
	   {
		dispose();

		Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Properties po1 = new Properties();
	    FileInputStream configStream1 = new FileInputStream(Constants.Path_Log4jConfiguraton);
        po1.load(configStream1);

		
	    workingFolderPath=txtHello.getText();

	    if(new File(workingFolderPath).isDirectory()==true)
	    {
		logFolderPath=workingFolderPath+"\\"+"Logs_"+dateFormat.format(date)+"\\log.txt";
        po1.setProperty("log4j.appender.file.File", logFolderPath);
        
        FileOutputStream output1 = new FileOutputStream(Constants.Path_Log4jConfiguraton);
	    po1.store(output1, null);
	    configStream1.close();
        output1.close();
       
        screenShotsPath=workingFolderPath+"\\"+"ScreenShot_"+dateFormat.format(date)+"\\";
        
     
		excelFilePath=textField_1.getText();
		
		File srcDirFile= new File(excelFilePath);
		File destDirFile=new File(workingFolderPath+"\\"+"DataEngine_"+dateFormat.format(date)+"\\");
		
		if(excelFilePath.contains("Web"))
		{
		if(excelFilePath.contains("DataEngine"))
		{
		ExcelUtils.setExcelFile(excelFilePath);
		FileUtils.copyFileToDirectory(srcDirFile, destDirFile);
		
		}
		
		else
		{

			JOptionPane.showMessageDialog(null,"File selected was incorrect, Please select an excel file again");
		}
		
		
				
		if(ExcelUtils.getSheetNames().get(0).equals("Browser"))
		{
			if((ExcelUtils.getCellData(0, 0, Constants.Sheet_Browsers)).equals("Browser Name") && (ExcelUtils.getCellData(0, 1, Constants.Sheet_Browsers)).equals("Browser Version") && (ExcelUtils.getCellData(0, 2, Constants.Sheet_Browsers)).equals("Operating System") && (ExcelUtils.getCellData(0, 3, Constants.Sheet_Browsers)).equals("IP Address") && (ExcelUtils.getCellData(0, 4, Constants.Sheet_Browsers)).equals("Sauce User Name") && (ExcelUtils.getCellData(0, 5, Constants.Sheet_Browsers)).equals("Sauce Lab Access Key") && (ExcelUtils.getCellData(0, 6, Constants.Sheet_Browsers)).equals("AppliTools Api Key")&& (ExcelUtils.getCellData(0, 7, Constants.Sheet_Browsers)).equals("Browser Run Mode") && (ExcelUtils.getCellData(0, 8, Constants.Sheet_Browsers)).equals("Cloud Run Mode") && (ExcelUtils.getCellData(0, 9, Constants.Sheet_Browsers)).equals("Result"))			
			{
				Log.info("Browser Sheet is correct");
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "Browser sheet is not correct");
				Log.info("Browser Sheet is not correct");
				System.exit(0);

			}
		}
		
		if(ExcelUtils.getSheetNames().get(1).equals("Test Cases"))
		{
			if((ExcelUtils.getCellData(0, 0, Constants.Sheet_TestCases)).equals("Test Case Name") && (ExcelUtils.getCellData(0, 1, Constants.Sheet_TestCases)).equals("Test Case Description") && ExcelUtils.getCellData(0, 2, Constants.Sheet_TestCases).equals("Run Mode") && (ExcelUtils.getCellData(0, 3, Constants.Sheet_TestCases)).equals("Priority") && (ExcelUtils.getCellData(0, 4, Constants.Sheet_TestCases)).equals("Result"))
			{
				Log.info("Test Cases sheet is correct");
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "Test Cases sheet is not correct");
				Log.info("Test Cases sheet is not correct");
				System.exit(0);

				
			}
		}
		
		if(ExcelUtils.getSheetNames().get(2).equals("UI Elements"))
		{
			if((ExcelUtils.getCellData(0, 0, Constants.Sheet_Locators).equals("UI Element ID") && ExcelUtils.getCellData(0, 1, Constants.Sheet_Locators).equals("UI Element Description") && ExcelUtils.getCellData(0, 2, Constants.Sheet_Locators).equals("UI Element")))
			{
				Log.info("UI Elements sheet is correct");

			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "UI Elements sheet is not correct");
				Log.info("UI Elements sheet is not correct");
				System.exit(0);

			}
		}
		
		if(ExcelUtils.getSheetNames().get(3).equals("Test Steps"))
		{
			if((ExcelUtils.getCellData(0, 0, Constants.Sheet_TestSteps).equals("Test Case Name") && ExcelUtils.getCellData(0, 1, Constants.Sheet_TestSteps).equals("Test Step ID") && ExcelUtils.getCellData(0, 2, Constants.Sheet_TestSteps).equals("Description") && ExcelUtils.getCellData(0, 3, Constants.Sheet_TestSteps).equals("Action Name") && ExcelUtils.getCellData(0, 4, Constants.Sheet_TestSteps).equals("UI_Element_ID") && ExcelUtils.getCellData(0, 5, Constants.Sheet_TestSteps).equals("Value") && ExcelUtils.getCellData(0, 6, Constants.Sheet_TestSteps).equals("Run Mode") && ExcelUtils.getCellData(0, 7, Constants.Sheet_TestSteps).equals("Result") ))
			{
				Log.info("Test Steps sheet is correct");
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "Test Steps sheet is not correct");
				Log.info("Test Steps sheet is not correct");
				System.exit(0);

			}
		}
		
		if(ExcelUtils.getSheetNames().get(4).equals("Action Keywords"))
		{
			if((ExcelUtils.getCellData(0, 0, Constants.Sheet_ActionKeywords).equals("Action Name") && ExcelUtils.getCellData(0, 1, Constants.Sheet_ActionKeywords).equals("Action Descriptions")))
			{
				Log.info("Action Keywords sheet is correct");
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "Action Keywords sheet is not correct");
				Log.info("Action Keywords sheet is not correct");
				System.exit(0);
			}
		}
		
		if(ExcelUtils.getSheetNames().get(5).equals("Test Results"))
		{
			if((ExcelUtils.getCellData(0, 0, Constants.Sheet_ActionKeywords).equals("Action Name") && ExcelUtils.getCellData(0, 1, Constants.Sheet_ActionKeywords).equals("Action Descriptions")))
			{
				Log.info("Test Results sheet is correct");
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "Test Results sheet is not correct");
				Log.info("Test Results sheet is not correct");
				System.exit(0);

			}
		}
		
		
		WebApplicationTest wat = new WebApplicationTest();
		wat.execute_TestCaseWeb();
	    }
		
		
	   }

	 else
	 {
			JOptionPane.showMessageDialog(null,"The Working Folder Path provided does not exist");

	 }
	   }
	    
		}