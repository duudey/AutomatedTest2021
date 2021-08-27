package pl.uek.pages.mainpages;

import pl.uek.pages.navigationbarpages.CockpitPage;
import pl.uek.pages.authorizationpages.LoginPage;
import pl.uek.pages.myaccountpages.*;
import pl.uek.pages.navigationbarpages.SearchResultsPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pl.uek.Credentials;

public class HomePage extends Page {

    private String url;

    @FindBy(xpath = "//*[@id=\"page-header\"]/div/div/div[2]/div/form/div[2]/a")
    private WebElement loginButton;

    @FindBy(className = "potentialidp")
    private WebElement loginCAS;

    @FindBy(id = "actionmenuaction-6")
    private WebElement logoutButton;

    @FindBy(className = "userbutton")
    private WebElement userButton;

    @FindBy(className = "welcome_userpicture")
    private WebElement myPicture;

    @FindBy(className = "alert alert-danger")
    private WebElement wrongLoginAlert;

    @FindBy(className = "logo")
    private WebElement logo;

    @FindBy(id = "logo")
    private WebElement incorrectPasswordAlert;

    @FindBy(id = "actionmenuaction-2")
    private WebElement profileButton;

    @FindBy(xpath = "//*[@id=\"search\"]")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"search\"]/button")
    private WebElement searchButton;

    @FindBy(xpath = "//*[text()='Zamknij komunikat']")
    private WebElement closeCookiesButton;

    @FindBy(xpath = "//*[@id=\"actionmenuaction-2\"]")
    private WebElement ProfileButton;

    @FindBy(xpath = "//*[@id=\"wrapper\"]/header[2]/nav/div/div/ul[1]/ul/li[1]/a")
    private WebElement CockpitButton;

    @FindBy(id = "moodle-dialogue-undefined-header-text")
    private WebElement CockpitError;

    @FindBy(xpath = "//*[@id=\"actionmenuaction-4\"]")
    private WebElement MessagesButton;

    @FindBy(xpath = "//*[@id=\"actionmenuaction-5\"]")
    private WebElement SettingsButton;

    @FindBy(xpath = "//a[contains(@data-udr,'zamowienia')]")
    private WebElement ordersMenuButton;


    public HomePage(WebDriver driver, String url) {
        super(driver);
        this.url = url;
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        driver.get(url);
        return this;
    }

    private void openUserButton() {
        userButton.click();
    }

    private LoginPage goToLogin() {
        loginButton.click();
        loginCAS.click();
        return new LoginPage(driver);
    }

   public HomePage logout() {
        openUserButton();
        waitForClickableWebElement(logoutButton);
        logoutButton.click();
        return this;
    }

    public boolean isLoginCorrect() {
        waitForClickableWebElement(myPicture);
        return myPicture.isDisplayed();
    }
    public boolean isLoginIncorrect() {
        return incorrectPasswordAlert.isDisplayed();
    }

    public boolean isLogoutCorrect() {
        return logo.isDisplayed();
    }


    public SearchResultsPage searchForCourse(String phraseToSearch){
        Actions action = new Actions(driver);
        waitForVisibilityWebElement(searchInput);
        action.moveToElement(searchInput).click().sendKeys(phraseToSearch).perform();
        waitForVisibilityWebElement(searchButton);
        searchButton.click();
        return new SearchResultsPage(driver);
    }
    public ProfilePage goToProfilePage() {
        openUserButton();
        waitForClickableWebElement(ProfileButton);
        ProfileButton.click();
        return new ProfilePage(driver);
    }

    public CockpitPage goToCockpitPage() {
        Actions action = new Actions(driver);
        openUserButton();
        CockpitButton.click();
        //waitForVisibilityWebElement(CockpitError);
        //action.sendKeys(Keys.ESCAPE).perform();
        return new CockpitPage(driver);
    }

    public MessagesPage goToMessagePage() {
        openUserButton();
        waitForClickableWebElement(MessagesButton);
        MessagesButton.click();
        return new MessagesPage(driver);
    }

    public SettingsPage goToSettingsPage() {
        openUserButton();
        waitForClickableWebElement(SettingsButton);
        SettingsButton.click();
        return new SettingsPage(driver);
    }

    public HomePage login(Credentials credentials) {
        LoginPage loginPage = goToLogin();
        loginPage.login(credentials);
        return this;
    }

}
