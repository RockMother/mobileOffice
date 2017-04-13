package mobileoffice.controllers;

import base.controllers.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by kiril_000 on 01.04.2017.
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    @RequestMapping(method = {RequestMethod.GET})
    public String get(){
        return "login";
    }
}
