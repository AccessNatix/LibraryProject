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
        Transaction trans=session.beginTransaction();
        this.session.save(author);
        trans.commit();
    }
    
    public void delete(Author author)
    {
        Transaction trans=session.beginTransaction();
        this.session.delete(author);
        trans.commit();
    }
    
    public void update(Author author)
    {
        Transaction trans=session.beginTransaction();
        this.session.update(author);
        trans.commit();
    }
    
    public List<Author> find(String name)
    {
        Transaction trans=session.beginTransaction();
        String hql = "from com.libraryproject.entity.Author";
        Query query = session.createQuery(hql);
        List<Author> results = query.list();
        trans.commit();
        return results;
    }
}
