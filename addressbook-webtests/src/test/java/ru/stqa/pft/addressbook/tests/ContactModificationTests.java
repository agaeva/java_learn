package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.DateContact;

public class ContactModificationTests extends TestBase{
    @Test
    public void testContactCreation() throws Exception {
        app.getContactHelper().editContact();
        app.getContactHelper().fillFormContact(new DateContact("Ivan", "Petrov", null, null, null, null, null, null, null),false);
        app.getContactHelper().addAllContact();
    }
}
