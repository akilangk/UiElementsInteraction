package atmecsTraining.uiElementsInteractionTask.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BrowserActions {
    public static WebDriver driver;
    String userWorkingDirectory = System.getProperty("user.dir");
    String pathSeparator = System.getProperty("file.separator");
    String configFileName = "testData.properties";

    public String filePath(String fileName) {
        return userWorkingDirectory + pathSeparator + "src" + pathSeparator + "test" +
                pathSeparator + "java" + pathSeparator + "atmecsTraining" + pathSeparator +
                "uiElementsInteractionTask" + pathSeparator + "pages" + pathSeparator + fileName;
    }

    public Properties getPropertiesObject(String fileName) {
        Properties property = new Properties();
        try {
            FileInputStream file = new FileInputStream(filePath(fileName));
            property.load(file);
        } catch (FileNotFoundException exception) {
            System.out.println("The specified file is not present in the given path.");
        } catch (IOException exception) {
            System.out.println("Check the file in the specified path.");
        }
        return property;
    }

    @BeforeSuite
    public void launchBrowser() {
        String browserName = getPropertiesObject(configFileName).getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    @AfterSuite
    public void closeBrowser() {
        driver.quit();
    }

    @AfterTest
    public void printNewLine() {
        System.out.println();
    }
}
