package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;

import java.io.File;
import java.util.Objects;

public class DataContact {
  private int id = Integer.MAX_VALUE;
  @Expose
  private String firstname;
  @Expose
  private String lastname;
  @Expose
  private String contact;
  @Expose
  private String homePhone;
  @Expose
  private String mobilePhone;
  @Expose
  private String workPhone;
  @Expose
  private String allPhones;
  @Expose
  private String email;
  @Expose
  private String email2;
  @Expose
  private String email3;
  @Expose
  private String allEmails;
  @Expose
  private String address;
  @Expose
  private String address2;
  @Expose
  private String allAddress;
  @Expose
  private File photo;

  public File getPhoto() {
    return photo;
  }

  public DataContact withPhoto(File photo) {
    this.photo = photo;
    return this;
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

  public DataContact withAllAddress(String allAddress) {
    this.allAddress = allAddress;
    return this;
  }

  public DataContact withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public DataContact withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public DataContact withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public DataContact withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public DataContact withId(int id) {
    this.id = id;
    return this;
  }

  public DataContact withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public DataContact withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public DataContact withAddress(String address) {
    this.address = address;
    return this;
  }

  public DataContact withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public DataContact withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public DataContact withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public DataContact withEmail(String email) {
    this.email = email;
    return this;
  }

  public DataContact withAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  public DataContact withContact(String group) {
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
    DataContact contact = (DataContact) o;
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
