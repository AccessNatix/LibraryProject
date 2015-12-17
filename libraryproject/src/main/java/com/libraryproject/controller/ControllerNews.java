package com.libraryproject.controller;

import com.libraryproject.entity.Author;
import com.libraryproject.entity.Book;
import com.libraryproject.entity.Category;
import com.libraryproject.helperentity.AuthorHelper;
import com.libraryproject.helperentity.BookHelper;
import com.libraryproject.helperentity.CategoryHelper;
import java.util.ArrayList;
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
public class ControllerNews {
    
    @RequestMapping(value="/news",method = RequestMethod.GET)    
    public ModelAndView getNewsPage()
    {
        CategoryHelper helper = new CategoryHelper();
        List<Category> categories = helper.findAll();
        
        BookHelper bookHelper = new BookHelper();
        List<Book> books = bookHelper.findAll();
               
        ModelAndView view = new ModelAndView("news");
        view.addObject("categories",categories);
        view.addObject("books", books);
        
        return view;
    }
    
    @RequestMapping(value="/news", method = RequestMethod.POST)
    public ModelAndView postSearchOnNews(
        @RequestParam("seach") String value,
        @RequestParam("searchCategory") String category
    )
    {
        switch(category)
        {
            case "name":
                return new ModelAndView("redirect:/news/namekey/"+value);
            case "category":
                return new ModelAndView("redirect:/news/categorykey/"+value);
            case "author":
                return new ModelAndView("redirect:/news/authorkey/"+value);
        }
        
        return new ModelAndView("redirect:/news");
    }

    
    @RequestMapping(value="/news/authorid/{id}",method = RequestMethod.GET)    
    public ModelAndView getNewsAuthor(@PathVariable(value="id") int id)
    {
        AuthorHelper helper = new AuthorHelper();
        Author author = helper.find(id);
        
        if(author == null)
        {
            return new ModelAndView("redirect:/news");
        }
        
        CategoryHelper helperCategory = new CategoryHelper();
        List<Category> categories = helperCategory.findAll();
        
        ModelAndView view = new ModelAndView("news");
        view.addObject("categories",categories);
        view.addObject("books", author.getBooks());
        
        return view;
    }
    
    @RequestMapping(value="/news/namekey/{key}",method = RequestMethod.GET)    
    public ModelAndView getNewsNameKeysWords(@PathVariable(value="key") String key)
    {
        CategoryHelper helperCategory = new CategoryHelper();
        List<Category> categories = helperCategory.findAll();
        
        BookHelper helper = new BookHelper();
        List<Book> books = helper.findAll();
        
        List<Book> booksInKey = new ArrayList<>();
        
        for(Book book : books)
        {
            if(book.getName().contains(key))
            {
                booksInKey.add(book);
            }
        }
        
        ModelAndView view = new ModelAndView("news");
        view.addObject("categories",categories);
        view.addObject("books", booksInKey);
        
        return view;
    }
    
    @RequestMapping(value="/news/authorkey/{key}",method = RequestMethod.GET)    
    public ModelAndView getNewsAuthorKeysWords(@PathVariable(value="key") String key)
    {
        CategoryHelper helperCategory = new CategoryHelper();
        List<Category> categories = helperCategory.findAll();
        
        AuthorHelper helper = new AuthorHelper();
        List<Author> authors = helper.findAll();

        List<Book> books = new ArrayList<>();
        
        for(Author author : authors)
        {
            if(author.getName().contains(key))
            {
                books.addAll(author.getBooks());
            }
        }
        
        ModelAndView view = new ModelAndView("news");
        view.addObject("categories",categories);
        view.addObject("books", books);
        
        return view;
    }
    
    @RequestMapping(value="/news/categoryid/{id}",method = RequestMethod.GET)    
    public ModelAndView getNewsCategory(@PathVariable(value="id") int id)
    {
        CategoryHelper helper = new CategoryHelper();
        List<Category> categories = helper.findAll();
        Category category = helper.find(id);
        
        if(category == null)
        {
            return new ModelAndView("redirect:/news");
        }
        
        ModelAndView view = new ModelAndView("news");
        view.addObject("categories",categories);
        view.addObject("books", category.getBooks());
        
        return view;
    }
    
    @RequestMapping(value="/news/categorykey/{key}",method = RequestMethod.GET)    
    public ModelAndView getNewsCategoryKeysWords(@PathVariable(value="key") String key)
    {
        CategoryHelper helper = new CategoryHelper();
        List<Category> categories = helper.findAll();
        
        List<Book> books = new ArrayList<>();
        
        for(Category category : categories)
        {
            if(category.getName().contains(key))
            {
                books.addAll(category.getBooks());
            }
        }        
        
        ModelAndView view = new ModelAndView("news");
        view.addObject("categories",categories);
        view.addObject("books", books);
        
        return view;
    }

}
