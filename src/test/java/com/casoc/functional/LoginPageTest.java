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
    private static  WebDriver chromeDriver;

    @BeforeClass
    public static void setUp() throws IOException {
        System.setProperty("webdriver.firefox.bin", "E:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        //chromedriver需要单独下载 https://sites.google.com/a/chromium.org/chromedriver/downloads
        System.setProperty("webdriver.chrome.driver", "E:\\windows_tool\\chromedriver_win32\\chromedriver.exe");
        firefoxDriver = new FirefoxDriver();
        chromeDriver = new ChromeDriver();
    }

    public String visitOtherPath() {
        firefoxDriver.get("http://localhost:8080/");
        return firefoxDriver.getTitle();
    }

    public String loginSuccess() {
        WebElement usernameElement = firefoxDriver.findElement(By.name("j_username"));
        WebElement passwordElement = firefoxDriver.findElement(By.name("j_password"));
        usernameElement.sendKeys("adviser");
        passwordElement.sendKeys("adviser");
        passwordElement.submit();
        return firefoxDriver.getTitle();
    }

    public String nonexistentUserLogin() {
        firefoxDriver.get("http://localhost:8080/login.jsp");
        WebElement usernameElement = firefoxDriver.findElement(By.name("j_username"));
        WebElement passwordElement = firefoxDriver.findElement(By.name("j_password"));
        usernameElement.sendKeys("nonexistentUser");
        passwordElement.sendKeys("nonexistentUser");
        passwordElement.submit();
        return getErrorMessage(firefoxDriver);
    }

    public String incorrectPasswordLogin() {
        WebElement usernameElement = firefoxDriver.findElement(By.name("j_username"));
        WebElement passwordElement = firefoxDriver.findElement(By.name("j_password"));
        usernameElement.sendKeys("adviser");
        passwordElement.sendKeys("incorrectPassword");
        passwordElement.submit();
        return getErrorMessage(firefoxDriver);
    }

    public String loginMoreThanOnce() {
        chromeDriver.get("http://localhost:8080/");
        WebElement usernameElement = chromeDriver.findElement(By.name("j_username"));
        WebElement passwordElement = chromeDriver.findElement(By.name("j_password"));
        usernameElement.sendKeys("adviser");
        passwordElement.sendKeys("adviser");
        passwordElement.submit();
        return getErrorMessage(chromeDriver);
    }

    private String getErrorMessage(WebDriver webDriver) {
        return webDriver.findElement(By.id("errorMessage")).getText();
    }

    @AfterClass
    public static void destroy() {
        firefoxDriver.close();
        chromeDriver.close();
    }
}
