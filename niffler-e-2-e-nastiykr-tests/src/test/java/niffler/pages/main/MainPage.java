package niffler.pages.main;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import niffler.config.NifflerUiProperties;
import niffler.pages.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage implements BasePage<MainPage> {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private final SpendsTableComponent table = new SpendsTableComponent();
    private final SelenideElement pageApp = $("main.main");

    @Step("Open Main Page")
    @Override
    public MainPage openPage() {
        LOGGER.info("[Step] Open Login Page [{}]", NifflerUiProperties.LOGIN_UI_URL);
        open(NifflerUiProperties.MAIN_UI_URL);
        return this;
    }

    @Step("Main page should be loaded")
    @Override
    public MainPage shouldBeLoaded() {
        LOGGER.info("[Check] Main Page should be loaded");
        pageApp.should(Condition.visible);
        return this;
    }

    public SpendsTableComponent table() {
        return table;
    }
}