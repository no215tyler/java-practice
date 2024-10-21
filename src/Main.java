import java.util.*;
import java.util.stream.Collectors;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 標準入力で半角スペース区切りでList化
    List<Integer> nums = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    // 降順ソート
    System.out.println("【降順ソート一括処理】");
    Collections.sort(nums, Collections.reverseOrder());
    nums.forEach(n -> {
      System.out.print(String.format("%d ", n));
    });
    System.out.println();

    // 昇順ソート
    System.out.println("【昇順ソート】");
    Collections.sort(nums);
    nums.forEach(n -> {
      System.out.print(String.format("%d ", n));
    });
    System.out.println();

    // 昇順ソートの後に逆順にすることで降順ソートをする手法
    System.out.println("【昇順ソート後に逆順にして実質降順ソートにする】");
    Collections.reverse(nums);
    nums.forEach(n -> {
      System.out.print(String.format("%d ", n));
    });
    System.out.println();

    sc.close();
  }
}