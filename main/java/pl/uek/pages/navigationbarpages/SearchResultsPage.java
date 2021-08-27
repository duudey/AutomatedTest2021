package pl.uek.pages.navigationbarpages;

import pl.uek.pages.mainpages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchResultsPage extends Page {


    @FindBy(xpath = "//*[@id=\"region-main\"]/div/h2")
    private WebElement noResultsFoundInformation;

    @FindBy(xpath = "//*[text()='Kliknij, aby wejść do kursu']")
    private WebElement goToCourseButton;
//problem
    @FindBy(id = "page-enrol-index")
    private WebElement loginRequiredMessage;

    @FindBy(id = "id_submitbutton")
    private WebElement courseSubmitButton;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[2]/div/div/section/div/div[1]/div[2]/div[2]/div[3]/a[1]")
    private WebElement courseLecturerButton;

    @FindBy(xpath = "//*[text()='Szczegóły użytkownika']")
    private WebElement lecturerForumElement;

    @FindBy(id = "modal-body")
    private WebElement loginRequiredforLecturerViewMessage;

    @FindBy(xpath = "//*[text()='Kliknij, aby wejść do kursu']")
    private WebElement goToBussinesECardPage;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage goToRandomCourse(){
        waitForClickableWebElement(goToCourseButton);
        goToCourseButton.click();
        return(this);
    }

    public SearchResultsPage goToCourseLecturer(){
        courseLecturerButton.click();
        return(this);
    }

    public BusinessECardPage goToBusinessECardPage() {
        goToBussinesECardPage.click();
        return new BusinessECardPage(driver);
    }


    public boolean isLecturerPageOpened(){
        waitForClickableWebElement(lecturerForumElement);
        return lecturerForumElement.isDisplayed();
    }

    public boolean isLecturerPageNotOpened(){
        waitForVisibilityWebElement(loginRequiredforLecturerViewMessage);
        return loginRequiredforLecturerViewMessage.isDisplayed();
    }

    public boolean isSigningCourseForUnloggedUserImpossible(){
        waitForVisibilityWebElement(loginRequiredMessage);
        return loginRequiredMessage.isDisplayed();
    }

    public boolean isSigningToCoursePossible(){
        waitForClickableWebElement(courseSubmitButton);
        return courseSubmitButton.isDisplayed();
    }

    public boolean isResultsShown(){
        waitForVisibilityWebElement(goToCourseButton);
        return goToCourseButton.isDisplayed();
    }

    public boolean isNoResultFound(){
        return  noResultsFoundInformation.isDisplayed();
    }

}
