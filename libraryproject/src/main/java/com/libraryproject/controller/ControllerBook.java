/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraryproject.controller;

import com.libraryproject.entity.Book;
import com.libraryproject.helperentity.BookHelper;
import java.util.HashMap;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.MatcherAssert.assertThat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

/**
 *
 * @author anatole
 */
@Controller
public class ControllerBook {
    
    @RequestMapping(value ="/book/news")
    public ModelAndView getDefaultPage()
    {
        BookHelper bookHelper = new BookHelper();
        
        //bookHelper.
        
        return new ModelAndView("news");
    }
    
    @RequestMapping(value ="/book/{id}")
    public ModelAndView getDefaultPage(@PathVariable(value="id") final int id)
    {
        BookHelper bookHelper = new BookHelper();
        
        Book book = bookHelper.find(id);

        HashMap<String,String> maps = new HashMap<>();
        
        if(book != null)
        {
            maps.put("Name", book.getName());
            maps.put("Category", "plop");
            maps.put("Author", "plip");
            
            return new ModelAndView("book", maps);
        }
        else
        {
            maps.put("Name", "NON");
            maps.put("Category", "NON");
            maps.put("Author", "NON");
            
            return new ModelAndView("book", maps);

        }

        

    }
}
