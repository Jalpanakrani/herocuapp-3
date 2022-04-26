package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class utility extends BaseTest {

        //This method on click on element
        public void clickOnElement(By by) {
            WebElement element = driver.findElement(by);
            driver.findElement(by).click();
        }
        //This method will get text from element
        public String getTextFromElement(By by) {
            return driver.findElement(by).getText();
        }
        //This method wii send text to email
        public void sendTextToElement(By by,String text){
            driver.findElement(by).sendKeys(text);
        }}

