package mobileoffice.controllers;

import base.controllers.BaseController;
import mobileoffice.business.contracts.ClientsService;
import mobileoffice.business.contracts.ContractService;
import mobileoffice.business.contracts.data.ClientDataService;
import mobileoffice.business.contracts.data.TariffDataService;
import mobileoffice.business.contracts.data.VContractWithTariffDataService;
import mobileoffice.dao.entities.Client;
import mobileoffice.models.NewClientModel;
import org.springframework.security.access.annotation.Secured;
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
@Secured("ROLE_MANAGER")
public class ClientsController extends BaseController {

    private ClientDataService clientDataService;
    private ContractService contractService;
    private VContractWithTariffDataService contractWithTariffDataService;
    private ClientsService clientsService;
    private TariffDataService tariffDataService;

    public ClientsController(ClientDataService clientDataService,
                             ContractService contractService,
                             VContractWithTariffDataService contractWithTariffDataService,
                             ClientsService clientsService,
                             TariffDataService tariffDataService){

        this.clientDataService = clientDataService;
        this.contractService = contractService;
        this.contractWithTariffDataService = contractWithTariffDataService;
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
        long id = clientsService.createClient(newClientModel);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam long id, Model model) throws Exception {
        Client client = clientDataService.getById(id);
        model.addAttribute("user", client);
        model.addAttribute("contracts", contractService.getClientContracts(client.getId()));
        model.addAttribute("tariffs", tariffDataService.getAll());
        return "clients/edit";
    }


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchByNumberPost(Model model) throws Exception {
        return "clients/search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchByNumberPost(@RequestParam String number, Model model) throws Exception {
        model.addAttribute("clients", clientsService.searchByNumber(number));
        return "clients/search";
    }
}
