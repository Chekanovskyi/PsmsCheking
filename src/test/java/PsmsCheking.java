import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;


/**
 * Created by Alexandr on 19.07.2016.
 */
public class PsmsCheking {
VerificationLogic verification = new VerificationLogic();
    private WebDriver driver;
    private String baseUrl;
    public long dateTime;
    public int maxLimitEntarence=7;
    public int countOfEntarence;
    public boolean isElementPresetn;
    protected  int actualCount=0;

    public long generateDateEmail() {
        Calendar mills = new GregorianCalendar();
        return dateTime = (mills.getTimeInMillis());

    }

    @DataProvider(name ="psmsSitesUrl")
    public Object [][] getUrel()
    { return new Object[][]{
            {"naughtyavenue"},
            {"getnaughty"},
    };
    }
    @BeforeTest
    public void setupTest(){
        driver = new FirefoxDriver();
    }


    @Test(dataProvider = "psmsSitesUrl")
    public void psmsPresents(String siteUrl) throws InterruptedException {
        driver.get("https://www."+siteUrl+".com/?utm_source=int");

        WebElement waiting = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='submit_button']")));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='UserForm_password']"));
        passwordField.clear();
        passwordField.click();
        passwordField.sendKeys("gop2pog");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement email = driver.findElement(By.xpath("//input[@id='UserForm_email']"));
        email.clear();
        email.click();
        email.sendKeys("9000tn+" + generateDateEmail() + "@gmail.com");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement locationField = driver.findElement(By.xpath("//input[@id='UserForm_location']"));
        locationField.click();
        locationField.clear();

        locationField.sendKeys("33445");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement birthDate = driver.findElement(By.xpath("//select[@id='UserForm_day']"));
        birthDate.sendKeys("29");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement birthMount = driver.findElement(By.xpath("//select[@id='UserForm_month']"));
        birthMount.sendKeys("April");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement birthYear = driver.findElement(By.xpath("//select[@id='UserForm_year']"));
        birthYear.sendKeys("1990");

         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        waiting = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='submit_button']")));
        Thread.sleep(4000);
        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit_button']"));
        submitButton.click();
        Thread.sleep(5000);
        WebElement skipConfirm = driver.findElement(By.xpath("//a[@class='btn']"));
    skipConfirm.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(siteUrl+"/pay");
        for(int i=0; i<=maxLimitEntarence; i++){
           waiting = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/a[@href='/pay/page/verifiedByVisa']")));
            String pageSource = driver.getCurrentUrl();
             driver.get(pageSource+i);
             actualCount=+i;
           if (verification.isElementPresent(By.xpath("//div//li[@data-type='sms']")))
               break;
             }
             }


}



