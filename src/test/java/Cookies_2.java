import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class Cookies_2 {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Создаём драйвер для браузера Chrome в методе @Before
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-mesto.praktikum-services.ru/");
    }

    @Test
    public void test() {
        // Добавляем куку
        Cookie newCookie = new Cookie("my_first_cookie", "15");
        driver.manage().addCookie(newCookie);

        // Удаляем куку по имени
        driver.manage().deleteCookieNamed("my_first_cookie");

        // Добавляем куку снова с новым значением
        Cookie updatedCookie = new Cookie("my_first_cookie", "25");
        driver.manage().addCookie(updatedCookie);
    }

    @After
    public void teardown() {
        // Закрываем браузер в методе @After
        driver.quit();
    }
}


