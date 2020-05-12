/*
 * Write a method to get the name of last day of the given month in given year.
 * Use GregorianCalendar class to solve this exercise.
 * The name of day must corresponds next format: Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday.
 * If month isn't correct then name is "Wrong Month".
 */

/**
 * @author Bogdan Kurchak
 */
public static String lastDayOfMonth(int month, int year) {
    if (month < 0 || month > 11) {
        return "Wrong Month";
    }

    int[] amountOfDaysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    java.util.GregorianCalendar gregorianCalendar =
            new java.util.GregorianCalendar(year, month, amountOfDaysInMonth[month]);
    java.util.Date date = (gregorianCalendar).getTime();

    return new java.text.SimpleDateFormat("EEEE", java.util.Locale.US).format(date);
}
