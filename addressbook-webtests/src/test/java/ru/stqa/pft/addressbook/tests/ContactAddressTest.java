package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.DateContact;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTest extends TestBase{
  @Test
  public void testContactEmails() {
    app.contact().goToHomePage();
    DateContact contact = app.contact().all().iterator().next();
    DateContact contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllAddress(), equalTo(mergeEmails(contactInfoFromEditForm)));



  }

  private String mergeEmails(DateContact contact) {
    return Arrays.asList(contact.getAddress())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactAddressTest::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String address) {
    return address.replaceAll("\\s", "").replaceAll("[-,]","");
  }

}
