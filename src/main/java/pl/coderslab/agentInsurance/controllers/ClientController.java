package pl.coderslab.agentInsurance.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.agentInsurance.model.Client;
import pl.coderslab.agentInsurance.model.Vehicle;
import pl.coderslab.agentInsurance.repositories.ClientDao;
import pl.coderslab.agentInsurance.repositories.VehicleDao;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/client")
public class ClientController {

    private ClientDao clientDao;
    private VehicleDao vehicleDao;

    public ClientController(ClientDao clientDao, VehicleDao vehicleDao) {
        this.clientDao = clientDao;
        this.vehicleDao = vehicleDao;
    }

    @RequestMapping("/clientList")
    public String getAllClients(Model model) {
        model.addAttribute("clients", clientDao.findAll());
        return "client/clientList";
    }

    @GetMapping("/addClient")
    public String showClientForm(Model model) {
        model.addAttribute("client", new Client());
        return "client/addClient";
    }

    @PostMapping("/addClient")
    public String performClientForm(@Valid Client client, BindingResult result) {
        if (result.hasErrors()) {
            return "client/addClient";
        }
        clientDao.saveClient(client);
        return "redirect:/client/clientList";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam long id, Model model) {
        List<Vehicle> byClient = vehicleDao.findByClient(id);
        if (byClient.isEmpty()) {
            clientDao.delete(clientDao.findById(id));
        } else {
            return "redirect:/client/deleteInfo";
        }
        return "redirect:/client/clientList";
    }

    @RequestMapping("/deleteInfo")
    public String deleteInformation(Model model) {

        return "client/deleteInfo";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String showEditForm(@RequestParam long id, Model model) {
        model.addAttribute("client", clientDao.findById(id));
        return "client/addClient";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEditForm(@Valid Client client, BindingResult result) {
        if (result.hasErrors()) {
            return "client/addClient";
        }
        clientDao.update(client);
        return "redirect:/client/clientList";
    }

    @ModelAttribute("natio")
    public List<String> Nationality() {
        return Arrays.asList("Poland", "Germany", "France", "Spain", "Italy");
    }


}
