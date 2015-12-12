package com.libraryproject.controller;

import com.libraryproject.entity.Book;
import com.libraryproject.entity.Borrowed;
import com.libraryproject.entity.User;
import com.libraryproject.helperentity.BookHelper;
import com.libraryproject.helperentity.BorrowedHelper;
import com.libraryproject.helperentity.UserHelper;
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
public class ControllerBorrowedBook {
    
    @RequestMapping(value ="/borrow/{id}", method = RequestMethod.GET)
    public ModelAndView borrowBook(@PathVariable(value="id") final int id)
    {
        // check session
        UserHelper helper = new UserHelper();
        User user = helper.find(10);
        
        if(user.getBorroweds().size() >= 3)
        {
            BookHelper bookHelper = new BookHelper();
            Book book = bookHelper.find(id);
            
            BorrowedHelper borrowed = new BorrowedHelper();
            borrowed.create(new Borrowed(book,user));
        }
        else
        {
            // if too much book
        }
        

    }

}
