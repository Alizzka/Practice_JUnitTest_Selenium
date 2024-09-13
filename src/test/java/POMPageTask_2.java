/* Задание:
Тебе нужно протестировать страницу регистрации пользователя в приложении Mesto.
Класс страницы уже задан в коде — это RegistrationPageMesto. Опиши в page object три локатора: нужны поля для ввода email и пароля, кнопка регистрации.
Затем создай шаг. Объедини в нём:
заполнение поля email,
заполнение поля пароля,
клик по кнопке «Регистрация».
Пусть новый метод называется register*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class POMPageTask_2 {

    private WebDriver driver;
    // локатор поля «Email»
    private By emailField = By.id("email");
    // локатор поля «Пароль»
    private By passwordField = By.id("password");
    // локатор кнопки «Регистрация»
    private By signUpButton = By.className("header__auth-link");
    // конструктор класса
    public POMPageTask_2(WebDriver driver){
        this.driver = driver;
    }
    // метод заполняет поле «Email»
    public void setUsername(String username) {
        driver.findElement(emailField).sendKeys(username);
    }
    // метод заполняет поле «Пароль»
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    // метод кликает по кнопке «Регистрация»
    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }
    // метод регистрации в приложении: объединяет ввод email, пароля и клик по кнопке
    public void register(String username, String password){
        setUsername(username);
        setPassword(password);
        clickSignUpButton();
    }
}



