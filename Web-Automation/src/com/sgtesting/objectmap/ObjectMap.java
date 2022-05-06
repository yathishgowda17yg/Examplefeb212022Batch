package com.sgtesting.objectmap;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class ObjectMap {
	public static Properties prop=null;
	FileInputStream fin=null;
	
	public ObjectMap(String filename)
	{
		try 
		{
			fin=new FileInputStream(filename);
			prop=new Properties();
			prop.load(fin);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public By getLocator(String logicalname)
	{
		By by=null;
		try 
		{
			String locatordetails=prop.getProperty(logicalname);
			String locator[]=locatordetails.split("!");
			String locatorname=locator[0];
			String locatorvalue=locator[1];
			switch(locatorname.toLowerCase())
			{
			case"id":
				by=By.id(locatorvalue);
				break;
			case"name":
				by=By.name(locatorvalue);
				break;
			case"xpath":
				by=By.xpath(locatorvalue);
				break;
			case "css selector":
				by=By.cssSelector(locatorvalue);
				break;
			case "classname":
				by=By.className(locatorvalue);
				break;
			case "tagname":
				by=By.tagName(locatorvalue);
				break;
			default:
				System.out.println("Invalid locatorname");		
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return by;
	}

}
