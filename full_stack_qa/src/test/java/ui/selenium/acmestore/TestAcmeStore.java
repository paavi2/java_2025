package ui.selenium.acmestore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestAcmeStore {

    /* Scenario
    Load -
    Get all list of available product
    Validate price & name of the product present in all product
    * */
    @Test
    public  void verifyNameAndPrice(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://demo.vercel.store/");
        List<WebElement> productNames = driver.findElements(By.xpath("//img/following-sibling::div//h3"));
        List<WebElement> productCost = driver.findElements(By.xpath("//img/following-sibling::div//p"));
        Map<String,String> products = getProduct();
        for(int i=0; i<productNames.size(); i++){
            String actualName = productNames.get(i).getText();
            String actualPrice = productCost.get(i).getText();
            System.out.print("Name => "+actualName);
            System.out.println(":: Price => "+actualPrice);
            if(products.containsKey(actualName))
                Assert.assertEquals(products.get(actualName),actualPrice,"Price mismatch");
        }
        driver.quit();
    }

    private  Map<String, String> getProduct(){
        Map<String,String> products = new HashMap<>();
        products.put("Acme Circles T-Shirt","$20.00USD");
        products.put("Acme Drawstring Bag","$12.00USD");
        products.put("Acme Cup","$15.00USD");
        return  products;
    }

}
