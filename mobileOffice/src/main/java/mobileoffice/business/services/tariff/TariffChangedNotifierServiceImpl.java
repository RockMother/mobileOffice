package mobileoffice.business.services.tariff;

import mobileoffice.business.contracts.jms.JmsMessageSender;
import mobileoffice.business.contracts.tariff.TariffChangedNotifierService;
import org.springframework.stereotype.Service;

/**
 * Created by kisc on 5/12/2017.
 */
@Service
public class TariffChangedNotifierServiceImpl implements TariffChangedNotifierService {
    private JmsMessageSender sender;

    public TariffChangedNotifierServiceImpl(JmsMessageSender sender){
        this.sender = sender;
    }

    @Override
    public void tariffChanged(){
        sender.send("Tariff changed");
    }
}
