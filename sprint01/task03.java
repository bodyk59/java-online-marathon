/**
 * @author Bogdan Kurchak
 */
class Century {
    public static int century(int year) {
        return (year % 100 == 0) ? (year / 100) : (year / 100 + 1);
    }
}
