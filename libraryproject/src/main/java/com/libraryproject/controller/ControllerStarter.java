package com.libraryproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author anatole
 */
@Controller
public class ControllerStarter {
    
    @RequestMapping("/")
    public ModelAndView index()
    {
        return new ModelAndView("index");
    }
}
