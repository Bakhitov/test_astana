package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class LoginPage {
    /**
     * WebElement element
     */
    private static WebElement element = null;
    /**
     * @param driver это объект который позволяет общаться с chrome
     * @return возращает значение функции
     * throws InterruptedException обработка исключении, если будет не найден элемент, то сработает этот объект
     */
    public static WebDriver LoadPage(WebDriver driver){
        driver.get("http://95.58.192.184:20003/");
        return driver;
    }
    public static WebElement txtbx_UserName(WebDriver driver) throws ElementNotFoundException {
        element = driver.findElement(By.id("email"));
        return element;
    }
    public static WebElement txtbx_Password(WebDriver driver) throws ElementNotFoundException {
        element = driver.findElement(By.id("pass"));
        return element;
    }
    public static WebElement btn_LogIn(WebDriver driver) throws  ElementNotFoundException {
        element = driver.findElement(By.id("loginbutton"));
        return element;
    }
}
