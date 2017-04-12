package mobileoffice.controllers;

import mobileoffice.business.contracts.OptionsService;
import mobileoffice.business.contracts.data.OptionsDataService;
import mobileoffice.business.contracts.data.TariffDataService;
import mobileoffice.business.contracts.data.TariffOptionsRspDataService;
import mobileoffice.business.contracts.tariff.TariffService;
import mobileoffice.dao.entities.Options;
import mobileoffice.dao.entities.Tariff;
import mobileoffice.models.TariffModel;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by kisc on 4/3/2017.
 */
@Controller
@RequestMapping("/tariffs")
@Secured("ROLE_MANAGER")
public class TariffController {

    private OptionsService optionsService;
    private TariffOptionsRspDataService tariffOptionsRspDataService;
    private TariffService tariffService;
    private TariffDataService tariffDataService;
    private OptionsDataService optionsDataService;

    public TariffController(TariffDataService tariffDataService,
                            OptionsDataService optionsDataService,
                            OptionsService optionsService,
                            TariffOptionsRspDataService tariffOptionsRspDataService,
                            TariffService tariffService){
        this.tariffDataService = tariffDataService;
        this.optionsDataService = optionsDataService;
        this.optionsService = optionsService;
        this.tariffOptionsRspDataService = tariffOptionsRspDataService;
        this.tariffService = tariffService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) throws Exception {
        model.addAttribute("tariffs", tariffDataService.getAll());
        return "tariffs/tariff";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addGet(Model model) throws Exception {
        model.addAttribute("options", optionsDataService.getAll());
        model.addAttribute("addNew", true);
        return "tariffs/edit";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPost(TariffModel tariffModel) throws Exception {
        Tariff result = tariffService.addNewTariff(tariffModel);
        return "redirect:edit?id=" + result.getId();
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editPost(@RequestParam long id, Model model) throws Exception {
        List<Options> selectedOptions = tariffService.getSelectedOptions(id);
        model.addAttribute("options", optionsService.getAvailableOptions(selectedOptions));
        model.addAttribute("selectedOptions", selectedOptions);
        model.addAttribute("tariff", tariffDataService.getById(id));
        model.addAttribute("addNew", false);
        return "tariffs/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editPost(@RequestParam long id, TariffModel tariffModel, Model model) throws Exception {
        tariffService.updateTariff(id, tariffModel);
        List<Options> selectedOptions = tariffService.getSelectedOptions(id);
        model.addAttribute("options", optionsService.getAvailableOptions(selectedOptions));
        model.addAttribute("selectedOptions", selectedOptions);
        model.addAttribute("tariff", tariffDataService.getById(id));
        model.addAttribute("addNew", false);
        return "tariffs/edit";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteGet(@RequestParam long id) throws Exception {
        tariffService.delete(id);
        return "redirect:/tariffs";
    }


}
