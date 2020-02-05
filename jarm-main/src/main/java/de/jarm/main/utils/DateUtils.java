package de.jarm.main.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	
    public static String toString(LocalDate datum) {
        return datum.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static LocalDate toDate(String datum) {
        return LocalDate.parse(datum, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
	
}
