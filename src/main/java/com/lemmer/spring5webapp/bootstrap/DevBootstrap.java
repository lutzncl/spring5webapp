package com.lemmer.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import com.lemmer.spring5webapp.model.Author;
import com.lemmer.spring5webapp.model.Book;
import com.lemmer.spring5webapp.model.Publisher;
import com.lemmer.spring5webapp.repositories.AuthorRepository;
import com.lemmer.spring5webapp.repositories.BookRepository;
import com.lemmer.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

  private AuthorRepository authorRepository;
  private BookRepository bookRepository;
  private PublisherRepository publisherRepository;
  
  
  
  public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
      PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }



  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    initData();
  }
  
  
  
  private void initData() {
    
    Publisher publisher1 = new Publisher();
    publisher1.setName("Harper Collins");
    publisher1.setPostcode("NE21 2FB");
    publisher1.setCity("Newcastle");
    publisher1.setStreet("Northumberland Street");
    publisher1.setHouseNumber("43");
    
    publisherRepository.save(publisher1);
    
    Publisher publisher2 = new Publisher();
    publisher2.setName("Worx");
    publisher2.setPostcode("NE21 3FB");
    publisher2.setCity("Newcastle");
    publisher2.setStreet("Northumberland Street");
    publisher2.setHouseNumber("42");
    
    publisherRepository.save(publisher2);
    
    //Eric
    Author eric = new Author("Eric", "Evans");
    Book ddd = new Book("Domain Driven Design", "1234", publisher1);
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);
    
    authorRepository.save(eric);
    bookRepository.save(ddd);
    
  //Eric
    Author rod = new Author("Rod", "Johnson");
    Book noEJB = new Book("J2EE Development without EJB", "23443", publisher2);
    rod.getBooks().add(noEJB);
    noEJB.getAuthors().add(eric);
    
    authorRepository.save(rod);
    bookRepository.save(noEJB);
  }
 
}
