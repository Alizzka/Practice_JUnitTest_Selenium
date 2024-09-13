import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// Класс с автотестом
public class POMTest_2 {

    private WebDriver driver;

    @Test
    public void checkActivity() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        // переход на страницу тестового приложения
        driver.get("https://qa-mesto.praktikum-services.ru/");

        // создай объект класса страницы авторизации
        POMTask_2 objLoginPage = new POMTask_2(driver);
        // выполни авторизацию
        objLoginPage.login("alizzka@mail.ru",
                "1234");

        // создай объект класса главной страницы приложения
        HomePageMesto objHomePage = new HomePageMesto(driver);
        // дождись загрузки данных профиля на главной странице
        objHomePage.waitForLoadProfileData();

        // кликни на кнопку редактирования профиля
        objHomePage.clickOnEditActivityButton();

        // создай объект класса для поп-апа редактирования профиля;
        ProfilePageMesto objProfilePage = new ProfilePageMesto(driver);

        // это переменная со значением, которое надо ввести в поле «Занятие»
        String newActivity = "Тестировщик";
        // в одном шаге проверь, что поле «Занятие» доступно для редактирования, и введи в него новое значение
        objProfilePage.setActivity(newActivity);
        // сохрани изменения в профиле
        objProfilePage.clickSaveButton();

        // проверь, что поле «Занятие» на основной странице поменяло значение на новое
        objHomePage.waitForChangedActivity(newActivity);
    }


    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}