import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bubble {
  /**
   * ランダムなリストを生成する
   * 
   * @return List<Integer>
   */
  public static List<Integer> makeRandomList() {
    List<Integer> numbers = new ArrayList<>();

    // リストにランダムな数字を追加
    Random rand = new Random();
    for (int i = 1; i <= 6; i++) {
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

  public static List<Integer> bubbleSort(List<Integer> numbers) {
    int lenNumbers = numbers.size();

    // 要素分のループ
    for (var i = 0; i < lenNumbers; i++) {

      // 比較する回数からlimit分を引いたループ
      for (var j = 0; j < lenNumbers - 1 - i; j++) {

        // 前後の要素で比較
        if (numbers.get(j) > numbers.get(j + 1)) {

          // 一時変数に現在の値を保存
          int tempNum = numbers.get(j);

          // 対象の要素を入れ替える
          numbers.set(j, numbers.get(j + 1));
          numbers.set(j + 1, tempNum);
        }
      }
    }
    return numbers;
  }

  /**
   * 実行
   */
  public static void main(String[] args) {
    // ランダムなリストを生成する
    List<Integer> numbers = makeRandomList();

    // バブルソート
    List<Integer> sortedNumbers = bubbleSort(numbers);
    System.out.println(sortedNumbers);
  }
}
