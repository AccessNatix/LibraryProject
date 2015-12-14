package com.libraryproject.entity;
// Generated 13 déc. 2015 17:11:41 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Category generated by hbm2java
 */
public class Category  implements java.io.Serializable {


     private Integer id;
     private String name;
     private Set<Book> books = new HashSet<Book>(0);

    public Category() {
    }

	
    public Category(String name) {
        this.name = name;
    }
    public Category(String name, Set<Book> books) {
       this.name = name;
       this.books = books;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Set<Book> getBooks() {
        return this.books;
    }
    
    public void setBooks(Set<Book> books) {
        this.books = books;
    }




}


