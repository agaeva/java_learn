package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.DateContact;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    app.contactHelper().goToHomePage();
    if (!app.group().isThereGroup()) {
      app.contactHelper().createContact(new DateContact().withFirstname("Ivan")
              .withLastname("Petrov").withAddress("Tver").withPhone1("557868686")
              .withPhone2("938374664").withPhone3("383664664").withEmail("test@test.ru").withAddress2("r"), true);
    }
  }

  @Test
  public void testContactCreation() throws Exception {

    List<DateContact> before = app.contactHelper().contactList();
    int index = before.size() - 1;
    app.contactHelper().editContact(index);

    DateContact contact = new DateContact().withId(before.get(index).getId()).withFirstname("Ivan")
            .withLastname("Petrov").withContact("test1").withAddress("Tver").withPhone1("557868686")
            .withPhone2("938374664").withPhone3("383664664").withEmail("test@test.ru").withAddress2("r");

    app.contactHelper().modifyContact(contact);

    List<DateContact> after = app.contactHelper().contactList();

    Assert.assertEquals(after.size(), before.size());

    before.remove(index);

    before.add(contact);

    Comparator<? super DateContact> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());

    before.sort(byId);

    after.sort(byId);

    Assert.assertEquals(before, after);
  }


}
