package rerun_failed;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLevelRetry {

    @Test
    public void pass(){
        System.out.println("Test passed successfully");
    }

    @Test
    public void fail(){
        System.out.println("Test failed - will be retried");
        Assert.assertEquals(true,false,"Expected to rerun");
    }
}
