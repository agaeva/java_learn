package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.DateContact;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void addAllContact() {
        clickContact(By.xpath("//input[21]"));
    }

    public void fillFormContact(DateContact groupDateContact, boolean creation ) {
        addType(By.name("firstname"), groupDateContact.getFirstname());
        addType(By.name("lastname"), groupDateContact.getLastname());
        addType(By.name("address"), groupDateContact.getAddress());
        addType(By.name("home"), groupDateContact.getPhone1());
        addType(By.name("mobile"), groupDateContact.getPhone2());
        addType(By.name("work"), groupDateContact.getPhone3());
        clickContact(By.name("fax"));
        addType(By.name("email"), groupDateContact.getEmail());
        addType(By.name("address2"), groupDateContact.getAddress2());

       if (creation) {
           new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(groupDateContact.getContact());
       } else {
           Assert.assertFalse(isElementPresent(By.name("new_group")));
       }
    }

    public void createContact(DateContact contact, boolean creation) {
        clickButtonAdd();
        fillFormContact(contact,creation);
        addAllContact();
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

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void editContact(int index) { wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));

    }
    public void addContact() {
        clickContact(By.xpath("//input[22]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("entry")).size();
    }
    public void homeClick() { clickContact(By.linkText("home page"));
    }

    public List<DateContact> getContactList() {
        List<DateContact> contacts = new ArrayList<DateContact>();

        List<WebElement> elements = wd.findElements(By.name("entry"));

        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));

            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));

            DateContact contact = new DateContact(id, cells.get(2).getText(), cells.get(1).getText(), null, null, null, null,null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
