package testcases.contact;

import base.BaseSetup;
import base.ExcelHelpers;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import pages.contact.ContactGroupPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;


public class ContactGroupTest {
    WebDriver driver;
    ContactGroupPage contactGroupPage;

    @BeforeClass
    public void setUp() {

        // Đã khởi tạo browser hết rồi kể cả wait, phóng to màn hình,...
        driver = new BaseSetup().setupDriver("chrome");

        driver.get("https://stg.textback.ai");
        ((JavascriptExecutor) driver).executeScript("window.localStorage.setItem('auth-storage', '{\"jwt\":\"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0aGFvLm5ndXllbjJAdGV4dGJhY2suYWkiLCJpc3MiOiJ0ZXh0YmFjay5haSIsImlhdCI6MTcyOTI0NjY1NiwiZXhwIjoxNzI5ODUxNDU2fQ.umqtxGCixhh7vYnQ95xLFsksP5g2QqGDu6j66O8CPl4\"}');");

        driver.get("https://stg.textback.ai/contact/groups");

        //excel= new ExcelHelpers();
    }

    @Test(priority = 0)
    public void createContactGroup() throws Exception {
       contactGroupPage = new ContactGroupPage(driver);
       contactGroupPage.openCreateGroupPopup();
    }
}
