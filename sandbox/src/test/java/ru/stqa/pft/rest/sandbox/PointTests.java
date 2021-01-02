package ru.stqa.pft.rest.sandbox;


import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class PointTests {
  public void TestDistance() {
    Point p1 = new Point(2, 6);
    Point p2 = new Point(8, 2);

    Assert.assertEquals(p1.distance(p2), p2.distance(p1));
    Assert.assertEquals(MyTwoProgram.distance(p1, p2), p1.distance(p2));
    Assert.assertEquals(MyTwoProgram.distance(p1, p2), p2.distance(p1));
    Assert.assertEquals(MyTwoProgram.distance(p1, p2), 7.211102550927978);
  }
}
