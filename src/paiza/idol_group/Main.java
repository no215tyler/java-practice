package paiza.idol_group;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // N: 初期メンバー数, K: イベント回数
    int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int N = input[0];
    int K = input[1];

    // グループのインスタンスと初期メンバーの定義
    Group g = new Group();
    for (int i = 0; i < N; i++) {
      g.join(sc.nextLine());
    }

    // イベント処理
    for (int i = 0; i < K; i++) {
      String[] event = sc.nextLine().split(" ");
      switch (event[0]) {
        case "join":
          g.join(event[1]);
          break;

        case "leave":
          g.leave(event[1]);
          break;

        case "handshake":
          g.handshake();
          break;
      }
    }
  }
}

class Group {
  // TreeSetを使って、常にソートされた状態でメンバーを保持
  Set<Idol> members = new TreeSet<>(Comparator.comparing(idol -> idol.name));

  // メンバー加入
  public void join(String name) {
    this.members.add(new Idol(name)); // Setなので自動的に重複が防がれる
  }

  // メンバー脱退
  public void leave(String name) {
    this.members.remove(new Idol(name)); // removeもO(1)で実行される
  }

  // 握手会
  public void handshake() {
    if (!this.members.isEmpty()) {
      // TreeSetは常にソートされた状態を保持するため、ソートは不要
      for (Idol member : members) {
        System.out.println(member.name);
      }
    }
  }
}

class Idol {
  String name;

  public Idol(String name) {
    this.name = name;
  }

  // 名前で比較を行うようにequalsとhashCodeをオーバーライド
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Idol idol = (Idol) o;
    return Objects.equals(name, idol.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
