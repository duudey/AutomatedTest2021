package pl.uek.student;

import org.testng.annotations.Test;
import pl.uek.SeleniumTestCase;
import pl.uek.configuration.DataTestProvider;
import pl.uek.pages.navigationbarpages.BusinessECardPage;
import pl.uek.pages.navigationbarpages.SearchResultsPage;

import static org.testng.AssertJUnit.assertTrue;

public class PermissionsStudentTest extends SeleniumTestCase {

    @Test(groups = {"all"}, dataProvider = "realCourseName", dataProviderClass = DataTestProvider.class)
    public void shouldStudentSignToCourse(String realCourseName) throws Exception {
        SearchResultsPage searchResultsPage = homePage.login(ADMIN).searchForCourse(realCourseName).goToRandomCourse();

        assertTrue(searchResultsPage.isSigningToCoursePossible());
    }

    @Test(groups = {"all"}, dataProvider = "courseLecturerName", dataProviderClass = DataTestProvider.class)
    public void shouldStudentOpenLecturerPage(String courseLecturerName) throws Exception {
        SearchResultsPage searchResultsPage = homePage.login(ADMIN).searchForCourse(courseLecturerName).goToCourseLecturer();

        assertTrue(searchResultsPage.isLecturerPageOpened());
    }

    @Test(groups = {"all"}, dataProvider = "businessECardName", dataProviderClass = DataTestProvider.class)
    public void shouldStudentOpenBusinessECard(String businessECardName) throws Exception {
        BusinessECardPage businessECardPage = homePage.login(ADMIN).searchForCourse(businessECardName).goToBusinessECardPage();

        assertTrue(businessECardPage.isBusinnesECardVisible());
    }
}
