package pages.contact;

import base.ValidateHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewContactGroupPopup {
    private WebDriver driver;
    private ValidateHelper helper;

    @FindBy(xpath="//h5[@class='modal-title']")
    private WebElement titleCreateContactGroup;
    String label= "New contact group";

    public NewContactGroupPopup(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        helper = new ValidateHelper(driver);
    }

    public void setDataContactGroup(){
        if(checkLabel(label)){

        }else{

        }
    }

    public boolean checkLabel(String label) {
        if (helper.verifyText(titleCreateContactGroup, label)) {
            return false;
        } else{
            return true;
        }

    }
}
