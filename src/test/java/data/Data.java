package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Data {

    private static final Faker faker = new Faker(new Locale("en"));

    private static SimpleDateFormat monthFormat = new SimpleDateFormat("MM");

    private static SimpleDateFormat yearFormat = new SimpleDateFormat("yy");

    public static String genRightCardNumber() {
        String number1 = "4444444444444441";
        return number1;
    }

    public static String genWrongCardNumber() {
        String number2 = "4444444444444442";
        return number2;
    }

    public static Date genDate() {
        Date date = faker.date().future(43800, TimeUnit.HOURS);
        return date;
    }

    public static String genMonth(Date date) {
        String monthDate = monthFormat.format(date);
        return monthDate;
    }

    public static String genYear(Date date) {
        String yearDate = yearFormat.format(date);
        return yearDate;
    }

    public static String genName() {
        String name = faker.name().fullName();
        return name;
    }

    public static String genCode() {
        String code = faker.number().digits(3);
        return code;
    }

    public static User getRightUser() {
        Date date = genDate();
        return new User(genRightCardNumber(), genMonth(date), genYear(date), genName(), genCode());
    }

    public static User getWrongUser() {
        Date date = genDate();
        return new User(genWrongCardNumber(), genMonth(date), genYear(date), genName(), genCode());
    }

    @Value
    public static class User {
        private String card;
        private String month;
        private String year;
        private String name;
        private String code;
    }
}