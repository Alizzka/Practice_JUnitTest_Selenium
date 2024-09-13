import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Before;
import java.time.Duration;

public class GetElementText {

    private WebDriver driver;

    // Для отображения интерфейса
    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://qa-mesto.praktikum-services.ru/");

        // Это блок авторизации
        driver.findElement(By.id("email")).sendKeys("alizzka@mail.ru");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.className("auth-form__button")).click();

        // Ожидание элемента с помощью WebDriverWait
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("header__user")));

        // Найди кнопку выхода и получи её текст
        String text = driver.findElement(By.className("header__logout")).getText();
        System.out.println("Текст кнопки: " + text);

        // Задержка для того, чтобы можно было увидеть результат
        Thread.sleep(5000);
    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}

