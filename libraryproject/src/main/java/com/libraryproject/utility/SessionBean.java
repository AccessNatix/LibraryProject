package com.libraryproject.utility;

import java.io.Serializable;

/**
 * Session bean for the user
 * 
 * 
 * @author anatole
 */
public class SessionBean implements Serializable{
   
    private final int id;
    
    public SessionBean(int id)
    {
        this.id = id;
    }
    
    public int getId()
    {
        return this.id;
    }
}
