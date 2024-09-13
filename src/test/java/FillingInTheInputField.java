import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

public class FillingInTheInputField {

    private WebDriver driver;

    // Инициализация драйвера перед каждым тестом
    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage"); // убрали "--headless"
        driver = new ChromeDriver(options);
    }

    //для отображения интерфейса (без "--headless")
    @Test
    public void test() throws InterruptedException {
        // Открыть страницу тестового стенда
        driver.get("https://qa-mesto.praktikum-services.ru/");

        // Найти поле "Email" и заполни его
        driver.findElement(By.id("email")).sendKeys("alizzka@mail.ru");
        // Найти поле "Пароль" и заполни его
        driver.findElement(By.id("password")).sendKeys("1234");
        // Найти кнопку "Войти" и кликни по ней
        driver.findElement(By.className("auth-form__button")).click();

        // Задержка на 5 секунд для визуальной проверки
        Thread.sleep(5000);
    }

    @After
    public void teardown() {
        // Закрыть браузер
        if (driver != null) {
            driver.quit();
        }
    }
}
