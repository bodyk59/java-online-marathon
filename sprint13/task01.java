/*
 * Write a method to convert date and time, represented via Date object to object of Calendar type.
 */

/**
 * @author Bogdan Kurchak
 */
public static Calendar convertDateToCalendar(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar;
}
