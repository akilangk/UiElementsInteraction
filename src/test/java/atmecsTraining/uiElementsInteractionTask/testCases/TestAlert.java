package atmecsTraining.uiElementsInteractionTask.testCases;

import atmecsTraining.uiElementsInteractionTaskReUsables.ReusableActions;
import atmecsTraining.uiElementsInteractionTaskReUsables.ReusableVerifications;
import org.testng.annotations.Test;

import java.util.Properties;

public class TestAlert extends BrowserActions {

    String alertsFileName = getPropertiesObject(configFileName).getProperty("alertsLocatorsFileName");
    Properties locatorsFile = getPropertiesObject(alertsFileName);
    String expectedPageTitle = locatorsFile.getProperty("expectedPageTitle");
    String alertsUrl = locatorsFile.getProperty("url");
    String alertButton = locatorsFile.getProperty("alertButton");
    String timerAlertButton = locatorsFile.getProperty("timerAlertButton");
    String confirmButton = locatorsFile.getProperty("confirmButton");
    String confirmButtonText = locatorsFile.getProperty("confirmButtonText");
    String alertText = locatorsFile.getProperty("alertText");
    String promptButton = locatorsFile.getProperty("promptButton");
    String promptText = locatorsFile.getProperty("promptResult");

    /**
     * Verify the given alerts and perform different alert operations
     */

    @Test
    public void testAlerts() {
        ReusableActions reusableActions = new ReusableActions(driver);
        ReusableVerifications reusableVerifications = new ReusableVerifications(driver);
        reusableActions.openUrl(alertsUrl);
        if (reusableVerifications.verifyPageTitle(expectedPageTitle)) {
            reusableActions.click(reusableActions.findElementById(alertButton));
            printAlertText(reusableActions.getAlertTextAndAccept());
            reusableActions.click(reusableActions.findElementById(timerAlertButton));
            printAlertText(reusableActions.waitForAlertAndGetTextAndAccept(5));
            reusableActions.click(reusableActions.findElementById(confirmButton));
            reusableActions.dismissAlert();
            printAlertResult(reusableActions.getTextFromElement
                    (reusableActions.findElementByCssSelector(confirmButtonText)));
            reusableActions.click(reusableActions.findElementById(promptButton));
            reusableActions.sendTextInAlertAndAccept(alertText);
            printAlertResult(reusableActions.getTextFromElement
                    (reusableActions.findElementById(promptText)));
        } else {
            System.out.println("This is not the expected webpage");
        }
    }

    public void printAlertText(String text) {
        System.out.println("Alert Text: " + text);
    }

    public void printAlertResult(String text) {
        System.out.println("Alert Result: " + text);
    }

}
