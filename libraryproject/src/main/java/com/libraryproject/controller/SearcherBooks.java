package com.libraryproject.controller;

import com.libraryproject.entity.Author;
import com.libraryproject.entity.Book;
import com.libraryproject.entity.Category;
import com.libraryproject.helperentity.BookHelper;
import java.util.List;

/**
 * A lirreeeeeeeeeeeeeeee!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * A lirreeeeeeeeeeeeeeee!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * A lirreeeeeeeeeeeeeeee!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * 
 * Input possible de la recherche
 * - Author
 * - Category
 * - KeyWords (list)
 * 
 * Output
 * - Liste de book résultant après recherche
 * 
 * 1. Vérifier l'intégrité des keywords
 * 2. Commencer par rechercher les bouquins par authors et par category (réduire l'input) si c'est défini
 * 3. Faire une recherche reliant les keywords avec par exemple la description et le nom du fichier
 * 4. Et ça devrait être cool
 * 
 * 
 * @author anatole
 */
public class SearcherBooks {
  
    private Author author;
    private Category category;
    private List<String> keywords;
    
    public SearcherBooks()
    {
        this.author = null;
        this.category = null;
        this.keywords = null;
    }
    
    public void setAuthor(Author author)
    {
        this.author = author;
    }
    
    public void setCategory(Category category)
    {
        this.category = category;
    }
    
    public void setKeywords(List<String> keywords)
    {
        this.keywords = keywords;
    }
    
    /**
     * Corps de fonction voulu
     * 
     * @return bouquin correspondant aux critères
     */
    public List<Book> search()
    {
        BookHelper bookHelper = new BookHelper();
        
        //List<Book> book = bookHelper.findAll();
        
        // DO SOME STUFF
        
        return null;
    }
}
