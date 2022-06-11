import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import stellaburgers.pageobject.LoginPage;
import stellaburgers.pageobject.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest extends BaseTest {

    private UserClient userClient;
    private User user;
    private String accessToken;

    LoginPage loginPage = page(LoginPage.class);

    @Before
    public void getUser() {
        user = User.getRandom();
    }

    @After
    public void deleteUser() {
        if (loginPage.isUserRegistered()) {
            userClient = new UserClient();
            accessToken = userClient.loginUser(UserCredentials.from(user)).extract().path("accessToken");
            userClient.deleteUser(accessToken);
        }
    }

    @Test
    @DisplayName("Регистрация пользователя")
    public void userSuccessfullyRegisteredTest() {
        RegistrationPage registrationPage = open(RegistrationPage.pageUrl, RegistrationPage.class);
        registrationPage.registerNewUser(user.getName(), user.getEmail(), user.getPassword());

        loginPage.isLoginPageDisplayed();
    }

    @Test
    @DisplayName("Регистрация пользователя с невалидным паролем")
    public void userIsNotRegisteredTest() {
        RegistrationPage registrationPage = open(RegistrationPage.pageUrl, RegistrationPage.class);
        registrationPage.registerNewUser(user.getName(), user.getEmail(), RandomStringUtils.randomAlphabetic(5));

        registrationPage.isInvalidPasswordErrorDisplayed();
    }
}
