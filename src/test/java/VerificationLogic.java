import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Alexandr on 04.08.2016.
 */
public class VerificationLogic {
    private WebDriver driver;

    public boolean isElementPresent(By locatorKey) {
        try {

            driver.findElement(locatorKey);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementVisible(String cssLocator){
        return driver.findElement(By.cssSelector(cssLocator)).isDisplayed();
    }
}
