package ru.stqa.pft.addressbook.tests;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.DateContact;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    app.contactHelper().goToHomePage();
    if (!app.group().isThereGroup()) {
      app.contactHelper().createContact(new DateContact().withFirstname("Ivan")
              .withLastname("Petrov").withContact("test1").withAddress("Tver").withPhone1("557868686")
              .withPhone2("938374664").withPhone3("383664664").withEmail("test@test.ru").withAddress2("r"), true);
    }
  }

  @Test
  public void testContactDeletion() throws Exception {

    Contacts before = app.contactHelper().all();
    DateContact deletedContact = before.iterator().next();
    app.contactHelper().deletionContact(deletedContact);
    Contacts after = app.contactHelper().all();
    assertEquals(after.size(), before.size() - 1);
    assertThat(after, equalTo(before.without(deletedContact)));

  }




}
