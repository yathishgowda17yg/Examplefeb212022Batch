package com.sgtesting.Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowerDemo {

		public static WebDriver oBrowser=null;
		public static void main(String[] args) {
			launchBrowser();
			navigate();
			closeApplication();
		}
		private static void launchBrowser()
		{
			try
			{
				System.setProperty("webdriver.gecko.driver", "D:\\JavaPractice\\JavaAutomation\\Web-Automation\\Library\\drivers\\geckodriver.exe");
				oBrowser=new FirefoxDriver();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		private static void navigate()
		{
			try
			{
				oBrowser.get("http://localhost:81/login.do");
				Thread.sleep(4000);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		private static void closeApplication()
		{
			try
			{
				oBrowser.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}
