package niffler.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:niffler_ui.properties")
public interface NifflerUiConfig extends Config {
    @Key("url.local")
    String nifflerUrl();

    @Key("path.register")
    String registerPath();

    @Key("path.login")
    String loginPath();

    @Key("path.main")
    String mainPath();
}
