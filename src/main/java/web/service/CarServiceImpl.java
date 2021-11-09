package web.service;

import web.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("carService")
public class CarServiceImpl implements CarService{

    private Car car;

    public CarServiceImpl() {
    }

    @Override
    public int countCars(List<Car> list) {
        return list.size();
    }

    @Autowired
    public void setCar(Car car) {
        this.car = car;
    }
}
