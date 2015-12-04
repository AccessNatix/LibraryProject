/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraryproject.helperentity;

import com.libraryproject.entity.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author anatole
 */
public class GenericHelper {
    
    private SessionFactory sessionFactory = null;
    protected Session session;
    
    public GenericHelper()
    {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    public void openSession()
    {
        this.session = this.sessionFactory.openSession();
    }
    
    public void closeSession()
    {
        this.session.close();
    }
}
