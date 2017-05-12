package mobileoffice.controllers.rest;

import mobileoffice.business.contracts.data.TariffDataService;
import mobileoffice.dao.entities.Tariff;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kisc on 5/12/2017.
 */
@RestController
@RequestMapping("/rest/tariffs")
public class TariffRestController {
    private TariffDataService tariffDataService;

    public TariffRestController(TariffDataService tariffDataService){
        this.tariffDataService = tariffDataService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Tariff> listAllTariffs() throws Exception {
        List<Tariff> tariffs = tariffDataService.getAll();
        return tariffs;
    }
}
