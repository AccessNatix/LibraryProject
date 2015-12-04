/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraryproject.helperentity;

import com.libraryproject.entity.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author anatole
 */
public class GenericHelper {
    
    protected Session session = null;
    
    public GenericHelper()
    {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
}
