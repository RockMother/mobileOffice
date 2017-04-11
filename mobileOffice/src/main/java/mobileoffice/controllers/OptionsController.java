package mobileoffice.controllers;

import mobileoffice.business.contracts.data.OptionsDataService;
import mobileoffice.business.contracts.OptionsService;
import mobileoffice.models.OptionModel;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by kiril_000 on 11.04.2017.
 */
@Controller
@RequestMapping("/options")
@Secured("ROLE_MANAGER")
public class OptionsController {

    private OptionsDataService optionsDataService;
    private OptionsService optionsService;

    public OptionsController(OptionsDataService optionsDataService,
                             OptionsService optionsService){
        this.optionsDataService = optionsDataService;
        this.optionsService = optionsService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) throws Exception {
        model.addAttribute("options", optionsDataService.getAll());
        return "options/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(Model model){
        model.addAttribute("addNew", true);
        return "options/edit";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postAdd(OptionModel optionModel) throws Exception {
        optionsService.createNewOptions(optionModel);
        return "redirect:/options";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam long id, Model model) throws Exception {
        model.addAttribute("option", optionsDataService.getById(id));
        model.addAttribute("addNew", false);
        return "options/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String postEdit(Model model, OptionModel optionModel) throws Exception {
        model.addAttribute("option", optionsService.updateOptions(optionModel));
        model.addAttribute("addNew", false);
        return "options/edit";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam long id) throws Exception {
        optionsService.delete(id);
        return "redirect:/options";
    }
}