package com.lemmer.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import com.lemmer.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Integer> {

}
