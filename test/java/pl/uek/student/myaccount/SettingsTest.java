package pl.uek.student.myaccount;

import org.testng.annotations.Test;
import pl.uek.SeleniumTestCase;
import pl.uek.pages.myaccountpages.ProfileModificationPage;
import pl.uek.pages.myaccountpages.SettingsPage;

import static org.testng.AssertJUnit.assertTrue;

public class SettingsTest extends SeleniumTestCase {

    @Test(groups = {"default", "all"})
    public void shouldChangeDescriptionBySettingsPage() throws Exception {
        ProfileModificationPage profileModificationPage = homePage.login(ADMIN).goToSettingsPage().goToProfileModificationPage().editDescription();
        assertTrue(profileModificationPage.isChangeInSettingsSaved());
    }

    @Test(groups = {"default", "all"})
    public void shouldChangeLanguagePreferences() throws Exception {
        SettingsPage settingsPage = homePage.login(ADMIN).goToSettingsPage().changeLanguageOfSite();
        assertTrue(settingsPage.isChangeInSettingsSaved());
    }

    @Test(groups = {"default", "all"})
    public void shouldChangeForumPreferences() throws Exception {
        SettingsPage settingsPage = homePage.login(ADMIN).goToSettingsPage().changeForumPreferences();
        assertTrue(settingsPage.isChangeInSettingsSaved());
    }
}
