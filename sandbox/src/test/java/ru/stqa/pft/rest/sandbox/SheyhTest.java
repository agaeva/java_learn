package ru.stqa.pft.rest.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SheyhTest {

  @Test
  public void SheyhTest() {
    SheyhClass n = new SheyhClass(13);
    Assert.assertEquals(n.N(), 27);
    Assert.assertEquals(n.x(), 14);
    Assert.assertEquals(n.y(), 9);
    Assert.assertEquals(n.z(), 3);
  }

}
