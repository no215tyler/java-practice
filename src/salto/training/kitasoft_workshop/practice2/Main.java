package salto.training.kitasoft_workshop.practice2;

import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
                        new InputStreamReader( System.in ));
    Practice.practice6(br);
  }
}

class Practice {

  public static void practice6(BufferedReader br) throws IOException {
    System.out.println("年齢を入力してください");
    int age = Integer.parseInt(br.readLine());
    // 日数の計算は閏年等を考慮せず、年齢×365とする
    System.out.println(String.format("あなたが生まれてからおよそ%d日経過しました。", age * 365));
  }

  public static void practice5(BufferedReader br) throws IOException {
    double x = Integer.parseInt(br.readLine());
    double y = Integer.parseInt(br.readLine());
    double result = (x + y) / 2;
    System.out.println((int)result);
  }

  public static void practice4(BufferedReader br) throws IOException {
    int x = Integer.parseInt(br.readLine());
    int y = Integer.parseInt(br.readLine());
    System.out.println(String.format("和: %d", x + y));
    System.out.println(String.format("差: %d", x - y));
    System.out.println(String.format("商: %d\n余り: %d", x / y, x % y));
  }

  public static void practice3(BufferedReader br) throws IOException {
    int x = Integer.parseInt(br.readLine());
    System.out.println((int)Math.pow(x, 1));
    System.out.println((int)Math.pow(x, 2));
    System.out.println((int)Math.pow(x, 3));
  }

  public static void practice2(BufferedReader br) throws IOException {
    int x = Integer.parseInt(br.readLine());
    System.out.println(x);
  }

  public static void practice1(BufferedReader br) throws IOException {
    String s = br.readLine();
    System.out.println(s);
  }
}