package atmecsTraining.uiElementsInteractionTaskReUsables;

import org.openqa.selenium.WebDriver;

public class ReusableVerifications {
    public WebDriver driver;

    /**
     * Constructor Description: Used to initialize WebDriver variable
     * @param driver WebDriver
     */

    public ReusableVerifications(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Method Description: Used to verify the actual page title with the expected page title
     * @param expectedTitle Expected page title
     * @return true - if the actual and expected page title were same
     * (or) false - if the actual page title differs from the expected page title
     */

    public boolean verifyPageTitle(String expectedTitle) {
        ReusableActions reusableActions = new ReusableActions(driver);
        String actualTitle = reusableActions.getPageTitle();
        return actualTitle.equals(expectedTitle);
    }
}
