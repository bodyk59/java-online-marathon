/*
 * 1. Create an instances of Employee class named 'emp1' and 'emp2'.
 * 2. Set values for 'fullName' and 'salary' properties.
 * 3. Create array of Employee type with name 'employees' and add two objects created before.
 * 4. Create variable with name 'employeesInfo' of String type.
 * 5. Using a loop, iterrate across array and write to 'employeesInfo' info about employee.
 */
 
/**
 * @author Bogdan Kurchak
 */
class Employee {
    public String fullName;
    public float salary;
}

class Main {
  Employee emp1 = new Employee();
  emp1.fullName = "Kurchak Bogdan";
  emp1.salary = 10000f;

  Employee emp2 = new Employee();
  emp2.fullName = "Vasylenko Vasyl";
  emp2.salary = 10000f;

  Employee[] employees = {emp1, emp2};
  String employeesInfo = "[";

  for (int i = 0; i < employees.length; i++) {
      employeesInfo += "{fullName: \"" + employees[i].fullName +
                       "\", salary: " + employees[i].salary + "}";

      employeesInfo += (i != employees.length - 1) ? ", " : "]";
  }
}
