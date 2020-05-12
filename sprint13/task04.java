import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 * Write a method to get the date n-years m-months and k-days after today using new DateTime API.
 * Return the obtained date in the format ISO_LOCAL_DATE.
 */

/**
 * @author Bogdan Kurchak
 */
public static String getDateAfterToday(int years, int months, int days) {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
    LocalDate localDate = LocalDate.now().plusYears(years).plusMonths(months).plusDays(days);
    return localDate.format(dateTimeFormatter);
}
