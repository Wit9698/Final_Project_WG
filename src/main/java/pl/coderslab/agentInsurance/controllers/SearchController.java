package pl.coderslab.agentInsurance.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.agentInsurance.model.Client;
import pl.coderslab.agentInsurance.model.Insurance;
import pl.coderslab.agentInsurance.model.Vehicle;
import pl.coderslab.agentInsurance.repositories.ClientDao;
import pl.coderslab.agentInsurance.repositories.InsuranceDao;
import pl.coderslab.agentInsurance.repositories.VehicleDao;

@Controller
@RequestMapping("/search")
public class SearchController {


 private ClientDao clientDao;
 private InsuranceDao insuranceDao;
 private VehicleDao vehicleDao;

    public SearchController(ClientDao clientDao, InsuranceDao insuranceDao, VehicleDao vehicleDao) {
        this.clientDao = clientDao;
        this.insuranceDao = insuranceDao;
        this.vehicleDao = vehicleDao;
    }

    @GetMapping("/client")
    public String searchClient(Model model) {
        model.addAttribute("client", new Client());
        return "client/searchClient";
    }


    @PostMapping("/client")
    @ResponseBody
    public String searchClientPerform(@RequestParam String email, Client client) {
        return clientDao.findByEmail(email).toString();
    }

    @GetMapping("/insurance")
    public String searchInsurance(Model model) {
        model.addAttribute("insurance", new Insurance());
        return "insurance/searchInsurance";
    }


    @PostMapping("/insurance")
    @ResponseBody
    public String searchInsurancePerform(@RequestParam String insuranceNumber, Insurance insurance) {
        return insuranceDao.findByNumber(insuranceNumber).toString();
    }

    @GetMapping("/vehicle")
    public String searchVehicle(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "vehicle/searchVehicle";
    }


    @PostMapping("/vehicle")
    @ResponseBody
    public String searchVehiclePerform(@RequestParam String plateNumber, Vehicle vehicle) {
        return vehicleDao.findByPlate(plateNumber).toString();
    }
}




