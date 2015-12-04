/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraryproject.helperentity;

import com.libraryproject.entity.User;
import java.util.List;
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
        this.session.delete(user);
        trans.commit();
        this.closeSession();
    }
    
    public boolean isExisting(String username,String email)
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        String hql = "FROM com.libraryproject.entity.User user WHERE user.username = :username OR user.mail = :email";
        Query query = this.session.createQuery(hql).setString("username", username).setString("email", email);
        List<User> results = query.list();
        trans.commit();
        this.closeSession();
        return results.size() > 0;
    }
    
    public boolean identification(String username, String password)
    {
        this.openSession();
        Transaction trans= this.session.beginTransaction();
        String hql = "FROM com.libraryproject.entity.User user WHERE user.username = :username AND user.password = :password";
        Query query = this.session.createQuery(hql).setString("username", username).setString("password", password);
        List<User> results = query.list();
        trans.commit();
        this.closeSession();
        return results.size() > 0;
    }
}
