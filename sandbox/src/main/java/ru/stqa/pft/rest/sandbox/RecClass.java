package ru.stqa.pft.rest.sandbox;

public class RecClass {
  public double x, y;
  public double a, b;

  public RecClass(double x, double y, double a, double b) {
    this.x = x;
    this.y = y;
    this.a = a;
    this.b = b;
  }

  public String view() {
    return this.x + ";" + this.y + ";" ;

  }
  public String view2() {
    return this.a + ";" + this.b + ";";
  }
  public double area() {
    return this.a * this.b;
  }

  public double kor2() {
    return this.x + this.b;
  }
  public double kor3() {
    return this.y - this.a;
  }
 }
