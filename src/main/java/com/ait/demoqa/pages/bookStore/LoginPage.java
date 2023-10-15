package com.ait.demoqa.pages.bookStore;

import com.ait.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login")
    WebElement loginButton;

    public ProfilePage loginPositive(String uName, String pwd) {
        // когда тест падал из-за рекламы в футере
        typeWithJSExecutor(userName,uName, 0,200);
        //type(userName,uName);
        typeWithJSExecutor(password,pwd,0,100);
        //type(password,pwd);
        click(loginButton);

        return new ProfilePage(driver);
    }

    public LoginPage loginNegative(String uName, String pwd) {
        typeWithJSExecutor(userName,uName, 0,200);
        //type(userName,uName);
        type(password,pwd);
        click(loginButton);

        return this;
    }

    public LoginPage getLogin() {
        click(loginButton);
        return new LoginPage(driver);
    }
}


