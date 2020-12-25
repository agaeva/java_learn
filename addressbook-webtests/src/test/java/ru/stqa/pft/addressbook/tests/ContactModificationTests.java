package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.DateContact;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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

    Contacts before = app.contactHelper().all();
    DateContact modifiedContact = before.iterator().next();

    DateContact contact = new DateContact().withId(modifiedContact.getId()).withFirstname("Ivan")
            .withLastname("Petrov").withAddress("Tver").withPhone1("557868686")
            .withPhone2("938374664").withPhone3("383664664").withEmail("test@test.ru").withAddress2("r");
    app.contactHelper().modifyContact(contact);

    Contacts after = app.contactHelper().all();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }


}
