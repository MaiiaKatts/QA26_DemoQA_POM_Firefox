package com.ait.demoqa.pages.links;

import com.ait.demoqa.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrokenLinksImagesPage extends BasePage {
    public BrokenLinksImagesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/a[2]")// как записать этот локатор?
    List<WebElement> clickOnBrokenLink;

    public BrokenLinksImagesPage checkBrokenLink() {
        System.out.println("Total amount of images on the page: " + clickOnBrokenLink.size());
        for (int index = 0; index < clickOnBrokenLink.size(); index++) {
            WebElement link = clickOnBrokenLink.get(index);
            String imageURL = link.getAttribute("src");
            System.out.println("URL of link " + (index + 1) + " is " + imageURL);

            verifyLinks(imageURL);
            try {
                boolean imageDisplayed = (Boolean)((JavascriptExecutor)driver)
                        .executeScript("return(typeof arguments[0].naturalWidth!=undefined" +
                                " && arguments[0].naturalWidth>0);", clickOnBrokenLink);
                if (imageDisplayed) {
                    System.out.println("Displayed OK");
                    System.out.println("_______________________________________________");
                } else {
                    System.out.println("Displayed BROKEN");
                    System.out.println("_______________________________________________");
                }
            } catch (Exception e) {
                System.out.println("ERROR");

            }
        }
        return this;
    }

    @FindBy(tagName = "img")
    List<WebElement> images;

    public BrokenLinksImagesPage checkBrokenImages() {
        System.out.println("Total amount of images on the page: " + images.size());
        for (int index = 0; index < images.size(); index++) {
            WebElement link = images.get(index);
            String imageURL = link.getAttribute("src");
            System.out.println("URL of image " + (index + 1) + " is " + imageURL);

            verifyLinks(imageURL);
            try {
                boolean imageDisplayed = (Boolean)((JavascriptExecutor)driver)
                        .executeScript("return(typeof arguments[0].naturalWidth!=undefined" +
                                " && arguments[0].naturalWidth>0);", images);
                if (imageDisplayed) {
                    System.out.println("Displayed OK");
                    System.out.println("_______________________________________________");
                } else {
                    System.out.println("Displayed BROKEN");
                    System.out.println("_______________________________________________");
                }
            } catch (Exception e) {
                System.out.println("ERROR");

            }
        }
        return this;
    }
}

