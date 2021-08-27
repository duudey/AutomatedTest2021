package pl.uek.guest;

import org.testng.annotations.Test;
import pl.uek.SeleniumTestCase;
import pl.uek.configuration.DataTestProvider;
import pl.uek.pages.navigationbarpages.BusinessECardPage;
import pl.uek.pages.navigationbarpages.SearchResultsPage;

import static org.testng.AssertJUnit.assertTrue;

public class PermissionsGuestTest extends SeleniumTestCase {

    @Test(groups = {"all"}, dataProvider = "realCourseName", dataProviderClass = DataTestProvider.class)
    public void shouldNotGuestSignToCourse(String realCourseName) throws Exception {
        SearchResultsPage searchResultsPage = homePage.searchForCourse(realCourseName).goToRandomCourse();

        assertTrue(searchResultsPage.isSigningCourseForUnloggedUserImpossible());
    }

    @Test(groups = {"all"}, dataProvider = "courseLecturerName", dataProviderClass = DataTestProvider.class)
    public void shouldNotGuestOpenLecturerPage(String courseLecturerName) throws Exception {
        SearchResultsPage searchResultsPage = homePage.searchForCourse(courseLecturerName).goToCourseLecturer();

        assertTrue(searchResultsPage.isLecturerPageNotOpened());
    }

    @Test(groups = {"all"}, dataProvider = "businessECardName", dataProviderClass = DataTestProvider.class)
    public void shouldGuestOpenBusinessECard(String businessECardName) throws Exception {
        BusinessECardPage businessECardPage = homePage.searchForCourse(businessECardName).goToBusinessECardPage();

        assertTrue(businessECardPage.isBusinnesECardVisible());
    }
}


