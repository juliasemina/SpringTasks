package web.model;

import org.springframework.stereotype.Component;

@Component
public class Car {
    private String name;
    private Integer year;
    private Integer power;

    public Car() {
    }

    public Car(String model, Integer year, Integer power) {
        this.name = model;
        this.year = year;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }
}
