package pages;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import data.Data;
import org.openqa.selenium.Keys;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private static final Faker faker = new Faker(new Locale("en"));
    public void buyTest() {
        $("#root > div > button:nth-child(3) > span > span").click();
        $(withText("Оплата по карте")).shouldBe(visible);
    }

    public void creditTest() {
        $("#root > div > button.button.button_view_extra.button_size_m.button_theme_alfa-on-white > span > span").click();
        $(withText("Кредит по данным карты")).shouldBe(visible);
    }

    // выглядит очень уродливо. НО ЗАТО РАБОТАЕТ!

    public void testingBase(Data.User user) {
        $("#root > div > form > fieldset > div:nth-child(1) > span > span > span.input__box > input").setValue(user.getCard());
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input").setValue(user.getMonth());
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__box > input").setValue(user.getYear());
        $("#root > div > form > fieldset > div:nth-child(3) > span > span:nth-child(1) > span > span > span.input__box > input").setValue(user.getName());
        $("#root > div > form > fieldset > div:nth-child(3) > span > span:nth-child(2) > span > span > span.input__box > input").setValue(user.getCode());
    }

    public void successPurchase() {
        $("#root > div > form > fieldset > div:nth-child(4) > button").click();
        $(withText("Успешно")).shouldHave(visible, Duration.ofSeconds(15));
        $(".notification__content").shouldHave(Condition.text("Операция одобрена Банком."), Duration.ofSeconds(15)).shouldBe(Condition.visible);
    }

    public void failPurchase() {
        $("#root > div > form > fieldset > div:nth-child(4) > button").click();
        $(withText("Ошибка")).shouldHave(visible, Duration.ofSeconds(15));
        $(withText("Ошибка! Банк отказал в проведении операции.")).shouldHave(visible, Duration.ofSeconds(15));
    }

    public void blankField() {
        $("#root > div > form > fieldset > div:nth-child(4) > button").click();
        $(withText("Неверный формат")).shouldHave(visible, Duration.ofSeconds(15));
        $(withText("Поле обязательно для заполнения")).shouldHave(visible, Duration.ofSeconds(15));
    }

    public void numberFormatPartial() {
        $("#root > div > form > fieldset > div:nth-child(1) > span > span > span.input__box > input").sendKeys(Keys.CONTROL + "a");
        $("#root > div > form > fieldset > div:nth-child(1) > span > span > span.input__box > input").sendKeys(Keys.DELETE);
        $("#root > div > form > fieldset > div:nth-child(1) > span > span > span.input__box > input").setValue(faker.number().digits(15));
        $("#root > div > form > fieldset > div:nth-child(4) > button").click();
        $("#root > div > form > fieldset > div:nth-child(1) > span > span > span.input__sub").shouldHave(Condition.text("Неверный формат"), visible);
    }

    public void numberFormatEmpty() {
        $("#root > div > form > fieldset > div:nth-child(1) > span > span > span.input__box > input").sendKeys(Keys.CONTROL + "a");
        $("#root > div > form > fieldset > div:nth-child(1) > span > span > span.input__box > input").sendKeys(Keys.DELETE);
        $("#root > div > form > fieldset > div:nth-child(4) > button").click();
        $("#root > div > form > fieldset > div:nth-child(1) > span > span > span.input__sub").shouldHave(Condition.text("Неверный формат"), visible);
    }

    public void monthFormatPartial() {
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input").sendKeys(Keys.CONTROL + "a");
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input").sendKeys(Keys.DELETE);
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input").setValue(faker.number().digits(1));
        $("#root > div > form > fieldset > div:nth-child(4) > button").click();
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__sub").shouldHave(Condition.text("Неверный формат"), visible);
    }

    public void monthFormatEmpty() {
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input").sendKeys(Keys.CONTROL + "a");
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input").sendKeys(Keys.DELETE);
        $("#root > div > form > fieldset > div:nth-child(4) > button").click();
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__sub").shouldHave(Condition.text("Неверный формат"), visible);
    }

    public void monthFormatZeroes() {
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input").sendKeys(Keys.CONTROL + "a");
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input").sendKeys(Keys.DELETE);
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input").setValue("00");
        $("#root > div > form > fieldset > div:nth-child(4) > button").click();
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__sub").shouldHave(Condition.text("Неверно указан срок действия карты"), visible);
    }

    public void monthFormatOne() {
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input").sendKeys(Keys.CONTROL + "a");
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input").sendKeys(Keys.DELETE);
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input").setValue("01");
    }

    public void monthFormatTwo() {
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input").sendKeys(Keys.CONTROL + "a");
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input").sendKeys(Keys.DELETE);
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input").setValue("02");
    }

    public void monthFormatEleven() {
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input").sendKeys(Keys.CONTROL + "a");
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input").sendKeys(Keys.DELETE);
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input").setValue("11");
    }

    public void monthFormatTwelve() {
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input").sendKeys(Keys.CONTROL + "a");
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input").sendKeys(Keys.DELETE);
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input").setValue("12");
    }

    public void monthFormatThirteen() {
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input").sendKeys(Keys.CONTROL + "a");
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input").sendKeys(Keys.DELETE);
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input").setValue("13");
        $("#root > div > form > fieldset > div:nth-child(4) > button").click();
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__sub").shouldHave(Condition.text("Неверно указан срок действия карты"), visible);
    }

    public void yearFormatPartial() {
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__box > input").sendKeys(Keys.CONTROL + "a");
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__box > input").sendKeys(Keys.DELETE);
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__box > input").setValue(faker.number().digits(1));
        $("#root > div > form > fieldset > div:nth-child(4) > button").click();
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__sub").shouldHave(Condition.text("Неверный формат"), visible);
    }

    public void yearFormatEmpty() {
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__box > input").sendKeys(Keys.CONTROL + "a");
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__box > input").sendKeys(Keys.DELETE);
        $("#root > div > form > fieldset > div:nth-child(4) > button").click();
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__sub").shouldHave(Condition.text("Неверный формат"), visible);
    }

    public void yearFormatPrevious() {
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__box > input").sendKeys(Keys.CONTROL + "a");
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__box > input").sendKeys(Keys.DELETE);
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__box > input").setValue(new SimpleDateFormat("yy").format(faker.date().past(366, 365, TimeUnit.DAYS)));
        $("#root > div > form > fieldset > div:nth-child(4) > button").click();
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__sub").shouldHave(Condition.text("Истёк срок действия карты"), visible);
    }

    public void yearFormatNext() {
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__box > input").sendKeys(Keys.CONTROL + "a");
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__box > input").sendKeys(Keys.DELETE);
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__box > input").setValue(new SimpleDateFormat("yy").format(faker.date().future(366, 365, TimeUnit.DAYS)));
    }

    public void yearFormatFour() {
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__box > input").sendKeys(Keys.CONTROL + "a");
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__box > input").sendKeys(Keys.DELETE);
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__box > input").setValue(new SimpleDateFormat("yy").format(faker.date().future(1461, 1460, TimeUnit.DAYS)));
    }

    public void yearFormatFive() {
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__box > input").sendKeys(Keys.CONTROL + "a");
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__box > input").sendKeys(Keys.DELETE);
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__box > input").setValue(new SimpleDateFormat("yy").format(faker.date().future(1826, 1825, TimeUnit.DAYS)));
    }

    public void yearFormatSix() {
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__box > input").sendKeys(Keys.CONTROL + "a");
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__box > input").sendKeys(Keys.DELETE);
        $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__box > input").setValue(new SimpleDateFormat("yy").format(faker.date().future(2192, 2191, TimeUnit.DAYS)));
        $("#root > div > form > fieldset > div:nth-child(4) > button").click();
        $("#root > div > form > fieldset > div:nth-child(2) > span > span.input-group__input-case.input-group__input-case_invalid > span > span > span.input__sub").shouldHave(Condition.text("Неверно указан срок действия карты"), visible);
    }

    public void nameFormatEmpty() {
        $("#root > div > form > fieldset > div:nth-child(3) > span > span:nth-child(1) > span > span > span.input__box > input").sendKeys(Keys.CONTROL + "a");
        $("#root > div > form > fieldset > div:nth-child(3) > span > span:nth-child(1) > span > span > span.input__box > input").sendKeys(Keys.DELETE);
        $("#root > div > form > fieldset > div:nth-child(4) > button").click();
        $("#root > div > form > fieldset > div:nth-child(3) > span > span:nth-child(1) > span > span > span.input__sub").shouldHave(Condition.text("Поле обязательно для заполнения"), visible);
    }

    public void codeFormatPartial() {
        $("#root > div > form > fieldset > div:nth-child(3) > span > span:nth-child(2) > span > span > span.input__box > input").sendKeys(Keys.CONTROL + "a");
        $("#root > div > form > fieldset > div:nth-child(3) > span > span:nth-child(2) > span > span > span.input__box > input").sendKeys(Keys.DELETE);
        $("#root > div > form > fieldset > div:nth-child(3) > span > span:nth-child(2) > span > span > span.input__box > input").setValue(faker.number().digits(2));
        $("#root > div > form > fieldset > div:nth-child(4) > button").click();
        $("#root > div > form > fieldset > div:nth-child(3) > span > span:nth-child(2) > span > span > span.input__sub").shouldHave(Condition.text("Неверный формат"), visible);
    }

    public void codeFormatEmpty() {
        $("#root > div > form > fieldset > div:nth-child(3) > span > span:nth-child(2) > span > span > span.input__box > input").sendKeys(Keys.CONTROL + "a");
        $("#root > div > form > fieldset > div:nth-child(3) > span > span:nth-child(2) > span > span > span.input__box > input").sendKeys(Keys.DELETE);
        $("#root > div > form > fieldset > div:nth-child(4) > button").click();
        $("#root > div > form > fieldset > div:nth-child(3) > span > span:nth-child(2) > span > span > span.input__sub").shouldHave(Condition.text("Неверный формат"), visible);
    }
}
