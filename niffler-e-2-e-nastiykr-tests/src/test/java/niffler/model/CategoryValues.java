package niffler.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CategoryValues {
    RESTAURANTS("Рестораны"),
    PRODUCTS("Продукты"),
    STUDY("Обучение"),
    TRANSPORT("Транспорт"),
    OTHER("Прочее");

    private final String categoryName;

    CategoryValues(String categoryName) {
        this.categoryName = categoryName;
    }

    @JsonValue
    public String getCategoryName() {
        return categoryName;
    }
}
