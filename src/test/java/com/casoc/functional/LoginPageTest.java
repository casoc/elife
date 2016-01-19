package com.casoc.functional;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

@RunWith(ConcordionRunner.class)
public class LoginPageTest {

    private static WebDriver firefoxDriver;
//    private static  WebDriver chromeDriver;

    @BeforeClass
    public static void setUp() throws IOException {
//        System.setProperty("webdriver.firefox.bin", "E:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        //chromedriver需要单独下载 https://sites.google.com/a/chromium.org/chromedriver/downloads
        System.setProperty("webdriver.chrome.driver", "E:\\windows_tool\\chromedriver_win32\\chromedriver.exe");
        firefoxDriver = new FirefoxDriver();
//        chromeDriver = new ChromeDriver();
    }

    public String visitOtherPath() {
        firefoxDriver.get("http://localhost:8080/");
        return firefoxDriver.getTitle();
    }

    public String loginSuccess() {
        useUsernameAndPasswordLogin(firefoxDriver, "adviser", "adviser");
        return firefoxDriver.getTitle();
    }

    public String logoffSuccess() {
        WebElement logoffLink = firefoxDriver.findElement(By.linkText("login out"));
        logoffLink.click();
        return firefoxDriver.getTitle();
    }

    public String nonexistentUserLogin() {
        firefoxDriver.get("http://localhost:8080/");
        useUsernameAndPasswordLogin(firefoxDriver, "nonexistentUser", "nonexistentUser");
        return getErrorMessage(firefoxDriver);
    }

    public String incorrectPasswordLogin() {
        useUsernameAndPasswordLogin(firefoxDriver, "adviser", "incorrectPassword");
        return getErrorMessage(firefoxDriver);
    }

//    public String loginMoreThanOnce() {
//        chromeDriver.get("http://localhost:8080/");
//        useUsernameAndPasswordLogin(chromeDriver, "adviser", "adviser");
//        return getErrorMessage(chromeDriver);
//    }

    private String getErrorMessage(WebDriver webDriver) {
        return webDriver.findElement(By.id("errorMessage")).getText();
    }

    private void useUsernameAndPasswordLogin(WebDriver driver, String username, String password) {
        WebElement usernameElement = driver.findElement(By.name("j_username"));
        WebElement passwordElement = driver.findElement(By.name("j_password"));
        usernameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        passwordElement.submit();
    }

    @AfterClass
    public static void destroy() {
        firefoxDriver.close();
//        chromeDriver.close();
    }
}
