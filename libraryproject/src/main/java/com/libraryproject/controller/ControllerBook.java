/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraryproject.controller;

import com.libraryproject.entity.Book;
import com.libraryproject.helperentity.BookHelper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author anatole
 */
@Controller
public class ControllerBook {
   
    
    @RequestMapping(value ="/book/{id}", method = RequestMethod.GET)
    public ModelAndView getBookPage(@PathVariable(value="id") final int id)
    {
        BookHelper bookHelper = new BookHelper();
        
        Book book = bookHelper.find(id);

        HashMap<String,String> maps = new HashMap<>();
        
        if(book != null)
        {
            maps.put("title", book.getName());
            maps.put("stock", String.valueOf(book.getStock()));
            maps.put("category", book.getCategory().getName());
            maps.put("author", book.getAuthor().getName());
            maps.put("description",book.getDescription());
            maps.put("image", "/books/"+String.valueOf(book.getId()));
            
            try {
                FileUtils.writeByteArrayToFile(new File("/books/"+String.valueOf(book.getId())), book.getImage());
            } catch (IOException ex) {
                Logger.getLogger(ControllerNews.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return new ModelAndView("book", maps);
        }
        else
        {
            maps.put("title", "No title");
            maps.put("stock", "No stock");
            maps.put("category", "No category");
            maps.put("author", "No author");
            maps.put("description","No description");
            maps.put("image", "blankbook.jpg");
                        
            return new ModelAndView("book", maps);

        }
    }
}
