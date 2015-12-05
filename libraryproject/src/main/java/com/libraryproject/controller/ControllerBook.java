/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraryproject.controller;

import com.libraryproject.entity.Book;
import com.libraryproject.helperentity.BookHelper;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author anatole
 */
@Controller
public class ControllerBook {
    
    @RequestMapping(value = "/book/news")
    public ModelAndView getNewsPage()
    {
        HashMap<String,List<Book>> maps = new HashMap<>();
        
        BookHelper bookHelper = new BookHelper();
        List<Book> books =  bookHelper.findAll();
       
        if(books != null)
        {
            maps.put("books",books);
            return new ModelAndView("news", maps);
        }
        else
        {
            return new ModelAndView("news");
        }
    }
    
    @RequestMapping(value ="/book/{id}")
    public ModelAndView getBookPage(@PathVariable(value="id") final int id)
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
