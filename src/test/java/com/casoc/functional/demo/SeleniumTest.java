package com.casoc.functional.demo;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SeleniumTest {

    @Test
    public void should() {
        // 如果你的 FireFox 没有安装在默认目录，那么必须在程序中设置
        System.setProperty("webdriver.firefox.bin", "E:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        // 创建一个 FireFox 的浏览器实例
        WebDriver driver = new FirefoxDriver();

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
                return d.getTitle().toLowerCase().startsWith("ztree");
            }
        });

        // 显示搜索结果页面的 title
        assertThat(driver.getTitle(), is("ztree_百度搜索"));

        //关闭浏览器
        driver.quit();
    }
}
