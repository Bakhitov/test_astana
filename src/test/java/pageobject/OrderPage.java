package pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class OrderPage {

    private static WebElement element = null;

    private static By btnNext = By.xpath("//*[@id=\"container\"]/div/div/div[2]/div/form/div/div[2]/button/div/div");

    private static By item = By.xpath("//*[@id=\"studyYearsFrom\"]/div[1]/button");

    private static By itemValue = By.xpath("/html/body/div[3]/div/div/div/div[2]/span/div");

    private static By itemquantity = By.xpath("//*[@id=\"documentNumber\"]");

    private static By sauce = By.xpath("//*[@id=\"studyYearsFrom\"]/div[1]/button");

    private static By sauceValue = By.xpath("/html/body/div[4]/div/div/div/div[3]");



    public static WebElement textOrder(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div[2]/div/h3"));
        return element;
    }

    public static WebElement toastErrorCreateOrder(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div[3]/div"));
        return element;
    }

    public static WebElement jsSelect1(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/span/div"));
        return element;
    }

    public static void clickBtnNext(WebDriver driver){
        driver.findElement(btnNext).click();
    }

    public static void clickItem(WebDriver driver){
        driver.findElement(item).click();
    }

    public static void selectItemValue(WebDriver driver){
        driver.findElement(itemValue).click();
    }

    public static void setItemquantity(WebDriver driver, String quantity){
        driver.findElement(itemquantity).sendKeys(quantity);
    }

    public static void clickSauce(WebDriver driver){
        driver.findElement(sauce).click();
    }

    public static void selectSauceValue(WebDriver driver){
        driver.findElement(sauceValue).click();
    }
}