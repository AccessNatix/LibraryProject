/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraryproject.helperentity;

import com.libraryproject.entity.User;
import org.hibernate.Transaction;

/**
 *
 * @author anatole
 */
public class UserHelper extends GenericHelper{
    
    public void save(User user)
    {
        Transaction trans=session.beginTransaction();
        this.session.save(user);
        trans.commit();
    }
    
    public void update(User user)
    {
        Transaction trans=session.beginTransaction();
        this.session.delete(user);
        trans.commit();
    }
}
