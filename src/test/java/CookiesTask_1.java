import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CookiesTask_1 {
    private WebDriver driver;

    // Поля для данных теста
    private final String email;
    private final String password;
    private final boolean isLoggedIn;

    // Конструктор параметров
    public CookiesTask_1(String email, String password, boolean isLoggedIn) {
        this.email = email;
        this.password = password;
        this.isLoggedIn = isLoggedIn;
    }

    // Параметры для теста (учётка и несколько случайных)
    @Parameterized.Parameters
    public static Collection<Object[]> getCredentials() {
        return Arrays.asList(new Object[][] {
                {"alizzka@mail.ru", "1234", true},  // Рабочие данные
                {"qwerty@gmail.com", "Pw123456", false},  // Неверные данные
                {"email2@test.example", "password2", false}  // Неверные данные
        });
    }

    // Метод инициализации WebDriver
    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-mesto.praktikum-services.ru/");
    }

    @Test
    public void loginTest() {
        // Авторизация
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.className("auth-form__button")).click();

        // Проверка авторизации
        if (isLoggedIn) {
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.className("header__user")));
        }

        // Утверждение результата
        assertEquals(isLoggedIn, driver.findElements(By.cssSelector(".profile__image")).size() != 0);
    }

    // Метод закрытия браузера
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


