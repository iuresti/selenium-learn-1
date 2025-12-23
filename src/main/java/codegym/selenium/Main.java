package codegym.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        System.out.println(driver.getTitle());

        WebElement searchBox = driver.findElement(By.name("q"));

        searchBox.sendKeys("Selenium WebDriver");

        searchBox.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));

        WebElement searchBox2 = driver.findElement(By.name("q"));

        searchBox2.sendKeys("Busqueda 2");

        driver.quit();

    }
}
