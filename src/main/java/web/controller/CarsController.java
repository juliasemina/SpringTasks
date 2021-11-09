package web.controller;

import web.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    private CarService carService;

    public List<Car> getCarsList() {
        List<Car> carsList = new ArrayList<>();
        carsList.add(new Car("Lada", 2001, 80));
        carsList.add(new Car("Opel", 2020, 160));
        carsList.add(new Car("BMV", 2011, 240));
        carsList.add(new Car("AUDI", 2021, 250));
        carsList.add(new Car("Skoda", 2016, 160));

        return carsList;
    }

    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        List<Car> carsList = getCarsList();

        if (carsList.size() != 0) {
            int num = carService.countCars(carsList);

            if (count == null || count >= num) {
                model.addAttribute("carList", carsList);
            } else {
                List<Car> newCarsList = carsList.stream().limit(count).toList();
                model.addAttribute("carList", newCarsList);
            }
        }
        return "cars";
    }

    @Autowired
    public void setCar(CarService carService) {
        this.carService = carService;
    }
}