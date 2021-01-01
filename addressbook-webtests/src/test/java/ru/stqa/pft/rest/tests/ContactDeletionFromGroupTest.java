package ru.stqa.pft.rest.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.rest.model.Contacts;
import ru.stqa.pft.rest.model.DataContact;
import ru.stqa.pft.rest.model.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ContactDeletionFromGroupTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
      String json = "";
      String line = reader.readLine();

      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<DataContact> contacts = gson.fromJson(json, new TypeToken<List<DataContact>>() {
      }.getType());

      return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
    }
  }

  @Test(dataProvider = "validContactsFromJson")
  public void testContactDeletionFromGroup(DataContact contact) throws Exception {
    app.goTo().groupPage();

    if (!app.group().isThereGroup()) {
      app.group().create(new GroupData().withName("test1").withFooter("test2").withHeader("test3"));
    }

    Contacts before = app.db().contacts();
    app.contact().goToHomePage();
    app.contact().createContact(contact, true);
    assertThat(app.contact().getContactCount(), equalTo(before.size() + 1));
    Contacts after = app.db().contacts();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream()
                    .mapToInt((c) -> c.getId()).max().getAsInt()))));
    verifyContactListInUI();

    int i = app.contact().all().stream()
            .mapToInt(DataContact::getId).max().orElseThrow();
    app.contact().selectContactById(i);
    app.contact().addGroupToContact();
    app.contact().pageAddGroupToContact();
    assertFalse(app.db().contacts().stream().filter(d -> d.getId() == i).findFirst().orElseThrow().getGroups().isEmpty());

    app.contact().goToHomePage();
    app.contact().selectGroupToContact();
    app.contact().selectContactById(i);
    app.contact().clickRemove();
    assertTrue(app.db().contacts().stream().filter(d -> d.getId() == i).findFirst().orElseThrow().getGroups().isEmpty());
  }
}
