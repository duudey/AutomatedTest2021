package pl.uek.pages.myaccountpages;

import pl.uek.pages.mainpages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends Page {


    @FindBy(xpath = "//*[text()='Modyfikuj profil']")
    private WebElement goToModificationPage;

    @FindBy(xpath = "//*[text()='Preferowany język']")
    private WebElement languagePreferences;

    @FindBy(xpath = "//*[text()='Preferencje forum']")
    private WebElement forumPreferences;

    @FindBy(xpath = "//*[text()='Modyfikuj profil']")
    private WebElement SettingsModificationElement;

    @FindBy(id = "id_submitbutton")
    private WebElement submitSettingsButton;


    public SettingsPage(WebDriver driver) {
        super(driver);
    }


    public ProfileModificationPage goToProfileModificationPage() {
        goToModificationPage.click();
        return new ProfileModificationPage(driver);
    }

    public SettingsPage changeLanguageOfSite() {
        languagePreferences.click();
        waitForClickableWebElement(submitSettingsButton);
        submitSettingsButton.click();
        return new SettingsPage(driver);
    }

    public SettingsPage changeForumPreferences() {
        forumPreferences.click();
        waitForClickableWebElement(submitSettingsButton);
        submitSettingsButton.click();
        return new SettingsPage(driver);
    }

    public boolean isChangeInSettingsSaved(){
        waitForClickableWebElement(SettingsModificationElement);
        return SettingsModificationElement.isDisplayed();
    }

}
