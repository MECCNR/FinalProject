import data.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.DBprogramPOSTGRE;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static data.Data.getRightUser;
import static data.Data.getWrongUser;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinalTestDBPostgre {
    @BeforeEach
    void setup() {
        open("http://localhost:8080");
        postgre.clearTablePOSTGRE();
    }

    MainPage main = new MainPage();

    DBprogramPOSTGRE postgre = new DBprogramPOSTGRE();

    Data.User rightUser = getRightUser();

    Data.User wrongUser = getWrongUser();

    @Test
    void successPurchasePostgre() {
        main.buyTest();
        main.testingBase(rightUser);
        main.successPurchase();
        String actual = postgre.takeFromPurchasePOSTGRE();
        String expected = "APPROVED";

        assertEquals(expected, actual);
    }

    @Test
    void failPurchasePostgre() {
        main.buyTest();
        main.testingBase(wrongUser);
        main.failPurchase();
        String actual = postgre.takeFromPurchasePOSTGRE();
        String expected = "DECLINED";

        assertEquals(expected, actual);
    }

    @Test
    void successCreditPostgre() {
        main.creditTest();
        main.testingBase(rightUser);
        main.successPurchase();
        String actual = postgre.takeFromCreditPOSTGRE();
        String expected = "APPROVED";

        assertEquals(expected, actual);
    }

    @Test
    void failCreditPostgre() {
        main.creditTest();
        main.testingBase(wrongUser);
        main.failPurchase();
        String actual = postgre.takeFromCreditPOSTGRE();
        String expected = "DECLINED";

        assertEquals(expected, actual);
    }
}
