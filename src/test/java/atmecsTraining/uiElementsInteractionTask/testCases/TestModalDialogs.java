package atmecsTraining.uiElementsInteractionTask.testCases;

import atmecsTraining.uiElementsInteractionTaskReUsables.ReusableActions;
import atmecsTraining.uiElementsInteractionTaskReUsables.ReusableVerifications;
import org.testng.annotations.Test;

import java.util.Properties;

public class TestModalDialogs extends BrowserActions {
    String modalsFileName = getPropertiesObject(configFileName).getProperty("modalsLocatorsFileName");
    Properties locatorsFile = getPropertiesObject(modalsFileName);
    String modalDialogsUrl = locatorsFile.getProperty("url");
    String expectedPageTitle = locatorsFile.getProperty("expectedPageTitle");
    String smallModal = locatorsFile.getProperty("smallModal");
    String smallModalText = locatorsFile.getProperty("smallModalText");
    String closeSmallModal = locatorsFile.getProperty("closeSmallModal");
    String largeModal = locatorsFile.getProperty("largeModal");
    String largeModalText = locatorsFile.getProperty("largeModalText");
    String closeLargeModal = locatorsFile.getProperty("closeLargeModal");

    /**
     * Get the text from modal dialogs and close them
     */

    @Test
    public void testModalDialogs() {
        ReusableActions reusableActions = new ReusableActions(driver);
        ReusableVerifications reusableVerifications = new ReusableVerifications(driver);
        reusableActions.openUrl(modalDialogsUrl);
        if (reusableVerifications.verifyPageTitle(expectedPageTitle)) {
            reusableActions.click(reusableActions.findElementById(smallModal));
            printText(reusableActions.getTextFromElement
                    (reusableActions.waitAndReturnElementUsingXPath(2, smallModalText)));
            reusableActions.click(reusableActions.findElementById(closeSmallModal));
            reusableActions.click(reusableActions.findElementById(largeModal));
            printText(reusableActions.getTextFromElement
                    (reusableActions.waitAndReturnElementUsingXPath(2, largeModalText)));
            reusableActions.click(reusableActions.findElementById(closeLargeModal));
        } else {
            System.out.println("This is not the expected webpage");
        }
    }

    public void printText(String text) {
        System.out.println(text);
    }
}
