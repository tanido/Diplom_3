import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import stellaburgers.pageobject.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class LoginTest extends BaseTest {

    private UserClient userClient;
    private User user;
    private String accessToken;

    MainPage mainPage = page(MainPage.class);
    LoginPage loginPage = page(LoginPage.class);


    @Before
    public void getUser() {
        userClient = new UserClient();
        user = User.getRandom();
        userClient.createUser(user);
        accessToken = userClient.loginUser(UserCredentials.from(user)).extract().path("accessToken");
    }

    @After
    public void deleteUser() {
        userClient.deleteUser(accessToken);
    }


    @Test
    @DisplayName("Вход через кнопку 'Личный кабинет'")
    public void loginViaProfileButtonTest() {
        mainPage.profileButtonClick();
        loginPage.loginUser(user.getEmail(), user.getPassword());

        mainPage.isCreateOrderButtonDisplayed();
    }

    @Test
    @DisplayName("Вход через кнопку 'Войти в аккаунт'")
    public void loginViaLoginButtonTest() {
        mainPage.loginButtonClick();
        loginPage.loginUser(user.getEmail(), user.getPassword());

        mainPage.isCreateOrderButtonDisplayed();
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginViaRegistrationLoginButtonTest() {
        RegistrationPage registrationPage = open(RegistrationPage.pageUrl, RegistrationPage.class);
        registrationPage.registrationLoginButtonClick();
        loginPage.loginUser(user.getEmail(), user.getPassword());

        mainPage.isCreateOrderButtonDisplayed();
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginViaRecoveryLoginButtonTest() {
        RecoverPasswordPage recoverPasswordPage = open(RecoverPasswordPage.pageUrl, RecoverPasswordPage.class);
        recoverPasswordPage.recoveryLoginButtonClick();
        loginPage.loginUser(user.getEmail(), user.getPassword());

        mainPage.isCreateOrderButtonDisplayed();

    }
}
