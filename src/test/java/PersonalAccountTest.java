import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import stellaburgers.pageobject.LoginPage;
import stellaburgers.pageobject.MainPage;
import stellaburgers.pageobject.PersonalAccountPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class PersonalAccountTest extends BaseTest {

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
        open(LoginPage.pageUrl, LoginPage.class);
        loginPage.loginUser(user.getEmail(), user.getPassword());
        mainPage.profileButtonClick();
    }

    @After
    public void deleteUser() {
        userClient.deleteUser(accessToken);
    }

    @Test
    @DisplayName("Вход в профиль через кнопку 'Личный кабинет'")
    public void openPersonalAccountViaProfileButtonTest() {
        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        personalAccountPage.isPersonalAccountDisplayed();
    }

    @Test
    @DisplayName("Переход к конструктору")
    public void openConstructorFromPersonalAccountTest() {
        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        personalAccountPage.constructorButtonClick();
        mainPage.isCreateOrderButtonDisplayed();
    }

    @Test
    @DisplayName("Переход на главную страницу по клику на лого")
    public void openConstructorViaLogoTest() {
        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        personalAccountPage.logoButtonClick();
        mainPage.isCreateOrderButtonDisplayed();
    }

    @Test
    @DisplayName("Выход из профиля")
    public void logoutTest() {
        PersonalAccountPage personalAccountPage = page(PersonalAccountPage.class);
        personalAccountPage.logoutButtonClick();
        loginPage.isLoginPageDisplayed();
    }

}
