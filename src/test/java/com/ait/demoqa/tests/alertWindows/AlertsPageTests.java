package com.ait.demoqa.tests.alertWindows;

import com.ait.demoqa.pages.alertWindows.AlertsPage;
import com.ait.demoqa.pages.HomePage;
import com.ait.demoqa.pages.SidePanel;
import com.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsPageTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getAlertsFrameAndWindows();
        new SidePanel(driver).selectAlerts();
    }
    @Test
    public void justAlertTest() {
        new AlertsPage(driver)
                .acceptAlert();
    }

    @Test
    public void waitForAlertTest() {
        new AlertsPage(driver)
                .acceptAlertIn5sec();
    }

    @Test
    public void confirmAlertTest() {
        new AlertsPage(driver).
                confirmAlert("Cancel")
                .assertConfirm("Cancel");
    }

    @Test
    public void promptAlertTest() {
        new AlertsPage(driver)
                .promptAlert("Good night & Good luck!")
                .assertMessage("Good night & Good luck!");
    }


}
