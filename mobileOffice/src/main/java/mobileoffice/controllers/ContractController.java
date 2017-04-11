package mobileoffice.controllers;

import mobileoffice.business.contracts.ContractService;
import mobileoffice.business.contracts.data.ContractOptionRspDataService;
import mobileoffice.business.contracts.data.OptionsDataService;
import mobileoffice.business.contracts.data.TariffDataService;
import mobileoffice.business.contracts.data.VContractWithTariffDataService;
import mobileoffice.dao.entities.Options;
import mobileoffice.dao.entities.VContractWithTariff;
import mobileoffice.models.EditContractModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by kisc on 4/10/2017.
 */
@Controller
@RequestMapping("/contract")
public class ContractController {
    private ContractService contractService;
    private VContractWithTariffDataService contractWithTariffDataService;
    private TariffDataService tariffDataService;
    private ContractOptionRspDataService contractOptionRspDataService;
    private OptionsDataService optionsDataService;

    public ContractController(ContractService contractService,
                              VContractWithTariffDataService contractWithTariffDataService,
                              TariffDataService tariffDataService,
                              ContractOptionRspDataService contractOptionRspDataService,
                              OptionsDataService optionsDataService
    ){
        this.contractService = contractService;

        this.contractWithTariffDataService = contractWithTariffDataService;
        this.tariffDataService = tariffDataService;
        this.contractOptionRspDataService = contractOptionRspDataService;
        this.optionsDataService = optionsDataService;
    }

    @RequestMapping(value = "/block", method = RequestMethod.GET)
    public String block(@RequestParam long id) throws Exception {
        contractService.blockContractByClient(id);
        return "redirect:/profile";
    }
    @RequestMapping(value = "/unblock", method = RequestMethod.GET)
    public String unblock(@RequestParam long id) throws Exception {
        contractService.unblockContractByClient(id);
        return "redirect:/profile";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEditContract(Model model, @RequestParam long id) throws Exception {
        VContractWithTariff contract = contractWithTariffDataService.getById(id);
        List<Options> selectedOptions = contractService.getContractOptions(contract.getId());
        model.addAttribute("contract", contract);
        model.addAttribute("options", contractService.getAvailableOptions(id, selectedOptions));
        model.addAttribute("selectedOptions", selectedOptions);
        model.addAttribute("tariffs", tariffDataService.getAll());
        return "profile/contract";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String postEditContract(EditContractModel editContractModel) throws Exception {
        contractService.updateContractData(editContractModel);
        return "redirect:/contract/edit?id=" + editContractModel.getId();
    }




}
