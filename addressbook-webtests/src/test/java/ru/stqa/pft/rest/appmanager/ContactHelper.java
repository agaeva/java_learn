package ru.stqa.pft.rest.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.rest.model.Contacts;
import ru.stqa.pft.rest.model.DataContact;

import java.util.List;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void addAllContact() {
    clickContact(By.xpath("//input[21]"));
  }

  public void fillFormContact(DataContact groupDataContact, boolean creation) {
    addType(By.name("firstname"), groupDataContact.getFirstname());
    addType(By.name("lastname"), groupDataContact.getLastname());
    addType(By.name("home"), groupDataContact.getHomePhone());
    addType(By.name("mobile"), groupDataContact.getMobilePhone());
    addType(By.name("work"), groupDataContact.getWorkPhone());
    clickContact(By.name("fax"));
    addType(By.name("email"), groupDataContact.getEmail());
    addType(By.name("email2"), groupDataContact.getEmail2());
    addType(By.name("email3"), groupDataContact.getEmail3());
    addType(By.name("address"), groupDataContact.getAddress());
    addType(By.name("address2"), groupDataContact.getAddress2());
    attach(By.name("photo"), groupDataContact.getPhoto());

//    if (creation) {
//      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(groupDataContact.getContact());
//    } else {
//      Assert.assertFalse(isElementPresent(By.name("new_group")));
//    }
  }

  public void createContact(DataContact contact, boolean creation) {
    clickButtonAdd();
    fillFormContact(contact, creation);
    addAllContact();
    contactCache = null;
    goToHomePage();
  }



  public void modifyContact(DataContact contact) {
    editContactById(contact.getId());
    fillFormContact(contact, false);
    addContact();
    contactCache = null;
    homeClick();
  }



  public void deletionContact(DataContact contact) {
    selectContactById(contact.getId());
    deleteContact();
    alertMessage();
    contactCache = null;
    goToHomePage();
  }

  public void clickButtonAdd() {
    clickContact(By.linkText("add new"));
  }

  public void alertMessage() {
    wd.switchTo().alert().accept();
  }

  public void goToHomePage() {    clickContact(By.linkText("home"));  }

  public void deleteContact() {
    clickContact(By.xpath("//input[@value='Delete']"));
  }

  public void selectContactById(int id) {    wd.findElement(By.cssSelector("input[value= '"+ id + "']")).click(); }

  public void editContactById(int id) {  wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']",id))).click();  }

  public void editContact() {   wd.findElement(By.xpath("//img[@alt='Edit']")).click();  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void addContact() {
    clickContact(By.xpath("//input[22]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("entry")).size();
  }

  public void homeClick() {
    clickContact(By.linkText("home page"));
  }

  public void addGroupToContact() {
    clickContact(By.name("to_group"));
    clickContact(By.name("to_group"));
    clickContact(By.name("add"));
  }
  public void pageAddGroupToContact() {
    wd.findElement(By.partialLinkText("group page")).click();  }

    public void clickRemove() {
      clickContact(By.name("remove"));
  }

   public void selectGroupToContact() {
      clickContact(By.name("group"));
    clickContact(By.name("group"));

    }


  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts (contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> rows = wd.findElements(By.name("entry"));

    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));

      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String allAddress = cells.get(3).getText();
      String allEmails = cells.get(4).getText();
      String allPhones = cells.get(5).getText();


      DataContact contact = new DataContact().withId(id)
              .withFirstname(firstname)
              .withLastname(lastname)
              .withAllAddress(allAddress)
              .withAllEmails(allEmails)
              .withAllPhones(allPhones);

      contactCache.add(contact);
    }
    return new Contacts (contactCache);
  }

  public DataContact infoFromEditForm(DataContact contact) {
    editContactById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String address2 = wd.findElement(By.name("address2")).getAttribute("value");
    wd.navigate().back();

    return new DataContact().withId(contact.getId())
            .withFirstname(firstname)
            .withLastname(lastname)
            .withHomePhone(home)
            .withMobilePhone(mobile)
            .withWorkPhone(work)
            .withEmail(email)
            .withEmail2(email2)
            .withEmail3(email3)
            .withAddress(address)
            .withAddress2(address2);
  }


}

