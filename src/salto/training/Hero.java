package salto.training;

public class Hero {
  private String name;
  private int hp;
  private int mp;
  private final int MAXHP = 500;
  private final int MAXMP = 10;

  public Hero(String name, int hp, int mp) {
    this.name = name;
    this.hp = hp;
    this.mp = mp;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String s) {
    this.name = s;
  }

  public int getHp() {
    return this.hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }
}
