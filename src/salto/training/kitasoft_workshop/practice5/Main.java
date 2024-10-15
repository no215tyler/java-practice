package salto.training.kitasoft_workshop.practice5;

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

		Practice.practice8(br);
	}
}

class Practice {

	public static void practice8(BufferedReader br) throws IOException {
		System.out.println("整数を10回入力し、昇順に表示するプログラム");
		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			nums.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(nums);
		nums.stream().forEach(n -> {
			System.out.printf("%d ", n);
		});
	}

	public static void practice7(BufferedReader br) throws IOException {
		System.out.println("1 桁の数値（ 1 ～ 9 に限定）を２つ入力し、その積を表示するプログラム(配列を活用すること)");
		int kuku[][] = new int[9][9];

		//配列 kuku に値を代入する
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				kuku[r][c] = (r+1) * (c+1);
			}
		}

		int input1 = 0;
		int input2 = 0;

		do {
			input1 = Integer.parseInt(br.readLine());
			if (input1 < 1 || input1 > 9) {
				System.out.println("入力が無効です。1～9の数値を入力してください");
			}
		} while (input1 < 1 || input1 > 9);
		do {
			input2 = Integer.parseInt(br.readLine());
			if (input2 < 1 || input2 > 9) {
				System.out.println("入力が無効です。1～9の数値を入力してください");
			}
		} while (input2 < 1 || input2 > 9);
		System.out.println("結果: " + kuku[input1 -1][input2 -1]);
	}

	public static void practice6(BufferedReader br) throws IOException {
		System.out.println("九九表を表示するプログラム");
		int kuku[][] = new int[9][9];

		//配列 kuku に値を代入する
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				kuku[r][c] = (r+1) * (c+1);
			}
		}

		for( int i = 0 ; i < 9 ; i++ ) {
			for( int j = 0 ; j < 9 ; j++ ) {
				System.out.printf( " %2d", kuku[i][j] );
			}
		System.out.println();
		}
	}

	public static void practice5(BufferedReader br) throws IOException {
		System.out.println("入力された数値を 16 桁の２進数で表示するプログラム");
		int value = Integer.parseInt( br.readLine() );
		int binary[] = new int[16];

		for( int i = 15 ; i >= 0 ; i--, value /= 2 )
      binary[i] = value % 2;

		for( int i = 0 ; i < 16 ; i++ )
      System.out.print( binary[i] );
	}

	public static void practice4(BufferedReader br) throws IOException {
		System.out.println("数値を繰り返して入力し、合計が 100 を超えた場合、または入力が 10 回行われた場合、入力を止め入力された数値をすべて表示するプログラム");
		List<Integer> list = new ArrayList<>();
		int result = 0;
		int count = 0;

		do {
			int input = Integer.parseInt(br.readLine());
			list.add(input);
			result = list.stream().mapToInt(Integer::intValue).sum();
			count += 1;
		} while (count < 10 && result <= 100);
		list.stream().forEach(System.out::println);
	}

	public static void practice3(BufferedReader br) throws IOException {
		System.out.println("10個の数値を入力し偶数と奇数に分類して表示するプログラム");
		int input = 0;
		List<Integer> even = new ArrayList<>();
		List<Integer> odd = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			input = Integer.parseInt(br.readLine());
			if (input % 2 == 0) {
				even.add(input);
			} else {
				odd.add(input);
			}
		}
		System.out.print("偶数; ");
		even.stream().forEach(n -> {
			System.out.print(n + " ");
		});
		System.out.println();
		System.out.print("奇数; ");
		odd.stream().forEach(n -> {
			System.out.print(n + " ");
		});
	}

	public static void practice2(BufferedReader br) throws IOException {
		System.out.println("10個の数値を入力し、入力された順番と逆順に表示するプログラム");
		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			nums.add(Integer.parseInt(br.readLine()));
		}

		for (int i = nums.size() - 1; i >= 0; i--) {
			System.out.println(nums.get(i));
		}
	}

	public static void practice1(BufferedReader br) throws IOException {
		System.out.println("10個の数値を入力しそれぞれの数値を2倍して表示するプログラム");
		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			nums.add(Integer.parseInt(br.readLine()));
		}
		for (int i = nums.size() - 1; i >= 0; i--) {
			System.out.println(nums.get(i));
		}
	}
}