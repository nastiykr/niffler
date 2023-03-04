package niffler.jupiter;

import niffler.model.CategoryValues;
import niffler.model.CurrencyValues;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ExtendWith(SpendsCreateExtension.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Spend {
    CategoryValues category() default CategoryValues.STUDY;

    CurrencyValues currency() default CurrencyValues.RUB;

    double amount();

    String description();

    String username();

}