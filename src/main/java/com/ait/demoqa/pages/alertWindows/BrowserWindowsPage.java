package com.ait.demoqa.pages.alertWindows;

import com.ait.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsPage extends BasePage {
    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "tabButton")
    WebElement newTab;

    public BrowserWindowsPage switchToNewTab(int index) {
        click(newTab);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(index));
        return this;
    }
//    @FindBy(id = "sampleHeading")
//    WebElement title;
//
//    public BrowserWindowsPage assertNewTabInfo(String text) {
//        Assert.assertTrue(shouldHaveText(title,text,5));
//        return this;
//    }

    @FindBy(id = "windowButton")
    WebElement newWindow;
    public BrowserWindowsPage switchToNewWindow(int index) {
        click(newWindow);
        List<String> windows = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(windows.get(index));
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement title;
    public BrowserWindowsPage assertNewWindowInfo(String text) {
        Assert.assertTrue(shouldHaveText(title,text,5));
        return this;
    }

    @FindBy(id = "messageWindowButton")
    WebElement newWindowMessage;
    public BrowserWindowsPage switchToNewWindowMessage(int index) {
        click(newWindowMessage);
        List<String> windowMessages = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(windowMessages.get(index));
        return this;
    }
    @FindBy(xpath = "//body")
    WebElement info;
    public BrowserWindowsPage assertNewWindowMessageInfo(String text) {
        Assert.assertTrue(shouldHaveText(info,text,15));
        return this;
    }
}
