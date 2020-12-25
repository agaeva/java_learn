package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class DateContact {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String lastname;
  private String contact;
  private String address;
  private String phone1;
  private String phone2;
  private String phone3;
  private String email;
  private String address2;


  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() { return address;
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

  public int getId() {
    return id;
  }

  public DateContact withId(int id) {

    this.id = id;
    return this;
  }

  public DateContact  withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public DateContact  withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public DateContact  withAddress(String address) {
    this.address = address;
    return this;
  }

  public DateContact  withPhone1(String phone1) {
    this.phone1 = phone1;
    return this;
  }

  public DateContact  withPhone2(String phone2) {
    this.phone2 = phone2;
    return this;
  }

  public DateContact  withPhone3(String phone3) {
    this.phone3 = phone3;
    return this;
  }

  public DateContact  withEmail(String email) {
    this.email = email;
    return this;
  }

  public DateContact  withAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  public DateContact  withContact(String group) {
    this.contact = group;
    return this;
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
