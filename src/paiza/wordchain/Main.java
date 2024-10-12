package paiza.wordchain;

import java.util.*;
import java.util.stream.Collectors;


public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 初期入力値（N: プレイヤー数 K: 単語リスト数 M: しりとり回数
    List<Integer> input = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    int N = input.get(0);
    int K = input.get(1);
    int M = input.get(2);

    // プレイヤーのインスタンス
    List<Player> players = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      players.add(new Player(i));
      Player.alived.add(i + 1);
    }

    // 単語のリスト数（インスタンス）
    Wordlist wl = new Wordlist();
    for (int i = 0; i < K; i++) {
      wl.addList(sc.nextLine());
    }


    int cnt = 0;
    // しりとり処理
    while(cnt <= M) {
      Iterator<Integer> it = Player.alived.iterator();
      while(it.hasNext()) {
        it.next();
        String word = sc.nextLine();
        // 2. 最初の人以外の発言の頭文字は、直前の人の発言の最後の文字と一緒でなければならない。(脱落者不在の場合)
        wl.checkRuleLastWord(word, cnt);
        // 1.3. 発言は、単語リストにある K 個の単語のうちのいずれかの単語でなければならない。
        wl.subtractList(word);
        // 4. z で終わる単語を発言してはならない。
        if (!wl.dropPlayerFlg) {
          wl.checkRuleExistZ(word);
        }
        // dropPlayerFlgがTrueの場合はplayersから除外する
        if (wl.dropPlayerFlg) {
          it.remove();
        }

        cnt += 1;
        if (cnt == M) {
          break;
        }
      }
      if (cnt == M) {
        break;
      }
    }

    System.out.println(String.format("%d", Player.alived.size()));
    Player.alived.stream().forEach(System.out::println);

    sc.close();
  }
}

class Player {
  int id;
  static List<Integer> alived = new ArrayList<>();

  public Player(int id) {
    this.id = id + 1;
  }
}

class Wordlist {
  List<String> list = new ArrayList<>();
  String lastStr;
  boolean dropPlayerFlg = true; //初回のプレイヤーはルール2をパスするためにtrueがデフォルト値

  public void addList(String word) {
    this.list.add(word);
  }

  // ルール1:
  public void subtractList(String word) {
    int index = this.list.indexOf(word);
    if (index >= 0) {
      this.list.remove(index);
      this.dropPlayerFlg = false;
    } else {
      this.dropPlayerFlg =  true;
    }
  }

  // ルール2
  public void checkRuleLastWord(String word, int count) {
    String[] str = word.split("");
    int idx = str.length;
    if (count >= 1 && !this.dropPlayerFlg) {
      if (str[0].equals(this.lastStr)) {
        this.dropPlayerFlg = false;
      } else {
        this.dropPlayerFlg = true;
      }
    } else if (count == 0) {
      this.dropPlayerFlg = false;
    }
    this.lastStr = str[idx - 1];
  }

  // ルール3 (ルール1に包含)
  public void checkRuleIsExistWord(String word) {
    int count = (int)this.list.stream().filter(s -> s.equals(word)).count();
    if (count == 0) {
      this.dropPlayerFlg = true;
    } else {
      this.dropPlayerFlg = false;
    }
  }

  // ルール4
  public void checkRuleExistZ(String word) {
    String[] str = word.split("");
    int idx = str.length;
    if (str[idx - 1].equals("z")) {
      this.dropPlayerFlg = true;
    } else {
      this.dropPlayerFlg = false;
    }
  }

}