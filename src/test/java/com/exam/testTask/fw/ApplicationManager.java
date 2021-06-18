package com.exam.testTask.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    public WebDriver wd;

    SearchHelper search;
    ItemFilterHelper itemFilter;
    String browser;

    public ApplicationManager(String browser) {

        this.browser = browser;
    }

    public SearchHelper getSearch() {
        return search;
    }

    public ItemFilterHelper getItemFilter() {
        return itemFilter;
    }

    public void init() {
        if(browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        }else if (browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        }


        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://yandex.ru/");

        search = new SearchHelper(wd);
        itemFilter = new ItemFilterHelper(wd);
    }
    public void stop() {
        wd.quit();
    }

}
