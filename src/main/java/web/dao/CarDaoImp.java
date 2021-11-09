package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

    @Override
    public List<Car> listCars() {
        List<Car> list = new ArrayList<>();

        list.add(new Car("Lada", 2001, 80));
        list.add(new Car("Opel", 2020, 160));
        list.add(new Car("BMV", 2011, 240));
        list.add(new Car("AUDI", 2021, 250));
        list.add(new Car("Skoda", 2016, 160));

        return list;
    }

}
