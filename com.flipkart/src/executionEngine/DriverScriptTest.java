package executionEngine;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import config.*;

public class DriverScriptTest extends JFrame {


	
	public static JPanel contentPane;
	public static JTextField txtHello;
	public static JTextField textField_1;
	public static DriverScriptTest startEngine;

	
	public static void main(String[] args) throws Exception 
	{

	       EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						   startEngine = new DriverScriptTest();
					       startEngine.execute_TestCase2();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	      
	}	

	public  void execute_TestCase2() throws Exception
	{
		setUndecorated(true);
		setRootPaneCheckingEnabled(false);
		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 353);
		setLocationRelativeTo(null);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setFocusCycleRoot(true);
		contentPane.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		contentPane.setBounds(new Rectangle(100, 100, 130, 100));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterThePath = new JLabel("Select Path of Working Folder");
		lblEnterThePath.setForeground(new Color(128, 128, 128));
		lblEnterThePath.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnterThePath.setBackground(new Color(0, 0, 0));
		lblEnterThePath.setBounds(63, 104, 187, 31);
		contentPane.add(lblEnterThePath);
		
		txtHello = new JTextField();
		txtHello.setName("");
		txtHello.setBounds(271, 104, 296, 31);
		txtHello.setEditable(false);
		contentPane.add(txtHello);
		txtHello.setColumns(10);
		
		JLabel lblSelectPathOf = new JLabel("Select Path of Configuration File");
		lblSelectPathOf.setForeground(new Color(128, 128, 128));
		lblSelectPathOf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSelectPathOf.setBounds(63, 149, 187, 28);
		contentPane.add(lblSelectPathOf);
		
		textField_1 = new JTextField();
		textField_1.setBounds(271, 146, 296, 31);
		textField_1.setEditable(false);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblWelcomeToVitalhealth = new JLabel("Welcome to Zaya's Automation Framework");
		lblWelcomeToVitalhealth.setHorizontalTextPosition(SwingConstants.CENTER);
		lblWelcomeToVitalhealth.setForeground(new Color(128, 128, 128));
		lblWelcomeToVitalhealth.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcomeToVitalhealth.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToVitalhealth.setBackground(Color.BLACK);
		lblWelcomeToVitalhealth.setBounds(191, 22, 465, 34);
		contentPane.add(lblWelcomeToVitalhealth);
		
		Button button = new Button("Browse");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
                showOpenFileDialog();

			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Dialog", Font.BOLD, 12));
		button.setBackground(new Color(51, 153, 255));
		button.setBounds(573, 104, 113, 31);
		contentPane.add(button);
		
		Button button_1 = new Button("Browse");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
                showOpenFileDialog1();

			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Dialog", Font.BOLD, 12));
		button_1.setBackground(new Color(51, 153, 255));
		button_1.setBounds(573, 146, 113, 31);
		contentPane.add(button_1);
		
		Button button_2 = new Button("RUN TEST");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Dialog", Font.BOLD, 12));
		button_2.setBackground(new Color(30, 144, 255));
		button_2.setBounds(63, 205, 623, 34);
		contentPane.add(button_2);
		
		Button button_3 = new Button("DOWNLOAD SAMPLE EXCEL WEB");
		button_3.setActionCommand("DOWNLOAD SAMPLE EXCEL WEB");
		button_3.setForeground(new Color(128, 128, 128));
		button_3.setFont(new Font("Dialog", Font.BOLD, 12));
		button_3.setBackground(Color.WHITE);
		button_3.setBounds(564, 309, 200, 34);
		contentPane.add(button_3);
		
		Button button_4 = new Button("DOWNLOAD SAMPLE EXCEL MOBILE");
		button_4.setForeground(new Color(128, 128, 128));
		button_4.setFont(new Font("Dialog", Font.BOLD, 12));
		button_4.setBackground(Color.WHITE);
		button_4.setActionCommand("DOWNLOAD SAMPLE EXCEL MOBILE");
		button_4.setBounds(23, 309, 227, 34);
		contentPane.add(button_4);
		
		JLabel icon = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Zaya.png")).getImage();
		icon.setIcon(new ImageIcon(img));
		icon.setBounds(23, 11, 173, 71);
		contentPane.add(icon);
		
	    //L1 l1 = new L1();
	    L2 l2 = new L2();
	    button_4.addActionListener(new L1(Constants.Download_ExcelWeb, Constants.Excel_NameMobile));
	    button_3.addActionListener(new L1(Constants.Download_ExcelWeb, Constants.Excel_NameWeb));
	    button_2.addActionListener(l2);


	}
	

	
    private void showOpenFileDialog() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            txtHello.setText(selectedFile.getAbsolutePath());
        }
    }
    
    private void showOpenFileDialog1() {
        JFileChooser fileChooser1 = new JFileChooser();
        fileChooser1.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser1.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser1.addChoosableFileFilter(new FileNameExtensionFilter("Microsoft Excel Documents", "xlsx",".xls"));
        fileChooser1.setAcceptAllFileFilterUsed(true);
        int result1= fileChooser1.showSaveDialog(this);
      
        if (result1 == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser1.getSelectedFile();
            textField_1.setText(selectedFile.getAbsolutePath());
        }     
        
    }  
}
    

class L1 extends DriverScriptTest implements ActionListener
{
 public String excelUrl;
 public String excelName;

	
  public L1(String excelUrl, String excelName)
  {
	  this.excelUrl=excelUrl;
	  this.excelName=excelName;
  }
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
				try 
				{ 
				
				 URL url=new URL(excelUrl); 
				 HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				 int filesize = connection.getContentLength(); 
				 float totalDataRead=0; 
				 java.io.BufferedInputStream in = new java.io.BufferedInputStream(connection.getInputStream());
				 java.io.FileOutputStream fos = new java.io.FileOutputStream(excelName); 
				 java.io.BufferedOutputStream bout = new BufferedOutputStream(fos,14921); 
				 byte[] data = new byte[14921]; 
				 int i=0; 
				 JOptionPane jop2 = new JOptionPane("Zaya's Test Automation Framework");
				 JDialog k2 = jop2.createDialog("Please wait till file is downloaded");
		         k2.setModal(false); 
		         k2.setVisible(true);

				 while((i=in.read(data,0,14921))>=0) 
				 {
				 totalDataRead=totalDataRead+i; 
				 bout.write(data,0,i); 
				 float Percent=(totalDataRead*100)/filesize; 
				 
				 }	
				 bout.close();
				 in.close(); 
				 //fos.close();
				 k2.dispose();

				 
				 } 
			     
				 catch(Exception e)
				 { 
					 JOptionPane.showMessageDialog(null, "Sample Configuration file downloaded");

				 }
			
		} 

    }
    
class L2 extends DriverScriptTest implements ActionListener{
    
	    
	    @Override
	    public void actionPerformed(ActionEvent e) 
	    {
	    	try {
	    		
			
			 VerifyingExcel verify= new VerifyingExcel();
			verify.execute_TestCase1();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	    	
	    	
			}
	        
	    }
	
