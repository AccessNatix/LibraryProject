/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraryproject.helperentity;

import com.libraryproject.entity.Borrowed;
import com.libraryproject.entity.User;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author anatole
 */
public class UserHelper extends GenericHelper{
    
    public void save(User user)
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        this.session.save(user);
        trans.commit();
        this.closeSession();
    }
    
    public void update(User user)
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        this.session.update(user);
        trans.commit();
        this.closeSession();
    }
    
    //TODO
    public void delete(int id)
    {
        // not yet implemented
    }
    
    public void reset()
    {
        deleteAll();
        
        this.openSession();
        Transaction trans = this.session.beginTransaction();
        this.session.createSQLQuery("ALTER TABLE user AUTO_INCREMENT = 1;").executeUpdate();
        trans.commit();
        this.closeSession();
    }

    
    public void deleteAll()
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        String hql = "DELETE com.libraryproject.entity.User";
        Query query = this.session.createQuery(hql);
        query.executeUpdate();
        trans.commit();
        this.closeSession();
    }
    
    public User getUserWithId(int user)
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        
        String hql = "FROM com.libraryproject.entity.User user WHERE user.id = :id";
        Query query = this.session.createQuery(hql).setInteger("id", user);
        User result = (User) query.uniqueResult();
        
        Hibernate.initialize(result.getBorroweds());

        trans.commit();
        this.closeSession();
        
        return result;
    }
    
    public List<User> findAll()
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        
        String hql = "FROM com.libraryproject.entity.User user";
        Query query = this.session.createQuery(hql);
        List<User> result = (List<User>) query.list();
        
        for(User user : result)
        {
            Hibernate.initialize(user.getBorroweds());
        }
        
        trans.commit();
        this.closeSession();
        
        return result;
    }
    
    public User find(int id)
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        String hql = "FROM com.libraryproject.entity.User user WHERE user.id = :id";
        Query query = this.session.createQuery(hql).setInteger("id", id);
        User result = (User) query.uniqueResult();
        
        if(result == null)
        {
            return null;
        }
        
        if(result.getBorroweds() != null)
        {
            Hibernate.initialize(result.getBorroweds());      

            for(Borrowed borrow : result.getBorroweds())
            {
                Hibernate.initialize(borrow.getBook());
                Hibernate.initialize(borrow.getUser());            
            }            
        }
        
        trans.commit();
        this.closeSession();
        return result;
    }
    
    public int isExisting(String username,String email)
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        String hql = "FROM com.libraryproject.entity.User user WHERE user.username = :username OR user.mail = :email";
        Query query = this.session.createQuery(hql).setString("username", username).setString("email", email);
        List<User> results = query.list();
        trans.commit();
        this.closeSession();
        
        if(results.size() > 0)
        {
            return results.get(0).getId();
        }
        else
        {
            return -1;
        }
    }
    
    public int identification(String username, String password)
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        String hql = "FROM com.libraryproject.entity.User user WHERE user.username = :username AND user.password = :password";
        Query query = this.session.createQuery(hql).setString("username", username).setString("password", password);
        List<User> results = query.list();
        trans.commit();
        this.closeSession();
        
        if(results.size() > 0)
        {
            return results.get(0).getId();
        }
        else
        {
            return -1;
        }
    }
}
