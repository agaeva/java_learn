package ru.stqa.pft.addressbook.model;

public class DateContact {
    private final String firstname;
    private final String lastname;
    private final String address;
    private final String phone1;
    private final String phone2;
    private final String phone3;
    private final String email;
    private final String address2;

    public DateContact(String firstname, String lastname, String address, String phone1, String phone2, String phone3, String email, String address2) {
        this.firstname = firstname;
        this.lastname = lastname;
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
}
