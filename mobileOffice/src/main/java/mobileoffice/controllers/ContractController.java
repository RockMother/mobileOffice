package mobileoffice.controllers;

import base.controllers.BaseController;
import mobileoffice.business.contracts.ContractService;
import mobileoffice.business.contracts.data.ContractOptionRspDataService;
import mobileoffice.business.contracts.data.OptionsDataService;
import mobileoffice.business.contracts.data.TariffDataService;
import mobileoffice.business.contracts.data.VContractWithTariffDataService;
import mobileoffice.dao.entities.VContractWithTariff;
import mobileoffice.models.EditContractModel;
import mobileoffice.models.security.UserDetailsImpl;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

/**
 * Created by kisc on 4/10/2017.
 */
@Controller
@RequestMapping("/contract")
public class ContractController extends BaseController {
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
        model.addAttribute("contract", contractService.getContractModel(id));
        model.addAttribute("tariffs", tariffDataService.getAll());
        return "profile/contract";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String postEditContract(EditContractModel editContractModel, Principal principal) throws Exception {
        UserDetailsImpl userDetails = (UserDetailsImpl) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        boolean asManager = userDetails.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_MANAGER"));
        VContractWithTariff contract = contractWithTariffDataService.getById(editContractModel.getId());
        if (contract.getIsBlocked() && contract.getIsAdminBlocker() && !asManager){
            throw new AccessDeniedException("Access is denied");
        }

        contractService.updateContractData(editContractModel, asManager);
        if (!asManager) {
            return "redirect:/contract/edit?id=" + editContractModel.getId();
        } else {
            return "redirect:/clients/edit?id=" + editContractModel.getClientId();
        }
    }




}
