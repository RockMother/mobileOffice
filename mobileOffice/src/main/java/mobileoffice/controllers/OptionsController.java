package mobileoffice.controllers;

import base.controllers.BaseController;
import mobileoffice.business.contracts.OptionsService;
import mobileoffice.business.contracts.data.OptionsDataService;
import mobileoffice.dao.entities.Options;
import mobileoffice.models.OptionModel;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiril_000 on 11.04.2017.
 */
@Controller
@RequestMapping("/options")
@Secured("ROLE_MANAGER")
public class OptionsController extends BaseController {

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
        List<Options> selectedRequiredOptions = optionsService.getSelectedRequiredOptions(id);
        List<Options> selectedIncompatibleOptions = optionsService.getSelectedIncompatibleOptions(id);

        List<Options> allSelectedOptions = new ArrayList<>();
        allSelectedOptions.addAll(selectedRequiredOptions);
        allSelectedOptions.addAll(selectedIncompatibleOptions);

        List<Options> avaliableOptions =  optionsService.getAvailableOptions(id, allSelectedOptions);

        model.addAttribute("option", optionsDataService.getById(id));
        model.addAttribute("selectedRequiredOptions", selectedRequiredOptions);
        model.addAttribute("availableRequiredOptions",avaliableOptions);
        model.addAttribute("selectedIncompatibleOptions", selectedIncompatibleOptions);
        model.addAttribute("avaliableIncompatibleOptions", avaliableOptions);
        model.addAttribute("addNew", false);
        return "options/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String postEdit(Model model, OptionModel optionModel) throws Exception {
        model.addAttribute("option", optionsService.updateOptions(optionModel));
        model.addAttribute("addNew", false);
        return "redirect:/options/edit?id=" + optionModel.getId();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam long id) throws Exception {
        optionsService.delete(id);
        return "redirect:/options";
    }
}
