package mobileoffice.controllers;

import mobileoffice.business.contracts.ClientsService;
import mobileoffice.business.contracts.ContractService;
import mobileoffice.models.security.UserDetailsImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by kisc on 4/11/2017.
 */
@Controller
@RequestMapping("/profile")
public class ClientProfileController {
    private ContractService contractService;

    public ClientProfileController(ContractService contractService){
        this.contractService = contractService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model, Principal principal) throws Exception {
        model.addAttribute("contracts", contractService.getUserContracts(((UserDetailsImpl) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getId()));
        return "profile/profile";
    }
}
