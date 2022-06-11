package stellaburgers.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    public static final String pageUrl = "https://stellarburgers.nomoreparties.site/login";

    //поле ввода email
    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    private SelenideElement emailInput;

    //поле ввода пароля
    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    private SelenideElement passwordInput;

    //кнопка "Войти"
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'button_button__33qZ0') and text()='Войти']")
    private SelenideElement loginButton;

    //кнопка "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = ".//a[@class='Auth_link__1fOlj' and text()='Зарегистрироваться']")
    private SelenideElement registerButton;

    //кнопка "Восстановить пароль"
    @FindBy(how = How.XPATH, using = ".//a[@class='Auth_link__1fOlj' and text()='Восстановить пароль']")
    private SelenideElement recoverPasswordButton;


    //метод логина пользователя
    public void loginUser(String email, String password) {
        emailInput.setValue(email);
        passwordInput.setValue(password);
        loginButton.click();
    }

    //буленовский метод для проверки условия для удаления пользователя
    public boolean isUserRegistered() {
        return loginButton.isDisplayed();
    }

    //метод отображение страницы логина
    public void isLoginPageDisplayed() {
        loginButton.shouldBe(Condition.visible);
    }
}
