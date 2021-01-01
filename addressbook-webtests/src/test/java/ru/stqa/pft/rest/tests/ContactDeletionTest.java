package ru.stqa.pft.rest.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.rest.model.Contacts;
import ru.stqa.pft.rest.model.DataContact;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    app.contact().goToHomePage();
    if (!app.group().isThereGroup()) {
      app.contact().createContact(new DataContact() .withFirstname("Ivan")
              .withLastname("Petrov")
//              .withContact("test1")
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
  public void testContactDeletion() throws Exception {

    Contacts before = app.db().contacts();
    DataContact deletedContact = before.iterator().next();
    app.contact().deletionContact(deletedContact);
    Contacts after = app.db().contacts();
    assertThat(app.contact().getContactCount(), equalTo(before.size() - 1));
    assertThat(after, equalTo(before.without(deletedContact)));
    verifyContactListInUI();

  }


}
