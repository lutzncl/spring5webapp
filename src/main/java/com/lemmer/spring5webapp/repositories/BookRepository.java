package com.lemmer.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import com.lemmer.spring5webapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
