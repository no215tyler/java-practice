package paiza.supercar;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    final int N = input[0];
    final int K = input[1];

    // スーパーカーインスタンスの生成
    List<SuperCar> cars = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      String[] prompt = sc.nextLine().split(" ");
      String type = prompt[0];
      int fuel = Integer.parseInt(prompt[1]);
      int fuelEfficiency = Integer.parseInt(prompt[2]);
      cars.add(createCarType(type, fuel, fuelEfficiency));
    }

    // メイン処理
    for (int i = 0; i < K; i++) {
      String[] prompt = sc.nextLine().split(" ");
      int index = Integer.parseInt(prompt[0]) - 1;
      String fanc = prompt[1];
      fanctions(cars, index, fanc);
    }

    // 最終結果（移動距離の出力）
    cars.stream().forEach(c -> {
      System.out.println(c.getDistance());
    });

    sc.close();
  }

  public static void fanctions(List<SuperCar> cars, int index, String fanc) {
    switch (fanc) {
      case "run":
        cars.get(index).run();
        break;

      case "fly":
        SuperSuperCar sscar = (SuperSuperCar)cars.get(index);
        sscar.fly();
        break;

      case "teleport":
        SuperSuperSuperCar ssscar = (SuperSuperSuperCar)cars.get(index);
        ssscar.teleport();
        break;
    }
  }

  public static SuperCar createCarType(String type, int fuel, int fuelEfficiency) {
    if (type.equals("supercar")) {
      return new SuperCar(fuel, fuelEfficiency);
    } else if (type.equals("supersupercar")) {
      return new SuperSuperCar(fuel, fuelEfficiency);
    } else {
      return new SuperSuperSuperCar(fuel, fuelEfficiency);
    }
  }
}

class SuperCar {
  private int fuel;
  private int fuelEfficiency;
  private int distance = 0;

  public SuperCar(int fuel, int fuelEfficiency) {
    this.fuel = fuel;
    this.fuelEfficiency = fuelEfficiency;
  }

  public int getFuel() { return this.fuel; }
  public void setFuel(int fuel) { this.fuel -= fuel; }
  public int getFuelEfficiency() { return this.fuelEfficiency; }
  public int getDistance() { return this.distance; }
  public void setDistance(int distance) { this.distance += distance; }

  public void run() {
    if (this.getFuel() > 0) {
      this.setFuel(1);
      this.setDistance(this.getFuelEfficiency());
    }
  }
}

class SuperSuperCar extends SuperCar {
  public SuperSuperCar(int fuel, int fuelEfficiency) {
    super(fuel, fuelEfficiency);
  }
  public void fly() {
    if (this.getFuel() >= 5) {
      setFuel(5);
      int calc = (int)Math.pow(getFuelEfficiency(), 2);
      setDistance(calc);
    } else if ((this.getFuel() < 5) && (this.getFuel() > 0)) {
      this.run();
    }
  }
}

class SuperSuperSuperCar extends SuperSuperCar {
  public SuperSuperSuperCar(int fuel, int fuelEfficiency) {
    super(fuel, fuelEfficiency);
  }
  @Override
  public void fly() {
    if (this.getFuel() >= 5) {
      this.setFuel(5);
      int calc = (int)Math.pow(getFuelEfficiency(), 2) * 2;
      this.setDistance(calc);
    } else if ((this.getFuel() < 5) && (this.getFuel() > 0)) {
      this.run();
    }
  }

  public void teleport() {
    int cost = (int)Math.pow(this.getFuelEfficiency(), 2);
    int distance = (int)Math.pow(this.getFuelEfficiency(), 4);
    if (this.getFuel() >= cost) {
      this.setFuel(cost);
      this.setDistance(distance);
    } else if (this.getFuel() < cost) {
      this.fly();
    }
  }
}