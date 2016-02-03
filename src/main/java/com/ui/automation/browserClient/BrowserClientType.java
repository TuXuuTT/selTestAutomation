package com.ui.automation.browserClient;

public enum BrowserClientType {
    IE("ie"),
    FF("ff"),
    GC("gc"),
    PJS("pjs");

    private String browserClientName;

    private BrowserClientType(final String browserClientName) {
        this.browserClientName = browserClientName;
    }

    @Override
    public String toString() {
        return browserClientName;
    }
}
