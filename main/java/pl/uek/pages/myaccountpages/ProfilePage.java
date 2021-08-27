package pl.uek.pages.myaccountpages;

import pl.uek.pages.mainpages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProfilePage extends Page {

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[2]/div/div/section/div/div/div/section[1]/div/ul/li[1]/span/a")
    private WebElement editProfile;


    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public ProfileModificationPage goToProfileModificationPage() {
        editProfile.click();
        return new ProfileModificationPage(driver);
    }

    public boolean isProfileVisible(){
        waitForClickableWebElement(editProfile);
        return editProfile.isDisplayed();
    }

}