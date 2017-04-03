package mobileoffice.controllers;

import mobileoffice.business.contracts.RegistrationService;
import mobileoffice.models.RegistrationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by kiril_000 on 02.04.2017.
 */
@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String get(){
        return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute RegistrationModel registrationModel) throws Exception {
        registrationService.registerNewUser(registrationModel);
        return "redirect:index";
    }
}
