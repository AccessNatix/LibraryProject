package com.libraryproject.controller;

import com.libraryproject.entity.Category;
import com.libraryproject.entity.User;
import com.libraryproject.helperentity.AuthorHelper;
import com.libraryproject.helperentity.CategoryHelper;
import com.libraryproject.helperentity.UserHelper;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author anatole
 */
@Controller
public class ControllerAdmin {

    @RequestMapping("/admin")
    public ModelAndView getMainPage()
    {
        // get list of user
        UserHelper userHelper = new UserHelper();
        List<User> users = userHelper.findAll();
        
        // show users to view
        ModelAndView result = new ModelAndView("admin");
        result.addObject("users", users);
        
        return result;
    }
    
    @RequestMapping("/admin/user/{id}/del")
    public ModelAndView deleteUser(@PathVariable(value="id") final int id)
    {
        UserHelper helper = new UserHelper();
        helper.delete(id);
        
        return new ModelAndView("admin");
    }

    @RequestMapping("/admin/category/add")
    public ModelAndView addCategory(
        @RequestParam("category_name") String name
        )
    {
        CategoryHelper helper = new CategoryHelper();
        Category category = new Category(name);
        helper.create(category);
        
        return new ModelAndView("admin");
    }
    
    @RequestMapping("/admin/category/{id}/del")
    public ModelAndView deleteCategory(@PathVariable(value="id") final int id)
    {
        CategoryHelper helper = new CategoryHelper();
        helper.delete(id);
        
        return new ModelAndView("admin");
    }
    
    @RequestMapping(value="/admin/author/add",method = RequestMethod.POST)
    public ModelAndView addAuthor(
        @RequestParam("name") String name
        )
    {
        CategoryHelper helper = new CategoryHelper();
        Category category = new Category(name);
        
        helper.create(category);
        
    
        return new ModelAndView("admin");
    }

    @RequestMapping("/admin/author/{id}/del")
    public ModelAndView deleteAuthor(@PathVariable(value="id") final int id)
    {
        AuthorHelper helper = new AuthorHelper();
        helper.delete(id);
        
        return new ModelAndView("admin");
    }   
}