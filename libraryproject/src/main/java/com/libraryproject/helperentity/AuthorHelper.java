package com.libraryproject.helperentity;

import com.libraryproject.entity.Author;
import java.util.List;
import org.hibernate.Hibernate;
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
    
    public void delete(int id)
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        String hql = "DELETE com.libraryproject.entity.Book book where book.id = :id";
        Query query = this.session.createQuery(hql);
        query.executeUpdate();
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
    
    public List<Author> findAll()
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        String hql = "from com.libraryproject.entity.Author";
        Query query = session.createQuery(hql);
        List<Author> results = query.list();
        
        for(Author author : results)
        {
            Hibernate.initialize(author.getBooks());            
        }
        
        trans.commit();
        this.closeSession();
        return results;        
    }
    
    public Author find(String name)
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        String hql = "from com.libraryproject.entity.Author author where author.name = :name";
        Query query = session.createQuery(hql).setString("name", name);
        Author results = (Author) query.uniqueResult();
        
        Hibernate.initialize(results.getBooks());
        
        trans.commit();
        this.closeSession();
        return results;
    }
    
    public Author find(int id)
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        String hql = "from com.libraryproject.entity.Author author where author.id = :id";
        Query query = session.createQuery(hql).setInteger("id", id);
        Author results = (Author) query.uniqueResult();
        
        Hibernate.initialize(results.getBooks());
        
        trans.commit();
        this.closeSession();
        return results;
    }

}
