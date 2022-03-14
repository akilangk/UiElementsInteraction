package atmecsTraining.uiElementsInteractionTask.testCases;

import atmecsTraining.uiElementsInteractionTaskReUsables.ReusableActions;
import atmecsTraining.uiElementsInteractionTaskReUsables.ReusableVerifications;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Properties;

public class TestCheckBoxes extends BrowserActions {
    String checkBoxesFileName = getPropertiesObject(configFileName).getProperty("checkBoxesLocatorsFileName");
    Properties locatorsFile = getPropertiesObject(checkBoxesFileName);
    String checkBoxesUrl = locatorsFile.getProperty("url");
    String expectedPageTitle = locatorsFile.getProperty("expectedPageTitle");
    String languageName = locatorsFile.getProperty("languageName");
    String seleniumCheckBox = locatorsFile.getProperty("seleniumCheckBox");
    String deselectSection = locatorsFile.getProperty("deselectSection");
    String selectAllSection = locatorsFile.getProperty("selectAllSection");
    String genericLocator = locatorsFile.getProperty("genericLanguageLocator");

    /**
     * Verify if the checkboxes are present and perform the given operations
     */

    @Test
    public void testCheckBoxes() {
        ReusableActions reusableActions = new ReusableActions(driver);
        ReusableVerifications reusableVerifications = new ReusableVerifications(driver);
        reusableActions.openUrl(checkBoxesUrl);
        if (reusableVerifications.verifyPageTitle(expectedPageTitle)) {
            reusableActions.clickUsingJavaScriptExecutor(reusableActions.
                    findElementByXPath(languageCheckBoxLocator(languageName)));
            printSeleniumIsCheckedOrNot(reusableActions.findElementByXPath(seleniumCheckBox));
            deSelectOnlySelectedCheckBoxes(reusableActions.findElementsByXPath(deselectSection));
            reusableActions.clickAllElements(reusableActions.findElementsByXPath(selectAllSection));
        } else {
            System.out.println("This is not the expected webpage");
        }
    }

    /**
     * Method Description: Used to create unique xpath locator for given language name
     *
     * @param languageName Name of the language
     * @return Unique xpath locator for language
     */

    public String languageCheckBoxLocator(String languageName) {
        return String.format(genericLocator, languageName);
    }

    /**
     * Method Description: Used to deselect the checkbox which is already selected
     *
     * @param elementList List of WebElements
     */

    public void deSelectOnlySelectedCheckBoxes(List<WebElement> elementList) {
        ReusableActions reusableActions = new ReusableActions(driver);
        for (WebElement element : elementList) {
            if (reusableActions.isChecked(element))
                reusableActions.clickUsingJavaScriptExecutor(element);
        }
    }

    /**
     * Method Description: Used to verify and print, the checkbox named Selenium is checked or not
     *
     * @param element WebElement of the Selenium checkbox
     */

    public void printSeleniumIsCheckedOrNot(WebElement element) {
        ReusableActions reusableActions = new ReusableActions(driver);
        if (reusableActions.isChecked(element))
            System.out.println("Selenium is already checked.");
        else
            System.out.println("Selenium is not checked.");
    }
}
