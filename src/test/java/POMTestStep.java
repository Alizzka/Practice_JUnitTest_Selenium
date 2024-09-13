import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class POMTestStep {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Инициализация WebDriver для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-mesto.praktikum-services.ru/");
    }

    @Test
    public void loginTest() throws InterruptedException {
        // создать объект класса страницы авторизации
        POMPageStep objLoginPage = new POMPageStep(driver);

        // Добавляем паузу, чтобы можно было увидеть тест в действии
        Thread.sleep(2000); // Задержка на 2 секунды

        // выполнить авторизацию
        objLoginPage.login("alizzka@mail.ru",
                "1234");

        // Добавляем паузу для наблюдения
        Thread.sleep(2000); // Задержка на 2 секунды
    }

    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }
}

