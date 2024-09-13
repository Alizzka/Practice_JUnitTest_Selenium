import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task_2 {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Создаём драйвер для браузера Chrome перед выполнением теста
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-mesto.praktikum-services.ru/");
    }

    @Test
    public void test() {
        // Выполни авторизацию
        driver.findElement(By.id("email")).sendKeys("alizzka@mail.ru");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.className("auth-form__button")).click();

        // Ждём загрузки страницы
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("profile__image")));

        // Кликни по кнопке добавления нового контента
        driver.findElement(By.className("profile__add-button")).click();

        // В поле названия введи «Прага»
        driver.findElement(By.name("name")).sendKeys("Прага");

        // В поле ссылки на изображение введи ссылку
        driver.findElement(By.name("link")).sendKeys("https://code.s3.yandex.net/qa-automation-engineer/java/files/new_photo_selenium.jpg");

        // Сохрани контент
        driver.findElement(By.xpath(".//form[@name='new-card']/button[text()='Сохранить']")).click();

        // Дождись появления кнопки удаления карточки
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[@class='card__delete-button card__delete-button_visible']")));

        // Удали контент
        driver.findElement(By.xpath(".//button[@class='card__delete-button card__delete-button_visible']")).click();
    }

    @After
    public void teardown() {
        // Закрой браузер после выполнения теста
        if (driver != null) {
            driver.quit();
        }
    }
}


