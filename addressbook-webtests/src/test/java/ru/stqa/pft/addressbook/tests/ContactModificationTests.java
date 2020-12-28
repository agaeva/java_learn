package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.DataContact;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if (app.db().contacts().size() == 0) {
      app.contact().goToHomePage();
      app.contact().createContact(new DataContact()
              .withFirstname("Ivan")
              .withLastname("Petrov")
              .withContact("test1")
              .withHomePhone("557868686")
              .withMobilePhone("938374664")
              .withWorkPhone("383664664")
              .withEmail("test@test.ru")
              .withEmail2("test2@test.ru")
              .withEmail3("test3@test.ru")
              .withAddress("Tver")
              .withAddress2("r"), true);
    }
  }

  @Test
  public void testContactCreation() throws Exception {

    Contacts before = app.db().contacts();
    DataContact modifiedContact = before.iterator().next();

    DataContact contact = new DataContact()
            .withId(modifiedContact.getId())
            .withFirstname("Ivan")
            .withLastname("Petrov")
            .withAddress("Tver")
            .withHomePhone("557868686")
            .withMobilePhone("938374664")
            .withWorkPhone("383664664")
            .withEmail("test@test.ru")
            .withEmail2("test2@test.ru")
            .withEmail3("test3@test.ru")
            .withAddress("Tver")
            .withAddress2("r")
            .withPhoto(new File("src/test/resources/contacts.json"));
    app.contact().goToHomePage();
    app.contact().modifyContact(contact);
    assertThat(app.contact().getContactCount(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }


}
