package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.config.service.CarServiceImp;

@Controller
@RequestMapping("/cars")
public class CarsController {
    private final CarServiceImp carServiceImp;

    public CarsController(CarServiceImp carServiceImp) {
        this.carServiceImp = carServiceImp;
    }

    @GetMapping()
    public String getCarList(ModelMap model, @RequestParam(value="count",required = false) Integer count) {
        model.addAttribute("auto","Car table");
        model.addAttribute("cars",carServiceImp.getCountCar(count));
        return "cars";
    }
}
