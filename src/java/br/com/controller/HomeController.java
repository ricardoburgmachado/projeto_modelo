package br.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Ricardo
 */
@Controller
public class HomeController {
    
    
    @RequestMapping(value ={"/home", "", "/"})
    public ModelAndView home(){
    
        return new ModelAndView("home");
    }
    
}
