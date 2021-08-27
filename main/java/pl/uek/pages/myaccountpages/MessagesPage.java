package pl.uek.pages.myaccountpages;

import pl.uek.pages.mainpages.Page;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MessagesPage extends Page {

    public MessagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"view-overview-messages-toggle\"]/button/strong")
    private WebElement expandPrivateMessages;

    @FindBy(xpath = "//*[@id=\"view-overview-messages-target\"]/div[3]/a[1]/div[1]/p/span")
    private WebElement randomMessage;

    @FindBy(className = "form-control border-left-0 searchinput")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"yui_3_17_2_1_1565984495780_52\"]/button/span[1]/img")
    private WebElement searchButton;

    @FindBy(xpath = "//*[text()='Strzałka Weronika']")
    private WebElement otherUser;

    @FindBy(xpath = "//*[@id=\"yui_3_17_2_1_1565984495780_80\"]")
    private WebElement messageTextArea;

    @FindBy(xpath = "//*[@id=\"yui_3_17_2_1_1565979767475_77\"]/button/span[1]/img")
    private WebElement sendMessage;

    public MessagesPage openPrivateMessages(){
        waitForClickableWebElement(expandPrivateMessages);
        expandPrivateMessages.click();
        return(this);
    }

    public MessagesPage searchForUser(){
        Actions action = new Actions(driver);
        waitForClickableWebElement(expandPrivateMessages);
        action.sendKeys("Weronika Strzałka").sendKeys(Keys.ENTER).perform();
        return(this);
    }

    public boolean isUserFound(){
        waitForClickableWebElement(otherUser);
        return otherUser.isDisplayed();
    }

    public boolean isHistoryOfMessagesDisplayed(){
        openPrivateMessages();
        waitForClickableWebElement(randomMessage);
        return randomMessage.isDisplayed();
    }


}