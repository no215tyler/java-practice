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
      g.members.add(new Idol(sc.nextLine()));
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
  List<Idol> members = new ArrayList<>();

  // メンバー加入
  public void join(String name) {
    this.members.add(new Idol(name));
  }

  // メンバー脱退
  public void leave(String name) {
    this.members.removeIf(m -> m.name.equals(name));
  }

  // 握手会
  public void handshake() {
    if (this.members.size() > 0) {
      this.members.sort(Comparator.comparing(idol -> idol.name));
      this.members.stream().forEach(idol -> {
        System.out.println(idol.name);
      });
    }
  }

}

class Idol {
  String name;
  public Idol(String name) {
    this.name = name;
  }
}