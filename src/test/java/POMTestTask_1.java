//код с новым введение данных для email вручную при каждом старте
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class POMTestTask_1 {

    private WebDriver driver;
    private POMPageTask_1 loginPage;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        // Создаём драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage"); // Убрали "--headless" для отображения UI
        driver = new ChromeDriver(options);
        driver.get("https://qa-mesto.praktikum-services.ru/");

        // Инициализация объекта страницы
        loginPage = new POMPageTask_1(driver);

        // Инициализация WebDriverWait для ожидания элементов
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testSignInButtonIsEnabled() {
        // Проверка, что кнопка "Войти" активна
        assertTrue("Кнопка «Войти» не активна", loginPage.checkSignInIsEnabled());
    }

    @Test
    public void testRegistrationButtonText() {
        // Проверка текста на кнопке «Регистрация»
        loginPage.checkTextRegistrationButton();
    }

    @Test
    public void testClickRegistrationButton() {
        // Нажимаем на кнопку регистрации
        loginPage.clickRegistrationButton();

        // Логика проверки, что произошло после нажатия
        String currentUrl = driver.getCurrentUrl();
        assertEquals("URL не изменился после нажатия на кнопку «Регистрация»", "https://qa-mesto.praktikum-services.ru/signup", currentUrl);

        // Ожидание появления формы регистрации (если она должна появиться на новой странице)
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))); // Замените по необходимости
        WebElement passwordInput = driver.findElement(By.name("password")); // Замените по необходимости
        WebElement registerButton = driver.findElement(By.xpath("//button[text()='Зарегистрироваться']")); // Замените по необходимости

        // Заполнение формы
        emailInput.sendKeys("skhhblvvv@mail.ru");
        passwordInput.sendKeys("1234");
        registerButton.click();

        // Ожидание появления попапа с подтверждением регистрации
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div[6]/div/form/div/p")));

        // Если попап имеет кнопку закрытия, можно добавить её закрытие здесь:
        WebElement closeButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[6]/div/form/button"));
        closeButton.click();

        // Ожидание появления кнопки добавления новой карточки после закрытия попапа
        WebElement addCardButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/main/section[1]/button")));
        assertTrue("Кнопка добавления новой карточки не отображается после успешной регистрации", addCardButton.isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

//первоначальный код
/*import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import static org.junit.Assert.assertEquals;

public class POMTestTask_1 {

    private WebDriver driver;
    private POMPageTask_1 loginPage;

    @Before
    public void setUp() {
        // Создаём драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage"); // Убрали "--headless" для отображения UI
        driver = new ChromeDriver(options);
        driver.get("https://qa-mesto.praktikum-services.ru/");

        // Инициализация объекта страницы
        loginPage = new POMPageTask_1(driver);
    }

    @Test
    public void testRegistrationButtonText() {
        // Проверка текста на кнопке «Регистрация»
        loginPage.checkTextRegistrationButton();
    }

    @Test
    public void testClickRegistrationButton() {
        // Проверка клика по кнопке «Регистрация»
        loginPage.clickRegistrationButton();

        // Логика проверки, что произошло после нажатия
        String currentUrl = driver.getCurrentUrl();
        assertEquals("URL не изменился после нажатия на кнопку «Регистрация»", "https://qa-mesto.praktikum-services.ru/signup", currentUrl);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}*/






