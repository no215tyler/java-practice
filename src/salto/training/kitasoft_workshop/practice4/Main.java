package salto.training.kitasoft_workshop.practice4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
							new InputStreamReader(System.in));
		Practice.practice22(br);
	}
}

class Practice {

	public static void practice22(BufferedReader br) throws IOException {
		int     n1 = 0;
		int     n2 = 1;
		int     n3 = n1 + n2;

		while( n1 <= 1000 ) {
      System.out.print(n1);
      n1 = n2;
      n2 = n3;
      n3 = n1 + n2;
      if (n1 < 1000) {
        System.out.print(", ");
      }
		}
	}

	public static void practice21(BufferedReader br) throws IOException {
		int size = Integer.parseInt( br.readLine() );
		for( int i = 0 ; i < size ; i++ ) {
      for( int j = 0 ; j < size ; j++ ) {
          if( i == j || ( size - i - 1 ) == j ) {
            System.out.print( "X" );
          } else {
            System.out.print( " " );
          }
      }

      System.out.println( "" );
		}
	}

	public static void practice20(BufferedReader br) throws IOException {
		System.out.println("サイズを示す数値を入力し、三角形を表示するプログラム");
		int size = Integer.parseInt(br.readLine());
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("$");
				if (j == i) {
					System.out.println("");
				}
			}
		}
	}

	public static void practice19(BufferedReader br) throws IOException {
		System.out.println("数値を繰り返して入力し、0 が入力されたら入力を止め、平均値を表示するプログラム");
		int result = 0;
		int count = 0;
		int input = Integer.parseInt(br.readLine());
		try {
		if (input == 0) {
			throw new Exception("初回入力で0が入力されました。プログラムを終了します。");
		} else {
			result += input;
		}

		do {
			input = Integer.parseInt(br.readLine());
			result += input;
			count += 1;
		} while (input != 0);
		int avg = result / count;
		System.out.printf("合計: %,d", avg);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void practice18(BufferedReader br) throws IOException {
		System.out.println("数値を繰り返して入力し、0 が入力されたら入力を止め、それまでの合計を表示するプログラム");
		int result = 0;
		int input;
		do {
			input = Integer.parseInt(br.readLine());
			result += input;
		} while (input != 0);
		System.out.printf("合計: %,d", result);
	}

	public static void practice17(BufferedReader br) throws IOException {
		int[] rows = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] cols = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				int x = rows[r] * cols[c];
				System.out.printf("%2d ", x);
				if (c == 8) {
					System.out.println("");
				}
			}
		}
	}

	public static void practice16(BufferedReader br) throws IOException {
		int n = Integer.parseInt( br.readLine() );

		for( int x = 2 ; n > 1 ; x++ ){
      while( ( n % x ) == 0 ){
          System.out.print( x + " " );
          n /= x;
      }
		}
	}

	public static void practice15(BufferedReader br) throws IOException {
		int value = Integer.parseInt( br.readLine() );
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

	public static void practice14(BufferedReader br) throws IOException {
		int ball = 0;
		int strike = 0;
		int input = 0;
		do {
			input = 0;
			System.out.println("ストライク=1, ボール=2, ファウル=3");
			while ((input <= 0 || input > 3)) {
				input = Integer.parseInt(br.readLine());
				if (input == 1) {
					strike += 1;
				} else if (input == 2) {
					ball += 1;
				} else if (input == 3) {
					if (strike < 2) {
						strike += 1;
					}
				} else {
					System.out.println("無効な入力です");
				}
			}
		} while ((strike < 3 && ball < 4 ));
		System.out.println(String.format("【結果】\nストライク: %d\nボール: %d", strike, ball));
	}

	public static void practice13(BufferedReader br) throws IOException {
		int ball = 0;
		int strike = 0;
		int input = 0;
		do {
			input = 0;
			System.out.println("ストライク=1, ボール=2");
			while ((input <= 0 || input > 2)) {
				input = Integer.parseInt(br.readLine());
				if (input == 1) {
					strike += 1;
				} else if (input == 2) {
					ball += 1;
				} else {
					System.out.println("無効な入力です");
				}
			}
		} while ((strike < 3 && ball < 4 ));
		System.out.println(String.format("【結果】\nストライク: %d\nボール: %d", strike, ball));
	}

	public static void practice12(BufferedReader br) throws IOException {
		int result = 0;
		do {
			result += Integer.parseInt(br.readLine());
		} while (result <= 100);
		System.out.printf("合計値: %d", result);
	}

	public static void practice11(BufferedReader br) throws IOException {
		int input = Integer.parseInt(br.readLine());
		int x = 0;
		for (int i = 0; i < input; i++) {
			if (x > 9) {
				x = 0;
			}
			System.out.print(x);
			x += 1;
		}
	}

	public static void practice10(BufferedReader br) throws IOException {
		int input = Integer.parseInt(br.readLine());
		for (int i = 0; i < input; i++) {
			System.out.print("*");
		}
	}

	public static void practice9(BufferedReader br) throws IOException {
		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			nums.add(Integer.parseInt(br.readLine()));
		}
		int maxValue = Collections.max(nums);
		int minValue = Collections.min(nums);
		System.out.println(String.format("最大値; %d\n最小値: %d", maxValue, minValue));
	}

	public static void practice8(BufferedReader br) throws IOException {
		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			int input = -1;
			do {
				input = Integer.parseInt(br.readLine());
				if (input < 0) {
					System.out.println("正の整数を入力してください");
				}
			} while (input < 0);
			nums.add(input);
		}
		long maxValue = Collections.max(nums);
		System.out.println("最大値: " + maxValue);
	}

	public static void practice7(BufferedReader br) throws IOException {
		int giants = 0;
		int tigers = 0;
		for (int i = 0; i < 9; i++) {
			System.out.printf("%d回表、巨人の得点は？", i);
			giants += Integer.parseInt(br.readLine());
			System.out.printf("%d回表、阪神の得点は？", i);
			tigers += Integer.parseInt(br.readLine());
		}
		System.out.println(String.format("巨人; %d点, 阪神: %d点", giants, tigers));
		if (giants > tigers) {
			System.out.println("巨人の勝ち");
		} else if (tigers > giants) {
			System.out.println("阪神の勝ち");
		} else {
			System.out.println("引き分け");
		}
	}

	public static void practice6(BufferedReader br) throws IOException {
		int o = 0;
		int x = 0;
		for (int i = 0; i < 10; i++) {
			int input = -1;
			do {
				System.out.println(String.format("%d回目の入力", i + 1));
				input = Integer.parseInt(br.readLine());
				if (input > 1 || input < 0) {
					System.out.println("0か1の数字を入力してください");
				}
			} while (input > 1 || input < 0 );
			if (input == 0) {
				x += 1;
			} else {
				o += 1;
			}
		}
		System.out.println(String.format("【戦績結果】\n勝ち: %d\n負け: %d", o, x));
	}

	public static void practice5(BufferedReader br) throws IOException {
		int x = 0;
		for (int i = 0; i < 10; i++) {
			x += Integer.parseInt(br.readLine());
		}
		System.out.println("平均値は" + (int)x / 10);
	}

	public static void practice4(BufferedReader br) throws IOException {
		int x = 1;
		for( int i = 2 ; i <= 7 ; i++ ) {
		    x *= i;
		}
		System.out.println( x );
	}

	public static void practice3(BufferedReader br) throws IOException {
		for (int i = 1; i <= 8; i++) {
			System.out.println((int)Math.pow(2, i));
		}
	}

	public static void practice2(BufferedReader br) throws IOException {
		for (int i = 1; i <= 9; i++) {
			System.out.println(3 * i);
		}
	}

	public static void practice1(BufferedReader br) throws IOException {
		for (int i = 0; i < 10; i++) {
			System.out.println("SPAM");
		}
	}
}