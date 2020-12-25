package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;

import ru.stqa.pft.addressbook.model.DateContact;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.contactHelper().goToHomePage();
    List<DateContact> before = app.contactHelper().contactList();
    if (!app.group().isThereGroup()) {
      app.group().create(new GroupDate().withName("test1").withFooter("test2").withHeader("test3"));
    }
    DateContact contact = new DateContact().withFirstname("Ivan")
            .withLastname("Petrov").withContact("test1").withAddress("Tver").withPhone1("557868686")
            .withPhone2("938374664").withPhone3("383664664").withEmail("test@test.ru").withAddress2("r");

    app.contactHelper().createContact(contact, true);

    List<DateContact> after = app.contactHelper().contactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super DateContact> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}

