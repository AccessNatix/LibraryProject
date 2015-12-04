/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraryproject.controller;

import com.libraryproject.entity.User;
import com.libraryproject.helperentity.UserHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author anatole
 */
@Controller
@RequestMapping("/login")
public class ControllerLogin {
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getLoginPage()
    {
        return new ModelAndView("login");
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView loginRequest(
        @RequestParam("username") String username,
        @RequestParam("password") String password
        )
    {
        UserHelper userHelper = new UserHelper();

        if(userHelper.identification(username, password))
        {
            return new ModelAndView("redirect:/");
        }
        else
        {
            return new ModelAndView("register");
        }        
    }    
    
}
