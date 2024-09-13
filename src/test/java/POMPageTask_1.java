/*Задание
Добавь в класс страницы локатор для кнопки «Регистрация». Поле назови registrationButton.
Используй два метода с этим локатором. Один — для нажатия на кнопку, второй — чтобы проверить,
есть ли на кнопке текст «Регистрация».*/

//обновленный код
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;

public class POMPageTask_1 {

    private WebDriver driver;
    // локатор поля ввода «Email»
    private By emailField = By.id("email");
    // локатор поля «Пароль»
    private By passwordField = By.id("password");
    // локатор кнопки входа в приложение
    private By signInButton = By.className("auth-form__button");
    // локатор кнопки «Регистрация»
    private By registrationButton = By.className("header__auth-link");

    // конструктор класса
    public POMPageTask_1(WebDriver driver) {
        this.driver = driver;
    }

    // метод проверяет, активна ли кнопка «Войти»
    public boolean checkSignInIsEnabled() {
        try {
            WebElement signInBtn = driver.findElement(signInButton);
            return signInBtn.isEnabled();
        } catch (Exception e) {
            fail("Не удалось найти кнопку «Войти»");
            return false;
        }
    }

    // метод кликает по кнопке «Войти»
    public void clickSignInButton() {
        try {
            driver.findElement(signInButton).click();
        } catch (Exception e) {
            fail("Не удалось кликнуть по кнопке «Войти»");
        }
    }

    // метод кликает по кнопке «Регистрация»
    public void clickRegistrationButton() {
        try {
            driver.findElement(registrationButton).click();
        } catch (Exception e) {
            fail("Не удалось кликнуть по кнопке «Регистрация»");
        }
    }

    // метод проверяет текст кнопки «Регистрация»
    public void checkTextRegistrationButton() {
        try {
            String actualText = driver.findElement(registrationButton).getText();
            assertEquals("Текст на кнопке «Регистрация» не соответствует ожидаемому", "Регистрация", actualText);
        } catch (Exception e) {
            fail("Не удалось получить текст кнопки «Регистрация»");
        }
    }
}


//первоначальный код
/*import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

public class POMPageTask_1 {

    private WebDriver driver;
    // локатор поля ввода «Email»
    private By emailField = By.id("email");
    // локатор поля «Пароль»
    private By passwordField = By.id("password");
    // локатор кнопки входа в приложение
    private By signInButton = By.className("auth-form__button");
    // локатор кнопки «Регистрация»
    private By registrationButton = By.className("header__auth-link");

    // конструктор класса
    public POMPageTask_1(WebDriver driver) {
        this.driver = driver;
    }

    // метод проверяет, активна ли кнопка «Войти»
    public boolean checkSignInIsEnabled() {
        return driver.findElement(signInButton).isEnabled();
    }

    // метод кликает по кнопке «Войти»
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    // метод кликает по кнопке «Регистрация»
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    // метод проверяет текст кнопки «Регистрация»
    public void checkTextRegistrationButton() {
        String actualText = driver.findElement(registrationButton).getText();
        assertEquals("Текст на кнопке «Регистрация» не соответствует ожидаемому", "Регистрация", actualText);
    }
}*/
