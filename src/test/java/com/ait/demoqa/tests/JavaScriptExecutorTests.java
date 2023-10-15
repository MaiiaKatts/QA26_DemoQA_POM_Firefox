package com.ait.demoqa.tests;

import com.ait.demoqa.data.UserData;
import com.ait.demoqa.pages.HomePage;
import com.ait.demoqa.pages.JSExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorTests extends TestBase {

    @BeforeMethod
    public void precondition() {

        new HomePage(driver).getFormOfAuthentication();
    }

        @Test
        public void JavaScriptExecutorTest() {
            new JSExecutor(driver)
                    .enterDataWithJSExecutor(
                            UserData.USER_NAME,
                            UserData.USER_PASSWORD)
                    .clickWithJS().checkURLwithJS().checkTitleOFPageWithJS();
        }

}
