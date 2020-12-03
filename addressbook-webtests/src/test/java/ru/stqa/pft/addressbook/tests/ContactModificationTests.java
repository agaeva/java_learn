package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.DateContact;
import ru.stqa.pft.addressbook.model.GroupDate;

public class ContactModificationTests extends TestBase{
    @Test
    public void testContactCreation() throws Exception {
        if (! app.getGroupHelper().isThereaGroup()){
            app.getContactHelper().createContact(new DateContact("Ivan", "Petrov", "test1","Tver", "557868686", "938374664", "383664664", "test@test.ru", "r"), true);
        }
        app.getContactHelper().editContact();
        app.getContactHelper().fillFormContact(new DateContact("Ivan", "Petrov", null, null, null, null, null, null, null),false);
        app.getContactHelper().addAllContact();
    }
}
