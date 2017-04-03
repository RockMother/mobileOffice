package mobileoffice.controllers;

import mobileoffice.business.contracts.data.VTariffWithOptionsDataService;
import mobileoffice.business.contracts.tariff.TariffService;
import mobileoffice.dao.contracts.OptionsRepository;
import mobileoffice.dao.entities.Tariff;
import mobileoffice.dao.entities.VTariffWithOptions;
import mobileoffice.models.TariffModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by kisc on 4/3/2017.
 */
@Controller
@RequestMapping("/tariffs")
public class TariffController {
    private VTariffWithOptionsDataService tariffWithOptionsDataService;
    private OptionsRepository optionsRepository;
    private TariffService tariffService;

    public TariffController(VTariffWithOptionsDataService tariffWithOptionsDataService,
                            OptionsRepository optionsRepository,
                            TariffService tariffService){
        this.tariffWithOptionsDataService = tariffWithOptionsDataService;
        this.optionsRepository = optionsRepository;
        this.tariffService = tariffService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) throws Exception {
        model.addAttribute("tariffs", tariffWithOptionsDataService.getAll());
        return "tariffs/tariff";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addGet(Model model) throws Exception {
        model.addAttribute("options", optionsRepository.getAll());
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
        VTariffWithOptions result = tariffWithOptionsDataService.getById(id);
        model.addAttribute("options", optionsRepository.getAll());
        model.addAttribute("tariffs", result);
        model.addAttribute("addNew", false);
        return "/tariffs/edit";
    }


}
