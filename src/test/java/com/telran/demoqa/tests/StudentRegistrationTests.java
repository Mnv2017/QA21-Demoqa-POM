package com.telran.demoqa.tests;

import com.telran.demoqa.data.StudentData;
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
        new FormsPage(driver).fillPersonalData(StudentData.FIRST_NAME, StudentData.LAST_NAME, StudentData.EMAIL, StudentData.PHONE)
                .selectGender(StudentData.GENDER).typeOfDate(StudentData.B_DAY)
                .addSubject(StudentData.SUBJECTS)
                .chooseHobbies(StudentData.HOBBIES)
                .uploadFile(StudentData.FILE);
//                .typeAdress(StudentData.ADDRESS).inputState(StudentData.STATE).inputCity(StudentData.CITY).clickOnSubmitButton();
//        Assert.assertTrue(new FormsPage(driver).getTitleFormDialog());
//        new FormsPage(driver).closeSuccessDialog();
    }
}
