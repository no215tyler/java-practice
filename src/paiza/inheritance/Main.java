package paiza.inheritance;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 初期設定値をインプット
    int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    // N: 客数, K: 注文回数
    int N = input[0];
    int K = input[1];
    // お客さんのインスタンスを生成
    List<Costmer> costmers = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      int age = Integer.parseInt(sc.nextLine());
      costmers.add(new Costmer(i, age));
    }

    // 注文処理
    for (int i = 0; i < K; i++) {
      String[] orders = sc.nextLine().split(" ");
      int idx = Integer.parseInt(orders[0]) - 1;
      String menu = orders[1];
      int price = Integer.parseInt(orders[2]);
      costmers.get(idx).order(menu, price);
    }


    // 最終結果（全員の個別会計額を表示）
    costmers.stream().forEach(c -> {
      System.out.println(c.accounting);
    });

    sc.close();
  }
}


class Costmer {
  int id;
  int age;
  boolean discount = false;
  int accounting = 0;

  public Costmer(int id, int age) {
    this.id = id;
    this.age = age;
  }

  public void order(String menu, int price) {
    switch(menu) {
      case "food":
        if(this.discount) {
          this.accounting += (price - 200);
        } else {
          this.accounting += price;
        }
        break;

      case "softdrink":
        this.accounting += price;
        break;

      case "alcohol":
        if (this.age >= 20) {
          this.accounting += price;
          this.discount = true;
        }
        break;
    }
  }
}
