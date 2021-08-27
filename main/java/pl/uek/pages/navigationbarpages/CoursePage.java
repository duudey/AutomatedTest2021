package pl.uek.pages.navigationbarpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoursePage extends CockpitPage {

    public CoursePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath= "//*[text()='Forum aktualności']")
    private WebElement courseForum;

    @FindBy(className= "sectionname")
    private WebElement courseName;

    @FindBy(id = "label_4_18")
    private WebElement participants;

    @FindBy(id = "label_4_21")
    private  WebElement grades;

    @FindBy(xpath = "//*[text()='Nazwisko']")
    private WebElement surnameParticipants;

    @FindBy(xpath = "//*[text()='Oceniany element']")
    private WebElement gradesGridTitle;

    @FindBy(xpath = "//*[text()='Wiadomości i ogłoszenia']")
    private WebElement firstTextOnForum;

    public CoursePage openForum(){
        waitForClickableWebElement(courseForum);
        courseForum.click();;
        return(this);
    }

    public CoursePage openGrades(){
        waitForClickableWebElement(grades);
        grades.click();;
        return(this);
    }

    public CoursePage openParticipants(){
        waitForClickableWebElement(participants);
        participants.click();;
        return(this);
    }

    public boolean isForumOpened() {
        waitForVisibilityWebElement(firstTextOnForum);
        return firstTextOnForum.isDisplayed();
    }

    public boolean isGradesOpened() {
        waitForVisibilityWebElement(gradesGridTitle);
        return gradesGridTitle.isDisplayed();
    }

    public boolean isParticipantsOpened() {
        waitForVisibilityWebElement(surnameParticipants);
        return surnameParticipants.isDisplayed();
    }

    public boolean isCourseOpened() {
        waitForVisibilityWebElement(courseName);
        return courseName.isDisplayed();
    }

}