package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.DateContact;
import ru.stqa.pft.addressbook.model.GroupDate;



import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    app.contactHelper().goToHomePage();
    Contacts before = app.contactHelper().all();
    if (!app.group().isThereGroup()) {
      app.group().create(new GroupDate().withName("test1").withFooter("test2").withHeader("test3"));
    }
    DateContact contact = new DateContact().withFirstname("Ivan")
            .withLastname("Petrov").withContact("test1").withAddress("Tver").withPhone1("557868686")
            .withPhone2("938374664").withPhone3("383664664").withEmail("test@test.ru").withAddress2("r");
    app.contactHelper().createContact(contact, true);

   Contacts after = app.contactHelper().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream()
                    .mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}

