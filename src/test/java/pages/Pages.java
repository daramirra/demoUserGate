package pages;

import com.codeborne.selenide.Selenide;
import config.Project;
import io.qameta.allure.Step;
import pages.login.*;

public final class Pages {
    @Step("Открыть страницу с формой входа в Систему")
    public static UserGateAuthPage openAuthPage() {
        try {
            System.err.println("######## OPEN " + Project.config.baseUrl());
            Selenide.open(Project.config.baseUrl());
            return new UserGateAuthPage();
        }catch(RuntimeException e){
            e.printStackTrace();
            throw e;
        }
    }

}