/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraryproject.controller;

import com.libraryproject.entity.Borrowed;
import com.libraryproject.entity.User;
import com.libraryproject.helperentity.UserHelper;
import java.util.HashSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author anatole
 */
@Controller
public class ControllerRegister {
    
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView getRegisterPage()
    {
        return new ModelAndView("register");
    }
    
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ModelAndView postRegisterPage(
        @RequestParam("name") String name,
        @RequestParam("surname") String surname,
        @RequestParam("email") String email,
        @RequestParam("username") String username,
        @RequestParam("password") String password,
        @RequestParam("repeat-password") String passwordRepeat
        )
    {
        UserHelper userHelper = new UserHelper();

        if(userHelper.isExisting(username, email) <= 0)
        {
            if(passwordRepeat.equals(password))
            {
                User user = new User(name, surname, email, username, password, new HashSet<Borrowed>());
                userHelper.save(user);
                return new ModelAndView("redirect:/");                
            }
            else
            {
                // repeat password is wrong
                ModelAndView view = new ModelAndView(new RedirectView("register?string=ERROR_REGISTER_PASSWORD"));
                return view;
            }
        }
        else
        {
            // user already existing 
            ModelAndView view = new ModelAndView(new RedirectView("register?string=ERROR_REGISTER_EXISTS"));
            return view;
        }
    }
}
