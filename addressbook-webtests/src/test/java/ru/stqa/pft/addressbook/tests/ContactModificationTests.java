package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.DateContact;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
//    if (!app.getGroupHelper().isThereaGroup()) {
//      app.getContactHelper().createContact(new DateContact("Ivan", "Petrov", "test1", "Tver", "557868686", "938374664", "383664664", "test@test.ru", "r"), true);
//    }

    List<DateContact> before = app.getContactHelper().getContactList();

//    app.getContactHelper().selectContact();

    app.getContactHelper().editContact(before.size() - 1);

    DateContact contact = new DateContact(before.get(before.size() - 1).getId(), "Ivan", "Petrov", null, null, null, null, null, null, null);

    app.getContactHelper().fillFormContact(contact, false);

    app.getContactHelper().addContact();

    app.getContactHelper().homeClick();

    List<DateContact> after = app.getContactHelper().getContactList();

    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);

    before.add(contact);

    Comparator<? super DateContact> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());

    before.sort(byId);

    after.sort(byId);

    Assert.assertEquals(before, after);
  }
}
