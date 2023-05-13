package pages;

import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;

public abstract class BasePage {

    @Step("Раскрыть меню пользователя и нажать кнопку 'Выход'")
    public void clickLogoutButton() {
        $("#entensys-logoutchooser-1029").click();
        $("#menuitem-1032-textEl").click();
    }

}
