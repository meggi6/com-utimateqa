package project5_selenium_week1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

/**
 * Project-5 - ProjectName : com-utimateqa
 * BaseUrl = https://courses.ultimateqa.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Sign In’ link
 * 7. Print the current url
 * 8. Enter the email to email field. 9. Enter the password to password field. 10. Click on Login Button.
 * 11. Navigate to baseUrl.
 * 12. Navigate forward to Homepage. 13. Navigate back to baseUrl.
 * 14. Refresh the page.
 * 15. Close the browser.
 */
public class Utimateqa {
    static String browser = "Chrome";  //setting browser
    static String baseUrl = "https://courses.ultimateqa.com/";
    static WebDriver driver;    //declaring webdriver interface

    public static void main(String[] args) {
        //Checking for multiple browsers to launch
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        } else {
            System.out.println("wrong browser name");
        }

        //launching url
        driver.get(baseUrl);
        //maximize window
        driver.manage().window().maximize();
        //setting Implicit wait to driver until page is fully loaded
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //printing website title on console
        System.out.println("Title of website is: " + driver.getTitle());
        //printing current URL
        System.out.println("The current URL is: " + driver.getCurrentUrl());
        //printing page source
        System.out.println("The page source is: " + driver.getPageSource());

        //Clicking on sign-in link element
        driver.findElement(By.linkText("Sign In")).click();
        //printing current URL
        System.out.println("The current URL is: " + driver.getCurrentUrl());
        driver.findElement(By.id("user[email]")).sendKeys("megha123@gmail.com");
        driver.findElement(By.id("user[password]")).sendKeys("megha@123");
        driver.findElement(By.className("g-recaptcha")).click();

        //navigation
        driver.navigate().to(baseUrl);
        driver.navigate().forward();
        driver.navigate().back();
        driver.navigate().refresh();

        driver.quit(); //close browser
    }

}
