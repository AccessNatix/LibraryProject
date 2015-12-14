package com.libraryproject.controller;

import com.libraryproject.entity.Book;
import com.libraryproject.entity.Category;
import com.libraryproject.helperentity.BookHelper;
import com.libraryproject.helperentity.CategoryHelper;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author anatole
 */
@Controller
public class ControllerStarter {
    
    @RequestMapping("/")
    public ModelAndView index(HttpSession session)
    {        
        CategoryHelper helper = new CategoryHelper();
        List<Category> category = helper.findAll();

        BookHelper bookHelper = new BookHelper();
        
        int id = 0;
        List<Book> books = bookHelper.findAll();
        List<Book> recent = new ArrayList<Book>();
        
        for(int i = books.size()-1; i >= 0; i-=1)
        {
            id++;
            
            if(id < 4)
            {
                recent.add(books.get(i));
            }
            else
            {
                break;
            }
        }
        
        ModelAndView view = new ModelAndView("index");
        view.addObject("categories", category);
        view.addObject("recents",recent);
        
        return view;
    }
}
