package pl.uek.student.myaccount;

import org.testng.annotations.Test;
import pl.uek.SeleniumTestCase;
import pl.uek.pages.myaccountpages.MessagesPage;

import static org.testng.AssertJUnit.assertTrue;

public class MessagesTest extends SeleniumTestCase {

    @Test(groups = {"default", "all"})
    public void shouldFindOtherUserToMessage() throws Exception {
        MessagesPage messagesPage = homePage.login(ADMIN).goToMessagePage().searchForUser();
        assertTrue(messagesPage.isUserFound());
    }

    @Test(groups = {"default", "all"})
    public void shouldShowMessageHistory() throws Exception {
        MessagesPage messagesPage = homePage.login(ADMIN).goToMessagePage().openPrivateMessages();
        assertTrue(messagesPage.isHistoryOfMessagesDisplayed());
    }
}
