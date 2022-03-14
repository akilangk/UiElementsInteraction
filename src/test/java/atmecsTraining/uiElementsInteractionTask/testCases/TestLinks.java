package atmecsTraining.uiElementsInteractionTask.testCases;

import atmecsTraining.uiElementsInteractionTaskReUsables.ReusableActions;
import atmecsTraining.uiElementsInteractionTaskReUsables.ReusableVerifications;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Properties;

public class TestLinks extends BrowserActions {
    String linksFileName = getPropertiesObject(configFileName).getProperty("linksLocatorsFileName");
    Properties locatorsFile = getPropertiesObject(linksFileName);
    String linksUrl = locatorsFile.getProperty("url");
    String expectedPageTitle = locatorsFile.getProperty("expectedPageTitle");
    String tagName = locatorsFile.getProperty("tagName");

    /**
     * Get the links count and links text in the webpage
     */

    @Test
    public void testLinks() {
        ReusableActions reusableActions = new ReusableActions(driver);
        ReusableVerifications reusableVerifications = new ReusableVerifications(driver);
        reusableActions.openUrl(linksUrl);
        if (reusableVerifications.verifyPageTitle(expectedPageTitle)) {
            printLinkText(reusableActions.findElementsByTagName(tagName));
            printLinkCount(reusableActions.findElementsByTagName(tagName).size());
        } else {
            System.out.println("This is not the expected webpage");
        }
    }

    public void printLinkText(List<WebElement> elementList) {
        ReusableActions reusableActions = new ReusableActions(driver);
        System.out.println("Link Texts:");
        for (String linkText : reusableActions.getTextsFromWebElements(elementList)) {
            System.out.println(linkText);
        }
    }

    public void printLinkCount(int count) {
        System.out.println("Links Count: " + count);
    }
}
