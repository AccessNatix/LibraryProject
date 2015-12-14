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
    private final boolean type;
    
    public SessionBean(int id, boolean type)
    {
        this.id = id;
        this.type = type;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public boolean getType()
    {
        return this.type;
    }
}
