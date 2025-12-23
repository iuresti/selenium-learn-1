package codegym.tests;

import codegym.selenium.LoginPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @BeforeEach
    public void openLogin() {
        driver.get("C:/Proyectos/codegym/mod4/WebStaticPage/index.html");
    }

    @Test
    public void loginFailedDueToEmptyUserName() {
        // Given:
        LoginPage loginPage = new LoginPage(driver);

        // When:
        loginPage.login("", "unPassword");

        // Then:
        assertEquals("Por favor ingresa tu usuario", loginPage.getUserHelpText());
        assertEquals("", loginPage.getPasswordHelpText());
    }

    @Test
    public void loginFailedDueToEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("unUser", "");

        assertEquals("", loginPage.getUserHelpText());
        assertEquals("Por favor ingresa tu contraseña", loginPage.getPasswordHelpText());
    }

    @Test
    public void loginFailedDueToEmptyEntries() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("", "");

        assertEquals("Por favor ingresa tu usuario", loginPage.getUserHelpText());
        assertEquals("Por favor ingresa tu contraseña", loginPage.getPasswordHelpText());
    }

}
