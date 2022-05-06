package com.sgtesting.reflectionscenarios;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RunReflectionScript {
	static Workbook wb=null;
	static FileInputStream fin=null;
	static Sheet sh=null;
	static Row row=null;
	static Cell cell=null;

	public static void main(String[] args) {
		executeTests();

	}

	private static void executeTests()
	{
		Workbook wb=null;
		FileInputStream fin=null;
		Sheet sh=null;
		Row row=null;
		Cell cell=null;
		try
		{
			String path=System.getProperty("user.dir");
			fin=new FileInputStream(path+"\\ExcelFile\\TestScript.xlsx");
			wb=new XSSFWorkbook(fin);
			int sc=wb.getNumberOfSheets();
			System.out.println(sc+"    its sc");
			
			for (int i = 0; i <sc; i++) 
			{
				sh=wb.getSheetAt(i);
				int rc=sh.getPhysicalNumberOfRows();
				for(int r=1;r<rc;r++)
				{
					row=sh.getRow(r);
					cell=row.getCell(0);
					String methodname=cell.getStringCellValue();
					cell=row.getCell(1);
					String pkgclassname=cell.getStringCellValue();
					System.out.println(methodname+" <------ "+pkgclassname);

					Class clsobject=Class.forName(pkgclassname);
					Object obj=clsobject.getDeclaredConstructor().newInstance();

					Method method=obj.getClass().getMethod(methodname);
					method.invoke(obj);
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fin.close();
				wb.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
