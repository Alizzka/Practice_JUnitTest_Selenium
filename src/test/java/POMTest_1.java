import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.CoreMatchers.is;

// Класс с автотестом
public class POMTest_1 {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Настройка драйвера для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    @Test
    public void checkEmailInHeader() {
        // Переход на страницу тестового приложения
        driver.get("https://qa-mesto.praktikum-services.ru/");

        // Создали объект класса страницы авторизации
        POMTask_1 objLoginPage = new POMTask_1(driver);

        // Выполняем авторизацию
        String email = "alizzka@mail.ru";  // Укажите email учётной записи
        String password = "1234";        // Укажите пароль учётной записи
        objLoginPage.login(email, password);

        // Создали объект класса заголовка страницы
        HeaderPageMesto objHeaderPage = new HeaderPageMesto(driver);

        // Дождаться загрузки заголовка страницы
        objHeaderPage.waitForLoadHeader();

        // Получить текст элемента с email в заголовке
        String headerEmail = objHeaderPage.emailInHeader();

        // Логирование для отладки
        System.out.println("Email в заголовке: " + headerEmail);

        // Проверка, что email в заголовке совпадает с введённым email
        MatcherAssert.assertThat(headerEmail, is(email));
    }

    @After
    public void tearDown() {
        // Закрыть браузер
        if (driver != null) {
            driver.quit();
        }
    }
}
