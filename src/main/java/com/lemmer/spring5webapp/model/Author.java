package com.lemmer.spring5webapp.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Author class
 * @author lutzlemmer
 * @since 06/09/2018
 */
@Entity
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String firstName;
  private String lastNamel;
  
  @ManyToMany
  private Set<Book> books = new HashSet<>();
  
  public Author(){
    
  }

  public Author(String firstName, String lastNamel) {
    
    this.firstName = firstName;
    this.lastNamel = lastNamel;
  }

  public Author(String firstName, String lastNamel, Set<Book> books) {
    
    this.firstName = firstName;
    this.lastNamel = lastNamel;
    this.books = books;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastNamel() {
    return lastNamel;
  }

  public void setLastNamel(String lastNamel) {
    this.lastNamel = lastNamel;
  }

  public Set<Book> getBooks() {
    return books;
  }

  public void setBooks(Set<Book> books) {
    this.books = books;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Author other = (Author) obj;
    if (id != other.id)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Author [id=" + id + ", firstName=" + firstName + ", lastNamel=" + lastNamel + ", books="
        + books + "]";
  }
  
  
  
  
}
