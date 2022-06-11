package stellaburgers.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {

    public static final String pageUrl = "https://stellarburgers.nomoreparties.site";

    //кнопка "Личный кабинет"
    @FindBy(how = How.XPATH, using = ".//p[contains(text(), 'Личный Кабинет')]")
    private SelenideElement profileButton;

    //вкладка "Булки"
    @FindBy(how = How.XPATH, using = ".//span[contains(text(), 'Булки')]")
    private SelenideElement bunTab;

    //активная вкладка "Булки"
    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'tab_tab_type_current__2BEPc')]")
    private SelenideElement bunTabActive;

    //заголовок "Булки"
    @FindBy(how = How.XPATH, using = ".//h2[contains(text(), 'Булки')]")
    private SelenideElement bunHeader;

    //вкладка "Соусы"
    @FindBy(how = How.XPATH, using = ".//span[contains(text(), 'Соусы')]")
    private SelenideElement sauceTab;

    //активная вкладка "Соусы"
    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'tab_tab_type_current__2BEPc')]")
    private SelenideElement sauceTabActive;

    //заголовок "Соусы"
    @FindBy(how = How.XPATH, using = ".//h2[contains(text(), 'Соусы')]")
    private SelenideElement sauceHeader;

    //вкладка "Начинки"
    @FindBy(how = How.XPATH, using = ".//span[contains(text(), 'Начинки')]")
    private SelenideElement fillingTab;

    //активная вкладка "Начинки"
    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'tab_tab_type_current__2BEPc')]")
    private SelenideElement fillingTabActive;

    //заголовок "Начинки"
    @FindBy(how = How.XPATH, using = ".//h2[contains(text(), 'Начинки')]")
    private SelenideElement fillingHeader;

    //кнопка "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = ".//button[contains(text(), 'Войти в аккаунт')]")
    private SelenideElement loginButton;

    //кнопка "Оформить заказ"
    @FindBy(how = How.XPATH, using = ".//button[contains(text(), 'Оформить заказ')]")
    private SelenideElement createOrderButton;


    //метод клик на кнопку "Личный кабинет"
    public void profileButtonClick() {
        profileButton.click();
    }

    //метод открытия вкладки "Булки"
    public void isBunTabVisible() {
        bunTab.click();
        bunTabActive.shouldHave(Condition.cssClass("tab_tab_type_current__2BEPc"));
        bunHeader.shouldBe(Condition.visible);
    }

    //метод открытия вкладки "Соусы"
    public void isSauceTabVisible() {
        sauceTab.click();
        sauceTabActive.shouldHave(Condition.cssClass("tab_tab_type_current__2BEPc"));
        sauceHeader.shouldBe(Condition.visible);
    }

    //метод клик на вкладку "Начинки"
    public void clickFillingTab() {
        fillingTab.click();
    }

    //метод открытия вкладки "Начинки"
    public void isFillingTabVisible() {
        fillingTab.click();
        fillingHeader.shouldBe(Condition.visible);
        fillingTabActive.shouldHave(Condition.cssClass("tab_tab_type_current__2BEPc"));
    }

    //метод клик на кнопку "Войти в аккаунт"
    public void loginButtonClick() {
        loginButton.click();
    }

    //метод отображение кнопки "Оформить заказ" у залогиненного пользователя
    public void isCreateOrderButtonDisplayed() {
        createOrderButton.shouldBe(Condition.visible);
    }
}
