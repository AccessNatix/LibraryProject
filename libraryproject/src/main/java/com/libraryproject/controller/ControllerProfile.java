package com.libraryproject.controller;

import com.libraryproject.entity.Book;
import com.libraryproject.entity.Borrowed;
import com.libraryproject.entity.User;
import com.libraryproject.helperentity.UserHelper;
import com.libraryproject.utility.SessionBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author anatole
 */
@Controller
public class ControllerProfile {
    
    @RequestMapping("/profile")
    public ModelAndView getProfilePage(HttpServletRequest request)
    {
        ModelAndView view = new ModelAndView("profile");
        
        HttpSession session = request.getSession();
        
        SessionBean beanUser = (SessionBean) session.getAttribute("user");
        
        if(beanUser == null)
            beanUser = (SessionBean) session.getAttribute("admin");
        
        if(beanUser != null)
        {
            UserHelper helper = new UserHelper();
            User user = helper.find(beanUser.getId());
            view.addObject("user",user);
            
            if(user.getType())
            {
                view.addObject("type", "admin");

                Set<Borrowed> borroweds = user.getBorroweds();
                
                view.addObject("borroweds",borroweds);
            }
            else
            {
                view.addObject("type", "user");
                
                Set<Borrowed> borroweds = user.getBorroweds();
                
                view.addObject("borroweds",borroweds);
            }
        }
        
        return view;
    }
    
}
