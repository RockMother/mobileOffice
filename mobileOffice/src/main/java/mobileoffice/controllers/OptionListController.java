package mobileoffice.controllers;


import mobileoffice.business.contracts.data.OptionsDataService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by kisc on 3/23/2017.
 */

@Controller
@RequestMapping("/options")
public class OptionListController {
    private final OptionsDataService service;

    public OptionListController(OptionsDataService service) {
        this.service = service;
    }

    @RequestMapping(method = {RequestMethod.GET})
    @Secured({"ROLE_USER"})
    public String get(Model model) throws Exception {
        model.addAttribute("options", this.service.getAll());
        return "options";
    }
}
