package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CarController {
    @Autowired
    DealerRepository dealerRepository;
    @Autowired
    CarRepository carRepository;
   @Autowired
    CarDealerRepository carDealerRepository;

    @RequestMapping("/")
    public String index(Model model){
      model.addAttribute("cars",carRepository.findAll() );
      model.addAttribute("dealer", dealerRepository.findAll());
      model.addAttribute("cardealer",carDealerRepository );
       return "homepage";
    }
    @RequestMapping("/addcar")
    public String addcar(Model model)
    {

        model.addAttribute("dealer", dealerRepository.findAll());

        model.addAttribute("car", new Car());
        return "carform1";
    }
    @RequestMapping("/processcar")

    public String processForm(@ModelAttribute("car") Car car, Model model)
    {

        model.addAttribute("car", carRepository.findAll());
        return "redirect:/";
    }

    @RequestMapping("/update/{id}")
    public String updateCar(@PathVariable("id") long id, Model model){
        model.addAttribute("course", carRepository.findById(id).get());
        return "carform";}
    @RequestMapping("/delete/{id}")
    public String delCar(@PathVariable("id") long id){
        carRepository.deleteById(id);
        return "redirect:/";
    }
    @RequestMapping("/detail/{id}")

    public String showCar(@PathVariable("id") long id, Model model){
        model.addAttribute("car", carRepository.findById(id).get());
        return "show";
    }

}
