package com.akqa.bp.navitas.automation.environment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by v.shcherbanyuk on 3/11/2015.
 */
public class LocalizationConfigurator {
    private static volatile LocalizationConfigurator localizationConfigurator;
    private static Properties properties = new Properties();
    protected static final Logger LOGGER = LogManager.getLogger(LocalizationConfigurator.class);

    private LocalizationConfigurator() throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream i18nStream = loader.getResourceAsStream(String.format("i18n/%s.properties", System.getProperty("i18n", "en")));
        try {
            properties.load(i18nStream);
            i18nStream.close();
        } catch (IOException e) {
            LOGGER.error("", e);
        }
    }

    public static LocalizationConfigurator getInstance() {
        LocalizationConfigurator sysProps = localizationConfigurator;
        if (sysProps == null) {
            synchronized (EnvironmentConfigurator.class) {
                sysProps = localizationConfigurator;
                if (sysProps == null) {
                    try {
                        localizationConfigurator = sysProps = new LocalizationConfigurator();
                    } catch (IOException e) {
                        LOGGER.error("", e);
                    }
                }
            }
        }
        return sysProps;
    }

    public String getActionTextOnBoardRole() {
        return properties.getProperty("action.onboard.role");
    }

    public String getActionTextOnBoardSupplier() {
        return properties.getProperty("action.onboard.supplier");
    }

    public String getActionTextEditSupplier() {
        return properties.getProperty("action.edit.supplier");
    }

    public String getActionTextDeactivateSupplier() {
        return properties.getProperty("action.deactivate.supplier");
    }

    public String getActionTextDelete() {
        return properties.getProperty("action.delete");
    }

    public String getActionTextLoginAsUser() {
        return properties.getProperty("action.login_as_user");
    }

    public String getActionTextLoginAsSupplier() {
        return properties.getProperty("action.login_as_supplier");
    }

    public String getActionEditServiceName() {
        return properties.getProperty("action.edit.service.name");
    }

    public String getActionTextOnBoardUser() {
        return properties.getProperty("action.onboard.user");
    }

    public String getErrorNotificationRequired() {
        return properties.getProperty("error.reason.required");
    }

    public String getErrorNotificationEmailShouldBeUnique() {
        return properties.getProperty("error.reason.email.unique");
    }

    public String getErrorNotificationEmailShouldBeValid() {
        return properties.getProperty("error.reason.email.valid");
    }

    public String getErrorNotificationUrlShouldBeValid() {
        return properties.getProperty("error.reason.url.valid");
    }

    public String getErrorNotificationExceededMaximumLength() {
        return properties.getProperty("error.reason.exceedsMaximumLength");
    }

    public String getModalDialogNewServiceTitile() {
        return properties.getProperty("modal.dialog.new.service.title");
    }

    public String getModalDialogEditNameServiceTitile() {
        return properties.getProperty("modal.dialog.edit.service.name.title");
    }

    public String getModalDialogLabelServiceNameField() {
        return properties.getProperty("modal.dialog.service.name.field");
    }

    public String getModalDialogLabelServiceTypeField() {
        return properties.getProperty("modal.dialog.new.service.type.field");
    }

    public String getModalDialogLabelServiceVersionField() {
        return properties.getProperty("modal.dialog.new.service.version.field");
    }

    public String getOperationalAlertTextServiceCreation() {
        return properties.getProperty("alert.action.create.service");
    }

    public String getOperationalAlertTextServiceNameChanged() {
        return properties.getProperty("alert.action.edit.service.name");
    }

    public String getOperationalAlertTextInviteUser() {
        return properties.getProperty("alert.action.new.user.invite");
    }


}
