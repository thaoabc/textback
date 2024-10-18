package base;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseSetup {
    private WebDriver driver;
    static String driverPath = "resources\\drivers\\";

    public BaseSetup() {
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public WebDriver setupDriver(String browserType) {
        switch (browserType.trim().toLowerCase()) {
            case "chrome":
                driver = initChromeDriver();
                break;
//            case "firefox":
//                driver = initFirefoxDriver();
//                break;
//			case "opera":
//				driver = initOperaDriver();
//				break;
//            case "edge":
//                driver = initEdgeDriver();
//                break;
            default:
                System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }

    private WebDriver initChromeDriver() {
        System.out.println("Launching Chrome browser...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

//    private static WebDriver initFirefoxDriver(String appURL) {
//        System.out.println("Launching Firefox browser...");
//        System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//        driver.navigate().to(appURL);
//        driver.manage().timeouts().pageLoadTimeout(30L, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
//        return driver;
//    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000L);
        this.driver.quit();
    }
}