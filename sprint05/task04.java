/*
 * Please, make refactoring of the code.
 * We know that adult  doesn't have childIDNumber child doesn't have passportNumber. 
 * Create a public constructor in each class to 
 * initialize all their fields (make the first parameter of type int).
 */

/**
 * @author Bogdan Kurchak
 */
class Person {
    int age;
    String name;
    String healthInfo;
    
    public Person(int age, String name, String healthInfo) {
        this.age = age;
        this.name = name;
        this.healthInfo = healthInfo;
    }
    
    public String getHealthStatus() {
        return this.name + " " + healthInfo; 
    }
}

class Child extends Person {
    String childIDNumber;
    
    public Child(int age, String name, String healthInfo, String childIDNumber) {
        super(age, name, healthInfo);
        this.childIDNumber = childIDNumber;
    }
}

class Adult extends Person {
    String passportNumber;
    
    public Adult(int age, String name, String healthInfo, String passportNumber) {
        super(age, name, healthInfo);
        this.passportNumber = passportNumber;
    }
}
