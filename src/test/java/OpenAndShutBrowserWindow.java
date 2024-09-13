import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

public class OpenAndShutBrowserWindow {

    private WebDriver driver;

    //Для отображения интерфейса
    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        // Инициализация драйвера в @Before
        driver = new ChromeDriver(options);
    }

    @Test
    public void test() {
        // Открыть страницу тестового стенда
        driver.get("https://qa-mesto.praktikum-services.ru/");

        // Пауза для того, чтобы можно было увидеть открытую страницу
        try {
            Thread.sleep(5000); // 5 секунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}

    /*@Test
    public void test() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        // Открой страницу тестового стенда
        driver.get("https://qa-mesto.praktikum-services.ru/");
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}*/