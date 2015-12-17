package com.libraryproject.controller;

import com.libraryproject.entity.Author;
import com.libraryproject.entity.Book;
import com.libraryproject.entity.Category;
import com.libraryproject.entity.User;
import com.libraryproject.helperentity.AuthorHelper;
import com.libraryproject.helperentity.BookHelper;
import com.libraryproject.helperentity.CategoryHelper;
import com.libraryproject.helperentity.UserHelper;
import com.libraryproject.inportordumpbdd.AddXmlToBdd;
import com.libraryproject.inportordumpbdd.init.Init;
import com.libraryproject.utility.SessionBean;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author anatole
 */
@Controller
public class ControllerAdmin {

    @RequestMapping("/admin")
    public ModelAndView getMainPage(HttpServletRequest request)
    {
        UserHelper userHelper = new UserHelper();
        SessionBean userbean = (SessionBean) request.getSession().getAttribute("user");
        User user = userHelper.find(userbean.getId());
        
        if(user == null || !user.getType())
        {
            ModelAndView result = new ModelAndView("redirect:/");   
            return result;
        }
        
        // show users to view
        ModelAndView result = new ModelAndView("admin");
     
        // get list of user
        List<User> users = userHelper.findAll();

        CategoryHelper categoryHelper = new CategoryHelper();
        List<Category> categories = categoryHelper.findAll();
        
        AuthorHelper authorHelper = new AuthorHelper();
        List<Author> authors = authorHelper.findAll();
        
        BookHelper bookHelper = new BookHelper();
        List<Book> books = bookHelper.findAll();
         
        result.addObject("users", users);
        result.addObject("categories",categories);
        result.addObject("authors", authors);
        result.addObject("books",books);
        
        return result;
    }
    
    @RequestMapping("/admin/user/{id}/del")
    public ModelAndView deleteUser(@PathVariable(value="id") final int id)
    {
        UserHelper helper = new UserHelper();
        helper.delete(id);
        
        return new ModelAndView("redirect:/admin");
    }

    @RequestMapping("/admin/category/add")
    public ModelAndView addCategory(
        @RequestParam("name") String name
        )
    {
        CategoryHelper helper = new CategoryHelper();
        Category category = new Category(name);
        helper.create(category);
        
        return new ModelAndView("redirect:/admin");
    }
    
    @RequestMapping("/admin/category/edit")
    public ModelAndView editCategory(
        @RequestParam("name") String name,
        @RequestParam("id") int id
        )
    {
        CategoryHelper helper = new CategoryHelper();
        Category category = helper.find(id);
        
        category.setName(name);
        
        helper.update(category);
        
        return new ModelAndView("redirect:/admin");
    }

    
    @RequestMapping("/admin/category/{id}/del")
    public ModelAndView deleteCategory(@PathVariable(value="id") final int id)
    {
        CategoryHelper helper = new CategoryHelper();
        helper.delete(id);
        
        return new ModelAndView("redirect:/admin");
    }
    
    @RequestMapping(value="/admin/author/add",method = RequestMethod.POST)
    public ModelAndView addAuthor(
        @RequestParam("name") String name
        )
    {
        AuthorHelper helper = new AuthorHelper();
        Author author = new Author(name, new HashSet<Book>());
        
        helper.create(author);
    
        return new ModelAndView("redirect:/admin");
    }
    
    @RequestMapping("/admin/author/edit")
    public ModelAndView editAuthor(
        @RequestParam("name") String name,
        @RequestParam("id") int id
        )
    {
        AuthorHelper helper = new AuthorHelper();
        Author author = helper.find(id);
        
        author.setName(name);
        
        helper.update(author);
        
        return new ModelAndView("redirect:/admin");
    }

    @RequestMapping("/admin/author/{id}/del")
    public ModelAndView deleteAuthor(@PathVariable(value="id") final int id)
    {
        AuthorHelper helper = new AuthorHelper();
        helper.delete(id);
        
        return new ModelAndView("redirect:/admin");
    }   

    /**
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public @ResponseBody ModelAndView importPage(@RequestParam("file") MultipartFile file)
    {
        AddXmlToBdd xmlLoader = new AddXmlToBdd();
        Map<String, byte[]> zipContents = new HashMap<>();
        
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                ZipInputStream zip = new ZipInputStream(new ByteArrayInputStream(bytes));
                
                ZipEntry entry;
                
                while ((entry = zip.getNextEntry()) != null) {
                  int size;
                  byte[] buffer = new byte[2048];

                  
                  FileOutputStream fos = new FileOutputStream(entry.getName());
                  BufferedOutputStream bos = new BufferedOutputStream(fos, buffer.length);

                  while ((size = zip.read(buffer, 0, buffer.length)) != -1) {
                    bos.write(buffer, 0, size);
                  }
                  
                  // save the current content
                  zipContents.put(entry.getName(), bytes);
                  
                  bos.flush();
                  bos.close();
                }
                
                if(zipContents.containsKey("init.xml"))
                {
                    Init init = xmlLoader.getInitConfiguration("init.xml");
                    
                    if(init != null)
                    {
                        if(zipContents.containsKey(init.getPathlibrary()))
                        {
                            System.err.println("Start parsing");
                            xmlLoader.loadXmlInDatabase(init.getPathlibrary(), zipContents);
                        }
                    }
                }
                else
                {
                    Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, "init.xml not found");
                }
      
            } catch (IOException ex) {
                Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return new ModelAndView("redirect:/admin");
    }    
}