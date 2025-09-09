package base;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import java.util.concurrent.ConcurrentHashMap;

public class RetryAnalyzer implements IRetryAnalyzer {

    private static final int MAX_RETRY_COUNT = 3;
    private static final ConcurrentHashMap<String, Integer> retryCountMap = new ConcurrentHashMap<>();

    int count = 0;
    int retryCount = 3;
    @Override
    public boolean retry(ITestResult result) {
//        String methodName = result.getMethod().getMethodName();
//        String className = result.getTestClass().getName();
//        String testKey = className + "." + methodName;
//
//        // Get current retry count for this specific test method
//        Integer currentCount = retryCountMap.get(testKey);
//        if (currentCount == null) {
//            currentCount = 0;
//        }
//
//        if (currentCount < MAX_RETRY_COUNT) {
//            currentCount++;
//            retryCountMap.put(testKey, currentCount);
//            return true;
//        }
//
//        // Clean up after max retries reached
//        retryCountMap.remove(testKey);
        if(count < retryCount){
            count++;
            return true;
        }
        return false;
    }
}
