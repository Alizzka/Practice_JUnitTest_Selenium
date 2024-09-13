import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

public class ClickOnTheElement {

    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage"); // убрали "--headless"
        driver = new ChromeDriver(options);
    }

    //Для отображения интерфейса
    @Test
    public void test() throws InterruptedException {
        // Открыть страницу тестового стенда
        driver.get("https://qa-mesto.praktikum-services.ru/");

        // Найти кнопку и кликнуть по ней
        driver.findElement(By.xpath(".//button[text()='Войти']")).click();

        // Задержка на 5 секунд, чтобы увидеть клик
        Thread.sleep(5000);
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit(); // Закрыть браузер
        }
    }
}

//код без @before
    /*@Test
    public void test() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-mesto.praktikum-services.ru/");
        // Найди кнопку и кликни по ней
        driver.findElement(By.xpath(".//button[text()='Войти']")).click();
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}*/
