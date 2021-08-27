package pl.uek.student.myaccount;

import org.testng.annotations.Test;
import pl.uek.SeleniumTestCase;
import pl.uek.pages.myaccountpages.ProfileModificationPage;
import pl.uek.pages.myaccountpages.ProfilePage;

import static org.testng.AssertJUnit.assertTrue;

public class ProfileTest extends SeleniumTestCase {

    @Test(groups = {"default", "all"})
    public void shouldChangeDescriptionByProfilePage() throws Exception {
        ProfileModificationPage profileModificationPage = homePage.login(ADMIN).goToProfilePage().goToProfileModificationPage().editDescription();
        assertTrue(profileModificationPage.isChangeSaved());
    }

    @Test(groups = {"default", "all"})
    public void shouldRequireEmail() throws Exception {
        ProfileModificationPage profileModificationPage = homePage.login(ADMIN).goToProfilePage().goToProfileModificationPage().removeEmail();
        assertTrue(profileModificationPage.isEmailRequired());
    }

    @Test(groups = {"default", "all"})
    public void shouldDisplayProfile() throws Exception {
        ProfilePage profilePage = homePage.login(ADMIN).goToProfilePage();
        assertTrue(profilePage.isProfileVisible());
    }
}
