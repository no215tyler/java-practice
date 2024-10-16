import java.util.*;

public class Main {
    public static void main(String[] args) {
        CoinCase cs = new CoinCase();
        cs.wallets.get(0).setAmount(2);
        System.out.print(cs.wallets.get(0).getKind() + "円玉が");
        System.out.println(cs.wallets.get(0).getAmount() + "円分");
    }
}

class Coin {
    private int kind;
    private int amount;
    public Coin(int kind, int amount) {
        this.kind = kind;
        this.amount = amount;
    }

    public int getKind() { return kind; }
    public int getAmount() { return this.amount; }
    public void setAmount(int amount) { this.amount = amount * this.kind; }
}

class CoinCase {
    List<Coin> wallets = new ArrayList<>();

    public CoinCase() {
        this.wallets.add(new Coin(500, 0));
        this.wallets.add(new Coin(100, 0));
        this.wallets.add(new Coin(50, 0));
        this.wallets.add(new Coin(10, 0));
        this.wallets.add(new Coin(5, 0));
        this.wallets.add(new Coin(1, 0));
    }
}
