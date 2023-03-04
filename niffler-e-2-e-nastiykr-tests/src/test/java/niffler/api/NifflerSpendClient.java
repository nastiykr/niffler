package niffler.api;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import niffler.api.service.RestService;
import niffler.config.NifflerApiProperties;
import niffler.model.SpendJson;

import java.io.IOException;
import java.util.List;

public class NifflerSpendClient extends RestService {

    private final NifflerSpendApi nifflerSpendApi = retrofit.create(NifflerSpendApi.class);

    public NifflerSpendClient() {
        super(NifflerApiProperties.SPEND_API);
    }

    @Step("Create spends")
    public SpendJson createSpend(SpendJson spendJson) {
        SpendJson spendResponse = null;
        try {
            spendResponse = nifflerSpendApi
                    .addSpend(spendJson)
                    .execute()
                    .body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return spendResponse;
    }

    @Step("Delete spends for user [{0}]")
    public void deleteSpends(String userName, List<String> spendIds) {
        String spendsString = "";
        if (spendIds.size() > 0) {
            spendsString = String.join(",", spendIds);
            Allure.addAttachment("spends ids", spendsString);
        }

        try {
            nifflerSpendApi
                    .deleteSpends(userName, spendsString)
                    .execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Get user [{0}] spends")
    public List<SpendJson> getUserSpends(String userName) {
        try {
            return nifflerSpendApi
                    .getUserSpends(userName)
                    .execute()
                    .body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
