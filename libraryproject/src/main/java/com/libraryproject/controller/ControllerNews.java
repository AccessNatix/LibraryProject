/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraryproject.controller;

import com.libraryproject.entity.Book;
import com.libraryproject.entity.Category;
import com.libraryproject.helperentity.BookHelper;
import com.libraryproject.helperentity.CategoryHelper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author anatole
 */
@Controller
public class ControllerNews {
   
    @RequestMapping(value="/news",method = RequestMethod.GET)    
    public ModelAndView getNewsPage()
    {
        CategoryHelper helper = new CategoryHelper();
        List<Category> category = helper.findAll();
        
        BookHelper bookHelper = new BookHelper();
        List<Book> books = bookHelper.findAll();
        
        for(Book book : books)
        {
            try {
                FileUtils.writeByteArrayToFile(new File("/books/"+String.valueOf(book.getId())), book.getImage());
            } catch (IOException ex) {
                Logger.getLogger(ControllerNews.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        ModelAndView view = new ModelAndView("news");
        view.addObject("categories",category);
        view.addObject("books", books);
        
        return view;
    }
   
}
