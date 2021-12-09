package com.telran.demoqa.tests;

import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.SidePanelPage;
import com.telran.demoqa.pages.ToolTipsPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ToolTipsTests extends TestBase{
    //обявляем страницы, которые будем использовать в тесте
    HomePage hPage;
    SidePanelPage sidePanel;
    ToolTipsPage toolTips;

    @BeforeMethod
    public void init(){ // инициализируем страницы
        hPage = PageFactory.initElements(driver, HomePage.class);
        sidePanel = PageFactory.initElements(driver,SidePanelPage.class);
        toolTips = PageFactory.initElements(driver,ToolTipsPage.class);
        hPage.getWidgets();
        sidePanel.selectToolTips();
    }

    @Test
    public void hoverToolTipsWithAttrTest(){
        toolTips.hoverToolTipsWithAttribute();
    }

    @Test
    public void toolTipsWithTextTest(){
        toolTips.hoverOnInputToSee();
    }

}
