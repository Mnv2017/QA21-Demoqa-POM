package com.telran.demoqa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormsPage extends PageBase {
    public FormsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement email;

    @FindBy(id = "userNumber")
    WebElement phone;

    public FormsPage fillPersonalData(String fName, String lName, String em, String ph) {
        type(firstName, fName);
        type(lastName, lName);
        type(email, em);
        type(phone, ph);
        return this;
    }

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement maleBtn;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    WebElement femaleBtn;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    WebElement otherBtn;

    public FormsPage selectGender(String gender) {
        if (gender.equals("Male")) {
            click(maleBtn);
        } else if (gender.equals("Female")) {
            click(femaleBtn);
        } else
            click(otherBtn);
        return this;
    }

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthBtn;

    public FormsPage typeOfDate(String bDay) {
        click(dateOfBirthBtn);
        String os = System.getProperty("os.name");
        System.out.println("OS: " + os);

        if (os.startsWith("Mac")) {
            dateOfBirthBtn.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        } else {
            dateOfBirthBtn.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }
        dateOfBirthBtn.sendKeys(bDay);
        dateOfBirthBtn.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    @FindBy(id = "react-select-2-option-0")
    WebElement selectInput;

    public FormsPage addSubject(String[] subjects) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                type(subjectsInput, subjects[i]);
                selectInput.click();
            }
        }
        return this;
    }

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    WebElement sport;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    WebElement reading;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    WebElement music;

    public FormsPage chooseHobbies(String[] hobbies) {
        for (int i = 0; i < hobbies.length; i++) {
            if (hobbies[i].equals("Sport")) {
                click(sport);
            } else if (hobbies[i].equals("Reading")) {
                click(reading);
            } else if (hobbies[i].equals("Music"))
                click(music);
        }
        return this;
    }

    @FindBy(id = "uploadPicture")
    WebElement chooseFile;

    public FormsPage uploadFile(String path) {
        chooseFile.sendKeys(path);
        return this;
    }
}
