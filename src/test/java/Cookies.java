import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class Cookies {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Создаём драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    @Test
    public void test() {
        driver.get("https://qa-mesto.praktikum-services.ru/");
        // Добавляем куки
        Cookie newCookie = new Cookie("my_first_cookie", "15");
        driver.manage().addCookie(newCookie);
    }

    @After
    public void teardown() {
        // Закрываем браузер
        driver.quit();
    }
}
