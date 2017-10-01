package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.AuthPage;
import pageobject.OrderPage;


public class testPageOpen {

    private static WebDriver driver;
    private static WebDriverWait wait;


    @BeforeClass
    public void beforeTest() {

        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
    }

    @Test
    public void NegativeNullAuthTest() {
        driver.get("http://95.58.192.184:20003/");
        AuthPage.setInputLogin(driver, "");
        AuthPage.setInputPassword(driver, "");
        AuthPage.clickBtnSignIn(driver);
        Assert.assertEquals(AuthPage.textErrorSignin(driver).getText().equals("Это поле является обязательным"), true);
    }

    @Test(dependsOnMethods = {"NegativeNullAuthTest"})
    public void NegativeAuthTest(){
        AuthPage.setInputLogin(driver, "nevernever");
        AuthPage.setInputPassword(driver, "nevernever");
        AuthPage.clickBtnSignIn(driver);
        Assert.assertEquals(AuthPage.textErrorSignin2(driver).getText().equals("Пользователь с указанным логином не существует"), true);
    }

    @Test(dependsOnMethods = {"NegativeAuthTest"})
    public void positiveAuthTest(){
        driver.get("http://95.58.192.184:20003/");
        AuthPage.setInputLogin(driver, "User");
        AuthPage.setInputPassword(driver, "123456");
        AuthPage.clickBtnSignIn(driver);
        Assert.assertEquals(OrderPage.textOrder(driver).getText().equals("Оформление заказа"), true);

    }

    @Test(dependsOnMethods = {"positiveAuthTest"})
    public void NegativeCreateOrder() {
        OrderPage.clickBtnNext(driver);
        Assert.assertEquals(OrderPage.toastErrorCreateOrder(driver).getText().equals("Проверьте правильность заполненных данных!"), true);
    }

    @Test(dependsOnMethods = {"NegativeCreateOrder"})
    public void positiveCreateOrder() {
        OrderPage.clickItem(driver);
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("click()", OrderPage.jsSelect1(driver));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        OrderPage.selectItemValue(driver);
        OrderPage.setItemquantity(driver, "3");
        OrderPage.clickSauce(driver);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        OrderPage.selectSauceValue(driver);

    }

    @AfterClass
    public void afterTest(){
        driver.quit();
    }
}