package tests.demo.logout;

import annotations.JiraIssue;
import annotations.JiraIssues;
import annotations.Layer;
import config.Project;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.Pages;
import pages.UserGateDemoAppPage;
import pages.login.UserGateAuthPage;
import tests.TestBase;

@Owner("dlapshinova")
@Tag("Demo")
@Feature("Выход из Системы")
public class UserGateDemoLogoutTests extends TestBase {

    private final String passwordValue = Project.config.accountPassword();
    private final String loginFormTitle = "Аутентификация";
    private final String expectedTitle = "Дашборд";
    private final String login = "demo";

    @Layer("Web")
    @Tags({@Tag("Web"), @Tag("UI")})
    @JiraIssues({@JiraIssue("HOMEWORK-698")})
    @Test
    @DisplayName("Выход из Системы")
    void logoutSuccessful() {
        UserGateAuthPage authPage = Pages.openAuthPage();
        authPage.checkLoginFormTitle(loginFormTitle);
        authPage.setLoginValue(login);
        authPage.setPasswordValue(passwordValue);
        authPage.clickEnterButton();
        UserGateDemoAppPage testAppPage = new UserGateDemoAppPage();
        testAppPage.checkDashBordTab(expectedTitle);
        testAppPage.clickLogoutButton();
        authPage.checkLoginFormTitle(loginFormTitle);
    }
}
