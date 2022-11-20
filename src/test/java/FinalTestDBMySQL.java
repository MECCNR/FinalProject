import com.codeborne.selenide.logevents.SelenideLogger;
import data.Data;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.DBProgramsMySQL;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static data.Data.getRightUser;
import static data.Data.getWrongUser;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinalTestDBMySQL {

    @BeforeAll
    static void setUpALl() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @BeforeEach
    void setup() {
        open("http://localhost:8080");
        sql.clearTableSQL();
    }

    MainPage main = new MainPage();

    DBProgramsMySQL sql = new DBProgramsMySQL();

    Data.User rightUser = getRightUser();

    Data.User wrongUser = getWrongUser();

    @Test
    void successPurchaseSQL() {
        main.buyTest();
        main.testingBase(rightUser);
        main.successPurchase();
        String actual = sql.takeFromPurchaseSQL();
        String expected = "APPROVED";

        assertEquals(expected, actual);
    }

    @Test
    void failPurchaseSQL() {
        main.buyTest();
        main.testingBase(wrongUser);
        main.failPurchase();
        String actual = sql.takeFromPurchaseSQL();
        String expected = "DECLINED";

        assertEquals(expected, actual);
    }

    @Test
    void successCreditSQL() {
        main.creditTest();
        main.testingBase(rightUser);
        main.successPurchase();
        String actual = sql.takeFromCreditSQL();
        String expected = "APPROVED";

        assertEquals(expected, actual);
    }

    @Test
    void failCreditSQL() {
        main.creditTest();
        main.testingBase(wrongUser);
        main.failPurchase();
        String actual = sql.takeFromCreditSQL();
        String expected = "DECLINED";

        assertEquals(expected, actual);
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }
}
