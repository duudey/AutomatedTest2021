package pl.uek.student;

import org.testng.annotations.Test;
import pl.uek.SeleniumTestCase;

import static org.testng.AssertJUnit.assertTrue;

public class LoginLogoutTest extends SeleniumTestCase {

    @Test(groups = {"default", "all"})
    public void shouldLogin() throws Exception {
        homePage.login(ADMIN);

        assertTrue(homePage.isLoginCorrect());
    }

    @Test(groups = {"all"})
    public void shouldLogout() throws Exception {
        homePage.login(ADMIN).logout();

        assertTrue(homePage.isLogoutCorrect());
    }
    @Test(groups = {"default", "all"})
    public void shouldNotLogin() throws Exception {
        homePage.login(FAKE);
        assertTrue(homePage.isLoginIncorrect());
    }

}
