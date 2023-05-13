package pages;

import com.codeborne.selenide.Selenide;
import config.Project;
import io.qameta.allure.Step;
import pages.login.*;

public final class Pages {
    @Step("Открыть страницу с формой входа в Систему")
    public static UserGateAuthPage openAuthPage() {
        Selenide.open(Project.config.baseUrl());
        return new UserGateAuthPage();
    }

}