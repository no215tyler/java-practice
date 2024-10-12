import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> players = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

    int N = 5;

    ///////////////////
    // Nターンのケース //
    ///////////////////
    // Iterator<Integer> it = players.iterator(); // <- イテレータ（リスト要素にカーソルを当てるイメージ）を取得
    // for (int i = 0; i < N; i++) {
    //   while(it.hasNext()) { // 次の要素があるか判定しtrue or falseで返す
    //     int num = it.next(); // カーソルを次に進めるイメージ（要素を変数に代入しているが代入しなくてもOK）
    //     // なんらかの条件: 【例】偶数番号をplayersリストから取り除く（この例だとfor文でNターン指定してる意味ないけど）
    //     if (num % 2 == 0) {
    //       System.out.println(String.format("プレイヤー%dを除外しました", num));
    //       it.remove();
    //     }
    //   }
    // }
    // // 残りのプレイヤーを表示
    // players.stream().forEach(System.out::println);

    ////////////////
    // N回のケース //
    ////////////////
    int count = 0;
    Iterator<Integer> it = players.iterator();
    while(it.hasNext() && count < N) {
      int num = it.next();
      // なんらかの条件: 【例】偶数番号をplayersリストから取り除く
      if (num % 2 == 0) {
        System.out.println(String.format("プレイヤー%dを除外しました", num));
        it.remove();
      }
      count++;
    }

    // 残りのプレイヤーを表示
    players.forEach(System.out::println);
  }
}