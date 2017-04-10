package mobileoffice.controllers;

import mobileoffice.business.contracts.ClientsService;
import mobileoffice.business.contracts.data.ClientDataService;
import mobileoffice.business.contracts.data.TariffDataService;
import mobileoffice.dao.entities.Client;
import mobileoffice.models.NewClientModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by kisc on 4/5/2017.
 */
@Controller
@RequestMapping("/clients")
public class ClientsController {

    private ClientDataService clientDataService;
    private ClientsService clientsService;
    private TariffDataService tariffDataService;

    public ClientsController(ClientDataService clientDataService,
                             ClientsService clientsService,
                             TariffDataService tariffDataService){

        this.clientDataService = clientDataService;
        this.clientsService = clientsService;
        this.tariffDataService = tariffDataService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) throws Exception {
        model.addAttribute("clients", clientDataService.getAll());
        return "clients/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) throws Exception {
        model.addAttribute("tariffs", tariffDataService.getAll());
        return "clients/edit";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(NewClientModel newClientModel) throws Exception {
        Client result = clientsService.createClient(newClientModel);
        return "redirect:edit?id=" + result.getId();
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam long id, Model model) throws Exception {
        model.addAttribute("user", clientDataService.getById(id));
        return "clients/edit";
    }
}
