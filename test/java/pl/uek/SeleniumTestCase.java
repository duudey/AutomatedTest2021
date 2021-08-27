package pl.uek;

import pl.uek.configuration.Browser;
import pl.uek.configuration.DataTestGenerator;
import pl.uek.pages.mainpages.HomePage;
import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

public abstract class SeleniumTestCase {

    private WebDriver driver;
    protected HomePage homePage;
    protected static final Credentials ADMIN = Credentials.ADMIN_PANEL;
    protected static final Credentials FAKE = Credentials.FAKE_USER;

    @BeforeMethod(groups = {"default", "all"})
    @Parameters("browser")
    public void openBrowser() {
        driver = Browser.valueOf(System.getProperty("browser")).newDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    @BeforeMethod(groups = {"default", "all"})
    public void openSite() {

        homePage = new HomePage(driver, Configuration.INSTANCE.getValue("app.site"))
                .open();
    }

    @AfterMethod(groups = {"default", "all" })
    public void closeBrowser(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            String testName = result.getName();
            takeScreenShot(testName + ".png");
        }
        driver.quit();
    }

    private void takeScreenShot(String testName) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File fileOnDisc = new File(Configuration.INSTANCE.getValue("screenshots.failed.tests.path") + DataTestGenerator.getRandomTodayAndTimeWith(testName));
        FileUtils.copyFile(screenshot, fileOnDisc);
    }
}