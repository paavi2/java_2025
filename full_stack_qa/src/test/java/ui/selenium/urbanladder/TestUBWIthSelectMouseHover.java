package ui.selenium.urbanladder;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TestUBWIthSelectMouseHover {

    WebDriver driver;
    public WebElement findElement(By obj){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(obj));
        return driver.findElement(obj);
    }
    //Search element
    //Click on first element
    //Drop down  - Sortby (Select 1)
    //Check result, change sort by, check result
    //click on first element
    //Add to card & verify cart has the product added
    @Test
    public void searchClickDropDownNewTab(){

         driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.urbanladder.com/");

        //Search 1 product
        String searchTxt = "Sofa cum bed";
        findElement(By.id("search")).sendKeys(searchTxt+ Keys.ENTER);

        //Close add popup
        findElement(By.xpath("//a[@class='close-reveal-modal hide-mobile']")).click();
        WebElement product1 = findElement(By.xpath("//li[@class='product  hovercard']//img"));
        String productText = product1.getAttribute("title");
        boolean isContain = productText.toLowerCase().contains(searchTxt.toLowerCase());
        Assert.assertEquals(isContain,true,"Searched product not present");
        System.out.println("Current window :: "+driver.getWindowHandle());

        //Select Price low to high
        WebElement dropdown = findElement(By.xpath("//div[@class='dropdown-wrapper']"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Price: Low to High");

        //Click on the product
        product1.click();

        //Switch to new window
        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        //if it contains sofa in url, switch to that & interact
        handles.stream().forEach(System.out::println);
        driver.switchTo().window(handles.get(1));

        //Add product to card
        findElement(By.xpath("//button[@data-event='add_to_cart']")).click();

        //Verify current URl contains card
        String url = driver.getCurrentUrl();
        boolean isUrlFine = url.contains("cart");
        Assert.assertEquals(isUrlFine,true,"Card page didn't load");
    }

    @AfterMethod
    public void destroy(){
        driver.quit();
    }
}
