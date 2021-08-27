package pl.uek.configuration;

import org.testng.annotations.DataProvider;


public class DataTestProvider {

    @DataProvider(name = "fakeCourseName")
    public static Object[][] getFakeCourseNameData() {
        return new Object[][]{
                {"453453452432"},
                {"Nie powinno znaleźć żadnego kursu"}
        };
    }

    @DataProvider(name = "realCourseName")
    public static Object[][] getRealCourseNameData() {
        return new Object[][]{
                {"Sieci komputerowe - wykład"},
                {"Programowanie systemów mobilnych"}
        };
    }

    @DataProvider(name = "courseLecturerName")
    public static Object[][] getCourseLecturerNameData() {
        return new Object[][]{
                {"Kurs"},
        };
    }

    @DataProvider(name = "businessECardName")
    public static Object[][] getBusinessECardNameData() {
        return new Object[][]{
                {"e-wizytówka"},
        };
    }

}