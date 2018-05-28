package eaction;

import java.util.Optional;

/**
 * @author zhangshaolin
 * @create 2018/5/19
 */
public class OptionTest {

    public static String getCarInsuranceName(Optional<Person> person) {

        return person.
                flatMap(Person::getCar).
                flatMap(Car::getInsurance).
                map(Insurance::getName).
                orElse("A");
    }


    public static void main(String[] args) {

        Person person = new Person();
        Car car = new Car();
        Insurance insurance = new Insurance();
        insurance.setName("zhangsan");
//        car.setInsurance(Optional.of(insurance));
        car.setInsurance(Optional.ofNullable(insurance));
        person.setCar(Optional.of(car));

        System.out.println(getCarInsuranceName(Optional.of(person)));

    }

}