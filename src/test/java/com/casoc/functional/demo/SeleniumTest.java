package com.casoc.functional.demo;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SeleniumTest {

    private WebDriver driver;

    @Test
    public void shouldOpenFireFoxAndSearchKeyWord() {
        // 如果你的 FireFox 没有安装在默认目录，那么须在将浏览器或driver地址加入PATH中，或用下面的代码指定
//        System.setProperty("webdriver.firefox.bin", "E:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");

        // 创建一个 FireFox 的浏览器实例
        driver = new FirefoxDriver();

        // 让浏览器访问 Baidu
        driver.get("http://www.baidu.com");
        // 用下面代码也可以实现
        // driver.navigate().to("http://www.baidu.com");

        // 获取 网页的 title
        assertThat(driver.getTitle(), is("百度一下，你就知道"));

        // 通过 id 找到 input 的 DOM
        WebElement element = driver.findElement(By.id("kw"));

        // 输入关键字
        element.sendKeys("zTree");

        // 提交 input 所在的  form
        element.submit();

        // 通过判断 title 内容等待搜索页面加载完毕，间隔10秒
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().startsWith("zTree");
            }
        });

        // 显示搜索结果页面的 title
        assertThat(driver.getTitle(), is("zTree_百度搜索"));

        //关闭浏览器
        driver.quit();
    }

    @Test
    public void shouldOpenChromeAndSearchKeyWord() {
        // 必须指定chromeDriver的目录，可以在http://chromedriver.storage.googleapis.com/index.html 下载
        System.setProperty("webdriver.chrome.driver", "E:\\windows_tool\\chromedriver_win32\\chromedriver.exe");

        // 创建一个 FireFox 的浏览器实例
        driver = new ChromeDriver();
        driver.get("http://www.baidu.com");

        // 获取 网页的 title
        assertThat(driver.getTitle(), is("百度一下，你就知道"));

        // 通过 id 找到 input 的 DOM
        WebElement element = driver.findElement(By.id("kw"));

        // 输入关键字
        element.sendKeys("zTree");

        // 提交 input 所在的  form
        element.submit();

        // 通过判断 title 内容等待搜索页面加载完毕，间隔10秒
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().startsWith("zTree");
            }
        });

        // 显示搜索结果页面的 title
        assertThat(driver.getTitle(), is("zTree_百度搜索"));

        //关闭浏览器
        driver.quit();
    }

}
