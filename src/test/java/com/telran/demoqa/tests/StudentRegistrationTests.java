package com.telran.demoqa.tests;

import com.telran.demoqa.data.StData;
import com.telran.demoqa.helpers.DataProviders;
import com.telran.demoqa.pages.FormsPage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.SidePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentRegistrationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).getForms();
        new SidePanelPage(driver).selectPracticeForm();
    }

    @Test
    public void fillStudentRegistrationFormTest() {
        new FormsPage(driver).fillPersonalData(StData.FIRST_NAME, StData.LAST_NAME, StData.EMAIL, StData.PHONE)
                .selectGender(StData.GENDER)//.typeOfDate(StData.B_DAY)
                .chooseDate("December","2021","5")
                .addSubject(StData.SUBJECTS)
                .chooseHobbies(StData.HOBBIES)
                .uploadFile(StData.FILE)
                .typeAdress(StData.ADDRESS).inputState(StData.STATE)
                .inputCity(StData.CITY).clickOnSubmitButton();
        Assert.assertTrue(new FormsPage(driver).getTitleFormDialog().contains("Thanks for submitting the form"));
        new FormsPage(driver).closeSuccessDialog();

    }

    @Test(dataProvider = "newStudent", dataProviderClass = DataProviders.class)
    public void fillStudentRegFormFromDataProviderTest(String fName, String lName, String email, String phone, String gender, String bDay, String [] subjects, String[] hobbies, String file) {
        new FormsPage(driver).fillPersonalData(fName,lName,email,phone)
                .selectGender(gender)
                .typeOfDate(bDay)
                .addSubject(subjects)
                .chooseHobbies(hobbies)
                .uploadFile(file);

    }

    @Test(dataProvider = "newStudentFromCSV", dataProviderClass = DataProviders.class)
    public void fillStudentRegFormFromCSVTest(StData st) {
        new FormsPage(driver).fillPersonalData(st.getFirstName(),st.getLastName(),st.getEmail(),st.getPhone())
                .selectGender(st.getGender())
                .typeOfDate(st.getbDay())
                .addSubject(st.getSubjects())
                .chooseHobbies(st.getHobbies())
                .uploadFile(st.getFile());
    }

    @Test(dataProvider = "usingFile", dataProviderClass = DataProviders.class)
    public void fillStudentRegFormExampleTest(String fName, String lName, String email, String phone, String bDay, String file) {
        new FormsPage(driver).fillPersonalData(fName,lName,email,phone)
                .selectGender(StData.GENDER)
                .typeOfDate(bDay)
                .addSubject(StData.SUBJECTS)
                .chooseHobbies(StData.HOBBIES)
                .uploadFile(file);

    }
}
