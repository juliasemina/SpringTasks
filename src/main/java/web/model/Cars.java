package web.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cars {
    public List<Car> getCarsList() {
        List<Car> carsList = new ArrayList<>();
        carsList.add(new Car("Lada", 2001, 80));
        carsList.add(new Car("Opel", 2020, 160));
        carsList.add(new Car("BMV", 2011, 240));
        carsList.add(new Car("AUDI", 2021, 250));
        carsList.add(new Car("Skoda", 2016, 160));

        return carsList;
    }
}
