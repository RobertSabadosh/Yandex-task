package com.exam.testTask.tests;

import com.exam.testTask.modells.Item;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchItemTest extends TestBase {

    @Test
    public void itemTest(){
        app.getSearch().isPopupWindowDisplayed();
        app.getSearch().goToMarket();
        app.getSearch().switchToNextTab();
        app.getSearch().selectElectronicDepartment();
        app.getItemFilter().filterItem(new Item().setItemType("smartfony/16814639/list?glfilter=4940921%3A13475069&hid=91491")
                .setPriceFrom("20000")
                .setPriceTo("35000")
                .setBrand("Apple"));
        app.getSearch().refresh();
        String itemName = app.getItemFilter().getItemNameFromListByOrder(2);
        System.out.println(itemName);
        app.getSearch().typeInSearchInputField(itemName);
        String foundItemName = app.getItemFilter().getItemNameFromListByOrder(2);
        System.out.println(foundItemName);
        Assert.assertEquals(foundItemName,itemName);

    }




}
