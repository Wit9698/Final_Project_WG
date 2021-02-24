package pl.coderslab.agentInsurance.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.agentInsurance.model.Insurance;
import pl.coderslab.agentInsurance.repositories.ClientDao;
import pl.coderslab.agentInsurance.repositories.InsuranceDao;
import pl.coderslab.agentInsurance.repositories.VehicleDao;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/insurance")
public class InsuranceController {

    private InsuranceDao insuranceDao;
    private VehicleDao vehicleDao;
    private ClientDao clientDao;

    public InsuranceController(InsuranceDao insuranceDao, VehicleDao vehicleDao, ClientDao clientDao) {
        this.insuranceDao = insuranceDao;
        this.vehicleDao = vehicleDao;
        this.clientDao = clientDao;
    }

    @RequestMapping("/insuranceList")
    public String getAllInsurances(Model model) {
        model.addAttribute("insurances", insuranceDao.findAll());
        return "insurance/insuranceList";
    }

    @GetMapping("/addInsurance")
    public String showForm(Model model) {
        model.addAttribute("insurance", new Insurance());
        model.addAttribute("clients", clientDao.findAll());
        model.addAttribute("vehicles", vehicleDao.findAll());

        return "insurance/addInsurance";
    }

    @PostMapping("/addInsurance")
    public String performForm(@Valid Insurance insurance, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("clients", clientDao.findAll());
            model.addAttribute("vehicles", vehicleDao.findAll());
            return "insurance/addInsurance";
        }
        insuranceDao.saveInsurance(insurance);
        return "redirect:/insurance/insuranceList";
    }

    @RequestMapping("/deleteInsurance")
    public String delete(@RequestParam long id, Model model) {
        insuranceDao.delete(insuranceDao.findById(id));
        return "redirect:/insurance/insuranceList";
    }

    @RequestMapping(value = "/editInsurance", method = RequestMethod.GET)
    public String showEditForm(@RequestParam long id, Model model) {
        model.addAttribute("insurance", insuranceDao.findById(id));
        model.addAttribute("vehicles", vehicleDao.findAll());
        model.addAttribute("clients", clientDao.findAll());
        return "insurance/addInsurance";
    }


    @RequestMapping(value = "/editInsurance", method = RequestMethod.POST)
    public String saveEditForm(@Valid Insurance insurance, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("clients", clientDao.findAll());
            model.addAttribute("vehicles", vehicleDao.findAll());
            return "insurance/addInsurance";
        }
        insuranceDao.update(insurance);
        return "redirect:/insurance/insuranceList";
    }

    @ModelAttribute("types")
    public List<String> types() {
        return Arrays.asList("OC", "AC", "NWW", "Assistance");
    }
}
