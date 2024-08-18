import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Registration {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @Before
        public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,20);
    }
    @After
    public void tearDown(){
        driver.quit();
    }

        @Test
        public void formReristration() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");
        var name = "Екатерина";
        driver.findElement(Main.firstName).sendKeys(name);
        var surname = "Зотова";
        driver.findElement(Main.lastName).sendKeys(surname);
        var mail = "test@example.com";
        driver.findElement(Main.email).sendKeys(mail);
        driver.findElement(Main.femaleRadioButton).click();
        var phone = "9999999998";
        driver.findElement(Main.userNumber).sendKeys(phone);

        driver.findElement(Main.dateOfBirth).click();
        WebElement monthYear = driver.findElement(By.className("react-datepicker__current-month"));
            while (!monthYear.getText().equals("June 1998")) { // Замените на нужный месяц и год
               driver.findElement(By.className("react-datepicker__navigation--previous")).click();
                monthYear = driver.findElement(By.className("react-datepicker__current-month"));
            }

           WebElement day = driver.findElement(By.xpath("//div[text()='24']"));
            day.click();

            driver.findElement(Main.subjectsActive).click();
            var subject = "Информационные технологии";
            driver.findElement(Main.subjects).sendKeys(subject);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 500);");

            wait.until(ExpectedConditions.presenceOfElementLocated(Main.picture));
            var imagePath = "/Users/admin/Desktop/картинки/1920х430.png";
            driver.findElement(Main.picture).sendKeys(imagePath);

            var currentAddress = "г. Самара";
            driver.findElement(Main.address).sendKeys(currentAddress);

            // 1 вариант
            driver.findElement(Main.state).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(Main.test));
            driver.findElement(Main.test).click();

            driver.findElement(Main.city).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(Main.test2));
            driver.findElement(Main.test2).click();


            // 2 вариант
           // driver.findElement(Main.city).click();
           // Actions actions = new Actions(driver);
           // actions.moveToElement(driver.findElement(Main.state)).sendKeys(Keys.ENTER).perform();

           // driver.findElement(Main.city).click();
           // Actions actions2 = new Actions(driver);
           // actions2.moveToElement(driver.findElement(Main.city)).sendKeys(Keys.ENTER).perform();

            driver.findElement(Main.submit).click();

            var actualTitle = driver.findElement(Main.title).getText();
            var expectedTitle = "Thanks for submitting the form";
            Assert.assertTrue("Модальное окно не отобразилось",driver.findElement(Main.modalContent).isDisplayed());
            Assert.assertEquals("Неправильный заголовок", expectedTitle, actualTitle);
        }
    }
