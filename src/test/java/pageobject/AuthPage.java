package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthPage {

    private static WebElement element = null;

    public static By inputLogin = By.xpath("//*[@id=\"container\"]/div/form/div/div[2]/div[1]/div/div[1]/div[1]/input");

    public static By inputPassword = By.xpath("//*[@id=\"container\"]/div/form/div/div[2]/div[2]/div/div[1]/div[1]/input");

    public static By btnSignIn = By.xpath("//*[@id=\"container\"]/div/form/div/div[2]/div[4]/div/button/div/div");

    public static void setInputLogin(WebDriver driver, String login){
        driver.findElement(inputLogin).sendKeys(login);
    }

    public static void setInputPassword(WebDriver driver, String password){
        driver.findElement(inputPassword).sendKeys(password);
    }

    public static WebElement textErrorSignin(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"container\"]/div/form/div/div[2]/div[2]/div/div[1]/div[2]"));
        return element;
    }
    public static WebElement textErrorSignin2(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"container\"]/div/form/div/div[2]/div[3]"));
        return element;
    }

    public static void clickBtnSignIn(WebDriver driver){
        driver.findElement(btnSignIn).click();
    }

}