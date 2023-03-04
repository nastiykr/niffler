package niffler.pages;

public interface BasePage<Page> {
    Page openPage();

    Page shouldBeLoaded();
}
