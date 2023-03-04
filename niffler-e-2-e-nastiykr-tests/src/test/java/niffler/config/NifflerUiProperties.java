package niffler.config;

import org.aeonbits.owner.ConfigFactory;
public class NifflerUiProperties {

    private static final NifflerUiConfig CONFIG = ConfigFactory.create(NifflerUiConfig.class);

    public static final String NIFFLER_UI_URL = CONFIG.nifflerUrl();
    public static final String LOGIN_UI_URL = CONFIG.nifflerUrl() + CONFIG.loginPath();
    public static final String MAIN_UI_URL = CONFIG.nifflerUrl() + CONFIG.mainPath();
}
