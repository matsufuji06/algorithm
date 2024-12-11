import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Bogo {
  /**
   * ランダムなリストを生成する
   * 
   * @return List<Integer>
   */
  public static List<Integer> makeRandomList() {
    List<Integer> numbers = new ArrayList<>();

    // リストにランダムな数字を追加
    Random rand = new Random();
    for (int i = 1; i <= 5; i++) {
      int num;
      do {
        // リストに存在する場合は再度ランダム値を生成
        num = rand.nextInt(100);
      } while (numbers.contains(num));

      // リストに存在しない値が生成されたらリストに追加
      numbers.add(num);
    }
    return numbers;
  }

  /**
   * 隣の値が小さい値→大きい値の順で並んでいるか判定
   * 
   * @param numbers
   * @return boolean
   */
  public static boolean isInOrder(List<Integer> numbers) {
    for (int i = 0; i < numbers.size() - 1; i++) {
      if (numbers.get(i) > numbers.get(i + 1)) {
        return false;
      }
    }
    return true;
  }

  /**
   * ボゴソート
   * 
   * @param numbers
   * @return List<Integer>
   */
  public static List<Integer> bogoSort(List<Integer> numbers) {
    while (!isInOrder(numbers)) {
      Collections.shuffle(numbers);
    }
    return numbers;
  }

  /**
   * 実行
   */
  public static void main(String[] args) {
    // ランダムなリストを生成する
    List<Integer> numbers = makeRandomList();

    // ボゴソート
    List<Integer> result = bogoSort(numbers);
    System.out.println(result);
  }
}