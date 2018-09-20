package com.lemmer.spring5webapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Publisher class
 * One-to-one relationship with book at stage one.
 * @author lutzlemmer
 * @since 18/09/2018
 *
 */
@Entity
public class Publisher {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String firstNameP;
  private String lastNameP;
  private String postcode;
  private String city;
  private String street;
  private String houseNumber;
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getFirstNameP() {
    return firstNameP;
  }
  public void setFirstNameP(String firstNameP) {
    this.firstNameP = firstNameP;
  }
  public String getLastNameP() {
    return lastNameP;
  }
  public void setLastNameP(String lastNameP) {
    this.lastNameP = lastNameP;
  }
  public String getPostcode() {
    return postcode;
  }
  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }
  public String getStreet() {
    return street;
  }
  public void setStreet(String street) {
    this.street = street;
  }
  public String getHouseNumber() {
    return houseNumber;
  }
  public void setHouseNumber(String houseNumber) {
    this.houseNumber = houseNumber;
  }
  
  
}
