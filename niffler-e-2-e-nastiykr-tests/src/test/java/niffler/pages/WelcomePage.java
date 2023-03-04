package niffler.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import niffler.config.NifflerUiProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WelcomePage implements BasePage<WelcomePage>{
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private final SelenideElement pageApp = $(".main-page__container");
    private final SelenideElement loginButton = $(Selectors.byLinkText("Login"));

    @Step("Open Welcome Page")
    @Override
    public WelcomePage openPage() {
        LOGGER.info("[Step] Open [{}]", NifflerUiProperties.NIFFLER_UI_URL);
        open(NifflerUiProperties.NIFFLER_UI_URL);
        return this;
    }

    @Step("Welcome Page should be loaded")
    @Override
    public WelcomePage shouldBeLoaded() {
        LOGGER.info("[Check] Welcome Page should be loaded");
        pageApp.should(Condition.visible);
        return this;
    }

    @Step("Click login button")
    public void clickLoginButton() {
        LOGGER.info("[Step] Click [Login] button");
        loginButton.click();
    }
}
