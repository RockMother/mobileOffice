package mobileoffice.controllers;

import mobileoffice.business.contracts.data.ClientDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by kisc on 4/5/2017.
 */
@Controller
@RequestMapping("/clients")
public class ClientsController {

    private ClientDataService clientDataService;

    public ClientsController(ClientDataService clientDataService){

        this.clientDataService = clientDataService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) throws Exception {
        model.addAttribute("clients", clientDataService.getAll());
        return "clients/list";
    }
}
