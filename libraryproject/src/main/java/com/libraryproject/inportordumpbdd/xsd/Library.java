//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2015.12.14 à 09:44:38 AM CET 
//


package com.libraryproject.inportordumpbdd.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}authors"/>
 *         &lt;element ref="{}categories"/>
 *         &lt;element ref="{}books"/>
 *         &lt;element ref="{}users"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "authors",
    "categories",
    "books",
    "users"
})
@XmlRootElement(name = "library")
public class Library {

    @XmlElement(required = true)
    protected Authors authors;
    @XmlElement(required = true)
    protected Categories categories;
    @XmlElement(required = true)
    protected Books books;
    @XmlElement(required = true)
    protected Users users;

    /**
     * Obtient la valeur de la propriété authors.
     * 
     * @return
     *     possible object is
     *     {@link Authors }
     *     
     */
    public Authors getAuthors() {
        return authors;
    }

    /**
     * Définit la valeur de la propriété authors.
     * 
     * @param value
     *     allowed object is
     *     {@link Authors }
     *     
     */
    public void setAuthors(Authors value) {
        this.authors = value;
    }

    /**
     * Obtient la valeur de la propriété categories.
     * 
     * @return
     *     possible object is
     *     {@link Categories }
     *     
     */
    public Categories getCategories() {
        return categories;
    }

    /**
     * Définit la valeur de la propriété categories.
     * 
     * @param value
     *     allowed object is
     *     {@link Categories }
     *     
     */
    public void setCategories(Categories value) {
        this.categories = value;
    }

    /**
     * Obtient la valeur de la propriété books.
     * 
     * @return
     *     possible object is
     *     {@link Books }
     *     
     */
    public Books getBooks() {
        return books;
    }

    /**
     * Définit la valeur de la propriété books.
     * 
     * @param value
     *     allowed object is
     *     {@link Books }
     *     
     */
    public void setBooks(Books value) {
        this.books = value;
    }

    /**
     * Obtient la valeur de la propriété users.
     * 
     * @return
     *     possible object is
     *     {@link Users }
     *     
     */
    public Users getUsers() {
        return users;
    }

    /**
     * Définit la valeur de la propriété users.
     * 
     * @param value
     *     allowed object is
     *     {@link Users }
     *     
     */
    public void setUsers(Users value) {
        this.users = value;
    }

}
