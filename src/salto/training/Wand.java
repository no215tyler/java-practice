package salto.training;

public class Wand {
  private String name;
  private double power;

  public Wand() {
    this.power = 0.5;
  }

  public String getNmae() {
    return this.name;
  }
  public void setName(String name) {
    if (name.length() >= 3 || name == null) {
      this.name = name;
    } else {
      throw new IllegalArgumentException("名前が短いため処理を完了できません");
    }
  }

  public double getPower() {
    return this.power;
  }
  public void setPower(double power) {
    if (power < 0.5) {
      this.power = 0.5;
    } else if (power > 100) {
      this.power = 100;
    } else {
      this.power = power;
    }
  }
}
