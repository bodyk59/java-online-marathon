/*
 * Create a new version of the Employee class that correspond next principles:
 * 1. All class fields must be private.
 * 2. Get and set methods must be used to access the class fields.
 * 3. The class must have a constructors with and without parameters.
 */
 
/**
 * @author Bogdan Kurchak
 */
 class Employee {
    private String fullName;
    private float salary;
    
    public Employee() {
        
    }
    
    public Employee(String fullName, float salary) {
        this.fullName = fullName;
        this.salary = salary;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public String getFullName() {
        return this.fullName;
    }
    
    public void setSalary(float salary) {
        this.salary = salary;
    }
    
    public float getSalary() {
        return this.salary;
    }
}
