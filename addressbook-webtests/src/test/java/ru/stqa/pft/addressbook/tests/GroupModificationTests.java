package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        app.goTo().groupPage();
        if ( app.group().all().size() == 0){
            app.group().create(new GroupDate().withName("test1"));
        }
    }

    @Test
    public void testGroupCreation() {
        Groups before = app.group().all();
        GroupDate modifiedGroup = before.iterator().next();

        GroupDate group = new GroupDate()
                .withId(modifiedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
        app.group().modifyGroup(group);
        Groups after = app.group().all();
        assertEquals(after.size(), before.size() );
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    }


}