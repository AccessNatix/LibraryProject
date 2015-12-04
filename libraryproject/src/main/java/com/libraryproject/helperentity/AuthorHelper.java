package com.libraryproject.helperentity;

import com.libraryproject.entity.Author;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author anatole
 */
public class AuthorHelper extends GenericHelper{
    
    public void create(Author author)
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        this.session.save(author);
        trans.commit();
        this.closeSession();
    }
    
    public void delete(Author author)
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        this.session.delete(author);
        trans.commit();
        this.closeSession();
    }
    
    public void update(Author author)
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        this.session.update(author);
        trans.commit();
        this.closeSession();
    }
    
    public List<Author> find(String name)
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        String hql = "from com.libraryproject.entity.Author";
        Query query = session.createQuery(hql);
        List<Author> results = query.list();
        trans.commit();
        this.closeSession();
        return results;
    }
}
