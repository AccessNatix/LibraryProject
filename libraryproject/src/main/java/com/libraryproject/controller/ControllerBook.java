/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraryproject.controller;

import com.libraryproject.entity.Author;
import com.libraryproject.entity.Book;
import com.libraryproject.entity.Borrowed;
import com.libraryproject.entity.Category;
import com.libraryproject.entity.User;
import com.libraryproject.helperentity.AuthorHelper;
import com.libraryproject.helperentity.BookHelper;
import com.libraryproject.helperentity.CategoryHelper;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author anatole
 */
@Controller
public class ControllerBook {
   
    @RequestMapping(value ="/book/{id}", method = RequestMethod.GET)
    public ModelAndView getBookPage(@PathVariable(value="id") final int id, HttpServletRequest request)
    {
        BookHelper bookHelper = new BookHelper();
        
        Book book = bookHelper.find(id);
        
        if(book == null)
        {
            ModelAndView view = new ModelAndView("redirect:/news");
            return view; 
        }

        HashMap<String,String> maps = new HashMap<>();
        
        maps.put("title", book.getName());
        maps.put("stock", String.valueOf(book.getStock()));
        maps.put("category", book.getCategory().getName());
        maps.put("author", book.getAuthor().getName());
        maps.put("description",book.getDescription());
        maps.put("image", book.getImage());

        ModelAndView view = new ModelAndView("book");
        view.addObject("id", id);
        view.addAllObjects(maps);

        Set<Borrowed> borroweds = book.getBorroweds();
        List<User> users = new ArrayList<>();

        for(Borrowed borrowed : borroweds)
        {
            users.add(borrowed.getUser());
        }

        view.addObject("users", users);

        return view;
    }

    @RequestMapping(value ="/book/{id}/del", method = RequestMethod.GET)
    public ModelAndView delBook(@PathVariable(value="id") final int id, HttpServletRequest request)
    {
        BookHelper helper = new BookHelper();
        Book book = helper.find(id);
        
        String applicationPath = request.getServletContext().getRealPath("");
        applicationPath += "/../../src/main/webapp/includes/images/";
        applicationPath += book.getImage();
        
        try{
    		File file = new File(applicationPath);
        	
    		if(file.delete()){
    			System.out.println(file.getName() + " is deleted!");
    		}else{
    			System.out.println("Delete operation is failed.");
    		}
    	}catch(Exception e){
    		e.printStackTrace();	
    	}
        
        helper.delete(book);
        return new ModelAndView("redirect:/admin");
    }

    @RequestMapping(value ="/book/{id}/edit", method = RequestMethod.GET)
    public ModelAndView editBook(@PathVariable(value="id") final int id)
    {
        BookHelper bookHelper = new BookHelper();
        AuthorHelper authorHelper = new AuthorHelper();
        CategoryHelper categoryHelper = new CategoryHelper();
        
        Book book = bookHelper.find(id);
        List<Author> authors = authorHelper.findAll();
        List<Category> categories = categoryHelper.findAll();
        
        ModelAndView view = new ModelAndView("book_edit");
        view.addObject("book", book);
        view.addObject("authors",authors);
        view.addObject("categories", categories);
        
        return view;
    }
    
    @RequestMapping(value ="/book/{id}/edit", method = RequestMethod.POST)
    public ModelAndView editBookPost(@PathVariable(value="id") final int id,
        @RequestParam("name") String name,
        @RequestParam("author") int author_id,
        @RequestParam("category") int category_id,
        @RequestParam("instock") int stock,
        @RequestParam("description") String description,
        @RequestParam("image_url") MultipartFile file, HttpServletRequest request)
    {
        AuthorHelper authorHelper = new AuthorHelper();
        CategoryHelper categoryHelper = new CategoryHelper();
        
        Author author = authorHelper.find(author_id);
        Category category = categoryHelper.find(category_id);
        
        BookHelper helper = new BookHelper();
        Book book = helper.find(id);
        
        book.setCategory(category);
        book.setAuthor(author);
        book.setStock(stock);
        book.setPrice(BigDecimal.valueOf(0));
        book.setDescription(description);
        

        if (!file.isEmpty()) {
            try {
                String applicationPath = request.getServletContext().getRealPath("");
                
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(applicationPath+"/../../src/main/webapp/includes/images/"+file.getOriginalFilename())));
                stream.write(bytes);
                stream.close();
                
            } catch (Exception e) {
                System.err.println("Failed");
            }
        } else {
            System.err.println("Failed");
        }
        
        book.setImage(file.getName());
        helper.update(book);
        
        return new ModelAndView("redirect:/book/"+id);
    }
    
    @RequestMapping(value ="/book/add", method = RequestMethod.POST)
    public ModelAndView addBookToDatabase(
        @RequestParam("name") String name,
        @RequestParam("author") int author_id,
        @RequestParam("category") int category_id,
        @RequestParam("instock") int stock,
        @RequestParam("description") String description,
        @RequestParam("image_url") MultipartFile file, HttpServletRequest request)
    {
        AuthorHelper authorHelper = new AuthorHelper();
        CategoryHelper categoryHelper = new CategoryHelper();
        
        Author author = authorHelper.find(author_id);
        Category category = categoryHelper.find(category_id);
        
         if (!file.isEmpty()) {
            try {
                String applicationPath = request.getServletContext().getRealPath("");
                
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(applicationPath+"/../../src/main/webapp/includes/images/"+file.getOriginalFilename())));
                stream.write(bytes);
                stream.close();
                
            } catch (Exception e) {
                System.err.println("Failed");
            }
        } else {
            System.err.println("Failed");
        }
        
        BookHelper helper = new BookHelper();
        Book book = new Book(author,category,name,BigDecimal.valueOf(0),description,stock,file.getName());
        helper.create(book);
        
        return new ModelAndView("redirect:/admin");
    }
}
