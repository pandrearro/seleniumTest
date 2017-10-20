/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.test.junit;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Pandrearro
 */
public class NewEmptyJUnitTest {

    public NewEmptyJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.manateeclerk.org/PublicRecords/CourtRecordsSearch/tabid/57/Default.aspx");

        WebElement element = driver.findElement(By.linkText("Case / Filing Type"));
        element.click();

        Select element1 = new Select(driver.findElement(By.id("dnn_ctr484_Search_drpCaseType")));
        element1.selectByVisibleText("COUNTY CIVIL");

        Select element2 = new Select(driver.findElement(By.id("dnn_ctr484_Search_drpfilingType")));
        element2.selectByVisibleText("EVICTION ONLY AND DAMAGES $0-$500");

        WebElement element3 = driver.findElement(By.id("dnn_ctr484_Search_txtFrom_dateInput"));
        element3.sendKeys("9/01/2007");

        WebElement element4 = driver.findElement(By.id("dnn_ctr484_Search_txtTo_dateInput"));
        element4.sendKeys("10/31/2017");

        WebElement element5 = driver.findElement(By.id("dnn_ctr484_Search_cmdSearch"));
        element5.click();

        WebDriverWait w = new WebDriverWait(driver, 60);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("dnn_ctr484_Results_rgResults_ctl00")));

        WebElement elementTable = driver.findElement(By.id("dnn_ctr484_Results_rgResults_ctl00"));
        
        //Añadir navegación del paginador 
        
        List<WebElement> pager = elementTable.findElements(By.xpath("//*[@id='dnn_ctr484_Results_rgResults_ctl00']/thead/tr[1]/td/table/tbody/tr/td/div[3]/a[1]"));

        for (WebElement page : pager){
            
        page.click();
            
        List<WebElement> elementsTR = elementTable.findElements(By.xpath("//*[@id='dnn_ctr484_Results_rgResults_ctl00']/thead/tr[1]/td/table/tbody/tr"));
               
        for (WebElement label: elementsTR){
            label.findElement(By.xpath("//*[@id='dnn_ctr484_Results_rgResults_ctl00_ctl04_lnkCaseNumber']")).click();
            
            //driver.navigate().back();
        }    
        }
        
        
          
       
    }
}
