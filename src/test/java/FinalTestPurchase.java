import data.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static data.Data.getRightUser;
import static data.Data.getWrongUser;

public class FinalTestPurchase {
    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    MainPage main = new MainPage();

    Data.User rightUser = getRightUser();

    Data.User wrongUser = getWrongUser();

    @Test
    void successPurchase() {
        main.buyTest();
        main.testingBase(rightUser);
        main.successPurchase();
    }

    @Test
    void failPurchase() {
        main.buyTest();
        main.testingBase(wrongUser);
        main.failPurchase();
    }

    @Test
    void blankFieldPurchase() {
        main.buyTest();
        main.blankField();
    }

    @Test
    void numberFormatPartialPurchase() {
        main.buyTest();
        main.testingBase(rightUser);
        main.numberFormatPartial();
    }

    @Test
    void numberFormatEmptyPurchase() {
        main.buyTest();
        main.testingBase(rightUser);
        main.numberFormatEmpty();
    }

    @Test
    void monthFormatPartialPurchase() {
        main.buyTest();
        main.testingBase(rightUser);
        main.monthFormatPartial();
    }

    @Test
    void monthFormatEmptyPurchase() {
        main.buyTest();
        main.testingBase(rightUser);
        main.monthFormatEmpty();
    }

    @Test
    void monthFormatZeroesPurchase() {
        main.buyTest();
        main.testingBase(rightUser);
        main.monthFormatZeroes();
    }

    @Test
    void monthFormatOnePurchase() {
        main.buyTest();
        main.testingBase(rightUser);
        main.monthFormatOne();
        main.successPurchase();
    }

    @Test
    void monthFormatTwoPurchase() {
        main.buyTest();
        main.testingBase(rightUser);
        main.monthFormatTwo();
        main.successPurchase();
    }

    @Test
    void monthFormatElevenPurchase() {
        main.buyTest();
        main.testingBase(rightUser);
        main.monthFormatEleven();
        main.successPurchase();
    }

    @Test
    void monthFormatTwelvePurchase() {
        main.buyTest();
        main.testingBase(rightUser);
        main.monthFormatTwelve();
        main.successPurchase();
    }

    @Test
    void monthFormatThirteenPurchase() {
        main.buyTest();
        main.testingBase(rightUser);
        main.monthFormatThirteen();
    }

    @Test
    void yearFormatPartialPurchase() {
        main.buyTest();
        main.testingBase(rightUser);
        main.yearFormatPartial();
    }

    @Test
    void yearFormatEmptyPurchase() {
        main.buyTest();
        main.testingBase(rightUser);
        main.yearFormatEmpty();
    }

    @Test
    void yearFormatPreviousPurchase() {
        main.buyTest();
        main.testingBase(rightUser);
        main.yearFormatPrevious();
    }

    @Test
    void yearFormatNextPurchase() {
        main.buyTest();
        main.testingBase(rightUser);
        main.yearFormatNext();
        main.successPurchase();
    }

    @Test
    void yearFormatFourPurchase() {
        main.buyTest();
        main.testingBase(rightUser);
        main.yearFormatFour();
        main.successPurchase();
    }

    @Test
    void yearFormatFivePurchase() {
        main.buyTest();
        main.testingBase(rightUser);
        main.yearFormatFive();
        main.successPurchase();
    }

    @Test
    void yearFormatSixPurchase() {
        main.buyTest();
        main.testingBase(rightUser);
        main.yearFormatSix();
    }

    @Test
    void nameFormatEmptyPurchase() {
        main.buyTest();
        main.testingBase(rightUser);
        main.nameFormatEmpty();
    }

    @Test
    void codeFormatPartialPurchase() {
        main.buyTest();
        main.testingBase(rightUser);
        main.codeFormatPartial();
    }

    @Test
    void codeFormatEmptyPurchase() {
        main.buyTest();
        main.testingBase(rightUser);
        main.codeFormatEmpty();
    }
}
