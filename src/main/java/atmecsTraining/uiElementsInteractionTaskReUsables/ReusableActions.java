package atmecsTraining.uiElementsInteractionTaskReUsables;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ReusableActions {

    public WebDriver driver;

    public ReusableActions(WebDriver driver){
        this.driver = driver;
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    /**
     * Method Description: Used to get the title of the current web page
     * @return Page title in String
     */

    public String getPageTitle() {
        return driver.getTitle();
    }

    public WebElement waitAndReturnElementUsingXPath(long seconds, String xPath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
    }

    public List<String> getAttributesFromTheWebElements(List<WebElement> elements, String attribute) {
        List<String> attributes = new ArrayList<>();
        if (!elements.isEmpty()) {
            for (WebElement element : elements) {
                attributes.add(element.getAttribute(attribute));
            }
        } else {
            System.out.println("No elements in the list to get the attributes.");
        }
        return attributes;
    }

    public List<String> getTextsFromWebElements(List<WebElement> elements) {
        List<String> texts = new ArrayList<>();
        if (!elements.isEmpty()) {
            for (WebElement element : elements) {
                texts.add(element.getText());
            }
        } else {
            System.out.println("No elements in the list to get the text.");
        }
        return texts;
    }

    public boolean isElementPresent(WebElement element) {
        return element.isDisplayed();
    }

    public void sendText(WebElement element, String text) {
        if (isElementPresent(element)) {
            element.sendKeys(text);
        } else {
            System.out.println("Element is not present in the webpage to send text.");
        }
    }

    public void click(WebElement element) {
        if (isElementPresent(element)) {
            element.click();
        } else {
            System.out.println("Element is not present in the webpage to perform click action.");
        }
    }

    public void clickAllElements(List<WebElement> elementList) {
        if (!elementList.isEmpty()) {
            for (WebElement element : elementList) {
                clickUsingJavaScriptExecutor(element);
            }
        } else {
            System.out.println("No elements in the list to get the text.");
        }
    }

    public String getTextFromElement(WebElement element) {
        String text = null;
        if (isElementPresent(element)) {
            text = element.getText();
        } else {
            System.out.println("Element is not present in the webpage to get the text.");
        }
        return text;
    }

    public void clickUsingJavaScriptExecutor(WebElement element) {
        if (isElementPresent(element)) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        } else {
            System.out.println("Element is not present in the webpage to perform click action.");
        }
    }

    public WebElement findElementById(String iD) {
        return driver.findElement(By.id(iD));
    }

    public WebElement findElementByXPath(String xPath) {
        return driver.findElement(By.xpath(xPath));
    }

    public WebElement findElementByCssSelector(String cssSelector) {
        return driver.findElement(By.cssSelector(cssSelector));
    }

    public List<WebElement> findElementsByXPath(String xPath) {
        return driver.findElements(By.xpath(xPath));
    }

    public List<WebElement> findElementsByTagName(String tagName) {
        return driver.findElements(By.tagName(tagName));
    }

    public boolean isChecked(WebElement element) {
        boolean result = false;
        if (isElementPresent(element)) {
            result = element.isSelected();
        } else {
            System.out.println("Element not present in the web page to check whether its selected or not.");
        }
        return result;
    }

    public boolean isEnabled(WebElement element) {
        boolean result = false;
        if (isElementPresent(element)) {
            result = element.isEnabled();
        } else {
            System.out.println("Element not present in the web page to check whether its enabled or not.");
        }
        return result;
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public String waitForAlertAndGetTextAndAccept(long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public String waitForAlertAndGetTextAndDismiss(long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        alert.dismiss();
        return alertText;
    }

    public void sendTextInAlertAndAccept(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }

    public String getAlertTextAndAccept() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public String getAlertTextAndDismiss() {
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.dismiss();
        return text;
    }
}
