import com.codeborne.selenide.logevents.SelenideLogger;
import data.Data;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static data.Data.getRightUser;
import static data.Data.getWrongUser;

public class FinalTestCredit {

    @BeforeAll
    static void setUpALl() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    MainPage main = new MainPage();

    Data.User rightUser = getRightUser();

    Data.User wrongUser = getWrongUser();

    @Test
    void successCredit() {
        main.creditTest();
        main.testingBase(wrongUser);
        main.successPurchase();
    }

    @Test
    void failCredit() {
        main.creditTest();
        main.testingBase(wrongUser);
        main.failPurchase();
    }

    @Test
    void blankFieldCredit() {
        main.creditTest();
        main.blankField();
    }

    @Test
    void numberFormatPartialCredit() {
        main.creditTest();
        main.testingBase(rightUser);
        main.numberFormatPartial();
    }

    @Test
    void numberFormatEmptyCredit() {
        main.creditTest();
        main.testingBase(rightUser);
        main.numberFormatEmpty();
    }

    @Test
    void monthFormatPartialCredit() {
        main.creditTest();
        main.testingBase(rightUser);
        main.monthFormatPartial();
    }

    @Test
    void monthFormatEmptyCredit() {
        main.creditTest();
        main.testingBase(rightUser);
        main.monthFormatEmpty();
    }

    @Test
    void monthFormatZeroesCredit() {
        main.creditTest();
        main.testingBase(rightUser);
        main.monthFormatZeroes();
    }

    @Test
    void monthFormatOneCredit() {
        main.creditTest();
        main.testingBase(rightUser);
        main.monthFormatOne();
        main.successPurchase();
    }

    @Test
    void monthFormatTwoCredit() {
        main.creditTest();
        main.testingBase(rightUser);
        main.monthFormatTwo();
        main.successPurchase();
    }

    @Test
    void monthFormatElevenCredit() {
        main.creditTest();
        main.testingBase(rightUser);
        main.monthFormatEleven();
        main.successPurchase();
    }

    @Test
    void monthFormatTwelveCredit() {
        main.creditTest();
        main.testingBase(rightUser);
        main.monthFormatTwelve();
        main.successPurchase();
    }

    @Test
    void monthFormatThirteenCredit() {
        main.creditTest();
        main.testingBase(rightUser);
        main.monthFormatThirteen();
    }

    @Test
    void yearFormatPartialCredit() {
        main.creditTest();
        main.testingBase(rightUser);
        main.yearFormatPartial();
    }

    @Test
    void yearFormatEmptyCredit() {
        main.creditTest();
        main.testingBase(rightUser);
        main.yearFormatEmpty();
    }

    @Test
    void yearFormatPreviousCredit() {
        main.creditTest();
        main.testingBase(rightUser);
        main.yearFormatPrevious();
    }

    @Test
    void yearFormatNextCredit() {
        main.creditTest();
        main.testingBase(rightUser);
        main.yearFormatNext();
        main.successPurchase();
    }

    @Test
    void yearFormatFourCredit() {
        main.creditTest();
        main.testingBase(rightUser);
        main.yearFormatFour();
        main.successPurchase();
    }

    @Test
    void yearFormatFiveCredit() {
        main.creditTest();
        main.testingBase(rightUser);
        main.yearFormatFive();
        main.successPurchase();
    }

    @Test
    void yearFormatSixCredit() {
        main.creditTest();
        main.testingBase(rightUser);
        main.yearFormatSix();
    }

    @Test
    void nameFormatEmptyCredit() {
        main.creditTest();
        main.testingBase(rightUser);
        main.nameFormatEmpty();
    }

    @Test
    void codeFormatPartialCredit() {
        main.creditTest();
        main.testingBase(rightUser);
        main.codeFormatPartial();
    }

    @Test
    void codeFormatEmptyCredit() {
        main.creditTest();
        main.testingBase(rightUser);
        main.codeFormatEmpty();
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }
}
