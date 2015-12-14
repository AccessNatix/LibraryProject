package com.libraryproject.helperentity;

import com.libraryproject.entity.Book;
import com.libraryproject.entity.Category;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author anatole
 */
public class CategoryHelper extends GenericHelper{

    public void create(Category category)
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        this.session.save(category);
        trans.commit();
        this.closeSession();
    }
    
    public void delete(Category category)
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        this.session.delete(category);
        trans.commit();
        this.closeSession();
    }
    
    public void update(Category category)
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        this.session.update(category);
        trans.commit();
        this.closeSession();
    }
    
    public void reset()
    {
        deleteAll();
        
        this.openSession();
        Transaction trans = this.session.beginTransaction();
        this.session.createSQLQuery("ALTER TABLE category AUTO_INCREMENT = 1;").executeUpdate();
        trans.commit();
        this.closeSession();
    }
    
    public void deleteAll()
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        String hql = "DELETE com.libraryproject.entity.Category";
        Query query = this.session.createQuery(hql);
        query.executeUpdate();
        trans.commit();
        this.closeSession();
    }
    
    public List<Category> findAll()
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        String hql = "from com.libraryproject.entity.Category";
        Query query = session.createQuery(hql)  ;
        List<Category> results = query.list();
        trans.commit();
        this.closeSession();
        return results;
    }
    
    public void delete(int id)
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        String hql = "DELETE com.libraryproject.entity.Category category where category.id = :id";
        Query query = this.session.createQuery(hql).setInteger("id", id);
        query.executeUpdate();
        trans.commit();
        this.closeSession();
    }
    
    public Category find(String name)
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        String hql = "from com.libraryproject.entity.Category category where category.name = :name";
        Query query = session.createQuery(hql).setString("name", name);
        Category results = (Category) query.uniqueResult();
        trans.commit();
        this.closeSession();
        return results;
    } 
    
    public Category find(int id)
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        String hql = "from com.libraryproject.entity.Category category where category.id = :id";
        Query query = session.createQuery(hql).setInteger("id", id);
        Category results = (Category) query.uniqueResult();
        
        Hibernate.initialize(results.getBooks());
        
        for(Book book : results.getBooks())
        {
            Hibernate.initialize(book);
            Hibernate.initialize(book.getAuthor());
            Hibernate.initialize(book.getCategory());
        }
        
        trans.commit();
        this.closeSession();
        return results;
    }

}
