package eight;

/**
 * Created by zhangshaolin on 2018/1/16.
 */
public class PersonTest {
   static class Person {
        String firstName;
        String lastName;

        Person() {}

        Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

       public void test() {

       }

       @Override
       public String toString() {
           return firstName+" "+lastName;
       }
   }
    interface PersonFactory<P extends Person> {
        P create(String firstName, String lastName);
    }

    public static void main(String[] args) {
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
        System.out.println(person);
    }
}
