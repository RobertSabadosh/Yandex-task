package com.exam.testTask.fw;

import com.exam.testTask.fw.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchHelper extends HelperBase {

    public SearchHelper(WebDriver wd) {

        super(wd);

    }

    public void selectElectronicDepartment() {
        click(By.cssSelector("[href='/catalog--elektronika/54440']"));
    }

    public void goToMarket() {
        click(By.cssSelector("[data-id='market']"));
    }

    public void typeInSearchInputField(String itemName) {
        type(By.cssSelector("#header-search"),itemName);
        click(By.cssSelector("[type='submit']"));
    }


    public void isPopupWindowDisplayed() {

        if(wd.findElement(By.cssSelector(".sc-jSFkmK.jGLdVH")).isDisplayed())
        {
            click(By.cssSelector("[data-id='button-all']"));
        }
    }
}
