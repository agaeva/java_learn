package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class DateContact {
  private int id;
  private String firstname;
  private String lastname;
  private String address;
  private String phone1;
  private String phone2;
  private String phone3;
  private String email;
  private String address2;


  private String contact;



  public DateContact(String firstname, String lastname, String group, String address, String phone1, String phone2, String phone3, String email, String address2) {
    this.id = Integer.MAX_VALUE;
    this.firstname = firstname;
    this.lastname = lastname;
    this.contact = group;
    this.address = address;
    this.phone1 = phone1;
    this.phone2 = phone2;
    this.phone3 = phone3;
    this.email = email;
    this.address2 = address2;
  }

  public DateContact(int id, String firstname, String lastname, String group, String address, String phone1, String phone2, String phone3, String email, String address2) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.contact = group;
    this.address = address;
    this.phone1 = phone1;
    this.phone2 = phone2;
    this.phone3 = phone3;
    this.email = email;
    this.address2 = address2;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getPhone1() {
    return phone1;
  }

  public String getPhone2() {
    return phone2;
  }

  public String getPhone3() {
    return phone3;
  }

  public String getEmail() {
    return email;
  }

  public String getAddress2() {
    return address2;
  }

  public String getContact() {
    return contact;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DateContact contact = (DateContact) o;
    return Objects.equals(firstname, contact.firstname) &&
            Objects.equals(lastname, contact.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname);
  }


  @Override
  public String toString() {
    return "DateContact{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }


}
