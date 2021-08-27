package pl.uek.configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class DataTestGenerator {


    public static String getRandomTodayAndTimeWith(String name) {
        return getTodayAndTime() + "_" + name;
    }

    private static String getTodayAndTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        Date date = new Date();
        return dateFormat.format(date).toString();
    }

}