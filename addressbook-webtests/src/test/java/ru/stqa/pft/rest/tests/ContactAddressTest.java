package ru.stqa.pft.rest.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.rest.model.DataContact;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTest extends TestBase{
  @Test
  public void testContactEmails() {
    app.contact().goToHomePage();
    DataContact contact = app.contact().all().iterator().next();
    DataContact contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllAddress(), equalTo(mergeEmails(contactInfoFromEditForm)));



  }

  private String mergeEmails(DataContact contact) {
    return Arrays.asList(contact.getAddress())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactAddressTest::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String address) {
    return address.replaceAll("\\s", "").replaceAll("[-,]","");
  }

}
