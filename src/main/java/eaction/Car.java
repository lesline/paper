package eaction;

import java.util.Optional;

/**
 * @author zhangshaolin
 * @create 2018/5/19
 */
public class Car {
    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }

    public void setInsurance(Optional<Insurance> insurance) {
        this.insurance = insurance;
    }
}