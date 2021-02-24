package pl.coderslab.agentInsurance.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.agentInsurance.model.Insurance;
import pl.coderslab.agentInsurance.model.Vehicle;
import pl.coderslab.agentInsurance.repositories.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/vehicle")
@Controller
public class VehicleController {

    private VehicleDao vehicleDao;
    private ClientDao clientDao;
    private BrandDao brandDao;
    private VehicleModelDao vehicleModelDao;
    private InsuranceDao insuranceDao;

    long x;
    String brand1;


    public VehicleController(VehicleDao vehicleDao, ClientDao clientDao, BrandDao brandDao, VehicleModelDao vehicleModelDao, InsuranceDao insuranceDao) {
        this.vehicleDao = vehicleDao;
        this.clientDao = clientDao;
        this.brandDao = brandDao;
        this.vehicleModelDao = vehicleModelDao;
        this.insuranceDao = insuranceDao;
    }

    @RequestMapping("/vehicleList")
    public String getAllClients(Model model) {
        model.addAttribute("vehicles", vehicleDao.findAll());
        return "vehicle/vehicleList";
    }

    @GetMapping("/addVehicle")
    public String addVehicleForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        model.addAttribute("clients", clientDao.findAll());
        model.addAttribute("brands", brandDao.findByI(x));
        model.addAttribute("models", vehicleModelDao.findByBrandId(x));
        return "vehicle/addVehicle";
    }

    @GetMapping("/addBrand")
    public String addBrandForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        model.addAttribute("brands", brandDao.findAll());
        return "vehicle/addBrand";
    }

    @PostMapping("/addBrand")
    public String performBrandForm(Vehicle vehicle) {
        x = vehicle.getVehicleModel().getBrand().getId();
        brand1 = vehicle.getVehicleModel().getBrand().getBrandName();
        return "redirect:/vehicle/addVehicle";
    }


    @PostMapping("/addVehicle")
    public String performVehicleForm(@Valid Vehicle vehicle, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("clients", clientDao.findAll());
            model.addAttribute("brands", brandDao.findByI(x));
            model.addAttribute("models", vehicleModelDao.findByBrandId(x));
            return "vehicle/addVehicle";
        }
        vehicleDao.saveVehicle(vehicle);
        return "redirect:/vehicle/vehicleList";
    }

    @RequestMapping("/deleteV")
    public String deleteVehicle(@RequestParam long id, Model model) {
        List<Insurance> byVehicle = insuranceDao.findByVehicle(id);
        if (byVehicle.isEmpty()) {
            vehicleDao.delete(vehicleDao.findById(id));
        } else {
            return "redirect:/vehicle/deleteInfoVehicle";
        }
        return "redirect:/vehicle/vehicleList";
    }

    @RequestMapping("/deleteInfoVehicle")
    public String deleteInformation(Model model) {

        return "vehicle/deleteInfoVehicle";
    }


    @RequestMapping(value = "/editV", method = RequestMethod.GET)
    public String showEditForm(@RequestParam long id, Model model) {
        model.addAttribute("vehicle", vehicleDao.findById(id));
        model.addAttribute("clients", clientDao.findAll());
        model.addAttribute("brands", brandDao.findAll());
        model.addAttribute("models", vehicleModelDao.findAll());
        return "vehicle/updateVehicle";
    }


    @RequestMapping(value = "/editV", method = RequestMethod.POST)
    public String saveEditForm(@Valid Vehicle vehicle, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("clients", clientDao.findAll());
            model.addAttribute("brands", brandDao.findByI(x));
            model.addAttribute("models", vehicleModelDao.findByBrandId(x));
            return "vehicle/updateVehicle";
        }
        vehicleDao.update(vehicle);
        return "redirect:/vehicle/vehicleList";
    }
    @ModelAttribute("types")
    public List<String> types() {
        return Arrays.asList("sedan", "vagon", "Coupe", "Hatchback", "Hybrid", "Minivan", "SUV", "Sports");
    }
    @ModelAttribute("categories")
    public List<String> categories() {
        return Arrays.asList("truck", "motorcycle", "bus", "car");
    }
}
