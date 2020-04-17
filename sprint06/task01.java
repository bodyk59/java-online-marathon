import java.util.*;

/*
 * Create next types: Person (field String name), Student (fields String studyPlace, int studyYears)
 * and Worker (fields String workPosition, int experienceYears).
 * Classes Student and Worker are derived from class Person. All classes have getters to return fields.
 * Create a maxDuration() method of the MyUtils class to return
 * a list of Students with maximum duration of study and Workers with maximum experience.
 * For example, for a given list
 * [Person [name=Ivan], Student [name=Petro, studyPlace=University, studyYears=3],
 * Worker [name=Andriy, workPosition=Developer, experienceYears=12],
 * Student [name=Stepan, studyPlace=College, studyYears=4],
 * Worker [name=Ira, workPosition=Manager, experienceYears=8],
 * Student [name=Ihor, studyPlace=University, studyYears=4]]
 * you should get
 * [Worker [name=Andriy, workPosition=Developer, experienceYears=12],
 * Student [name=Stepan, studyPlace=College, studyYears=4],
 * Student [name=Ihor, studyPlace=University, studyYears=4]]
 */

/**
 * @author Bogdan Kurchak
 */
class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person [name=" + getName() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return name != null ? getName().hashCode() : 0;
    }
}

class Student extends Person {
    private String studyPlace;
    private int studyYears;

    public Student(String name, String studyPlace, int studyYears) {
        super(name);
        this.studyPlace = studyPlace;
        this.studyYears = studyYears;
    }

    public String getStudyPlace() {
        return studyPlace;
    }

    public int getStudyYears() {
        return studyYears;
    }

    @Override
    public String toString() {
        return "Student [name=" + super.getName()
                + ", studyPlace=" + getStudyPlace()
                + ", studyYears=" + getStudyYears() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        if (getStudyYears() != student.getStudyYears()) return false;
        return Objects.equals(getStudyPlace(), student.getStudyPlace());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getStudyPlace() != null ? getStudyPlace().hashCode() : 0);
        result = 31 * result + getStudyYears();
        return result;
    }
}

class Worker extends Person {
    private String workPosition;
    private int experienceYears;

    public Worker(String name, String workPosition, int experienceYears) {
        super(name);
        this.workPosition = workPosition;
        this.experienceYears = experienceYears;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    @Override
    public String toString() {
        return "Worker [name=" + super.getName()
                + ", workPosition=" + getWorkPosition()
                + ", experienceYears=" + getExperienceYears() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Worker worker = (Worker) o;
        if (getExperienceYears() != worker.getExperienceYears()) return false;
        return Objects.equals(getWorkPosition(), worker.getWorkPosition());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getWorkPosition() != null ? getWorkPosition().hashCode() : 0);
        result = 31 * result + getExperienceYears();
        return result;
    }
}

public class MyUtils {
    public List<Person> maxDuration(List<Person> personList) {
        List<Worker> worker = new ArrayList<>();
        List<Student> student = new ArrayList<>();

        for (Person person : personList) {
            if (person instanceof Student) {
                student.add((Student) person);
            }

            if (person instanceof Worker) {
                worker.add((Worker) person);
            }
        }
        worker.sort((worker1, worker2)
                -> Integer.compare(worker2.getExperienceYears(), worker1.getExperienceYears()));
        student.sort((student1, student2)
                -> Integer.compare(student2.getStudyYears(), student1.getStudyYears()));

        List<Person> result = new ArrayList<>();

        for (int i = 0; i < worker.size(); i++) {
            if (!result.contains(worker.get(i))) {
                result.add(worker.get(i));
            }

            if (i + 1 != worker.size()) {
                if (worker.get(i).getExperienceYears() != worker.get(i + 1).getExperienceYears()) {
                    break;
                } 
            }
            
        }

        for (int i = 0; i < student.size(); i++) {
            if (!result.contains(student.get(i))) {
                result.add(student.get(i));
            }

            if (i + 1 != student.size()) {
                if (student.get(i).getStudyYears() != student.get(i + 1).getStudyYears()) {
                    break;
                }
            }
        }

        return result;
    }
}
