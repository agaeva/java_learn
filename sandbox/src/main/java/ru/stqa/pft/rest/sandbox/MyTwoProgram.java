package ru.stqa.pft.rest.sandbox;


public class MyTwoProgram {

  public static void main (String[] args) {
    Point p1 = new Point(2, 6);
    Point p2 = new Point(8, 2);
    System.out.println("Расстояние1 между точками (" + p1.view() + ") и (" + p2.view() + ") = " + distance(p1, p2));
    System.out.println("Расстояние2 между точками "+p2.distance(p1));
  }

    public static double distance(Point p1, Point p2){
      return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
    }
  }

