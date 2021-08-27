package pl.uek.student;

import org.testng.annotations.Test;
import pl.uek.SeleniumTestCase;
import pl.uek.configuration.DataTestProvider;
import pl.uek.pages.navigationbarpages.SearchResultsPage;

import static org.testng.AssertJUnit.assertTrue;

public class SearchingStudentTest extends SeleniumTestCase {

    @Test(groups = {"all"}, dataProvider = "realCourseName", dataProviderClass = DataTestProvider.class)
    public void shouldStudentSearchByRealCourseName(String realCourseName) throws Exception {
        SearchResultsPage searchResultsPage = homePage.login(ADMIN).searchForCourse(realCourseName);

        assertTrue(searchResultsPage.isResultsShown());
    }


    @Test(dataProvider = "fakeCourseName", dataProviderClass = DataTestProvider.class, groups = {"all"})
    public void shouldStudentSearchByFakeCourseName(String fakeCourseName) throws Exception {
        SearchResultsPage searchResultsPage = homePage.login(ADMIN).searchForCourse(fakeCourseName);

        assertTrue(searchResultsPage.isNoResultFound());
    }
}
