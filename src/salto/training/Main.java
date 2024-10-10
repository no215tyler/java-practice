package salto.training;

public class Main {
  public static void main(String[] args) {
    Hero h = new Hero("tester", 100, 5);
    Wizard wz = new Wizard();
    wz.setHp(100);
    wz.wand.setName("光の杖");
    System.out.println(String.format("装備している武器: %s", wz.wand.getNmae()));
    System.out.println(String.format("現在のHP: %d", wz.getHp()));
  }
}
