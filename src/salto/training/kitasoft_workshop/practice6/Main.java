package salto.training.kitasoft_workshop.practice6;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Practice.practice8(sc);
	}
}

class Practice {

	public static void practice8(Scanner sc) {
		System.out.println("再帰メソッドによってn番目の項を表示するプログラム");
		System.out.println("11番目～20番目の項を表示します");
		for( int n = 11 ; n <= 20 ; n++ ) {
      System.out.print( fibonacci( n ) + " " );
		}
	}

	public static void practice7(Scanner sc) {
		System.out.println("指定の範囲の数が素数かどうかを判定するメソッド");
		for (int i = 10000; i < 10100; i++) {
			isPrimeNumber(i);
		}
	}

	public static void practice6(Scanner sc) {
		System.out.println("九九の指定の段を一列で表示させるメソッド");
		int input = Integer.parseInt(sc.nextLine());
		Practice.getMultiplicationTables(input);
	}

	public static void practice5(Scanner sc) {
		System.out.println("三角形を表示するメソッド。サイズを示す数値と三角形を形成する文字を改行区切りで入力する");
		System.out.println("サイズを数値で入力してください");
		int size = Integer.parseInt(sc.nextLine());
		String s;
		do {
			System.out.println("文字列を1字で入力してください");
			s = sc.nextLine();
		} while (s.length() > 1 || s.length() < 1);
		Practice.createTriangle(size, s);
	}

	public static void practice4(Scanner sc) {
		System.out.println("サイズを示す数値を入力し、三角形を表示するプログラム");
		int size = Integer.parseInt(sc.nextLine());
		Practice.createTriangle(size);
	}

	public static void practice3(Scanner sc) {
		System.out.println("2つの整数の大きいほうを選ぶメソッド");
		int x = Integer.parseInt(sc.nextLine());
		int y = Integer.parseInt(sc.nextLine());
		int z = Integer.parseInt(sc.nextLine());
		int result = Practice.selectMaxValue(x, y);
		result = Practice.selectMaxValue(result, z);
		System.out.println("最大値は " + result + " です。");
	}

	public static void practice2(Scanner sc) {
		System.out.println("2つの整数の平均を計算し結果を出力するメソッド");
		int a = Integer.parseInt(sc.nextLine());
		int b = Integer.parseInt(sc.nextLine());
		int result = Practice.average(a, b);
		System.out.println(result);
	}

	public static void practice1(Scanner sc) {
		System.out.println("入力値を2乗するメソッド");
		int input = Integer.parseInt(sc.nextLine());
		System.out.println(Practice.squared(input));
	}

	// メソッド定義
	public static int fibonacci(int n) {
    if( n == 0 ) {
        return 0;
    } else if( n == 1 ) {
      return 1;
    } else {
      return fibonacci( n - 2 ) +fibonacci( n - 1 );
    }
	}

	public static void isPrimeNumber(int value) {
		int n;
		for( n = 2 ; n <= ( value / 2 ) ; n++ ){
      if( ( value % n ) == 0 )
          break;
		}

		if( n > ( value / 2 ) )
      System.out.println( value + "は素数です" );
		else
      System.out.println( value + "は素数ではありません" );
	}

	public static void getMultiplicationTables(int n) {
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d ", n * i);
		}
	}

	public static void createTriangle(int size) {
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("$");
				if (j == i) {
					System.out.println("");
				}
			}
		}
	}

	public static void createTriangle(int size, String s) { // オーバーロードメソッド
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(s);
				if (j == i) {
					System.out.println("");
				}
			}
		}
	}

	public static int selectMaxValue(int a, int b) {
		return Math.max(a, b);
	}

	public static int average(int a, int b) {
		return (a + b) / 2;
	}

	public static int squared(int n) {
		return (int)Math.pow(n, 2);
	}
}