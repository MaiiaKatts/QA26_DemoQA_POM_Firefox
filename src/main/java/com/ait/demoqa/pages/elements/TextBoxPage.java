package com.ait.demoqa.pages.elements;

import com.ait.demoqa.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TextBoxPage extends BasePage {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "currentAddress")
    WebElement currentAddress;
    @FindBy(id = "permanentAddress")
    WebElement permanentAddress;
    public TextBoxPage keyBoardEvent() {
        Actions actions = new Actions(driver);
        typeWithJSExecutor(currentAddress,
                "Transilvania region",0,300);
        //выбираем действующий адрес с помощью CTRL(Windows)/CMD(MacBook) + A
        actions.keyDown(Keys.COMMAND);
        actions.sendKeys("a");
        actions.keyUp(Keys.COMMAND);
        actions.perform();
        //copy current address using CTRL(CMD) + C
        actions.keyDown(Keys.COMMAND);
        actions.sendKeys("c");
        actions.keyUp(Keys.COMMAND);
        actions.perform();
        //press TAB to switch focus to permanent address
        actions.sendKeys(Keys.TAB).perform();
        //вставить скопированный элемент в другое окно
        actions.keyDown(Keys.COMMAND);
        actions.sendKeys("v");
        actions.keyUp(Keys.COMMAND);
        actions.perform();
        return this;
    }


    public TextBoxPage assertTextEquals() {
        Assert.assertEquals(
                currentAddress.getText(), permanentAddress.getText());
        return this;
    }

}
