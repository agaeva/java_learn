package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.DateContact;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.contact().goToHomePage();
    Contacts before = app.contact().all();
//    if (!app.group().isThereGroup()) {
//      app.group().create(new GroupDate().withName("test1").withFooter("test2").withHeader("test3"));
//    }
    DateContact contact = new DateContact()
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
            .withAddress2("r");
    app.contact().createContact(contact, true);
    assertThat(app.contact().getContactCount(), equalTo(before.size() + 1));

    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream()
                    .mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}

