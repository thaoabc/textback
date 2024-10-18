package base;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ValidateHelper {
    private WebDriver driver;
    WebDriverWait wait;
    private final int timeoutWaitForPageLoaded = 20;

    public ValidateHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2L));
    }

    public void setText(WebElement element, String valueText) {
        this.wait.until(ExpectedConditions.visibilityOf(element));
        this.wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(new CharSequence[]{valueText});
    }

    public void clickInput(WebElement element) {
        this.wait.until(ExpectedConditions.visibilityOf(element));
        this.wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public boolean verifyUrl(String url) {
        return this.driver.getCurrentUrl().contains(url);
    }

    public boolean verifyText(WebElement currentText, String expectedPageText) {
        String pageText = currentText.getText();
        return pageText.contains(expectedPageText);
    }

    public boolean verifyElementExist(List<WebElement> listElement) {
        int total = listElement.size();
        return listElement.size() > 0;
    }

    public void waitForJqueryLoad() {
        ExpectedCondition<Boolean> JQueryLoad = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    return (Long)((JavascriptExecutor)driver).executeScript("return JQuery.acive", new Object[0]) == 0L ? true : false;
                } catch (Exception var3) {
                    return true;
                }
            }
        };

        try {
            this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(20L));
            this.wait.until(JQueryLoad);
        } catch (Throwable var3) {
            Assert.fail("Quá thời gian load trang chờ JQuery");
        }

    }

    public void waitForJSLoaded() {
        ExpectedCondition<Boolean> JsLoad = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    return ((JavascriptExecutor)driver).executeScript("return document.readyState", new Object[0]).toString().equals("complete");
                } catch (Exception var3) {
                    return true;
                }
            }
        };

        try {
            this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(20L));
            this.wait.until(JsLoad);
        } catch (Throwable var3) {
            Assert.fail("Quá thời gian load trang chờ Javascript");
        }

    }
}
