package com.ait.demoqa.pages.form;

import com.ait.demoqa.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    WebElement name;
    @FindBy(id = "lastName")
    WebElement surname;
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id = "userNumber")
    WebElement userPhone;

    public PracticeFormPage enterPersonalData(
            String fName,
            String lName,
            String email,
            String phoneNum) {
        type(name, fName);
        type(surname, lName);
        type(userEmail, email);
        type(userPhone, phoneNum);

        return this;
    }

    @FindBy(css = "[for='gender-radio-1']")
    WebElement male;
    @FindBy(css = "[for='gender-radio-2']")
    WebElement female;
    @FindBy(css = "[for='gender-radio-3']")
    WebElement other;

    public PracticeFormPage selectGender(String gender) {
        if (gender.equals("Male")) {
            male.click();
        }
        else if (gender.equals("Female")) {
            female.click();
        }
        else {
            other.click();
        }
        return this;
    }

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;

    public PracticeFormPage enterBirthDate(String dateOfBirth) {//enterDate
        clickWithJSExecutor(dateOfBirthInput,0,100);
        String os = System.getProperty("os.name");
        if (os.startsWith("Mac")) {
            dateOfBirthInput.sendKeys(Keys.COMMAND, "a");
        } else {
            dateOfBirthInput.sendKeys(Keys.CONTROL, "a");
        }
        dateOfBirthInput.sendKeys(dateOfBirth);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    public PracticeFormPage selectSubjects(String[] subjects) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                type(subjectsInput, subjects[i]);
                subjectsInput.sendKeys(Keys.ENTER);
            }
        }
        return this;
    }

    @FindBy(css = "[for='hobbies-checkbox-1']")
    WebElement sports;
    @FindBy(css = "[for='hobbies-checkbox-2']")
    WebElement reading;
    @FindBy(css = "[for='hobbies-checkbox-3']")
    WebElement music;

    public PracticeFormPage selectHobbies(String[] hobby) {
        for (int i = 0; i < hobby.length; i++) {

            if (hobby[i].equals("Sports")) {
                clickWithJSExecutor(sports,0,100);
            }
            if (hobby[i].equals("Reading")) {
                clickWithJSExecutor(reading, 0, 100);
            }
            if (hobby[i].equals("Music")) {
                clickWithJSExecutor(music, 0, 100);
            }
        }
        return this;
    }
    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;

    public PracticeFormPage selectPicture(String path) {//почитать об этом!!!!
        uploadPicture.sendKeys(path);
        return this;
    }

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    public PracticeFormPage enterCurrentAddress(String address) {
        typeWithJSExecutor(currentAddress,address,0,300);
        return this;
    }

    @FindBy(id = "state")
    WebElement stateContainer;
    @FindBy(id = "react-select-3-input")
    WebElement stateInput;

    public PracticeFormPage selectState(String state) {
        click(stateContainer);
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER);

        return this;
    }
    @FindBy(id = "city")
    WebElement cityContainer;
    @FindBy(id = "react-select-4-input")
    WebElement cityInput;

    public PracticeFormPage selectCity(String city) {
        click(cityContainer);
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER);

        return this;
    }

    @FindBy(id = "submit")
    WebElement submit;

    public PracticeFormPage submitForm() {
        clickWithRectangle(submit,2,4);
        //4 - чтобы оказаться в верхней части нужного элем
        return this;
    }
    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement modalTitle;

    public PracticeFormPage assertModalTitle(String title) {
        Assert.assertTrue(
                shouldHaveText(modalTitle,title,10));
        return this;
    }

    @FindBy(css = ".react-datepicker__month-select")
    WebElement monthArea;
    @FindBy(css = ".react-datepicker__year-select")
    WebElement yearArea;

    public PracticeFormPage selectBirthDate(String month, String year, String day) {
        click(dateOfBirthInput);

        new Select(monthArea).selectByVisibleText(month);
        new Select(yearArea).selectByVisibleText(year);

        // areaLable - проговаривание прописанного текста -
        // для людей с ограниченными возможностями и сейчас при выборе дня
        // у нас именно эта ситуация:
        driver.findElement(By.xpath(
                "//div[@class='react-datepicker__week']//div[.='"
                + day + "']")).click();

        return this;
    }
}

