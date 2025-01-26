package driver;

import fileUtils.ConfigReader;
import org.openqa.selenium.WebDriver;

public class Driver {

    private Driver () {

    }
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.getProperty("browserType").toLowerCase()){
                case "chrome":
                    driver = ChromeWebDriver.loadChromeDriver();
                    break;
//                case "firefox":
//                    driver = FireFoxWebDriver.loadFireFoxDriver();
//                    break;
//                case "edge":
//                    driver = EdgeWebDriver.loadEdgeDriver();
//                    break;
//                case "safari":
//                    driver = SafariWebDriver.loadSafariDriver();
//                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser type: " + ConfigReader.getProperty("browserType"));
            }
        }
        return driver;
    }
}

