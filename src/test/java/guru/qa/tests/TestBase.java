package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    @BeforeEach
    void configureBeforeTest() {
        Configuration.baseUrl = "https://quizlet.com/";
    }

    @AfterEach
    void configureAfterTest() {
        Selenide.clearBrowserCookies();
        Selenide.closeWebDriver();
    }
}
