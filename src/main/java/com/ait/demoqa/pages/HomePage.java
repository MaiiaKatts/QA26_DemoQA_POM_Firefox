package com.ait.demoqa.pages;

import com.ait.demoqa.pages.links.BrokenLinksImagesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }


//    @FindBy(css = "card.mt-4.top-card:nth-child(3)")
    @FindBy(xpath = "//h5[.='Alerts, Frame & Windows']")
    WebElement alertsFrameAndWindows;

    public SidePanel getAlertsFrameAndWindows() {
        clickWithJSExecutor(alertsFrameAndWindows,0,300);
        return new SidePanel(driver);
    }


//    @FindBy(css = ".card.mt-4.top-card:nth-child(6)")
    @FindBy(xpath = "//h5[.='Book Store Application']")
    //@FindBy(css = ".top-card:nth-child(6)")
    WebElement bookStore;

    public SidePanel getBookStore() {
        clickWithJSExecutor(bookStore,0,600);
        return new SidePanel(driver);
    }

    @FindBy(xpath = "//h5[.='Elements']")
    //@FindBy(css = ".top-card:nth-child(1)")
    WebElement elements;
    public SidePanel getElements() {
        clickWithJSExecutor(elements,0,300);
        return new SidePanel(driver);
    }

    @FindBy(xpath = "//h5[.='Widgets']")
    WebElement widgets;

    public SidePanel getWidgets() {
        clickWithJSExecutor(widgets,0,300);
        return new SidePanel(driver);
    }

    @FindBy(xpath = "//a[.='Form Authentication']")
    WebElement form;

    public JSExecutor getFormOfAuthentication() {
        click(form);
        return new JSExecutor(driver);
    }

    @FindBy(tagName = "a")
    List<WebElement> allLinks;

    public Object checkAllLinks() {
        String url;
        System.out.println("Total amount of links on the page: " + allLinks.size());
        Iterator<WebElement> iterator = allLinks.iterator();
        while (iterator.hasNext()){
            url=iterator.next().getText();
            System.out.println(url);
        }
        return this;
    }
    @FindBy(xpath = "//a[.='Broken Images']")
    WebElement brokenImages;

    public BrokenLinksImagesPage getBrokenImages() {
        click(brokenImages);
        return new BrokenLinksImagesPage(driver);
    }

    @FindBy(xpath = "//h5[.='Forms']")
    WebElement forms;

    public SidePanel getForms() {
        clickWithJSExecutor(forms,0,300);
        return new SidePanel(driver);
    }

    @FindBy(xpath = "//h5[.='Interactions']")
    WebElement interactions;
    public SidePanel getInteractions() {
        clickWithJSExecutor(interactions,0,300);
        return new SidePanel(driver);
    }
}

