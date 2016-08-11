import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

/**
 * Created by Alexandr on 04.08.2016.
 */
public class VerificationLogic {
    private  WebDriver driver;
String testResult [];
    String resultOfPsmsTest;
    public boolean isElementPresent(By locatorKey) {
                   if (driver.findElement(locatorKey).isEnabled())
            return true;
        else
            return false;
        }


 public void generateTestResultFile(String siteName, String location, int whenAppear, boolean resultOfTest){
if (resultOfTest) {
    String resultOfPsmsTest = "PASS";
}
     else {
    String resultOfPsmsTest = "FAILED";
}
    String testResult = siteName+", "+location+", "+whenAppear+", "+ resultOfPsmsTest;
 }

}
