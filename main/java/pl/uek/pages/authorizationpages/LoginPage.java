
package pl.uek.pages.authorizationpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pl.uek.Credentials;
import pl.uek.pages.mainpages.HomePage;
import pl.uek.pages.mainpages.Page;

public class LoginPage extends Page {

    @FindBy(id = "username")
    private WebElement userInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(name = "submit")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage login(Credentials credentials) {
        userInput.sendKeys(credentials.getLogin());
        passwordInput.sendKeys(credentials.getPassword());
        submitButton.click();
        return new HomePage(driver);
    }

}

