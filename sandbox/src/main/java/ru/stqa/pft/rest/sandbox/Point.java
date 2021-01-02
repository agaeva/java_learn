package ru.stqa.pft.rest.sandbox;

  public class Point {
    public double x, y;

    public Point(double x, double y) {
      this.x = x;
      this.y = y;
    }

    public String view() {
      return this.x+ ";" + this.y;
    }

    public double distance(Point p2) {
      return Math.sqrt((p2.x - this.x) * (p2.x - this.x) + (p2.y - this.y) * (p2.y - this.y));
    }
  }