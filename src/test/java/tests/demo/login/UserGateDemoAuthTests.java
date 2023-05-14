package tests.demo.login;

import annotations.JiraIssue;
import annotations.JiraIssues;
import annotations.Layer;
import com.github.javafaker.Faker;
import config.Project;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.UserGateDemoAppPage;
import pages.Pages;
import pages.login.UserGateAuthPage;
import tests.TestBase;

import static helpers.DriverUtils.getConsoleLogs;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Owner("dlapshinova")
@Tag("Demo")
@Feature("Вход в Систему")
public class UserGateDemoAuthTests extends TestBase {

    private final String passwordValue = Project.config.accountPassword();
    private final String loginFormTitle = "Аутентификация";
    private final String expectedTitle = "Дашборд";
    private final String errorMessage = "Неверное имя пользователя или пароль";
    private final String login = "demo";
    private final Faker faker = new Faker();

    @Layer("Web")
    @Tags({@Tag("Web"), @Tag("UI")})
    @JiraIssues({@JiraIssue("HOMEWORK-698")})
    @Test
    @DisplayName("Лог консоли браузера на странице входа в Систему не содержит ошибок")
    void consoleLogShouldNotHaveErrors() {
        Pages.openAuthPage();

        step("Страница входа в Систему не содержит ошибок в логах консоли браузера", () -> {
            String consoleLogs = getConsoleLogs();
            assertThat(consoleLogs).doesNotContain("SERVE");
        });
    }

    @Layer("Web")
    @Tags({@Tag("Web"), @Tag("UI")})
    @JiraIssues({@JiraIssue("HOMEWORK-698")})
    @Test
    @DisplayName("Успешный вход в Систему")
    void loginSuccessful() {
        UserGateAuthPage authPage = Pages.openAuthPage();
        authPage.checkLoginFormTitle(loginFormTitle);
        authPage.setLoginValue(login);
        authPage.setPasswordValue(passwordValue);
        authPage.clickEnterButton();
        UserGateDemoAppPage testAppPage = new UserGateDemoAppPage();
        testAppPage.checkDashBordTab(expectedTitle);
    }

    @Layer("Web")
    @Tags({@Tag("Web"), @Tag("UI")})
    @JiraIssues({@JiraIssue("HOMEWORK-698")})
    @Test
    @DisplayName("Попытка входа в Систему с неверным логином")
    void inputInvalidLoginShowErrorMessage() {
        UserGateAuthPage authPage = Pages.openAuthPage();
        authPage.checkLoginFormTitle(loginFormTitle);
        authPage.setLoginValue(login);
        authPage.setPasswordValue(faker.number().digits(6));
        authPage.clickEnterButton();
        authPage.checkErrorMessage(errorMessage);
    }

    @Layer("Web")
    @Tags({@Tag("Web"), @Tag("UI")})
    @JiraIssues({@JiraIssue("HOMEWORK-698")})
    @Test
    @DisplayName("Попытка входа в Систему с неверным паролем")
    void inputInvalidPwdShowErrorMessage() {
        UserGateAuthPage authPage = Pages.openAuthPage();
        authPage.checkLoginFormTitle(loginFormTitle);
        authPage.setLoginValue(faker.number().digits(6));
        authPage.setPasswordValue(passwordValue);
        authPage.clickEnterButton();
        authPage.checkErrorMessage(errorMessage);
    }

    @Layer("Web")
    @Tags({@Tag("Web"), @Tag("UI")})
    @JiraIssues({@JiraIssue("HOMEWORK-698")})
    @Test
    @DisplayName("Попытка входа в Систему с незаполненным полем \"Пароль\"")
    void passwordCouldNotBeEmpty() {
        UserGateAuthPage authPage = Pages.openAuthPage();
        authPage.checkLoginFormTitle(loginFormTitle);
        authPage.setLoginValue(login);
        authPage.clearPasswordValue();
        authPage.clickEnterButton();
        authPage.checkErrorMessage(errorMessage);
    }

    @Layer("Web")
    @Tags({@Tag("Web"), @Tag("UI")})
    @JiraIssues({@JiraIssue("HOMEWORK-698")})
    @Test
    @DisplayName("Попытка входа в Систему с незаполненным полем \"Логин\"")
    void loginCouldNotBeEmpty() {
        UserGateAuthPage authPage = Pages.openAuthPage();
        authPage.checkLoginFormTitle(loginFormTitle);
        authPage.clearLoginValue();
        authPage.setPasswordValue(passwordValue);
        authPage.clickEnterButton();
        authPage.checkErrorMessage(errorMessage);
    }

    @Layer("Web")
    @Tags({@Tag("Web"), @Tag("UI")})
    @JiraIssues({@JiraIssue("HOMEWORK-698")})
    @Test
    @DisplayName("Попытка входа в Систему с незаполненными полями \"Логин\", \"Пароль\"")
    void loginAndPwdCouldNotBeEmpty() {
        UserGateAuthPage authPage = Pages.openAuthPage();
        authPage.checkLoginFormTitle(loginFormTitle);
        authPage.clearLoginValue();
        authPage.clearPasswordValue();
        authPage.clickEnterButton();
        authPage.checkErrorMessage(errorMessage);
    }

    @Layer("Web")
    @Tags({@Tag("Web"), @Tag("UI")})
    @JiraIssues({@JiraIssue("HOMEWORK-698")})
    @Test
    @DisplayName("Попытка входа в Систему с указанием спецсимволов в поле Логин")
    void loginValueWithSpecialCharacters() {
        UserGateAuthPage authPage = Pages.openAuthPage();
        authPage.checkLoginFormTitle(loginFormTitle);
        authPage.setLoginValue("!№%?*()_-=+/\\.,~`@#$^&|{[]};':\"<>");
        authPage.setPasswordValue(passwordValue);
        authPage.clickEnterButton();
        authPage.checkErrorMessage(errorMessage);
    }

    @Layer("Web")
    @Tags({@Tag("Web"), @Tag("UI")})
    @JiraIssues({@JiraIssue("HOMEWORK-698")})
    @ParameterizedTest(name = "Попытка входа в Систему с неверным регистром значения в поле Логин [{0}]")
    @ValueSource(strings = {"Demo", "DEMO", "dEMO", "demO"})
    void inputWrongFormatLogin(String loginValue) {
        UserGateAuthPage authPage = Pages.openAuthPage();
        authPage.checkLoginFormTitle(loginFormTitle);
        authPage.setLoginValue(loginValue);
        authPage.setPasswordValue(passwordValue);
        authPage.clickEnterButton();
        authPage.checkErrorMessage(errorMessage);
    }

}
