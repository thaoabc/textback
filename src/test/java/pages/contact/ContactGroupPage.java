package pages.contact;

import base.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactGroupPage {
    private WebDriver driver;
    private ValidateHelper helper;

    @FindBy(xpath="//div[normalize-space()='New group']")
    private WebElement btnCreateGroup;

    @FindBy(xpath="//a[@class='btn btn-success' and normalize-space()='Thêm sản phẩm mới']")
    private WebElement addProductBtn;

    private String url="//contact/groups";

    public ContactGroupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        helper= new ValidateHelper(driver);
    }

    public NewContactGroupPopup openCreateGroupPopup(){
        helper.clickInput(btnCreateGroup);
        return new NewContactGroupPopup(driver);
    }
}
