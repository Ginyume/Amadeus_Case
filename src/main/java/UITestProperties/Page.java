package UITestProperties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Page {
    private final WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public void SendKeysFromAndTo(String from, String to) throws InterruptedException {
        driver.findElement(By.id("headlessui-combobox-input-:Rq9lla:")).clear();
        Thread.sleep(500);
        driver.findElement(By.id("headlessui-combobox-input-:Rq9lla:")).sendKeys(from, Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.id("headlessui-combobox-input-:Rqhlla:")).clear();
        driver.findElement(By.id("headlessui-combobox-input-:Rqhlla:")).sendKeys(to,Keys.ENTER);
    }
    public void SendKeysFromAndTo(String from) throws InterruptedException {
        driver.findElement(By.id("headlessui-combobox-input-:Rq9lla:")).clear();
        Thread.sleep(500);
        driver.findElement(By.id("headlessui-combobox-input-:Rq9lla:")).sendKeys(from, Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.id("headlessui-combobox-input-:Rqhlla:")).clear();
        driver.findElement(By.id("headlessui-combobox-input-:Rqhlla:")).sendKeys(from);
        if (driver.findElement(By.xpath("//span[text()='"+from+"']")).isDisplayed()) {
            throw new AssertionError("Hata: Beklenmeyen eleman bulundu!");
        }
    }

    public void Listing() {
        String words=driver.findElement(By.xpath("//p[@class='mb-10']")).getText();
        int count=driver.findElements(By.xpath("//li[@class='overflow-hidden rounded-xl border border-gray-200']")).size();
        Assert.assertEquals("Found "+String.valueOf(count)+" items",words);

    }
}
