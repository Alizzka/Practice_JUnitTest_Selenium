import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class POMLocatorDescription {

    private WebDriver driver;
    // локатор поля «Email»
    private By emailField = By.id("email");
    // локатор поля «Пароль»
    private By passwordField = By.id("password");
    // локатор кнопки входа в приложение
    private By signInButton = By.className("auth-form__button");
    // конструктор класса
    public POMLocatorDescription(WebDriver driver){
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
}