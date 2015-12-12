/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraryproject.helperentity;

import com.libraryproject.entity.Borrowed;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author anatole
 */
public class BorrowedHelper extends GenericHelper{
 
    public void create(Borrowed borrowed)
    {        
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        this.session.save(borrowed);
        trans.commit();
        this.closeSession();
    }
    
    public void delete(Borrowed borrowed)
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        this.session.save(borrowed);
        trans.commit();
        this.closeSession();
    }
    
    public void update(Borrowed borrowed)
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        this.session.update(borrowed);
        trans.commit();
        this.closeSession();
    }
    
    public void deleteAll()
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        String hql = "DELETE com.libraryproject.entity.Borrowed";
        Query query = this.session.createQuery(hql);
        query.executeUpdate();
        trans.commit();
        this.closeSession();
    }
    
    public void findByUser()
    {
        
    }
}
