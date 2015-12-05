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
@RequestMapping("/register")
public class ControllerRegister {
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getRegisterPage()
    {
        return new ModelAndView("register");
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView postRegisterPage(
        @RequestParam("name") String name,
        @RequestParam("surname") String surname,
        @RequestParam("email") String email,
        @RequestParam("username") String username,
        @RequestParam("password") String password
        )
    {
        UserHelper userHelper = new UserHelper();

        if(!userHelper.isExisting(username, email))
        {
            User user = new User(name, surname, email, username, password);
            userHelper.save(user);
            return new ModelAndView("redirect:/");
        }
        else
        {
            return new ModelAndView("register");
        }
    }
}
