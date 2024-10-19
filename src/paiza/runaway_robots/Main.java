package paiza.runaway_robots;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int H = input[0];
    int W = input[1];
    int N = input[2];
    int K = input[3];

    // 工具箱の座標定義
    for (int i = 0; i < 10; i++) {
      List<Integer> positionXY = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
      // Itemクラス変数（List）に追加
      Item.itemBox.add(positionXY);
    }

    // ロボットの初期化×台数
    List<Robot> robots = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      int[] line = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int x = line[0];
      int y = line[1];
      int lv = line[2];
      robots.add(new Robot(x, y, lv, Robot.lvTable[lv]));
    }

    // 行動回数
    for (int i = 0; i < K; i++) {
      String[] prompt = sc.nextLine().split(" ");
      int index = Integer.parseInt(prompt[0]) - 1;
      String direction = prompt[1];
      robots.get(index).move(direction);
    }

    robots.stream().forEach(r -> {
      System.out.println(String.format("%d %d %d", r.getPositionX(), r.getPositionY(), r.getLv()));
    });

    sc.close();
  }
}

class Robot {
  static int[] lvTable = {0, 1, 2, 5, 10};
  private int positionY;
  private int positionX;
  private int lv;
  private int stepCount;

  public Robot(int positionX, int positionY, int lv, int stepCount) {
    this.positionX = positionX;
    this.positionY = positionY;
    this.lv = lv;
    this.stepCount = stepCount;
  }
  // getter
  public int getPositionX() {return this.positionX;}
  public int getPositionY() {return this.positionY;}
  public int getLv() {return this.lv;}
  public int getStepCount() {return this.stepCount;}

  // setter
  public void setLv(int lv) {this.lv = lv;}
  public void setPositionX(int x) {this.positionX += x;}
  public void setPositionY(int y) {this.positionY += y;}
  public void setStepCount(int stepCount) {this.stepCount = stepCount;}

  public void move(String direction) {
    switch (direction) {
      case "E":
        this.setPositionX(this.getStepCount());
        break;
      case "W":
        this.setPositionX(- this.getStepCount());
        break;
      case "S":
        this.setPositionY(this.getStepCount());
        break;
      case "N":
        this.setPositionY(- this.getStepCount());
        break;
    }
    checkGetableItem(this.getPositionX(), this.getPositionY());
  }

  public void checkGetableItem(int x, int y) {
    for (List<Integer> item : Item.itemBox) {
      if(item.get(0) == x && item.get(1) == y) {
        lvUp();
      }
    }
  }

  public void lvUp() {
    switch (this.lv) {
      case 1:
        this.setLv(2);
        this.setStepCount(2);
        break;
      case 2:
        this.setLv(3);
        this.setStepCount(5);
        break;
      case 3:
        this.setLv(4);
        this.setStepCount(10);
        break;
    }
  }

}

class Item {
  static List<List<Integer>> itemBox = new ArrayList<>();
}