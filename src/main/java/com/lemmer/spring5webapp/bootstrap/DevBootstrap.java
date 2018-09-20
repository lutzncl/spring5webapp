package com.lemmer.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import com.lemmer.spring5webapp.model.Author;
import com.lemmer.spring5webapp.model.Book;
import com.lemmer.spring5webapp.repositories.AuthorRepository;
import com.lemmer.spring5webapp.repositories.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

  private AuthorRepository authorRepository;
  private BookRepository bookRepository;
  
  
  
  public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }



  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    initData();
  }
  
  
  
  private void initData() {
    
    //Eric
    Author eric = new Author("Eric", "Evans");
    Book ddd = new Book("Domain Driven Design", "1234", "HarperCollins");
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);
    
    authorRepository.save(eric);
    bookRepository.save(ddd);
    
  //Eric
    Author rod = new Author("Rod", "Johnson");
    Book noEJB = new Book("J2EE Development without EJB", "23443", "Worx");
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);
    
    authorRepository.save(rod);
    bookRepository.save(noEJB);
  }
 
}
