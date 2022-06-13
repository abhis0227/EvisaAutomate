/**
 * 
 */
package Listener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.evisa.qa.util.Takescreenshot;

/**
 * @author Abhishek.Sharma3
 *
 */
public class CustomListener implements ITestListener {

	@Override
	public void onFinish(ITestContext res) {
		System.out.println("***********Test Finished*****************");

	}

	@Override
	public void onStart(ITestContext res) {
		System.out.println("***********Test Started*****************");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult res) {

	}

	@Override
	public void onTestFailure(ITestResult res) {
		try {
			String methodname = res.getMethod().getMethodName();
			Takescreenshot.failedscreenshot(methodname);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult res) {

	}

	@Override
	public void onTestStart(ITestResult res) {

	}

	@Override
	public void onTestSuccess(ITestResult res) {

	}

}
