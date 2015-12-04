/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraryproject.helperentity;

import com.libraryproject.entity.Book;
import com.libraryproject.entity.Category;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author anatole
 */
public class BookHelper extends GenericHelper{
    
    public void create(Book book)
    {
        Transaction trans=session.beginTransaction();
        this.session.save(book);
        trans.commit();
    }
    
    public void delete(Book book)
    {
        Transaction trans=session.beginTransaction();
        this.session.delete(book);
        trans.commit();
    }
    
    public void update(Book book)
    {
        Transaction trans = session.beginTransaction();
        this.session.update(book);
        trans.commit();
    }
    
    public List<Book> find(String name)
    {
        Transaction trans = session.beginTransaction();
        String hql = "from com.libraryproject.entity.Book";
        Query query = session.createQuery(hql);
        List<Book> results = query.list();
        trans.commit();
        return results;
    }
}
