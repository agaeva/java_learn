package ru.stqa.pft.rest.tests;
import org.testng.annotations.Test;
import ru.stqa.pft.rest.model.DataContact;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTest extends TestBase {
   @Test
   public void testContactPhones() {
     app.contact().goToHomePage();
     DataContact contact = app.contact().all().iterator().next();
     DataContact contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

     assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));

   }

  private String mergePhones(DataContact contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
              .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneTest::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
     return phone.replaceAll("\\s", "").replaceAll("[-()]","");
   }
}
