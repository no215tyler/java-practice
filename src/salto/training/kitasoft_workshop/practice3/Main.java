package salto.training.kitasoft_workshop.practice3;

import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
                        new InputStreamReader(System.in));
    Practice.practice13(br);
  }
}

class Practice {

  public static void practice13extra(BufferedReader br) throws IOException {
    int[] monthDaysList = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int chooseMonth;
    do {
      chooseMonth = Integer.parseInt(br.readLine());
      if (chooseMonth < 1 || chooseMonth > 12) {
        System.out.println("入力が間違っています。1〜12の数値を入力してください。");
      }
    } while (chooseMonth < 1 || chooseMonth > 12);
    System.out.println(String.format("%d月は%d日あります。", chooseMonth, monthDaysList[chooseMonth - 1]));
  }

  public static void practice13(BufferedReader br) throws IOException {
    int input;
    do {
      input = Integer.parseInt(br.readLine());
      if (input < 1 || input > 12 ) {
        System.out.println("入力が間違っています。1〜12の数値を入力してください。");
      }
    } while (input < 1 || input > 12 );

    switch (input) {
      case 1:
        System.out.println(String.format("%d月は31日まであります", input));
        break;
      case 2:
        System.out.println(String.format("%d月は28日まであります", input));
        break;
      case 3:
        System.out.println(String.format("%d月は31日まであります", input));
        break;
      case 4:
        System.out.println(String.format("%d月は30日まであります", input));
        break;
      case 5:
        System.out.println(String.format("%d月は31日まであります", input));
        break;
      case 6:
        System.out.println(String.format("%d月は30日まであります", input));
        break;
      case 7:
        System.out.println(String.format("%d月は31日まであります", input));
        break;
      case 8:
        System.out.println(String.format("%d月は31日まであります", input));
        break;
      case 9:
        System.out.println(String.format("%d月は30日まであります", input));
        break;
      case 10:
        System.out.println(String.format("%d月は31日まであります", input));
        break;
      case 11:
        System.out.println(String.format("%d月は30日まであります", input));
        break;
      case 12:
        System.out.println(String.format("%d月は31日まであります", input));
        break;
    }
  }

  public static void practice12(BufferedReader br) throws IOException {
    System.out.println("【一言鮨】");
    System.out.println("鮨を選択してください\n 1: まぐろ\n 2: えんがわ\n 3: いくら");
    int input = Integer.parseInt(br.readLine());
    switch (input) {
      case 1:
        System.out.println("大間のマグロ級の1日になる");
        break;
      case 2:
        System.out.println("縁側でのんびり過ごしましょう");
        break;
      case 3:
        System.out.println("いくらのいくらが食べたいですか？");
        break;
    }
  }

  public static void practice11(BufferedReader br) throws IOException {
    int month = Integer.parseInt(br.readLine());
    switch (month) {
      case 1:
        System.out.println("１月：元日、成人の日");
      case 2:
        System.out.println("２月：建国記念の日");
      case 3:
        System.out.println("３月：春分の日");
      case 4:
        System.out.println("４月：昭和の日");
      case 5:
        System.out.println("５月：憲法記念日、みどりの日、こどもの日");
      case 6:
      case 7:
        System.out.println("７月：海の日");
      case 8:
      case 9:
        System.out.println("９月：敬老の日、秋分の日");
      case 10:
        System.out.println("１０月：体育の日");
      case 11:
        System.out.println("１１月：文化の日、勤労感謝の日");
      case 12:
        System.out.println("１２月：天皇誕生日");
    }
  }

  public static void practice10(BufferedReader br) throws IOException {
    int x = Integer.parseInt(br.readLine());
    int y = Integer.parseInt(br.readLine());
    if( x < y && x % 2 == 0 && y % 2 == 0 ) {
      System.out.println( "xはyより小さく、かつ、xとyは共に偶数である。" );
    } else if( x == y && x < 0 ) {
      System.out.println( "xとyは等しく、かつ、負の数である。" );
    } else if( x < y || x % 2 == 0 ) {
      System.out.println( "xはyより小さい、または、xは偶数である。" );
    } else if( (x <= 10 || x >= 100) && (y >= 10 && y <= 100) ) {
      System.out.println( "xは10以下または100以上で、かつ、yは10以上かつ100以下である。" );
    } else if( !(x < 0 && y < 0) ) {
      System.out.println( "xもyも負の数である、ではない。" );
    }
  }

