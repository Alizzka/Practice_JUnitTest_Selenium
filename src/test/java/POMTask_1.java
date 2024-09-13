/*Напиши автотест, который проверит, что после авторизации пользователя в заголовке
страницы появляется его email. Для этого создай page object для заголовка страницы.
Опиши в нём нужный элемент и метод с проверкой. Затем создай класс с тестом.
Используй в нём два метода:
  • метод, который ранее использовался для авторизации;
  •	свой новый метод.
Не забудь дождаться загрузки заголовка. Для этого используй готовый метод waitForLoadHeader() в
классе с заголовком.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Класс страницы авторизации
class POMTask_1 {

    private WebDriver driver;
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By signInButton = By.className("auth-form__button");

    public POMTask_1(WebDriver driver){
        this.driver = driver;
    }

    public void setUsername(String username) {
        driver.findElement(emailField).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void login(String username, String password){
        setUsername(username);
        setPassword(password);
        clickSignInButton();
    }
}

// Класс заголовка страницы
class HeaderPageMesto {

    private WebDriver driver;
    // Локатор для элемента с email в заголовке страницы
    private By headerUser = By.className("header__user");

    public HeaderPageMesto(WebDriver driver){
        this.driver = driver;
    }

    // Метод ожидания загрузки заголовка страницы
    public void waitForLoadHeader(){
        new WebDriverWait(driver, Duration.ofSeconds(10))  // Увеличил время ожидания до 10 секунд
                .until(ExpectedConditions.visibilityOfElementLocated(headerUser));
    }

    // Метод для получения текста элемента с email в заголовке
    public String emailInHeader() {
        return driver.findElement(headerUser).getText();
    }
}

