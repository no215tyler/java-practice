package salto.training.kitasoft_workshop.practice7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Practice.practice6();
	}
}

class Practice {

	public static void practice6() {
		Scanner sc = new Scanner(System.in);
		CoinCase cs = new CoinCase();

		for (int i = 0; i < 10; i++) {
			try {
				System.out.printf("【%d回目の入力】どの種類の硬貨を何枚追加するか改行区切りで入力してください\n", i + 1);
				System.out.println("【0】500円\n【1】100円\n【2】50円\n【3】10円\n【4】5円\n【5】1円");
				int kind;
				do {
					kind = Integer.parseInt(sc.nextLine());
					if (kind < 0 || kind > 5) {
						System.out.println("0～5の数値で選択してください。\n【0】500円\n【1】100円\n【2】50円\n【3】10円\n【4】5円\n【5】1円");
					}
				} while (kind < 0 || kind > 5);
				System.out.println("何枚追加しますか？");
				int amount = Integer.parseInt(sc.nextLine());
				cs.AddCoins(kind, amount);
			} catch (NumberFormatException e) {
				System.out.println("エラー: 数値以外の入力です。処理を継続します。");
				continue;
			}
		}

		System.out.println(String.format("500円硬貨は%d枚（%d円分）あります。", cs.GetWallet().get(0), cs.GetAmount(0)));
		System.out.println(String.format("100円硬貨は%d枚（%d円分）あります。", cs.GetWallet().get(1), cs.GetAmount(1)));
		System.out.println(String.format("50円硬貨は%d枚（%d円分）あります。", cs.GetWallet().get(2), cs.GetAmount(2)));
		System.out.println(String.format("10円硬貨は%d枚（%d円分）あります。", cs.GetWallet().get(3), cs.GetAmount(3)));
		System.out.println(String.format("5円硬貨は%d枚（%d円分）あります。", cs.GetWallet().get(4), cs.GetAmount(4)));
		System.out.println(String.format("1円硬貨は%d枚（%d円分）あります。", cs.GetWallet().get(5), cs.GetAmount(5)));

		System.out.println(String.format("硬貨の総枚数は %d 枚あります。", cs.GetCount()));
		System.out.println(String.format("所持金総額: %d円", cs.GetAmount()));
	}

	public static void practice5() {
		Scanner sc = new Scanner(System.in);
		CoinCase cs = new CoinCase();

		for (int i = 0; i < 10; i++) {
			System.out.printf("【%d回目の入力】どの種類の硬貨を何枚追加するか改行区切りで入力してください\n", i + 1);
			System.out.println("【0】500円\n【1】100円\n【2】50円\n【3】10円\n【4】5円\n【5】1円");
			int kind;
			do {
				kind = Integer.parseInt(sc.nextLine());
				if (kind < 0 || kind > 5) {
					System.out.println("0～5の数値で選択してください。\n【0】500円\n【1】100円\n【2】50円\n【3】10円\n【4】5円\n【5】1円");
				}
			} while (kind < 0 || kind > 5);
			System.out.println("何枚追加しますか？");
			int amount = Integer.parseInt(sc.nextLine());
			cs.AddCoins(kind, amount);
		}


		System.out.println("どの種類の硬貨の枚数を確認しますか？");
		System.out.println("【0】500円\n【1】100円\n【2】50円\n【3】10円\n【4】5円\n【5】1円");
		int kind;
		do {
			kind = Integer.parseInt(sc.nextLine());
			if (kind < 0 || kind > 5) {
				System.out.println("0～5の数値で選択してください。\n【0】500円\n【1】100円\n【2】50円\n【3】10円\n【4】5円\n【5】1円");
			}
		} while (kind < 0 || kind > 5);
		System.out.println(String.format("%d枚あります。", cs.GetCount(0)));

		System.out.println(String.format("所持金総額: %d円", cs.GetAmount()));
	}

	public static void practice4() {
		Dog dog = new Dog("Beagle");
		dog.SetName("マロン");
		dog.SetAge(4);
		dog.ShowProfile();
	}

	public static void practice3() {
		Dog dog1 = new Dog();
		Dog dog2 = new Dog();
		// 1つ目のインスタンスに名前と年齢を設定する
		dog1.SetName("ハチ");
		dog1.SetAge(3);

		// 2つ目のインスタンスに名前と年齢を設定する
		dog2.SetName("クロ");
		dog2.SetAge(5);

		// 1つ目表示
		dog1.ShowProfile();

		// 2つ目表示
		dog2.ShowProfile();
	}

	public static void practice2() {
		Dog dog = new Dog();
		dog.SetName("シロ");
		dog.SetAge(6);
		dog.ShowProfile();
	}

	public static void practice1() {
		Dog dog = new Dog();
		dog.SetName("ポチ");
		dog.ShowProfile();
	}

}

class Money {
	protected int coin500 = 0;
	protected int coin100 = 0;
	protected int coin50 = 0;
	protected int coin10 = 0;
	protected int coin5 = 0;
	protected int coin1 = 0;
}

class CoinCase extends Money {
	private List<Integer> wallet = new ArrayList<>();

	public CoinCase() {
		this.wallet.add(this.coin500);
		this.wallet.add(this.coin100);
		this.wallet.add(this.coin50);
		this.wallet.add(this.coin10);
		this.wallet.add(this.coin5);
		this.wallet.add(this.coin1);
	}

	public void AddCoins(int kind, int amount) {
		this.wallet.set(kind, this.wallet.get(kind) + amount);
	}

	public int GetCount(int n) {
		return this.wallet.get(n);
	}

	public int GetCount() { // オーバーロードメソッド
		int count = 0;
		count += this.wallet.get(0);
		count += this.wallet.get(1);
		count += this.wallet.get(2);
		count += this.wallet.get(3);
		count += this.wallet.get(4);
		count += this.wallet.get(5);
		return count;
	}

	public int GetAmount() {
		int result = 0;
		result += this.wallet.get(0) * 500;
		result += this.wallet.get(1) * 100;
		result += this.wallet.get(2) * 50;
		result += this.wallet.get(3) * 10;
		result += this.wallet.get(4) * 5;
		result += this.wallet.get(5);
		return result;
	}

	public int GetAmount(int kind) {
		int[] kindsMoney = {500, 100, 50, 10, 5, 1};
		int result = 0;
		result = this.wallet.get(kind) * kindsMoney[kind];
		return result;
	}

	public List<Integer> GetWallet() {
		return this.wallet;
	}
}

class Dog {
    private String Name;
    private int age;
    private String breed;

    public Dog() {
      this.breed = "不明";
    }

    public Dog(String breed) { // オーバーロードコンストラクタ
      this.breed = breed;
    }

    public void SetAge(int age) {
      this.age = age;
    }

    public void SetName( String nm ) {
        Name = nm;
    }

    public void ShowProfile() {
        System.out.println( "名前は、" + Name + "です。" );
        System.out.println("年齢は、" + this.age + "才です。");
        System.out.println("犬種は、" + this.breed + "です。");
    }
}