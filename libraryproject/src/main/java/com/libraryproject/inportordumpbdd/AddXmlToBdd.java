package com.libraryproject.inportordumpbdd;

import com.libraryproject.entity.Author;
import com.libraryproject.entity.Book;
import com.libraryproject.entity.Borrowed;
import com.libraryproject.entity.Category;
import com.libraryproject.entity.User;
import com.libraryproject.helperentity.AuthorHelper;
import com.libraryproject.helperentity.BookHelper;
import com.libraryproject.helperentity.BorrowedHelper;
import com.libraryproject.helperentity.CategoryHelper;
import com.libraryproject.helperentity.UserHelper;
import com.libraryproject.inportordumpbdd.init.Init;
import com.libraryproject.inportordumpbdd.xsd.Library;
import java.io.File;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * add xml to bdd *  * @author anatole
@author anatole

 * 
 * 
 * @author anatole
 */
public class AddXmlToBdd {
    
    private final UserHelper mUserHelper;
    private final AuthorHelper mAuthorHelper;
    private final BookHelper mBookHelper;
    private final CategoryHelper mCategoryHelper;
    private final BorrowedHelper mBorrowedHelper;
    
    public AddXmlToBdd()
    {
        this.mUserHelper = new UserHelper();
        this.mAuthorHelper = new AuthorHelper();
        this.mCategoryHelper = new CategoryHelper();
        this.mBookHelper = new BookHelper();
        this.mBorrowedHelper = new BorrowedHelper();
    }
    
    /**
     * Parse xml to Library
     * @param xmlConfigurationLibraryPath
     * @return 
     */
    private Library parseXmlToLibrary(String xmlConfigurationLibraryPath)
    {
        Library library = null;
        
        try {
            File file = new File(xmlConfigurationLibraryPath);
            JAXBContext jaxbContext = JAXBContext.newInstance(Library.class);

            Unmarshaller jaxbUnmarshallerl = jaxbContext.createUnmarshaller();
            library = (Library) jaxbUnmarshallerl.unmarshal(file);
        } catch (JAXBException ex) {
            Logger.getLogger(AddXmlToBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return library;
    }
    
    public void loadXmlInDatabase(String xmlConfigurationLibraryPath, Map<String, byte[]> imagePath)
    {
        Library library = parseXmlToLibrary(xmlConfigurationLibraryPath);
        
        // get all fields from the xml
        List<com.libraryproject.inportordumpbdd.xsd.Author> authors = library.getAuthors().getAuthor();
        List<com.libraryproject.inportordumpbdd.xsd.Category> categories = library.getCategories().getCategory();
        List<com.libraryproject.inportordumpbdd.xsd.Book> books = library.getBooks().getBook();
        List<com.libraryproject.inportordumpbdd.xsd.User> users = library.getUsers().getUser();
        
        // delete borrowe book
        this.mBorrowedHelper.reset();
        // delete books
        this.mBookHelper.reset();
        // delete users
        this.mUserHelper.reset();
        // delete authors
        this.mAuthorHelper.reset();
        // delete category
        this.mCategoryHelper.reset();
        
        // put all user inside the database
        for(com.libraryproject.inportordumpbdd.xsd.User user : users)
        {
            User userTmp = new User(user.getName(), user.getSurname(), user.getEmail(), user.getUsername(), user.getPassword(), false, new HashSet<Borrowed>());
            this.mUserHelper.save(userTmp);
        }
        
        // put all category inside the database
        for(com.libraryproject.inportordumpbdd.xsd.Category category : categories)
        {
            Category categoryTmp = new Category(category.getName(),new HashSet<Book>());
            categoryTmp.setId(category.getId().intValue());
            this.mCategoryHelper.create(categoryTmp);
        }
        
        // put all author inside the database        
        for(com.libraryproject.inportordumpbdd.xsd.Author author : authors)
        {
            Author authorTmp = new Author(author.getName(), new HashSet<Book>());
            authorTmp.setId(author.getId().intValue());
            this.mAuthorHelper.create(authorTmp);
        }

        // put all author inside the database        
        for(com.libraryproject.inportordumpbdd.xsd.Book book : books)
        {
            // get author and get category
            Author authorTmp = this.mAuthorHelper.find(book.getAuthorId().intValue());
            Category categoryTmp = this.mCategoryHelper.find(book.getCategoryId().intValue());
            
            Book bookTmp = new Book(authorTmp, categoryTmp, book.getTitle(), new BigDecimal(0), book.getDescription(), book.getStock().intValue(), book.getImage());
            this.mBookHelper.create(bookTmp);
        }

    }
    
    public Init getInitConfiguration(String confxml)
    {
        Init init = null;
        
        try {
            File file = new File(confxml);
            JAXBContext jaxbContext = JAXBContext.newInstance(Init.class);

            Unmarshaller jaxbUnmarshallerl = jaxbContext.createUnmarshaller();
            init = (Init) jaxbUnmarshallerl.unmarshal(file);
        } catch (JAXBException ex) {
            Logger.getLogger(AddXmlToBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return init;
    }
}
