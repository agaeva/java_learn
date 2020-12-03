package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;

import ru.stqa.pft.addressbook.model.DateContact;
import ru.stqa.pft.addressbook.model.GroupDate;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    if (! app.getGroupHelper().isThereaGroup()){
      app.getGroupHelper().createGroup(new GroupDate("test1", "test2", "test3"));
    }
    app.getContactHelper().clickButtonAdd();
    app.getContactHelper().fillFormContact(new DateContact("Ivan", "Petrov", "test1","Tver", "557868686", "938374664", "383664664", "test@test.ru", "r"), true);
    app.getContactHelper().addAllContact();
  }



}
