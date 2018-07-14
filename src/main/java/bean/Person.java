package bean;

public class Person {
    String firstName;
    String lastName;


    static void test() {

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