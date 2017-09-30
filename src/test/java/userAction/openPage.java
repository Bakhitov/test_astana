package userAction;

import org.openqa.selenium.WebDriver;
import pageObject.LoginPage;
/**
 * Created by ahanbahitov on 05.06.17.
 */
public class openPage {
    public static void Execute(WebDriver driver){
        LoginPage.LoadPage(driver);
    }
}
