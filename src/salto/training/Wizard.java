package salto.training;

public class Wizard {
  private int hp;
  private int mp;
  private String name;
  protected Wand wand;

  public Wizard() {
    this.wand = new Wand();
  }

  public int getHp() {
    return this.hp;
  }
  public void setHp(int hp) {
    this.hp = zeroCheck(hp);
  }

  public int getMp() {
    return this.mp;
  }
  public void setMp(int mp) {
    this.mp = zeroCheck(mp);
  }

  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    if (name.length() >= 3) {
      this.name = name;
    } else {
      throw new IllegalArgumentException("名前が短いため処理を完了できません");
    }
  }

  public Wand getWand() {
    return this.wand;
  }

  public void setWand(Wand wand) {
    if (wand == null) {
      throw new IllegalArgumentException("設定しようとしている杖のステータスが異常です");
    }
    this.wand = wand;
  }

  int zeroCheck(int n) {
    if (n < 0) {
      return 0;
    } else {
      return n;
    }
  }



  void heal(Hero h) {
    int basePoint = 10;
    int recovPoint = (int)(basePoint * this.wand.getPower());
    h.setHp(h.getHp() + recovPoint);
    System.out.println(h.getName() + "のHPを" + recovPoint + "回復した!");
  }
}
