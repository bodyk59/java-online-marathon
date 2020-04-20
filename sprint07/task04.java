/*
 * Create a LineType enum that contains different kind of lines as constants SOLID, DOTTED, DASHED and DOUBLE.
 * Write a method that takes the constant of LineType type as input,
 * and returns the message “The line is <LineType> type”.
 * Where <LineType>  is name of type wrote in lower case. For example: "The line is dotted type".
 */

/**
 * @author Bogdan Kurchak
 */
static enum LineType {
    SOLID, DOTTED, DASHED, DOUBLE;
}

// Longer variant:
//    public static String drawLine(LineType lineType) {
//        String result = "";
//        switch (lineType) {
//            case SOLID:
//                result = "solid";
//                break;
//            case DOTTED:
//                result = "dotted";
//                break;
//            case DASHED:
//                result = "dashed";
//                break;
//            case DOUBLE:
//                result = "double";
//                break;
//        }
//        return "The line is " +  result + " type";
//    }

// Shorter variant:
public static String drawLine(LineType lineType) {
    return "The line is " +  lineType.name().toLowerCase() + " type";
}
