package codegym.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;
    private final By userNameTextBox = By.id("username");
    private final By passwordTextBox = By.id("password");
    private final By usernameHelp = By.id("userHelp");
    private final By passwordHelp = By.id("passHelp");
    private final By loginButton = By.id("loginBtn");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String userName, String password){
        driver.findElement(userNameTextBox).sendKeys(userName);
        driver.findElement(passwordTextBox).sendKeys(password);

        driver.findElement(loginButton).click();
    }

    public String getUserHelpText() {
        return driver.findElement(usernameHelp).getText();
    }


    public String getPasswordHelpText() {
        return driver.findElement(passwordHelp).getText();
    }
}
