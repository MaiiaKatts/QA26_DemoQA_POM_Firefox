package com.ait.demoqa.tests.elements;

import com.ait.demoqa.pages.HomePage;
import com.ait.demoqa.pages.SidePanel;
import com.ait.demoqa.pages.elements.UploadPage;
import com.ait.demoqa.tests.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadRobotTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getElements();
        new SidePanel(driver).selectUpload().hideIFrames();
    }

    //этот метод для виндоус и у меня он повалится
    //поэтому закоментирован assert - чтобы не валились тесты
//    @Test
//    public void robotKeyEventTest() {
//        new UploadPage(driver)
//                .performKeyEventUsingRobot()
//                .assertPath("C:\\fakepath\\D1.txt");
//    }

    @Test
    public void robotMouseEventTest() {
        new UploadPage(driver)
                .performMouseEventUsingRobot()
                .assertPath("C:\\fakepath\\D1.txt");
    }
}
