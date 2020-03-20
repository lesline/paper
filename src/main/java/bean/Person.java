package bean;

public class Person {
    String firstName;
    String lastName;

    volatile Integer age=1;
    volatile Integer grade=2;

    static void test() {

    }
    public void reset() {
        age = 1;
        grade = 2;
    }

    public void set2() {
        age = 3;
        grade = 4;
    }

    public int get() {
        return grade - age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public static void main(String[] args) {
        Person.test();
        ;
    }
}