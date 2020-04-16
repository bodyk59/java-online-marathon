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
        return "Person [name=" + name + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

class Student extends Person implements Comparable<Student> {
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
    public int compareTo(Student student) {
        return Integer.compare(this.studyYears, student.studyYears);
    }

    @Override
    public String toString() {
        return "Student [name=" + super.getName()
                + ", studyPlace=" + studyPlace
                + ", studyYears=" + studyYears + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return studyYears == student.studyYears &&
                Objects.equals(studyPlace, student.studyPlace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studyPlace, studyYears);
    }
}

class Worker extends Person implements Comparable<Worker> {
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
    public int compareTo(Worker worker) {
        return Integer.compare(this.experienceYears, worker.experienceYears);
    }

    @Override
    public String toString() {
        return "Worker [name=" + super.getName()
                + ", workPosition=" + workPosition
                + ", experienceYears=" + experienceYears + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Worker worker = (Worker) o;
        return experienceYears == worker.experienceYears &&
                Objects.equals(workPosition, worker.workPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), workPosition, experienceYears);
    }
}

public class MyUtils {
    public List<Person> maxDuration(List<Person> personList) {
        List<Worker> worker = new ArrayList<>();
        List<Student> student = new ArrayList<>();

        for (Person person : personList) {
            if (person instanceof Student && !student.contains(person)) {
                student.add((Student) person);
            }

            if (person instanceof Worker && !worker.contains(person)) {
                worker.add((Worker) person);
            }
        }

        for (int i = 0; i < worker.size(); i++) {
            worker.remove(Collections.min(worker));
        }

        for (int i = 0; i < student.size(); i++) {
            student.remove(Collections.min(student));
        }

        List<Person> result = new ArrayList<>();
        result.addAll(worker);
        result.addAll(student);

        return result;
    }
}
