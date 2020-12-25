package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.DateContact;

import java.util.List;

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

    List<DateContact> before = app.contactHelper().contactList();
    int index = before.size() - 1;

    app.contactHelper().deletionContact(index);

    List<DateContact> after = app.contactHelper().contactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);
  }




}
