package niffler.jupiter;

import niffler.api.NifflerSpendClient;
import niffler.model.SpendJson;

import java.lang.reflect.Field;
import java.util.*;

public class SpendExtensionsHelper {
    static void findAndDeleteSpendsForUserName(String userName) {
        List<String> spends = new ArrayList<>();
        new NifflerSpendClient().getUserSpends(userName)
                .stream()
                .filter(spendJson -> spendJson.getId() != null)
                .forEach(spendJson -> spends.add(spendJson.getId().toString()));
        new NifflerSpendClient().deleteSpends(userName, spends);
    }

    static void deleteSpends(List<Field> fieldList) {
        Set<String> userNames = new HashSet<>();

        fieldList.forEach(field ->
                userNames.add(field.getAnnotation(Spend.class).username()));

        userNames.forEach(SpendExtensionsHelper::findAndDeleteSpendsForUserName);
    }

    static List<Field> collectTestFields(Object requiredTestInstance) {
        return Arrays.stream(requiredTestInstance.getClass().getDeclaredFields())
                .filter(f -> f.getType().isAssignableFrom(SpendJson.class))
                .filter(f -> f.isAnnotationPresent(Spend.class))
                .toList();
    }
}
