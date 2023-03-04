package niffler.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:niffler_api.properties")
public interface NifflerApiConfig extends Config {

    @Config.Key("api.spend")
    String spendUrl();
}