package stellaburgers.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PersonalAccountPage {

    public static final String pageUrl = "https://stellarburgers.nomoreparties.site/account/profile";

    //кнопка "Выход"
    @FindBy(how = How.XPATH, using = ".//button[contains(text(), 'Выход')]")
    private SelenideElement logoutButton;

    //кнопка "Конструктор"
    @FindBy(how = How.XPATH, using = ".//p[contains(text(), 'Конструктор')]")
    private SelenideElement constructorButton;

    //логотип
    @FindBy(how = How.XPATH, using = ".//div[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logoButton;

    //кнопка "Профиль"
    @FindBy(how = How.XPATH, using = ".//a[contains(text(), 'Профиль')]")
    private SelenideElement profileButton;


    //метод клик на кнопку "Выход"
    public void logoutButtonClick() {
        logoutButton.click();
    }

    //метод клик на кнопку "Конструктор"
    public void constructorButtonClick() {
        constructorButton.click();
    }

    //метод клик на логотип
    public void logoButtonClick() {
        logoButton.click();
    }

    //метод отображения личного кабинета
    public void isPersonalAccountDisplayed() {
        profileButton.shouldBe(Condition.visible);
    }
}
