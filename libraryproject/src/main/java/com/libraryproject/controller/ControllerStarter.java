package com.libraryproject.controller;

import com.libraryproject.utility.SessionBean;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author anatole
 */
@Controller
public class ControllerStarter {
    @Autowired
    private SessionBean mSessionBean;
    
    @RequestMapping("/")
    public ModelAndView index(HttpSession session)
    {
        mSessionBean.setMessage("coucou);
        session.setAttribute("session_bean", mSessionBean);
        
        return new ModelAndView("index");
    }
}
