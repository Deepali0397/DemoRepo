package com.crm.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.crm.qa.base.BaseClass;

public class TestUtilClass extends BaseClass {
	
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 50;
	
	/*public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}*/
	public static String takeScreenshotAtEndOfTest() throws IOException {
	    String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	    TakesScreenshot ts = (TakesScreenshot)driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
	    String destination = System.getProperty("user.dir") + "/screenshots/" +  dateName
	            + ".png";
	    File finalDestination = new File(destination);
	    FileHandler.copy(source, finalDestination);
	    return destination;
	}
}
