package web.controller;

import web.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Cars;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    private CarService carService;
    private Cars cars;

    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        List<Car> carsList = cars.getCarsList();

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

    @Autowired
    public void setListCars(Cars cars) {
        this.cars = cars;
    }
}