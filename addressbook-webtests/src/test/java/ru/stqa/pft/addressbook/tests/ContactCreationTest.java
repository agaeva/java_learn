package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;

import ru.stqa.pft.addressbook.model.DateContact;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    List<DateContact> before = app.getContactHelper().getContactList();
    if (!app.getGroupHelper().isThereaGroup()) {
      app.getGroupHelper().createGroup(new GroupDate("test1", "test2", "test3"));
    }
    DateContact contact = new DateContact("Ivan", "Petrov", "test1", "Tver", "557868686", "938374664", "383664664", "test@test.ru", "r");
    app.getContactHelper().clickButtonAdd();
    app.getContactHelper().fillFormContact((contact), true);
    app.getContactHelper().addAllContact();
    app.getContactHelper().returnHomePage();
    List<DateContact> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);


    before.add(contact); //добавление в старый список контакт,который  мы только что создали
    //предсказывание ожидаемый результата
    Comparator<? super DateContact> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());

    before.sort(byId);

    after.sort(byId);

    Assert.assertEquals(before, after);
  }

}

