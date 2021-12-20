package com.qa.ExtentReportListener;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.crm.qa.util.TestUtilClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportNG implements IReporter {

	 private ExtentReports extent;
	 @SuppressWarnings("unused")
	private static final String OUTPUT_FOLDER = "test-output/";
     @SuppressWarnings("unused")
	private static final String FILE_NAME = "Extent.html";

//     private ExtentReports extent;
     private ExtentTest test;

		public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
				String outputDirectory) {
			extent = new ExtentReports(outputDirectory + File.separator
					+ "aaExtent.html", true);

			for (ISuite suite : suites) {
				Map<String, ISuiteResult> result = suite.getResults();

				for (ISuiteResult r : result.values()) {
					ITestContext context = r.getTestContext();

					buildTestNodes(context.getPassedTests(), LogStatus.PASS);
					buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
					buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
				}
			}

			extent.flush();
			extent.close();
		}

		private void buildTestNodes(IResultMap tests, LogStatus status) {
			ExtentTest test;

			if (tests.size() > 0) {
				for (ITestResult result : tests.getAllResults()) {
					test = extent.startTest(result.getMethod().getMethodName());

					test.setStartedTime(getTime(result.getStartMillis()));
					test.setEndedTime(getTime(result.getEndMillis()));

					for (String group : result.getMethod().getGroups())
						test.assignCategory(group);

					if (result.getThrowable() != null) {
						test.log(status, result.getThrowable());
					} else {
						test.log(status, "Test " + status.toString().toLowerCase()
								+ "ed");
					}

					extent.endTest(test);
				}
			}
		}
		
		  public void down(ITestResult result) throws IOException{


	            if(result.getStatus()==ITestResult.FAILURE){
	                test.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
	                test.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report

	                String screenshotPath = TestUtilClass.takeScreenshotAtEndOfTest();
	                test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
	                
	                //extentTest.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); //to add screenshot in extent report
	                //extentTest.fail("details").addScreenCaptureFromPath(screenshotPath);
	            }
	            else if(result.getStatus()==ITestResult.SKIP){
	                test.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
	            }
	            else if(result.getStatus()==ITestResult.SUCCESS){
	                test.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

	            }
	            extent.endTest(test);
	        extent.flush();
	        }

		private Date getTime(long millis) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(millis);
			return calendar.getTime();
		}
		
	
}
