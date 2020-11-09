package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.DateContact;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void addAllContact() {
        clickContact(By.xpath("//input[21]"));
    }

    public void fillFormContact(DateContact groupDateContact) {
        addType(By.name("firstname"), groupDateContact.getFirstname());
        addType(By.name("lastname"), groupDateContact.getLastname());
        addType(By.name("address"), groupDateContact.getAddress());
        addType(By.name("home"), groupDateContact.getPhone1());
        addType(By.name("mobile"), groupDateContact.getPhone2());
        addType(By.name("work"), groupDateContact.getPhone3());
        clickContact(By.name("fax"));
        addType(By.name("email"), groupDateContact.getEmail());
        addType(By.name("address2"), groupDateContact.getAddress2());
    }

    public void clickButtonAdd() {
        clickContact(By.linkText("add new"));
    }

    public void alertMessage() {
        wd.switchTo().alert().accept();;
    }

    public void returnHomePage() {
        clickContact(By.linkText("home"));
    }

    public void deleteContact() {
        clickContact(By.xpath("//input[@value='Delete']"));
    }

    public void selectContact() {
        clickContact(By.name("selected[]"));
    }
}
