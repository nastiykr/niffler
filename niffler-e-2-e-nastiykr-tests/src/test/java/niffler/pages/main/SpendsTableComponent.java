package niffler.pages.main;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import niffler.model.SpendJson;
import niffler.utils.DateConverter;
import niffler.utils.DoubleToStringConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertAll;

public class SpendsTableComponent {

    private final SelenideElement table = $("table.spendings-table");
    private final ElementsCollection spendsRows = table.$$("tbody tr");

    @Step("Find row with spend id [{0}]")
    public SelenideElement findSingleRowBySpendId(String spendId) {
        return rowsBySpendId(spendId)
                .first().scrollTo().ancestor("tr");
    }

    private ElementsCollection rowsBySpendId(String spendId) {
        return $$("input")
                .filter(Condition.value(spendId));
    }

    private SelenideElement rowBySpendId(String spendId) {
        return $$("input")
                .filter(Condition.value(spendId))
                .first().scrollTo().ancestor("tr");
    }

    @Step("Check spend data in table row")
    public void checkSpendDataRow(SpendJson spend) {
        var currentRow = rowBySpendId(spend.getId().toString());
        assertAll("Check spend data in row",
                () -> checkValue(currentRow, 1, "Date", DateConverter.dateToString(spend.getSpendDate())),
                () -> checkValue(currentRow, 2, "Amount", DoubleToStringConverter.convert(spend.getAmount())),
                () -> checkValue(currentRow, 3, "Currency", spend.getCurrency().toString()),
                () -> checkValue(currentRow, 4, "Category", spend.getCategory()),
                () -> checkValue(currentRow, 5, "Description", spend.getDescription()));
    }


    public void clickSpendCheckboxById(String spendId, Condition condition) {
        var el = $$("input")
                .filter(Condition.value(spendId))
                .first().scrollTo();
        el.click();
        el.should(condition);
    }

    private void checkValue(SelenideElement row, int colIndex, String alias, String expectedValue) {
        step("Check [%s], expected value [%s]".formatted(alias, expectedValue), () ->
                row.$("td", colIndex).as(alias)
                        .should(Condition.exactTextCaseSensitive(expectedValue), Duration.ZERO));
    }

}