package com.exam.testTask.fw;

import com.exam.testTask.modells.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemFilterHelper extends HelperBase {

    public ItemFilterHelper(WebDriver wd){
        super(wd);
    }

    public String getItemNameFromListByOrder(int number) {
       // return wd.findElement(By.xpath("//*[@data-autotest-id='product-snippet']["+ number +"]//h3")).getText();
       // return wd.findElement(By.xpath("//div[@class='_2Qo3ODl0by _1eVTqI-ogb cia-vs']/article["+ number +"]")).getText();
       return wd.findElement(By.xpath("//div[@class='_2Qo3ODl0by _1eVTqI-ogb cia-vs']/article["+ number +"]/div[4]//h3")).getText();
    }

    public void filterItem(Item item) {
        click(By.cssSelector("[href='/catalog--"+ item.getItemType() +"']"));


        // click(By.cssSelector("[data-id='button-all']"));
        //to move page down
//        Actions actions = new Actions(wd);
//        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        type(By.cssSelector("#glpricefrom"), item.getPriceFrom());
        type(By.cssSelector("#glpriceto"), item.getPriceTo());
        click(By.xpath("//span[text()='"+ item.getBrand() +"']"));
    }
}
