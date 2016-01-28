package com.akqa.bp.navitas.automation.environment;

import groovy.util.ConfigObject;
import groovy.util.ConfigSlurper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentConfigurator {

    private static volatile EnvironmentConfigurator environmentConfigurator;
    private static Properties properties = new Properties();
    protected static final Logger LOGGER = LogManager.getLogger(EnvironmentConfigurator.class);

    private EnvironmentConfigurator() throws IOException {

        //parse config.groovy and set one environment, which name is taken from system properties
        //It will be used to get it's inside url and parameters
        //in any case url and other params can be directly overridden if specified in system properties
        ConfigSlurper configSlurper = new ConfigSlurper();
        configSlurper.setEnvironment(getTestEnvironment());
        ConfigObject configObject = configSlurper.parse(new File("config.groovy").toURI().toURL());

        configObject.flatten();
        properties = configObject.toProperties();
    }

    public static EnvironmentConfigurator getInstance() {
        EnvironmentConfigurator sysProps = environmentConfigurator;
        if (sysProps == null) {
            synchronized (EnvironmentConfigurator.class) {
                sysProps = environmentConfigurator;
                if (sysProps == null) {
                    try {
                        environmentConfigurator = sysProps = new EnvironmentConfigurator();
                    } catch (IOException e) {
                        LOGGER.error("", e);
                    }
                }
            }
        }
        return sysProps;
    }

    public static String getTestEnvironment() {
        return System.getProperty("env", "qagl");
    }

    public static int getNumOfServices() {
        return Integer.parseInt(System.getProperty("numService"));
    }

    public Boolean isGridUsed() {
        return Boolean.parseBoolean(properties.getProperty("grid.isUsed"));
    }

    public String getSeleniumHub() {
        return properties.getProperty("grid.seleniumHub");
    }

    public String getGmailHost() {
        return properties.getProperty("gmail.host");
    }

    public String getGmailStoreType() {
        return properties.getProperty("gmail.mailStoreType");
    }

    public String getGmailLogin() {
        return properties.getProperty("gmail.login");
    }

    public String getGmailPassword() {
        return properties.getProperty("gmail.password");
    }

    public String getTestLinkUrl() {
        return properties.getProperty("testlink.url");
    }

    public String getTestLinkProjectName() {
        return properties.getProperty("testlink.project");
    }

    public String getTestLinkPlan() {
        return properties.getProperty("testlink.testPlan");
    }

    public String getTestLinkSuite() {
        return properties.getProperty("testlink.testSuite");
    }

    public String getTestLinkBuild() {
        return properties.getProperty("testlink.testBuild");
    }

    public String getTestClient() {
        return System.getProperty("browserClient", "gc");
    }

    public Boolean getTestLinkReporter() {
        return Boolean.parseBoolean(System.getProperty("testLinkReport"));
    }

    public String getAppUrl() {
        return System.getProperty("url", properties.get("url").toString());
    }

    public String getTenant() {
        return "@" + System.getProperty("tenant", properties.get("tenant").toString());
    }

    public String getAdminLogin() {
        return properties.getProperty("users.admin.login") + getTenant();
    }

    public String getSupplierAdminLogin() {
        return properties.getProperty("users.supplierAdmin.login") + getTenant();
    }

    public String getAssetManagerLogin() {
        return properties.getProperty("users.assetManager.login") + getTenant();
    }

    public String getPassword() {
        return properties.getProperty("users.password");
    }

    public int getApiPort() {
        return Integer.parseInt(properties.getProperty("api.port"));
    }

    public int getNumOfVirtualMarketPlaces() {
        return Integer.parseInt(System.getProperty("numVMP"));
    }

}
