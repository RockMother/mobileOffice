package mobileoffice.controllers;

import mobileoffice.business.contracts.ClientsService;
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
    private ClientsService clientsService;

    public ClientProfileController(ClientsService clientsService){
        this.clientsService = clientsService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model, Principal principal) throws Exception {
        model.addAttribute("contracts", clientsService.getContracts(((UserDetailsImpl) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getId()));
        return "profile/profile";
    }
}
