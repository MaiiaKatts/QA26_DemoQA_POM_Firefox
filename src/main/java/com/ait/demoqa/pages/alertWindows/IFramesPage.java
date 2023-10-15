package com.ait.demoqa.pages.alertWindows;

import com.ait.demoqa.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IFramesPage extends BasePage {
    public IFramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    List<WebElement> iframes;
    public IFramesPage returnListOfIFrames() {

        System.out.println("Total amount of IFrames on the page: "
                +  iframes.size());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Integer iFramesAmount = Integer.parseInt(js
                .executeScript("return window.length;").toString());
        System.out.println("Total amount of IFrames on the page: "
                +  iFramesAmount);

        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    public IFramesPage switchToFrameByIndex(int index) {
        driver.switchTo().frame(index);
        System.out.println("Text: " + sampleHeading.getText());
        return this;
    }

    @FindBy(id = "frame1")
    WebElement frame1;

    @FindBy(id = "framesWrapper")
    WebElement framesWrapper;

    public IFramesPage switchToIFrameByID() {
        driver.switchTo().frame(frame1);
        System.out.println("Text find by ID: " + sampleHeading.getText());

        //чтобы вернуться на главную страничку после того
        // как убедились что нашли наш IFrame:
        driver.switchTo().defaultContent();
        System.out.println("Text on the main page: " + framesWrapper.getText());
        return this;
    }

    @FindBy(tagName = "body")
    WebElement body;

    public IFramesPage switchToNestedIFrames() {
        System.out.println("Total amount of IFrames on the page: " + iframes.size());

        driver.switchTo().frame(frame1);
        System.out.println("Frame 1 is: " +
                body.getText());
        System.out.println("Total amount of IFrames on the parent frame: " + iframes.size());

        driver.switchTo().frame(0);
        System.out.println("Frame 2 is: " + body.getText());
        System.out.println("Total amount of IFrames on the child iframe: " + iframes.size());

//        driver.switchTo().parentFrame();
//        System.out.println("Frame 1 is " + body.getText());

        //для возврата на основной контент:
        driver.switchTo().defaultContent();
        System.out.println("Text on the main page: " + framesWrapper.getText());


        return this;
    }
}
