package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.LoginPage;
import userAction.openPage;


public class testPageOpen {

    private static WebDriver driver;


    @Before
    public void beforeTest() {

        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
    }
    @Test
    public void f(){
        LoginPage.LoadPage(driver);
        openPage.Execute(driver);
    }
    @After
    public void afterTest(){
        driver.quit();
    }
}