package mobileoffice.controllers;

import mobileoffice.models.security.UserDetailsImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by kiril_000 on 01.04.2017.
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping(method = {RequestMethod.GET})
    public String get(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal != null && !principal.equals("anonymousUser")) {
            UserDetailsImpl userDetails = (UserDetailsImpl) principal;
            if (userDetails.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_CLIENT")))
                return "redirect:profile";
        }

        return "index";
    }
}
