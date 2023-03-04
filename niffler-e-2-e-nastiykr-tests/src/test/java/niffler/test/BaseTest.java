package niffler.test;

import com.codeborne.selenide.junit5.TextReportExtension;
import io.qameta.allure.junit5.AllureJunit5;
import niffler.jupiter.BeforeSuiteExtension;
import niffler.jupiter.SpendsCreateExtension;
import niffler.jupiter.SpendsDeleteBeforeAllExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({BeforeSuiteExtension.class,
        SpendsDeleteBeforeAllExtension.class,
        SpendsCreateExtension.class,
        TextReportExtension.class,
        AllureJunit5.class})
public abstract class BaseTest {


}
