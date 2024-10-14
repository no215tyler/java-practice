package salto.training.kitasoft_workshop.practice1;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Practice.practice12();
  }
}

class Practice {

  public static void practice12() {
    int x = 6;
    System.out.println("インクリメント演算++の効果");
    for (int i = 0; i < x; i++) {
      System.out.println(i);
    }
    System.out.println("デクリメント演算--の効果");
    for (int i = x; i > 0; i--) {
      System.out.println(i);;
    }
  }

  public static void practice11() {
    int x = 5;
    int quotient = x / 3;
    int remainder = x % 3;
    System.out.println(String.format("商: %d\n余り: %d",quotient, remainder));
  }

  public static void practice10() {
    int x = 3;
    for (int i = 1; i <= 3; i++) {
      System.out.println((int)Math.pow(x, i));
    }
  }

  public static void practice9() {
    int x = 30;
    for (int i = 2; i <= 4; i++) {
      System.out.println(x * i);
    }
  }

  public static void practice8() {
    int x = 19;
    int y = 23;
    int z = x * y;
    System.out.println(z);
  }

  public static void practice7() {
    int x = 8;
    int y = 10;
    int buf = x;
    x = y;
    y = buf;
    System.out.println("x=" + x + ",y=" + y);
  }

  public static void practice6() {
    int x = 7;
    x *= 3;
    System.out.println(x);
    x /= 2;
    System.out.println(x);
  }

  public static void practice5() {
    System.out.println(13 * 17);
  }


  public static void practice4() {
    int x = 13 + 17;
    System.out.println(x);
  }

  public static void practice3() {
    int x = 13;
    int y = 17;
    System.out.printf("x=%d,y=%d\n", x, y);
  }

  public static void practice2() {
    int x = 11;
    System.out.println(x);
  }

  public static void practice1() {
    System.out.println("Hello World");
  }
}