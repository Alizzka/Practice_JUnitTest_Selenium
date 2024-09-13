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

public class JumpToElement {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Создаём драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://qa-mesto.praktikum-services.ru/");

        // Блок авторизации
        driver.findElement(By.id("email")).sendKeys("alizzka@mail.ru");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.className("auth-form__button")).click();

        // Ждём, пока загрузится главная страница
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("header__user")));

        // Найди футер через поиск по названию тега и сохрани его в переменную element
        WebElement element = driver.findElement(By.tagName("footer")); // Поиск футера по тегу

        // Прокрути страницу до элемента
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

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


