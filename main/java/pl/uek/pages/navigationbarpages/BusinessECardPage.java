package pl.uek.pages.navigationbarpages;

import pl.uek.pages.mainpages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class BusinessECardPage extends Page {


    @FindBy(id = "ew_zdjecie")
    private WebElement BusinessECardPhoto;

    public boolean isBusinnesECardVisible(){
        waitForVisibilityWebElement(BusinessECardPhoto);
        return BusinessECardPhoto.isDisplayed();
    }

    public BusinessECardPage(WebDriver driver) {
        super(driver);
    }

}


