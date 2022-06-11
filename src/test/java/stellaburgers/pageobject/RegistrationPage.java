package stellaburgers.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {

    public static final String pageUrl = "https://stellarburgers.nomoreparties.site/register";

    //поле ввода имени
    @FindBy(how = How.XPATH, using = ".//label[contains(@class, 'input__placeholder') and text()='Имя']/following-sibling::input[@name='name']")
    private SelenideElement nameInput;

    //поле ввода email
    @FindBy(how = How.XPATH, using = ".//label[contains(@class, 'input__placeholder') and text()='Email']/following-sibling::input[@name='name']")
    private SelenideElement emailInput;

    //поле ввода пароля
    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    private SelenideElement passwordInput;

    //кнопка "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = ".//button[contains(text(), 'Зарегистрироваться')]")
    private SelenideElement registerButton;

    //ссылка "Войти"
    @FindBy(how = How.XPATH, using = ".//a[@class='Auth_link__1fOlj' and text()='Войти']")
    private SelenideElement loginButton;

    //ошибка "Некорректный пароль"
    @FindBy(how = How.XPATH, using = ".//p[contains(@class, 'input__error') and text()='Некорректный пароль']")
    private SelenideElement invalidPasswordError;


    //метод клик на кнопку "Войти"
    public void registrationLoginButtonClick() {
        loginButton.click();
    }

    //метод регистрации пользователя
    public void registerNewUser(String name, String email, String password) {
        nameInput.setValue(name);
        emailInput.setValue(email);
        passwordInput.setValue(password);
        registerButton.click();
    }

    //метод проверка отображения ошибки "Некорректный пароль"
    public Boolean isInvalidPasswordErrorDisplayed() {
        return invalidPasswordError.isDisplayed();
    }
}
