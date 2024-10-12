package paiza.bind_number;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int N  = input[0];
    int M  = input[1];
    int cnt = 2;
    do {
      Binder.number.clear();
      for (int i = Binder.firstNum; i <= N * cnt; i++) {
        Binder.number.add(i);
      }
      Binder.firstNum = N * cnt + 1;
      cnt += 2;
    } while (Binder.number.indexOf(M) < 0 );

    int maxSum = Binder.number.getFirst() + Binder.number.getLast();
    int result = maxSum - M;
    System.out.println(result);
    sc.close();
  }
}

class Binder {
  static List<Integer> number = new ArrayList<>();
  static int firstNum = 1;
  static int lastNum;
}