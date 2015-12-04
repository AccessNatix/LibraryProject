package com.libraryproject.controller;

import com.libraryproject.entity.Author;
import com.libraryproject.entity.Book;
import com.libraryproject.entity.Category;
import com.libraryproject.helperentity.AuthorHelper;
import com.libraryproject.helperentity.BookHelper;
import com.libraryproject.helperentity.CategoryHelper;
import java.math.BigDecimal;
import java.util.List;
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
    public ModelAndView index()
    {
        //UserHelper helper = new UserHelper();
        //helper.save(new User("plop", "plop", "plop","plip", "coucou"));
       
        //AuthorHelper authorhelper = new AuthorHelper();
        //List<Author> authors = authorhelper.find("name");
        
        //CategoryHelper categoryHelpter = new CategoryHelper();
        //List<Category> catego = categoryHelpter.find("category");
        
        //BookHelper bookHelper = new BookHelper();
        //Book book = new Book(authors.get(0),catego.get(0),"plop",new BigDecimal(10), "hello", 10, "plop");
        //bookHelper.create(book);
        
        BookHelper bookHelper = new BookHelper();
        List<Book> books = bookHelper.find("plop");
        System.err.println("Size books = " + books.size());
        
        return new ModelAndView("index");
    }

}
