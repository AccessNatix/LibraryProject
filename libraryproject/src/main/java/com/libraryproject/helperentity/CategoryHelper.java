/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraryproject.helperentity;

import com.libraryproject.entity.Category;
import java.util.List;
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
    
    public List<Category> find(String name)
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        String hql = "from com.libraryproject.entity.Category";
        Query query = session.createQuery(hql);
        List<Category> results = query.list();
        trans.commit();
        this.closeSession();
        return results;
    }

}
