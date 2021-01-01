package ru.stqa.pft.rest.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "addressbook")

public class DataContact {
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "firstname")
  private String firstname;

  @Expose
  @Column(name = "lastname")
  private String lastname;



  @Expose
  @Column(name = "home")
  @Type(type = "text")
  private String homePhone;

  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobilePhone;

  @Expose
  @Column(name = "work")
  @Type(type = "text")
  private String workPhone;

  @Expose
  @Transient
  private String allPhones;

  @Expose
  @Type(type = "text")
  private String email;

  @Expose
  @Type(type = "text")
  private String email2;

  @Expose
  @Type(type = "text")
  private String email3;

  @Expose
  @Transient
  private String allEmails;

  @Expose
  @Type(type = "text")
  private String address;

  @Expose
  @Type(type = "text")
  private String address2;

  @Expose
  @Transient
  private String allAddress;

  @Expose
  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  public Groups getGroups() {
    return new Groups(groups);
  }

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable (name = "address_in_groups", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();

  public File getPhoto() {
    return new File(photo);
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DataContact that = (DataContact) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname) &&
            Objects.equals(homePhone, that.homePhone) &&
            Objects.equals(mobilePhone, that.mobilePhone) &&
            Objects.equals(workPhone, that.workPhone) &&
            Objects.equals(email, that.email) &&
            Objects.equals(email2, that.email2) &&
            Objects.equals(email3, that.email3) &&
            Objects.equals(address, that.address) &&
            Objects.equals(address2, that.address2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname, homePhone, mobilePhone, workPhone, email, email2, email3, address, address2);
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


  public DataContact withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }
  public DataContact inGroup (GroupData group){
    groups.add(group);
    return this;
  }

  @Override
  public String toString() {
    return "DataContact{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }


}
