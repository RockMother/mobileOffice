package mobileoffice.controllers;

import mobileoffice.business.contracts.ContractService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by kisc on 3/23/2017.
 */
@Controller
@RequestMapping("/contract")
public class ContractController {

    private ContractService contractService;

    public ContractController(ContractService contractService){
        this.contractService = contractService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model){
        model.addAttribute("contracts", contractService.getAll());
        return "contract";
    }
}
