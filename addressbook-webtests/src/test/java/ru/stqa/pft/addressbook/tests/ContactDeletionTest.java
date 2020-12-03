package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.DateContact;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact (new DateContact("Ivan", "Petrov", "test1","Tver", "557868686", "938374664", "383664664", "test@test.ru", "r"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().alertMessage();
    app.getContactHelper().returnHomePage();
  }



}
