package TestingPractice.TestingComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retry implements IRetryAnalyzer{

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		int count =0 ;
		int maxTry = 0;
		if(count<maxTry)
		{
			count++;
			return true;
		}
		return false;
	}
	
}
