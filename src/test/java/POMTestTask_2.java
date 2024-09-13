import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class POMTestTask_2 {

    private WebDriver driver;
    private WebDriverWait wait;
    private POMPageTask_2 registrationPage;

    @Before
    public void setUp() {
        // Настройки драйвера для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage"); // Убрали "--headless" для отображения UI
        driver = new ChromeDriver(options);
        driver.get("https://qa-mesto.praktikum-services.ru/");

        // Инициализация страницы регистрации
        registrationPage = new POMPageTask_2(driver);

        // Инициализация WebDriverWait для ожидания элементов
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testSuccessfulRegistration() {
        // Данные для регистрации
        String email = "tesjyhfer@mail.ru";
        String password = "passwd123";

        // Выполнение регистрации через шаг register
        registrationPage.register(email, password);

    }

    @After
    public void tearDown() {
        // Закрытие браузера
        driver.quit();
    }
}






