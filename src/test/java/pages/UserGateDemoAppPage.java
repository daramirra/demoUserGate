package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;


public class UserGateDemoAppPage extends BasePage{

    @Step("Открыта страница приложения на вкладке '{value}'")
    public void checkDashBordTab(String value) {
        SelenideElement dashBordPanel = $("#main-content-panel");
        dashBordPanel.shouldBe(visible, Duration.ofSeconds(60));
        dashBordPanel.shouldHave(text(value));
    }
}
