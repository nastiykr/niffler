package niffler.jupiter;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Field;
import java.util.List;

public class SpendsDeleteBeforeAllExtension implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        var requiredTestInstance = context.getTestInstance();
        List<Field> fieldList = SpendExtensionsHelper.collectTestFields(requiredTestInstance);
        SpendExtensionsHelper.deleteSpends(fieldList);
    }
}