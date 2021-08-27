package pl.uek.student;

import org.testng.annotations.Test;
import pl.uek.SeleniumTestCase;
import pl.uek.pages.navigationbarpages.CoursePage;

import static org.testng.AssertJUnit.assertTrue;

public class CourseTest extends SeleniumTestCase {

    @Test(groups = {"default", "all"})
    public void shouldOpenParticipantsGrades() throws Exception {
        CoursePage coursePage = homePage.login(ADMIN).goToCockpitPage().goToCoursePageFromNavigationPanel().openParticipants();
        assertTrue(coursePage.isParticipantsOpened());
    }

    @Test(groups = {"default", "all"})
    public void shouldOpenCourseGrades() throws Exception {
        CoursePage coursePage = homePage.login(ADMIN).goToCockpitPage().goToCoursePageFromNavigationPanel().openGrades();
        assertTrue(coursePage.isGradesOpened());
    }
    @Test(groups = {"default", "all"})
    public void shouldOpenCourseForum() throws Exception {
        CoursePage coursePage = homePage.login(ADMIN).goToCockpitPage().goToCoursePageFromNavigationPanel().openForum();
        assertTrue(coursePage.isForumOpened());
    }

    @Test(groups = {"default", "all"})
    public void shouldOpenCourseFromNavigationPanel() throws Exception {
        CoursePage coursePage = homePage.login(ADMIN).goToCockpitPage().goToCoursePageFromNavigationPanel();
        assertTrue(coursePage.isCourseOpened());
    }

    @Test(groups = {"default", "all"})
    public void shouldOpenCourseFromMainPanel() throws Exception {
        CoursePage coursePage = homePage.login(ADMIN).goToCockpitPage().goToCoursePageFromMainPanel();
        assertTrue(coursePage.isCourseOpened());
    }
}
