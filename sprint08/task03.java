import java.util.function.BinaryOperator;
import java.util.ArrayList;
import java.util.List;

/*
 * Please, add to class App static BinaryOperator field greetingOperator.
 * greetingOperator should work with strings.
 * It forms a new string as a result by the rule: "Hello " + parameter1 +" " parameter2 + "!!!"
 * Create a static method createGreetings that takes two parameters: List<Person>
 * and BinaryOperator and generates List<String> as a result.
 * We should be able to pass greetingOperator as a parameter here.
 * Please, use the second parameter in creating the result.
 */

/**
 * @author Bogdan Kurchak
 */
class Person {
    String name;
    String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}

class App {
    static BinaryOperator<String> greetingOperator = (name, surname) -> "Hello " + name + " " + surname + "!!!";

    public static List<String> createGreetings(List<Person> people, BinaryOperator<String> binaryOperator){
        List<String> result = new ArrayList<>();
        people.forEach(person -> result.add(binaryOperator.apply(person.name, person.surname)));
        return result;
    }
}
