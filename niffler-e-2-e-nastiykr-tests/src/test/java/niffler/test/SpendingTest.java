package niffler.test;

import niffler.jupiter.Spend;
import niffler.model.CategoryValues;
import niffler.model.CurrencyValues;
import niffler.model.SpendJson;
import niffler.pages.LoginPage;
import niffler.pages.WelcomePage;
import niffler.pages.main.MainPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class SpendingTest extends BaseTest {
    @Spend(amount = 499.99, description = "булочка", category = CategoryValues.RESTAURANTS, currency = CurrencyValues.RUB, username = "nastiykr")
    private SpendJson spendJson1;

    WelcomePage welcomePage = new WelcomePage();
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @BeforeEach
    void beforeEach() {
        welcomePage.openPage().shouldBeLoaded().clickLoginButton();

        loginPage.shouldBeLoaded().loginWith("nastiykr", "123");

        mainPage.shouldBeLoaded();
    }

    @Test
    @DisplayName("Check spends with full parameters")
    void checkSpendsWithFullParameters() {
        mainPage.table().checkSpendDataRow(spendJson1);
    }
}
