package com.exam.testTask.tests;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import com.exam.testTask.fw.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    Logger logger = LoggerFactory.getLogger(TestBase.class);


    @BeforeSuite
    public void setUp(){
        app.init();
    }

    @BeforeMethod
    public void startTest(Method m){
        logger.info("Start test " + m.getName());

    }




    @AfterMethod
    public void stopTest(Method m){
        logger.info("Stop test " +m.getName());
        logger.info("=============================");
    }


    @AfterSuite(enabled = false)
    public void tearDown(){
        logger.info("Stop test ");
        app.stop();
    }


}
