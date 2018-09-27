package com.lemmer.spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lemmer.spring5webapp.repositories.BookRepository;

//Create a controller and annotated with @Controller (this tells it that it's a spring bean so it's now going to be a spring managed component)
//Declare the BookRepository variable, which we want to inject)
//Create a constructor that takes in a book repository which spring will auto wire and create an instance for 
//request mapping of books, so when we get a request that comes into the "/books" URL this method is going to get invoked,
// the spring framework with spring MVC is going to pass in an instance of the 
//add an attribute to the model called "books" and that's going to be a list of books out of the book repository.
//So underneath the covers the bookrepositories using spring data JPA,
// it's going to use hibernate to go out and get a list of books out of our
// database
//returning the string books which is going to tell spring MVC to associate this with a view called "books"

@Controller // makes it a spring bean
public class BookController {
  
  private BookRepository bookRepository;
  
  
  /**
   * When spring creates this it is going to automatically inject the instance
   * of the bookRepository.
   * @param bookRepository
   */
  public BookController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  

  // In the model which is an interface spring will pass in the implementation of it at runtime
  // when this controller method is invoked.
  // 
  @RequestMapping("/books")
  public String getBooks(Model model) {
    
    // 
    model.addAttribute("books", bookRepository.findAll());
    
    // the "books" here is going to associate it with a Thymeleaf view.
    return "books";
  }
}
