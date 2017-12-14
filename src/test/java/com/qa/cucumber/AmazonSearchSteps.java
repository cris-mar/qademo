package com.qa.cucumber;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AmazonSearchSteps {
    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private Properties prop = new Properties();

    @Before
    public void before() {
        // System.setProperty("webdriver.chrome.driver", "C:\\Opt\\WebDriver\\chromedriver.exe");
        try {
            prop.load(new FileInputStream("config.properties"));
            System.setProperty("webdriver.chrome.driver", prop.getProperty("webdriver.chrome.driver"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, 10);
    }

    @After
    public void after() {
        driver.quit();
    }

    @Given("^Open Amazon site at '(.*?)'$")
    public void openSite(String url) {
        driver.navigate().to(url);
    }

    @When("^Enter the search term '(.*?)'$")
    public void queryProduct(String product) {
        driver.findElement(By.id("twotabsearchtextbox")).clear();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);
    }

    @And("^Click the Search button$")
    public void clickSearchButton() {
        driver.findElement(By.cssSelector("input.nav-input")).click();
    }

    @And("^Press Enter in the search field$")
    public void submitSearchQuery() {
        driver.findElement(By.name("site-search")).submit();
    }

    @And("^Order items by '(.*?)'$")
    public void sortSearchResults(String criteria) {
        new Select(driver.findElement(By.id("sort"))).selectByVisibleText(criteria);
        WebElement searchField = driver.findElement(By.xpath("//*[@id=\"centerPlus\"]/h3/span[1][contains(text(),\"Price: High to Low\")]"));
    }

    @And("^Item number (\\d+) is selected")
    public void selectItem(int itemNumber) {
        String xq = String.format("//li[@id='result_%d']/div/div/div/div[2]/div/div/a/h2", itemNumber - 1);
        WebElement searchField = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xq)));
        searchField.click();
    }

    @Then("^The model name (does contain|does not contain) '(.*?)'$")
    public void checkModelName(String selector, String criteria) {
        WebElement searchField = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='productTitle']")));
        if (selector.contains("does not contain")) {
            assertFalse(driver.findElement(By.xpath("//span[@id='productTitle']")).getText().contains(criteria));
        }
        if (selector.contains("does contain")) {
            assertTrue(driver.findElement(By.xpath("//span[@id='productTitle']")).getText().contains(criteria));
        }
    }
}
