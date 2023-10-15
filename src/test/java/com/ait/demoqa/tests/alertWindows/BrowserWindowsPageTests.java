package com.ait.demoqa.tests.alertWindows;

import com.ait.demoqa.pages.alertWindows.BrowserWindowsPage;
import com.ait.demoqa.pages.HomePage;
import com.ait.demoqa.pages.SidePanel;
import com.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserWindowsPageTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getAlertsFrameAndWindows();
        new SidePanel(driver).selectBrowserWindows();
    }

//    @Test
//    public void openNewTabTest() {
//        new BrowserWindowsPage(driver)
//                .switchToNewTab(1)
//                .assertNewTabInfo("This is a sample page");
//    }
    @Test
    public void openNewWindowTest() {
        new BrowserWindowsPage(driver)
                .switchToNewWindow(1)
                .assertNewWindowInfo("This is a sample page");
    }

    @Test
    public void openNewWindowMessageTest() {
        new BrowserWindowsPage(driver)
                .switchToNewWindowMessage(1)
                .assertNewWindowMessageInfo("Knowledge increases by sharing " +
                        "but not by saving. Please share this website with " +
                        "your friends and in your organization.Knowledge increases " +
                        "by sharing but not by saving. Please share this website " +
                        "with your friends and in your organization.");
    }
}
