package ru.stqa.pft.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.DateContact;

import java.util.List;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact (new DateContact("Ivan", "Petrov", "test1","Tver", "557868686", "938374664", "383664664", "test@test.ru", "r"), true);
    }
    List<DateContact> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteContact();
    app.getContactHelper().alertMessage();
    app.getContactHelper().returnHomePage();
    List<DateContact> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1 );

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }



}
