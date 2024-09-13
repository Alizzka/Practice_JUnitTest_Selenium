import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Task_1 {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Создаём драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage"); // Убрали "--headless" для отображения UI
        driver = new ChromeDriver(options);
        driver.get("https://qa-mesto.praktikum-services.ru/");
    }

    @Test
    public void test() {
        // Выполни авторизацию
        driver.findElement(By.id("email")).sendKeys("alizzka@mail.ru");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.className("auth-form__button")).click();

        // Ждём, пока загрузится главная страница
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".profile__image")));

        // Кликни по изображению профиля
        driver.findElement(By.cssSelector(".profile__image")).click();

        // В поле ссылки на изображение введи ссылку
        WebElement imageInput = driver.findElement(By.id("owner-avatar"));
        imageInput.sendKeys("https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/avatarSelenium.png");

        // Сохрани новое изображение
        WebElement saveButton = driver.findElement(By.xpath(".//form[@name='edit-avatar']/button[text()='Сохранить']"));
        saveButton.click();
    }

    @After
    public void teardown() {
        // Закрой браузер
        if (driver != null) {
            driver.quit();
        }
    }
}
