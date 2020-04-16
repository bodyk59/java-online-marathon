import java.util.*;

/*
 * Create classes Square and Rectang with method (double getPerimeter()) for calculating of perimeter.
 * Find solution for avoiding of duplicate code.
 * Create a double sumPerimeter(List<?> firures) method of the MyUtils class to return a sum perimeters of all figures.
 * For example, for a given list [[Square [width=4.00], Square [width=5.00], Rectang [height=2.00, width=3.00]]
 * you should get 46
 */

/**
 * @author Bogdan Kurchak
 */
abstract class Shape {
    private double width;

    public Shape(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public abstract double getPerimeter();
}

class Rectang extends Shape {
    private double height;

    public Rectang(double width, double height) {
        super(width);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (super.getWidth() + this.height);
    }

    @Override
    public String toString() {
        return "Rectang [height=" + height
                + ", width=" + super.getWidth()
                + "]";
    }
}

class Square extends Shape{
    public Square(double width) {
        super(width);
    }

    @Override
    public double getPerimeter() {
        return 4 * super.getWidth();
    }

    @Override
    public String toString() {
        return "Rectang [width=" + super.getWidth() + "]";
    }
}

public class MyUtils {
    public double sumPerimeter(List<?> firures) {
        double result = 0;

        for (Object shape : firures) {
            if (shape instanceof Rectang) {
                result += ((Rectang) shape).getPerimeter();
            }

            if (shape instanceof Square) {
                result += ((Square) shape).getPerimeter();
            }
        }

        return result;
    }
}
