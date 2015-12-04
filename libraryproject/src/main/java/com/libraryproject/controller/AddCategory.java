/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraryproject.controller;

import com.libraryproject.entity.Category;
import com.libraryproject.helperentity.CategoryHelper;
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
@RequestMapping("/addcategory")
public class AddCategory {
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAddCategory()
    {
        return new ModelAndView("addcategory");
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addCategory(
        @RequestParam("category") String category
    )
    {
        CategoryHelper categoryHelper = new CategoryHelper();
        
        Category cat = new Category(category);
        
        categoryHelper.create(cat);
        
        return new ModelAndView("redirect:/");
    }
        
}
