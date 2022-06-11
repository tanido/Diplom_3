import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import stellaburgers.pageobject.MainPage;

import static com.codeborne.selenide.Selenide.page;

public class ConstructorTest extends BaseTest {

    MainPage mainPage = page(MainPage.class);

    @Test
    @DisplayName("Открытие вкладки 'Соусы'")
    public void openSauceTabTest() {
        mainPage.isSauceTabVisible();
    }

    @Test
    @DisplayName("Открытие вкладки 'Начинки'")
    public void openFillingTabTest() {
        mainPage.isFillingTabVisible();
    }

    @Test
    @DisplayName("Открытие вкладки 'Булки'")
    public void openBunTabTest() {
       mainPage.clickFillingTab();
       mainPage.isBunTabVisible();
    }
}
