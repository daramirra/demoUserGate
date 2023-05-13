package pages.login;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import pages.BasePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
public class UserGateAuthPage extends BasePage {

    @Step("Открыта страница с формой входа, с заголовком '{value}'")
    public void checkLoginFormTitle(String value) {
        $(".x-panel-login-panel").shouldHave(text(value));
    }

    @Step("Заполнить поле 'Логин'")
    public void setLoginValue(String loginValue) {
        SelenideElement login = $("#textfield-1022-inputEl");
        login.sendKeys(Keys.CONTROL + "a");
        login.sendKeys(Keys.BACK_SPACE);
        login.setValue(loginValue);
    }

    @Step("Заполнить поле 'Пароль'")
    public void setPasswordValue(String loginValue) {
        SelenideElement password = $("#textfield-1024-inputEl");
        password.sendKeys(Keys.CONTROL + "a");
        password.sendKeys(Keys.BACK_SPACE);
        password.setValue(loginValue);
    }

    @Step("Очистить поле 'Логин'")
    public void clearLoginValue() {
        SelenideElement login = $("#textfield-1022-inputEl");
        login.sendKeys(Keys.CONTROL + "a");
        login.sendKeys(Keys.BACK_SPACE);
    }

    @Step("Очистить поле 'Пароль'")
    public void clearPasswordValue() {
        SelenideElement password = $("#textfield-1024-inputEl");
        password.sendKeys(Keys.CONTROL + "a");
        password.sendKeys(Keys.BACK_SPACE);
    }

    @Step("Нажать кнопку 'Войти'")
    public void clickEnterButton() {
        $("#button-1028-btnInnerEl").click();
    }

    @Step("На странице с формой входа в Систему отображено сообщение об ошибке '{value}'")
    public void checkErrorMessage(String value) {
            $("#messagebox-1001").shouldHave(text(value));
        }
}
