package web.service;

import web.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CarServiceImpl implements CarService{

    public CarServiceImpl() {
    }

    @Override
    public int countCars(List<Car> list) {
        return list.size();
    }

}
