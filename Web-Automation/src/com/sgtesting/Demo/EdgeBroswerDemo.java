package com.sgtesting.Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeBroswerDemo {
	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		Lunch();
		navigate();
		closeApplication();
	}
private static void Lunch()
{
	try
	{
		System.setProperty("webdriver.edge.driver", "D:\\JavaPractice\\JavaAutomation\\Web-Automation\\Library\\drivers\\msedgedriver.exe");
		oBrowser=new EdgeDriver();
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
