package web.config.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class CarServiceImp implements CarService {
    private List <Car> cars;
    {
        cars = new ArrayList<>();
        cars.add(new Car("Ford","Focus",2013));
        cars.add(new Car("Jeep","Grand Cherokee",2020));
        cars.add(new Car("Mustang","Shelby",2019));
        cars.add(new Car("Vaz","2107",1999));
        cars.add(new Car("Tesla","ModelX",2020));
    }



    @Override
    public List<Car> getCountCar(Integer count) {
        if (count == null) {
            count = 5;
        }
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
