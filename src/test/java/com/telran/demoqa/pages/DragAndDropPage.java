package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends PageBase {
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "draggable")
    WebElement dragMe;

    @FindBy(id = "droppable")
    WebElement dropHere;

    public DragAndDropPage actionDragMe() { // перетаскивае один элеент в другой

        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMe, dropHere).build().perform();

        String text = dropHere.getText();
        if (text.equals("Dropped!")) {
            System.out.println("****   PASS: Sourse is dropped to target as expected");
        } else {
            System.out.println("**** FAIL:  Sourse couldn't be dropped to target as expected");
        }
        return this;
    }

    public DragAndDropPage dragAndDropBy() { //перетаскиваем с координатами
        Actions actions = new Actions(driver);
        int x = dragMe.getLocation().getX();
        int y = dragMe.getLocation().getY();
        System.out.println("**** x = " + x + " y = " + y);

        int xOffset = dropHere.getLocation().getX();
        int yOffset = dropHere.getLocation().getY();
        System.out.println("**** xOffset = " + xOffset + " yOffset = " + yOffset);

        xOffset = (xOffset - x) + 50;
        yOffset = (yOffset - y) + 100;
        pause(1000);
        actions.dragAndDropBy(dragMe, xOffset, yOffset).build().perform();

        String text = dropHere.getText();
        if (text.equals("Dropped!")) {
            System.out.println("****   PASS: Sourse is dropped to target as expected");
        } else {
            System.out.println("**** FAIL:  Sourse couldn't be dropped to target as expected");
        }
        return this;
    }

    public DragAndDropPage dragAndDropBy100() {
        Actions actions = new Actions(driver);
        pause(1000);
        actions.dragAndDropBy(dragMe, 100, 100).build().perform();
        return this;
    }


}
