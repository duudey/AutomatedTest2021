package pl.uek.pages.myaccountpages;

import pl.uek.pages.mainpages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileModificationPage extends Page {

    @FindBy(xpath = "//*[@id=\"id_description_editoreditable\"]")
    private WebElement descriptionEditor;

    @FindBy(id = "id_email")
    private WebElement emailEditor;

    @FindBy(id = "id_submitbutton")
    private WebElement submitButton;

    @FindBy(id = "id_error_email")
    private WebElement emailError;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[2]/div/div/section/div/div/div/section[1]/div/ul/li[1]/span/a")
    private WebElement editProfile;

    @FindBy(xpath = "//*[text()='Modyfikuj profil']")
    private WebElement SettingsModificationElement;

    public ProfileModificationPage(WebDriver driver) {
        super(driver);
    }

    public ProfileModificationPage editDescription(){
        waitForClickableWebElement(descriptionEditor);
        descriptionEditor.click();
        descriptionEditor.sendKeys("1");
        submitButton.click();
        return(this);
    }

    public ProfileModificationPage removeEmail(){
        waitForClickableWebElement(emailEditor);
        emailEditor.click();
        emailEditor.clear();
        submitButton.click();
        return(this);
    }

    public boolean isEmailRequired(){
        waitForClickableWebElement(emailError);
        return emailError.isDisplayed();
    }

    public boolean isChangeSaved(){
        waitForClickableWebElement(editProfile);
        return editProfile.isDisplayed();
    }

    public boolean isChangeInSettingsSaved(){
        waitForClickableWebElement(SettingsModificationElement);
        return SettingsModificationElement.isDisplayed();
    }

}
