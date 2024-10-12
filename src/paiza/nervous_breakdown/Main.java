package paiza.nervous_breakdown;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // トランプ縦方向枚数: H, トランプ横方向枚数: W, プレイヤー数: N
    int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int H = input[0];
    int W = input[1];
    int N = input[2];

    // 神経衰弱のフィールドを定義
    List<List<Integer>> fields = new ArrayList<>();
    for (int i = 0; i < H; i++) {
      List<Integer> position = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
      fields.add(position);
    }

    // 記録回数
    int L = Integer.parseInt(sc.nextLine());

    // カード枚数の定義
    Cards.count = H * W;

    // プレイヤーインスタンス生成
    List<Player> players = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      players.add(new Player(i + 1));
    }

    // ゲームのメイン処理
    while (Cards.count > 0) {
      for (Player p : players){
        p.draw(fields, sc);
        if (Cards.count == 0) { break; }
      }
    }

    // 最終結果
    players.stream().forEach(p -> {
      System.out.println(p.cardStock);
    });
  }
}

class Player {
  int id;
  int cardStock;
  boolean continuableFlg;

  public Player(int id) {
    this.id = id;
    this.cardStock = 0;
    continuableFlg = false;
  }

  public void draw(List<List<Integer>> fields, Scanner sc) {
    do {
      int[] drawPosition = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int num1 = fields.get(drawPosition[0] - 1).get(drawPosition[1] - 1);
      int num2 = fields.get(drawPosition[2] - 1).get(drawPosition[3] - 1);
      if(num1 == num2) {
        // 2枚一致したらカード残量から-2枚 + 続けてプレイできる
        Cards.count -= 2;
        this.cardStock += 2;
        this.continuableFlg = true;
      } else {
        this.continuableFlg = false;
      }
      // debug
      // System.out.println(String.format("プレイヤーid: %d\n獲得枚数: %d\nカード残量: %d", this.id, this.cardStock, Cards.count));
    } while (this.continuableFlg && Cards.count > 0);
    this.continuableFlg = false;
  }

}

class Cards {
  static int count;
}