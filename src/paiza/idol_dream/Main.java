package paiza.idol_dream;

import java.util.*;
import java.util.stream.Collectors;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int N = input[0];
    int M = input[1];

    if (N > 0 && M > 0) {
      int result = 0;
      for (int i = 0; i < M; i++) {
        Event ev = new Event();
        ev.pl = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        if(ev.checkPositive()) {
          result += ev.pl.stream().mapToInt(Integer::intValue).sum();
        }
      }
      System.out.println(result);
    } else {
      System.out.println(0);
    }
    sc.close();
  }
}

class Event {
  List<Integer> pl = new ArrayList<>();

  public boolean checkPositive() {
    int result = this.pl.stream().mapToInt(Integer::intValue).sum();
    if (result > 0) {
      return true;
    } else {
      return false;
    }
  }
}