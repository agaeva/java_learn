package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.DataContact;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));
    String json = "";
    String line = reader.readLine();

    while (line != null) {
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
    List<DataContact> contacts = gson.fromJson(json, new TypeToken<List<DataContact>>() {}.getType());

    return contacts.stream().map((c) -> new Object[] {c}).collect(Collectors.toList()).iterator();
  }

  @Test(dataProvider = "validContactsFromJson")
  public void testContactCreation(DataContact contact) throws Exception {
    app.contact().goToHomePage();
    Contacts before = app.contact().all();
//    if (!app.group().isThereGroup()) {
//      app.group().create(new GroupData().withName("test1").withFooter("test2").withHeader("test3"));
//    }

    app.contact().createContact(contact, true);
    assertThat(app.contact().getContactCount(), equalTo(before.size() + 1));

    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream()
                    .mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}
