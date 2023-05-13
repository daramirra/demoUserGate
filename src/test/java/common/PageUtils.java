package common;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

public final class PageUtils {

    public static void clearInputValue(SelenideElement element) {
        element.sendKeys(Keys.CONTROL + "A");
        element.sendKeys(Keys.BACK_SPACE);
    }

    private PageUtils() {
    }
}
