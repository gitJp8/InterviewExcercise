import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {
    private WebDriver driver;

    WebDriverWait wait;

    public Base(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver setDriver() {
        driver = new ChromeDriver();
        return driver;
    }

    public void get(String url){
        driver.manage().window().maximize();
        driver.get(url);
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void sendKeys(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public boolean isDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void wait(By locator){
        wait = new WebDriverWait(driver, (Duration.ofSeconds(10)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void scrollToEnd(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void quit(){
        driver.quit();
    }
}
