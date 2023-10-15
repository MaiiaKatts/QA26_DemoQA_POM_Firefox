package com.ait.demoqa.tests.alertWindows;

import com.ait.demoqa.pages.HomePage;
import com.ait.demoqa.pages.alertWindows.IFramesPage;
import com.ait.demoqa.pages.SidePanel;
import com.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFramesTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getAlertsFrameAndWindows();
    }
    @Test
    public void iFramesTest() {
        new SidePanel(driver).selectFrames();
        new IFramesPage(driver)
                .returnListOfIFrames()
                .switchToFrameByIndex(2);
    }

    @Test
    public void switchToIFrameByIDTest(){
        new SidePanel(driver).selectFrames();
        new IFramesPage(driver).switchToIFrameByID();
    }

    @Test
    public void switchToNestedIFramesTest() {
        new SidePanel(driver).selectNestedFrames();
        new IFramesPage(driver).switchToNestedIFrames();
    }

    // doubleClick - метод, который перемещает курсор на элемент
    // и кликает на него:

}
