package pl.uek.guest;

import org.testng.annotations.Test;
import pl.uek.SeleniumTestCase;
import pl.uek.configuration.DataTestProvider;
import pl.uek.pages.navigationbarpages.SearchResultsPage;

import static org.testng.AssertJUnit.assertTrue;

public class SearchingGuestTest extends SeleniumTestCase {

    @Test(groups = {"all"}, dataProvider = "realCourseName", dataProviderClass = DataTestProvider.class)
    public void shouldGuestSearchByRealCourseName(String realCourseName) throws Exception {
        SearchResultsPage searchResultsPage = homePage.searchForCourse(realCourseName);

        assertTrue(searchResultsPage.isResultsShown());
    }


    @Test(dataProvider = "fakeCourseName", dataProviderClass = DataTestProvider.class, groups = {"all"})
    public void shouldGuestSearchByFakeCourseName(String fakeCourseName) throws Exception {
        SearchResultsPage searchResultsPage = homePage.searchForCourse(fakeCourseName);

        assertTrue(searchResultsPage.isNoResultFound());
    }
}
