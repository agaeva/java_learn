package ru.stqa.pft.rest.sandbox;

public class MyThreeProgram {
  public static void main (String[] args) {
    RecClass z1 = new RecClass(1, 3, 2,3);
    RecClass z2 = new RecClass(3, 4, 2,4);


    System.out.println("Пересекуются ли прямоугольники со сторонами c координатами левого верхнего угла ("  + z1.view() + ")"+ "и"+ "(" + z2.view() + ")" + " и сторонами " + "(" +z1.view2() + ")" + " и "+ "(" + z2.view2() + ")" + " ?");
    System.out.println("Площадь прямоугольника со сторонами " +z1.a+ " и " +z1.b+ " = " + z1.area());
    System.out.println("Площадь прямоугольника со сторонами " +z2.a+ " и " +z2.b+ " = " + z2.area());
    System.out.println("Координаты  первого прямоугольника = " + "("+ z1.x + ";" + z1.y +")" +","+ "("+ z1.x + ";" + z1.kor3()+ ")"+ ","+ "(" +z1.kor2()+ ";" + z1.y+")" + "," +"(" +z1.kor2()+ ";" + z1.kor3()+")" + ";");
    System.out.println("Координаты второго прямоугольника = " + "("+ z2.x + ";" + z2.y +")" +","+ "("+ z2.x + ";" + z2.kor3()+ ")"+ ","+ "(" +z2.kor2()+ ";" + z2.y+")" + "," +"(" +z2.kor2()+ ";" + z2.kor3()+")" + ";");

  }
}
