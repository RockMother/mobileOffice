package mobileoffice.controllers;

import base.controllers.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by kisc on 4/13/2017.
 */
@Controller
@RequestMapping("/error")
public class ErrorController extends BaseController {

    @RequestMapping(method = RequestMethod.GET)
    public String get() throws Exception {
        throw new Exception("Error im program");
    }


}
