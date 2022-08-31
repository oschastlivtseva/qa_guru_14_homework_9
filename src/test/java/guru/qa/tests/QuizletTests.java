package guru.qa.tests;

import guru.qa.utils.Lang;
import guru.qa.utils.SubjectsTab;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class QuizletTests extends TestBase {

    @ValueSource(strings = {"", "settings", "explanations", "search", "subjects/other-flashcards"})
    @ParameterizedTest(name = "Login button should be visible in nav menu on page \"https://quizlet.com/{0}\"")
    void checkLoginButtonVisibility(String pageUrl) {
        open(pageUrl);
        $(".SiteNavLoginSection-loginButton").shouldBe(visible);
    }

    static Stream<Arguments> checkMainPageTextOnDifferentLang() {
        return Stream.of(
                Arguments.of(Lang.RU, "Достигайте лучших возможных результатов \n Шаг за шагом изучайте любой предмет"),
                Arguments.of(Lang.ES, "Saca lo mejor de ti para que nada te detenga \n Domina cualquier tema, de a uno a la vez."),
                Arguments.of(Lang.KO, "가장 거침없는 자기 자신이 되세요 \n 어떤 주제든 마스터, 한 번에 하나의 성공"),
                Arguments.of(Lang.NL, "Haal het beste uit jezelf \n Leer alle onderwerpen één voor één.")
        );
    }

    @MethodSource()
    @ParameterizedTest(name = "For locale \"{0}\" should be visible text \"{1}\"")
    void checkMainPageTextOnDifferentLang(Lang lang, String expectedText) {
        open("" + lang.getNotation());
        $(".PrismicHeroCarouselCard-text").shouldHave(text(expectedText));
    }

    @EnumSource()
    @ParameterizedTest(name = "Check subjects header text is changing by clicking tab \"{0}\"")
    void checkSubjectsHeaderText(SubjectsTab subjectsTab) {
        open("subjects/other-flashcards");
        $(".AssemblyTabs").$(byText(subjectsTab.getNotation())).click();
        $(".AssemblyBreadcrumbWrapper").sibling(0).shouldHave(text(subjectsTab.getNotation()));
    }
}
