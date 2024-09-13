import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By; //импортировали класс By
import org.junit.Before;
import java.util.List;


public class FindAnElement {

    private WebDriver driver;

    // Инициализация драйвера перед каждым тестом
    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage"); // убрали "--headless" для отображения UI
        driver = new ChromeDriver(options);
    }

    //для отображения интерфейса и закрытия браузера после теста
    @Test
    public void test() {
        // Открытие страницы
        driver.get("https://qa-mesto.praktikum-services.ru/");

        // Найти один элемент и вывести атрибут alt изображения
        WebElement element = driver.findElement(By.xpath(".//img"));
        System.out.println("Alt атрибут изображения: " + element.getAttribute("alt"));
    }

    @Test
    public void tests() {
        // Открытие страницы
        driver.get("https://qa-mesto.praktikum-services.ru/");

        // Найти все кнопки и вывести их количество
        List<WebElement> elements = driver.findElements(By.xpath(".//button"));
        System.out.println("Количество кнопок на странице: " + elements.size());
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit(); // Закрыть браузер
        }
    }
}

/*@Test
    public void test() {
        //WebDriver driver = new ChromeDriver(); //создали драйвер
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-mesto.praktikum-services.ru/"); // открыли страницу

        WebElement element = driver.findElement(By.xpath(".//img")); // Для поиска одного элемента
        // Используем элемент, например, выводим его атрибут
        System.out.println("Alt атрибут изображения: " + element.getAttribute("alt"));
    }

    @Test
    public void tests() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-mesto.praktikum-services.ru/");

        List<WebElement> elements = driver.findElements(By.xpath(".//button"));
        // Используем список элементов, например, выводим количество кнопок на странице
        System.out.println("Количество кнопок на странице: " + elements.size());
    }
}*/


