import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task_3 {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Создаём драйвер для браузера Chrome перед каждым тестом
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

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("places__list")));

        // Найди карточку контента и сделай скролл до неё
        WebElement element = driver.findElement(By.cssSelector(".places__item"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    @After
    public void teardown() {
        // Закрой браузер после теста
        if (driver != null) {
            driver.quit();
        }
    }
}

