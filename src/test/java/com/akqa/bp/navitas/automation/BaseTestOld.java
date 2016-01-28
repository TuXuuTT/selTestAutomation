package com.akqa.bp.navitas.automation;

import com.akqa.bp.navitas.automation.browserClient.BrowserClient;
import com.akqa.bp.navitas.automation.environment.EnvironmentConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;

public class BaseTestOld {

//    private static TestLinkReporter testLinkReporter;
//
//    protected BrowserClient client;
//
//    private User adminUser;
//    private User assetManagerUser;
//    private User supplierAdminUser;
//
//    @BeforeSuite(groups = {"init"}, alwaysRun = true)
//    public void beforeSuiteInit() {
//        if (EnvironmentConfigurator.getInstance().getTestLinkReporter()) {
//            testLinkReporter = new TestLinkReporter();
//        }
//    }
//
//    @BeforeClass(groups = {"init"}, alwaysRun = true)
//    public void beforeClassInit() throws MalformedURLException {
//        client = new BrowserClient();
//        client.getDriver(EnvironmentConfigurator.getInstance().getTestClient());
//        adminUser = new User(EnvironmentConfigurator.getInstance().getAdminLogin(), EnvironmentConfigurator.getInstance().getPassword()).setFullName("Hannah").setRole(UserRole.ADMINISTRATOR.getValue()).setLoginName(EnvironmentConfigurator.getInstance().getAdminLogin());
//        supplierAdminUser = new User(EnvironmentConfigurator.getInstance().getSupplierAdminLogin(), EnvironmentConfigurator.getInstance().getPassword()).setFullName("Julie").setRole(UserRole.SERVICE_SUPPLIER.getValue()).setLoginName(EnvironmentConfigurator.getInstance().getSupplierAdminLogin());
//        assetManagerUser = new User(EnvironmentConfigurator.getInstance().getAssetManagerLogin(), EnvironmentConfigurator.getInstance().getPassword()).setFullName("Gary").setRole(UserRole.ASSET_MANAGER.getValue()).setLoginName(EnvironmentConfigurator.getInstance().getAssetManagerLogin());
//    }
//
//    @BeforeMethod(groups = {"init"}, alwaysRun = true)
//    public void beforeMethodInit() {
//    }
//
//    @AfterMethod(groups = {"init"}, alwaysRun = true)
//    public void afterMethodStop(ITestResult testResult) throws IOException {
//        if (EnvironmentConfigurator.getInstance().getTestLinkReporter()) {
//            testLinkReporter.setTestCaseStatus(testResult, testResult.getMethod().getDescription().split(","));
//        }
//    }
//
//    @AfterClass(groups = {"init"}, alwaysRun = true)
//    public void afterClassStop() {
//        if (getWebDriver() != null) {
//            getWebDriver().quit();
//        }
//    }
//
//    @AfterSuite(groups = {"init"}, alwaysRun = true)
//    public void afterSuiteStop() {
//    }
//
//    @Override
//    public void run(IHookCallBack callBack, ITestResult testResult) {
//        super.run(callBack, testResult);
//        if (testResult.getThrowable() != null) {
//            try {
//                takeScreenShot(testResult.getMethod().getMethodName());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Attachment(value = "Failure in method {0}", type = "image/png")
//    private byte[] takeScreenShot(String failureReason) throws IOException {
//        logger.info(String.format("Taking screenshot due to fail in method %s", failureReason));
//        return getWebDriver().getScreenshotAs(OutputType.BYTES);
//    }
//
//    public RemoteWebDriver getWebDriver() {
//        if (client != null) {
//            return client.getWebDriver();
//        }
//        return null;
//    }
//
//    public User getAdminUser() {
//        return adminUser;
//    }
//
//    public User getAssetManagerUser() {
//        return assetManagerUser;
//    }
//
//    public User getSupplierAdminUser() {
//        return supplierAdminUser;
//    }
//
//    protected String getRandomString(int length) {
//        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        Random rnd = new Random();
//
//        StringBuilder sb = new StringBuilder(length);
//        for (int i = 0; i < length; i++)
//            sb.append(AB.charAt(rnd.nextInt(AB.length())));
//        return sb.toString();
//    }
}
