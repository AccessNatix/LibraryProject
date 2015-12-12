package com.libraryproject.helperentity;

import com.libraryproject.entity.Book;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author anatole
 */
public class BookHelper extends GenericHelper{
    
    public void create(Book book)
    {        
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        this.session.save(book);
        trans.commit();
        this.closeSession();
    }
    
    public void delete(Book book)
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        this.session.delete(book);
        trans.commit();
        this.closeSession();
    }
    
    public void update(Book book)
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        this.session.update(book);
        trans.commit();
        this.closeSession();
    }
    
    public void deleteAll()
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        String hql = "DELETE com.libraryproject.entity.Book";
        Query query = this.session.createQuery(hql);
        query.executeUpdate();
        trans.commit();
        this.closeSession();
    }
    
    public Book find(int id)
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        String hql = "from com.libraryproject.entity.Book book WHERE book.id = :id";
        Query query = session.createQuery(hql).setInteger("id", id);
        Book results = (Book) query.uniqueResult();
        
        Hibernate.initialize(results.getCategory());
        Hibernate.initialize(results.getAuthor());
        
        trans.commit();
        this.closeSession();

        return results;
    }
    
    public List<Book> findAll()
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        String hql = "from com.libraryproject.entity.Book";
        Query query = session.createQuery(hql);
        List<Book> results = query.list();
        
        for(Book result : results)
        {
            Hibernate.initialize(result.getAuthor());
            Hibernate.initialize(result.getCategory());
        }
        
        trans.commit();
        this.closeSession();

        return results;        
    }
}
