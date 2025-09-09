package rerun_failed;

import base.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MethodLevelRetry {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void retryMethodLevelFailed(){
        Assert.assertEquals(true,false,"Failing purposefully");
    }

    public void pass(){
        Assert.assertEquals(true,true,"Shouldn't fail");
    }
}
