package com.qatestlab.utils;

import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class Properties {
    private static final String BASE_URL = "https://rozetka.com.ua";
    private static final String DEFAULT_BROWSER = FIREFOX;
    private static final int ELEMENT_LOAD_TIMEOUT = 10;
    private static final int SLEEP_TIMEOUT = 500;

    public static String getBaseUrl() {
        return System.getProperty(EnvironmentVariables.BASE_URL.toString(), BASE_URL);
    }

    public static String getBrowser() {
        return System.getProperty(EnvironmentVariables.BROWSER.toString(), DEFAULT_BROWSER);
    }

    public static int getElementLoadTimeout() {
        return ELEMENT_LOAD_TIMEOUT;
    }

    public static int getSleepTimeout() {
        return SLEEP_TIMEOUT;
    }
}

enum EnvironmentVariables {
    BASE_URL("env.base.url"),
    BROWSER("browser");

    private String value;
    EnvironmentVariables(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
