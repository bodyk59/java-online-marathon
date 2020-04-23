import java.util.function.Predicate;
import java.util.Set;

/*
 * Please, implement a static method getPredicateFromSet in MyUtils class.
 * getPredicateFromSet should take a Set of predicates working with integers
 * as a parameter and return a predicate with the functionality of
 * all predicates in the set invoked and connected by logical AND.
 */

/**
 * @author Bogdan Kurchak
 */
class MyUtils{
    static Predicate getPredicateFromSet(Set<Predicate<Integer>> predicateSet) {
        Predicate<Integer> result = predicateSet.iterator().next();

        for (Predicate<Integer> predicate : predicateSet) {
            result = result.and(predicate);
        }

        return result;
    }
}
