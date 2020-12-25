package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().groupPage();
    if (app.group().list().size() == 0){
      app.group().create(new GroupDate().withName("test1"));
    }
  }

  @Test
  public void testGroupDeletion() throws Exception {

    List<GroupDate> before = app.group().list();
    int index = before.size() - 1;

    app.group().deleteGroup(index);

    List<GroupDate> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
      Assert.assertEquals(before, after);

  }




}
