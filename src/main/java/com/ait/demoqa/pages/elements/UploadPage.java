package com.ait.demoqa.pages.elements;

import com.ait.demoqa.pages.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class UploadPage extends BasePage {
    public UploadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"uploadFile\"]")
    WebElement uploadFile;

    //метод для работы в системе Windows
    public UploadPage performKeyEventUsingRobot() {
        pause(1000);

        clickWithRectangle(uploadFile,2,4);

        //создаем объект класса робот
        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        //нажимаем на Shift
        robot.keyPress(KeyEvent.VK_SHIFT);
        //нажимаем на d, а получим Shift+d = D(uppercase)
        robot.keyPress(KeyEvent.VK_D);
        //отпускаем SHIFT
        robot.keyRelease(KeyEvent.VK_SHIFT);
        pause(1000);
        //нажимаем на 1
        robot.keyPress(KeyEvent.VK_1);
        //нажимаем на .
        robot.keyPress(KeyEvent.VK_PERIOD);
        //нажимаем на t
        robot.keyPress(KeyEvent.VK_T);
        //нажимаем на x
        robot.keyPress(KeyEvent.VK_X);
        //нажимаем на t
        robot.keyPress(KeyEvent.VK_T);
        //нажать enter
        robot.keyPress(KeyEvent.VK_ENTER);

        return this;
    }
    //метод для работы в системе Windows/Mac
    @FindBy(id = "uploadedFilePath")//C:\fakepath\D1.txt
    WebElement uploadFilePath;
    public UploadPage assertPath(String path) {
        Assert.assertTrue(isTextPresent(uploadFilePath, path));
        return this;
    }

    public UploadPage performMouseEventUsingRobot() {
        pause(1000);

        clickWithRectangle(uploadFile,3,3);
        pause(1000);

        //создаем объект класса робот
        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        //найдем разрешение экрана
        Dimension dimension =  driver.manage().window().getSize();
        System.out.println("Display dimension: "
                + dimension.getWidth() + " Х "
                + dimension.getHeight());
        //ищем точку расположения файла
        int x = dimension.getWidth() / 9 + 30;
        int y = dimension.getHeight() / 6 + 190;
//3+270
        //двигаем мышкой по заданным координатам:
        robot.mouseMove(x,y);
        pause(1500);

        //кликаем-нажимаем левой кнопкой мыши на наведенный объект:
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        pause(1500);
        //кликаем-отпускаем левую кнопку мыши с наведенный объект:
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        pause(1500);

        robot.keyPress(KeyEvent.VK_ENTER);

        return this;
    }
}

