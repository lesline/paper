package eaction;

import java.util.Optional;

/**
 * @author zhangshaolin
 * @create 2018/5/19
 */
public class Person {
    private Optional<Car> car;


    public Optional<Car> getCar() {
        return car;
    }

    public void setCar(Optional<Car> car) {
        this.car = car;
    }
}