package com.ait.demoqa.tests.form;

import com.ait.demoqa.data.VampireData;
import com.ait.demoqa.pages.HomePage;
import com.ait.demoqa.pages.SidePanel;
import com.ait.demoqa.pages.form.PracticeFormPage;
import com.ait.demoqa.tests.TestBase;
import com.ait.demoqa.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm();
    }

    @Test
    public void fillPracticeFormTest() {
        //попробуем скрыть блокирующий футер
        new PracticeFormPage(driver).hideIFrames();
        //заполняем первые 4 поля: имя, фамилия, e-mail и тел
        new PracticeFormPage(driver).enterPersonalData(
                        VampireData.FIRST_NAME,
                        VampireData.LAST_NAME,
                        VampireData.EMAIL,
                        VampireData.PHONE_NUMBER)
                //выбираем пол
                .selectGender(VampireData.GENDER)
                //вводим дату
                //.enterBirthDate(VampireData.DATE_OF_BIRTH)
                //выбираем дату без ввода в ручную
                .selectBirthDate("September", "1928", "8")// при этом методе невозможно выбрать год рождения 1428))
                //выбираем предмет
                .selectSubjects(VampireData.SUBJECTS)
                //выбираем хобби
                .selectHobbies(VampireData.HOBBY)
                //загружаем картинку
                .selectPicture(VampireData.PATH)
                //вводим адрес
                .enterCurrentAddress(VampireData.ADDRESS)
                //выбор штата
                .selectState(VampireData.STATE)
                //выбор города
                .selectCity(VampireData.CITY)
                //кликаем на submit
                .submitForm().assertModalTitle("Thanks for submitting the form");

    }

    // флакaющий тест - если тесты падают по неизвестным причинам
    @Test(dataProviderClass = DataProviders.class, dataProvider = "addNewVampireFromCSV")
    public void fillPracticeFormFromDataProviderTest(
            String name,
            String lastname,
            String email,
            String phone,
            String birthDate,
            String path,
            String address
    ) {
        new PracticeFormPage(driver).hideIFrames();//скрываем блокирующий футер
        new PracticeFormPage(driver).enterPersonalData
                        (name, lastname, email, phone)
                .selectGender(VampireData.GENDER)
                .enterBirthDate(birthDate)
                .selectSubjects(VampireData.SUBJECTS)
                .selectHobbies(VampireData.HOBBY)
                .selectPicture(path)
                .enterCurrentAddress(address)
                .selectState(VampireData.STATE)
                .selectCity(VampireData.CITY)
                .submitForm().assertModalTitle("Thanks for submitting the form");
    }
}
