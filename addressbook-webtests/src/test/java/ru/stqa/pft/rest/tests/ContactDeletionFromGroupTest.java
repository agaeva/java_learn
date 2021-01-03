package ru.stqa.pft.rest.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.rest.model.Contacts;
import ru.stqa.pft.rest.model.DataContact;
import ru.stqa.pft.rest.model.GroupData;
import ru.stqa.pft.rest.model.Groups;

import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionFromGroupTest extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.contact().goToHomePage();
            DataContact contact = new DataContact().withFirstname("Ivan").withLastname("Petrov").withEmail("test@test.ru");
            app.contact().createContact(contact, true);
        }

        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testContactDeleteFromGroup() {
        Contacts beforeContacts = app.db().contacts();
        DataContact selectContact = beforeContacts.iterator().next();
        Groups beforeGroups = app.db().groups();
        GroupData selectGroup = beforeGroups.iterator().next();
        app.contact().goToHomePage();

        if (selectContact.getGroups().isEmpty() || !selectContact.getGroups().contains(selectGroup)) {
            app.contact().selectShowGroup("[all]");
            app.contact().addContactToGroup(selectContact, selectGroup);
            Groups exp = selectContact.getGroups().withAdded(selectGroup);
            assertThat(exp, equalTo(app.db().contacts().stream().
                    filter((c) -> c.getId() == selectContact.getId())
                    .collect(Collectors.toList()).get(0).getGroups()));
            app.contact().goToHomePage();
        }
        app.contact().deleteContactFromGroup(selectContact, selectGroup);
        app.contact().goToHomePage();
        app.contact().selectShowGroup("[all]");
        Groups expGroups = selectContact.getGroups().without(selectGroup);
        assertThat(expGroups, equalTo(app.db().contacts().stream().
                filter((c) -> c.getId() == selectContact.getId())
                .collect(Collectors.toList()).get(0).getGroups()));
        verifyContactListInUI();
    }
}