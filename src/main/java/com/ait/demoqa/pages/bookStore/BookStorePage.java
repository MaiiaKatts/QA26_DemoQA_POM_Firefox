package com.ait.demoqa.pages.bookStore;

import com.ait.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class BookStorePage extends BasePage {

    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "login")
    WebElement loginButton;
    public LoginPage clickOnLoginButton() {
        click(loginButton);
        return new LoginPage(driver);
    }
    @FindBy(id = "searchBox")
    WebElement searchBox;
    public BookStorePage enterBookName(String book) {
        type(searchBox, book);
        return this;
    }

    @FindBy(xpath = "//span[@class='mr-2']/a")
    WebElement bookName;

    public BookStorePage verifyBookName(String book) {
        Assert.assertTrue(bookName.getText().contains(book));
        return this;
    }

    public BookStorePage selectBook() {//первая попавшаяся
        click(bookName);
        return this;
    }

    @FindBy(css = ".text-right.fullButton")
    WebElement addBookButton;

    public BookStorePage addToCollectionButton() {
        clickWithJSExecutor(addBookButton,0,600);
        pause(500);
        driver.switchTo().alert().accept();
        return this;
    }

    @FindBy(id = "delete-record-undefined")
    List<WebElement> bookList;

    @FindBy(id = "closeSmallModal-ok")
    WebElement okButton;

    public ProfilePage deleteBook() {
        bookList.get(0).click();
        pause(500);
        click(okButton);
        pause(500);
        driver.switchTo().alert().accept();

        return new ProfilePage(driver);
    }
}