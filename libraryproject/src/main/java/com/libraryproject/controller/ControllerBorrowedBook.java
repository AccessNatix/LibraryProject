package com.libraryproject.controller;

import com.libraryproject.entity.Book;
import com.libraryproject.entity.Borrowed;
import com.libraryproject.entity.User;
import com.libraryproject.helperentity.BookHelper;
import com.libraryproject.helperentity.BorrowedHelper;
import com.libraryproject.helperentity.UserHelper;
import com.libraryproject.utility.SessionBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    
    /**
     * Controller for seing all the book borrowed
     * @param request
     * @return 
     */
    @RequestMapping(value="/borrowed", method = RequestMethod.GET)
    public ModelAndView borrowedBook(
        HttpServletRequest request
    )
    {
        HttpSession session = request.getSession();
        SessionBean bean = (SessionBean) session.getAttribute("user");
        
        UserHelper helper = new UserHelper();
        User user = helper.find(bean.getId());
        
        Set<Borrowed> borrowed = user.getBorroweds();
        List<Book> books = new ArrayList<>();
        
        System.err.println("size = " + borrowed.size());
        
        for(Borrowed borrow : borrowed)
        {
            books.add(borrow.getBook());
        }
        
        ModelAndView view = new ModelAndView("borrowed");
        view.addObject("books", books);
        
        // add jsp page
        return view;
    }
    
    @RequestMapping(value= "/book/return/{id}", method = RequestMethod.GET)
    public ModelAndView unborrowedBook(@PathVariable(value="id") final int id, HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        SessionBean bean = (SessionBean) session.getAttribute("user");

        UserHelper helper = new UserHelper();
        User user = helper.find(bean.getId());
    
        Set<Borrowed> borroweds = user.getBorroweds();
        
        for(Borrowed borrowed : borroweds)
        {
            if(borrowed.getId() == id)
            {
                BookHelper bookHelper = new BookHelper();
                Book book = bookHelper.find(borrowed.getBook().getId());
                book.setStock(book.getStock()+1);
                bookHelper.update(book);
                
                BorrowedHelper borrowedHelper = new BorrowedHelper();
                borrowedHelper.delete(borrowed);
            }
        }
        
        return new ModelAndView("redirect:/profile");
    }
    
    @RequestMapping(value ="/borrowed/{id}", method = RequestMethod.GET)
    public ModelAndView borrowBook(@PathVariable(value="id") final int id, HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        SessionBean bean = (SessionBean) session.getAttribute("user");
        
        // check session
        UserHelper helper = new UserHelper();
        User user = helper.find(bean.getId());
        
        Set<Borrowed> borroweds = user.getBorroweds();
        
        for(Borrowed borrow : borroweds)
        {
            if(borrow.getBook().getId() == id)
            {
                ModelAndView view = new ModelAndView("redirect:/book/"+id+"?string=ERROR_SAME_BOOK");
                return view;            
            }
        }
        
        if(user.getBorroweds().size() <= 2)
        {
            BookHelper bookHelper = new BookHelper();
            Book book = bookHelper.find(id);
            
            if(book == null)
            {
                ModelAndView view = new ModelAndView("redirect:/news");
                return view; 
            }
            
            if(book.getStock() > 0)
            {
                book.setStock(book.getStock()-1);
                bookHelper.update(book);
                
                BorrowedHelper borrowed = new BorrowedHelper();
                borrowed.create(new Borrowed(book,user));

                ModelAndView view = new ModelAndView("redirect:/book/"+id);
                return view;         
            }
            else
            {
                ModelAndView view = new ModelAndView("redirect:/book/"+id+"?string=ERROR_NO_STOCK");
                return view;            
            }
        }
        else
        {
            ModelAndView view = new ModelAndView("redirect:/book/"+id+"?string=ERROR_FULL_BORROW");
            return view;
        }
    }

}
