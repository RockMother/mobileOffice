package base.controllers;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


public abstract class BaseController {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
        ModelAndView mav = new ModelAndView();
        if (ex.getClass() == AccessDeniedException.class){
            mav.setViewName("403");
        } else {
            mav.setViewName("error");
        }
        return mav;
    }
}
