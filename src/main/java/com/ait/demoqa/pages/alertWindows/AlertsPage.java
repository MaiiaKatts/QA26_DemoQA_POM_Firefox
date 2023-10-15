package com.ait.demoqa.pages.alertWindows;

import com.ait.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AlertsPage extends BasePage {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "alertButton")
    WebElement simpleAlert;

    public AlertsPage acceptAlert() {
        click(simpleAlert);
        return this;
    }

    @FindBy(id = "timerAlertButton")
    WebElement timeAlert;

    public AlertsPage acceptAlertIn5sec() {
        click(timeAlert);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent()).accept();
        return this;
    }

    @FindBy(id = "confirmButton")
    WebElement confirmAlert;

    public AlertsPage confirmAlert(String text) {
        click(confirmAlert);

        if (text != null && text.equalsIgnoreCase("ok")) {
            driver.switchTo().alert().accept();
        } else if (text != null && text.equalsIgnoreCase("cancel")) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    @FindBy(id = "confirmResult")
    WebElement confirmRes;

    public AlertsPage assertConfirm(String text) {
        //Assert.assertTrue(confirmRes.getText().contains(text));
        Assert.assertTrue(isTextPresent(confirmRes, text));
        return this;
    }

    @FindBy(id = "promptButton")
    WebElement promptAlert;
    public AlertsPage promptAlert(String text) {
        promptAlert.click();

        if (text != null) {
            driver.switchTo().alert().sendKeys(text);
            driver.switchTo().alert().accept();
        }
        return this;
    }

    @FindBy(id = "promptResult")
    WebElement promptRes;
    public AlertsPage assertMessage(String text) {
        //Assert.assertTrue(promptRes.getText().contains(text));
        Assert.assertTrue(isTextPresent(promptRes, text));
        return this;
    }
}
