package pl.uek.pages.navigationbarpages;

import pl.uek.pages.mainpages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CockpitPage extends Page {

    public CockpitPage(WebDriver driver) {
        super(driver);
    }

    private CockpitPage cockpitPage;

    @FindBy(className = "multiline")
    private WebElement courseCard;

    @FindBy(id = "label_3_17")
    private WebElement courseInNavigationBar;


    public CoursePage goToCoursePageFromMainPanel() {
        waitForClickableWebElement(courseCard);
        courseCard.click();
        return new CoursePage(driver);
    }

    public CoursePage goToCoursePageFromNavigationPanel() {
        waitForClickableWebElement(courseInNavigationBar);
        courseInNavigationBar.click();
        return new CoursePage(driver);
    }

}
