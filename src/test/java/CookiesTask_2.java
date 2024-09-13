import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.After;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

@RunWith(Parameterized.class)
public class CookiesTask_2 {
    private WebDriver driver; // Поле для WebDriver
    private final String cityName;
    private final boolean isVisible;

    public CookiesTask_2(String cityName, boolean isVisible) {
        this.cityName = cityName;
        this.isVisible = isVisible;
    }

    @Parameterized.Parameters
    public static Object[][] getCities() {
        // Сгенерируй тестовые данные (названия городов и результат поиска)
        return new Object[][] {
                {"Москва", true},
                {"Санкт-Петербург", true},
                {"Стамбул", false}

        };
    }

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-mesto.praktikum-services.ru/");
        // Выполни авторизацию. Укажи email и пароль своей учетной записи
        driver.findElement(By.id("email")).sendKeys("alizzka@mail.ru");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.className("auth-form__button")).click();
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("header__user")));
    }

    @Test
    public void citiesTest() {
        new WebDriverWait(driver, Duration.ofSeconds(30));
        // Найди карточку города по его названию
        List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@class,'card') and .//*[text()='" + cityName + "']]"));
        System.out.println("Проверяем город: " + cityName);
        // Проверь, что нашёлся хотя бы один нужный элемент
        assertEquals(isVisible, elements.size() > 0);

    }

    @After
    public void tearDown() {
        driver.quit();

    }
}


//код из задания спринта
/*import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.Assert.assertEquals;

import java.util.List;

@RunWith(Parameterized.class)
public class CookiesTask_2 {
    // Поля для параметризированного теста
    private final String cityName;
    private final boolean isVisible;

    public CookiesTask_2(String cityName, boolean isVisible) {
        this.cityName = cityName;
        this.isVisible = isVisible;
    }

    @Parameterized.Parameters
    public static Object[][] getCities() {
        // Тестовые данные: название городов и ожидаемый результат (найден или нет)
        return new Object[][]{
                {"Москва", true},
                {"Санкт-Петербург", true},
                {"Стамбул", false}
        };
    }

    @Test
    public void citiesTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://qa-mesto.praktikum-services.ru/");

        // Авторизация
        driver.findElement(By.id("email")).sendKeys("alizzka@mail.ru");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.className("auth-form__button")).click();
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("header__user")));

        // Выводим название города перед проверкой
        System.out.println("Проверяем город: " + cityName);
        new WebDriverWait(driver, Duration.ofSeconds(10));
        // Поиск карточки города по его названию
        List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@class,'card') and .//*[text()='" + cityName + "']]"));

        // Проверка, что хотя бы один элемент найден
        assertEquals(isVisible, elements.size() > 0);
        driver.quit();
    }
}*/

