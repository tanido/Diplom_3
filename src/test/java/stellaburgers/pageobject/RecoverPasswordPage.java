package stellaburgers.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RecoverPasswordPage {

    public static final String pageUrl = "https://stellarburgers.nomoreparties.site/forgot-password";

    //кнопка "Войти"
    @FindBy(how = How.XPATH, using = ".//a[@class='Auth_link__1fOlj' and text()='Войти']")
    private SelenideElement loginButton;


    //метод клик на кнопку "Войти"
    public void recoveryLoginButtonClick() {
        loginButton.click();
    }
}
