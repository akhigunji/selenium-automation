package Testcomponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		int count=0;
		int maxcount = 2;
		if(count<maxcount) {
			count++;
			return true;
		}
		return false;
	}

}
