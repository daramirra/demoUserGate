package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/remote.properties",
        "classpath:config/local.properties"})

public interface ProjectConfig extends Config {
    @Config.DefaultValue("chrome")
    @Config.Key("browser")
    String browser();

    @Config.DefaultValue("113.0")
    @Config.Key("browserVersion")
    String browserVersion();

    @Config.DefaultValue("1920x1080")
    @Config.Key("browserSize")
    String browserSize();

    @Config.DefaultValue("")
    @Config.Key("remoteDriverUrl")
    String remoteDriverUrl();

    @Config.Key("videoStorage")
    String videoStorage();

    @Config.Key("accountPassword")
    String accountPassword();

    @Config.DefaultValue("https://demo.usergate.com:8001/")
    @Config.Key("baseUrl")
    String baseUrl();
}
