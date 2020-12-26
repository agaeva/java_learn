package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class DateContact {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String lastname;
  private String contact;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;
  private String allPhones;
  private String email;
  private String email2;
  private String email3;
  private String allEmails;
  private String address;
  private String address2;
  private String allAddress;


  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }


  public String getWorkPhone() {
    return workPhone;
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

  public String getAllPhones() {
    return allPhones;
  }

  public String getEmail2() {
    return email2;
  }
  public String getEmail3() {
    return email3;
  }
  public String getAllEmails() {
    return allEmails;
  }
  public String getAllAddress() {
    return allAddress;
  }

  public DateContact withAllAddress(String allAddress) {
    this.allAddress = allAddress;
    return this;
  }

  public DateContact withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public DateContact withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public DateContact withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public DateContact withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public DateContact withId(int id) {
    this.id = id;
    return this;
  }

  public DateContact withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public DateContact withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public DateContact withAddress(String address) {
    this.address = address;
    return this;
  }

  public DateContact withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public DateContact withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public DateContact withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public DateContact withEmail(String email) {
    this.email = email;
    return this;
  }

  public DateContact withAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  public DateContact withContact(String group) {
    this.contact = group;
    return this;
  }
  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DateContact contact = (DateContact) o;
    return id == contact.id &&
            Objects.equals(firstname, contact.firstname) &&
            Objects.equals(lastname, contact.lastname);
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
