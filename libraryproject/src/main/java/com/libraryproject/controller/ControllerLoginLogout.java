/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraryproject.controller;

import com.libraryproject.helperentity.UserHelper;
import com.libraryproject.utility.SessionBean;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
public class ControllerLoginLogout {
    
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage()
    {
        return new ModelAndView(new RedirectView("register?signin"));
    }
    
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public ModelAndView loginRequest(
        HttpServletRequest request,
        @RequestParam("username") String username,
        @RequestParam("password") String password
        )
    {
        UserHelper userHelper = new UserHelper();

        int id = userHelper.identification(username, password);
        
        if(id != -1)
        {
            HttpSession session = request.getSession();
            SessionBean bean = new SessionBean(id);
            session.setAttribute("user", bean);
            return new ModelAndView("redirect:/");
            
        }
        else
        {
            ModelAndView view = new ModelAndView();
            view.setView(new RedirectView("register?signin"));
            view.addObject("ERROR_SIGNIN");
            return view;
        }
    }
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public ModelAndView getLogoutPage(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        session.setAttribute("user", null);
        
        return new ModelAndView("index");
    }
    
    
}
