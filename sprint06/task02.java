import java.math.BigDecimal;
import java.util.*;

/*
 * Create classes Employee (fields String name, int experience and BigDecimal basePayment) 
 * and Manager (field double coefficient) with methods which 
 * return the general working experience and payment for work done.
 * A getter methods of class Employee return value of all fields: getName(), getExperience() and getPayment().
 * Classes Manager is derived from class Employee 
 * and override getPayment() method to return multiplication of a coefficient and base payment.
 * Create a largestEmployees() method of the MyUtils class to return a List of unique employees 
 * with maximal working experience and payment without duplicate objects. The original list must be unchanged.
 * For example, for a given list
 * [Employee [name=Ivan, experience=10, basePayment=3000.00], 
 * Manager [name=Petro, experience=9, basePayment=3000.00, coefficient=1.5], 
 * Employee [name=Stepan, experience=8, basePayment=4000.00], 
 * Employee [name=Andriy, experience=7, basePayment=3500.00], 
 * Employee [name=Ihor, experience=5, basePayment=4500.00],
 * Manager [name=Vasyl, experience=8, basePayment=2000.00, coefficient=2.0]]
 * you should get
 * [Employee [name=Ivan, experience=10, basePayment=3000.00],
 * Manager [name=Petro, experience=9, basePayment=3000.00, coefficient=1.5], 
 * Employee [name=Ihor, experience=5, basePayment=4500.00]].
 */

/**
 * @author Bogdan Kurchak
 */
class Employee {
    private String name;
    private int experience;
    private BigDecimal basePayment;

    public Employee(String name, int experience, BigDecimal basePayment) {
        this.name = name;
        this.experience = experience;
        this.basePayment = basePayment;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public BigDecimal getPayment() {
        return basePayment;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getExperience() == employee.getExperience() &&
                Objects.equals(getName(), employee.getName()) &&
                Objects.equals(basePayment, employee.basePayment);
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getExperience();
        result = 31 * result + getPayment().intValue();
        return result;
    }

    @Override
    public String toString() {
        return "Employee [name=" + getName()
                + ", experience=" + getExperience()
                + ", basePayment=" + getPayment()
                + "]";
    }
}

class Manager extends Employee {
    private double coefficient;

    public Manager(String name, int experience, BigDecimal basePayment, double coefficient) {
        super(name, experience, basePayment);
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }

    @Override
    public BigDecimal getPayment() {
        return super.getPayment().multiply(BigDecimal.valueOf(getCoefficient()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Double.compare(manager.getCoefficient(), getCoefficient()) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = (int) (31 * result + getCoefficient());
        return result;
    }
    
    @Override
    public String toString() {
        return "Manager [name=" + super.getName()
                + ", experience=" + super.getExperience()
                + ", basePayment=" + super.getPayment()
                + ", coefficient=" + getCoefficient()
                + "]";
    }
}

public class MyUtils {
    public List<Employee> largestEmployees(List<Employee> workers) {
        List<Employee> copyWorkers = new ArrayList<>(workers);
        List<Employee> result = new ArrayList<>();

        copyWorkers.sort((employee1, employee2) 
                -> Integer.compare(employee2.getExperience(), employee1.getExperience()));
        
        for (int i = 0; i < copyWorkers.size(); i++) {
            if (!result.contains(copyWorkers.get(i))) {
                result.add(copyWorkers.get(i));
            }

            if (i + 1 != copyWorkers.size() 
                    && copyWorkers.get(i).getExperience() != copyWorkers.get(i + 1).getExperience()) {
                break;
            }
        }

        copyWorkers.removeAll(result);

        copyWorkers.sort((employee1, employee2)
                -> Integer.compare(employee2.getPayment().intValue(), employee1.getPayment().intValue()));

        for (int i = 0; i < copyWorkers.size(); i++) {
            if (!result.contains(copyWorkers.get(i))) {
                result.add(copyWorkers.get(i));
            }

            if (i + 1 != copyWorkers.size() 
                    && copyWorkers.get(i).getPayment().intValue() != copyWorkers.get(i + 1).getPayment().intValue()) {
                break;
            }
        }

        return result;
    }
}