  public static void practice9(BufferedReader br) throws IOException {
    System.out.println("受診曜日を入力してください\n>0=日曜、1=月曜、2=火曜、3=水曜、4=木曜、5=金曜、6=土曜");
    int inputWeek = Integer.parseInt(br.readLine());
    System.out.println("診療時間帯を入力してください\n>0=午前、1=午後、2=夜間");
    int inputTimeZone = Integer.parseInt(br.readLine());
    // 日曜(0)終日休診
    if ((inputWeek == 0) ||
      // 火曜(2)午前休診
    (inputWeek == 2 && inputTimeZone == 0) ||
      // 水曜(3)夜間休診
    (inputWeek == 3 && inputTimeZone == 2) ||
      // 金曜(5)午前休診
    (inputWeek == 5 && inputTimeZone == 0) ||
    // 土曜(6)午後・夜間休診
    (inputWeek == 6 && inputTimeZone == 1 || inputTimeZone == 2)) {
      System.out.println("休診日です");
    } else {
      // 上記以外は受診可能◯
      System.out.println("受診できます");
    }
  }

  public static void practice8(BufferedReader br) throws IOException {
    int midTermScore = Integer.parseInt(br.readLine());
    int finalTermScore = Integer.parseInt(br.readLine());

    if (midTermScore >= 60 && finalTermScore >= 60) {
      System.out.println("合格");
    } else if (midTermScore + finalTermScore >= 130) {
      System.out.println("合格");
    } else if ((midTermScore + finalTermScore >= 100 ) && midTermScore >= 90 || finalTermScore >= 90) {
      System.out.println("合格");
    } else {
      System.out.println("不合格");
    }
  }

  public static void practice7(BufferedReader br) throws IOException {
    int score = Integer.parseInt(br.readLine());
    // case1
    System.out.print("【ケース1】");
    if (score >= 60) {
      System.out.println("合格");
    } else {
      System.out.println("不合格");
    }

    // case2
    System.out.print("【ケース2】");
    if (score >= 80) {
      System.out.println("たいへんよくできました");
    } else if (score >= 70 && score < 80) {
      System.out.println("よくできました");
    } else {
      System.out.println("ざんねんでした");
    }

    // case3
    System.out.print("【ケース3】");
    if (score >= 80) {
      System.out.println("優");
    } else if (score >= 70 && score < 80) {
      System.out.println("良");
    } else if (score >= 60 && score < 70) {
      System.out.println("可");
    } else {
      System.out.println("不可");
    }
  }

  public static void practice6(BufferedReader br) throws IOException {
    int x = Integer.parseInt(br.readLine());
    if (x >= 0 && x % 2 == 0) {
      System.out.println("正の偶数");
    } else if (x >= 0 && x % 2 == 1) {
      System.out.println("正の奇数");
    } else if (x < 0 && x % 2 == 0) {
      System.out.println("負の偶数");
    } else {
      System.out.println("負の奇数");
    }
  }

  public static void practice5(BufferedReader br) throws IOException {
    int x = Integer.parseInt(br.readLine());
    if (x % 2 == 0) {
      System.out.println("入力値は偶数です");
    } else {
      System.out.println("入力値は奇数です");
    }
  }

  public static void practice4(BufferedReader br) throws IOException {
    int x = Integer.parseInt(br.readLine());
    int y = Integer.parseInt(br.readLine());
    if (x > y) {
      System.out.println("xはyより大きい");
    } else if (x < y) {
      System.out.println("xはyより小さい");
    } else {
      System.out.println("xとyは等しい");
    }
  }

  public static void practice3(BufferedReader br) throws IOException {
    int x = Integer.parseInt(br.readLine());
    int y = Integer.parseInt(br.readLine());
    if (x > y) {
      System.out.println("xはyより大きい");
    } else if (x < y) {
      System.out.println("xはyより小さい");
    }
  }

  public static void practice2(BufferedReader br) throws IOException {
    int x = Integer.parseInt(br.readLine());
    int y = Integer.parseInt(br.readLine());
    System.out.println(String.format("大きい数字: %d", Math.max(x, y)));
  }

  public static void practice1(BufferedReader br) throws IOException {
    int x = Integer.parseInt(br.readLine());
    int y = Integer.parseInt(br.readLine());
    if (x > y) {
      System.out.println("xはyより大きい。");
    }
  }
}