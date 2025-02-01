import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cocktail {
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

  /**
   * カクテルソート
   * 
   * @param numbers
   * @return List<Integer>
   */
  public static List<Integer> cocktailSort(List<Integer> numbers) {
    int lenNumbers = numbers.size();

    boolean swapped = true;
    int startIndex = 0;
    int endIndex = lenNumbers - 1; // 最後の要素の1つ前の要素まで見ればいい

    while (swapped) {
      swapped = false;

      // バブルソートと同様（前→後ろ）
      for (var i = startIndex; i < endIndex; i++) {
        if (numbers.get(i) > numbers.get(i + 1)) {
          // 一時変数に前の要素の大きかった値を保存
          int tempNum = numbers.get(i);

          // 対象の要素を入れ替える
          numbers.set(i, numbers.get(i + 1));
          numbers.set(i + 1, tempNum);

          swapped = true;
        }
      }
      // ソートが完了していたらwhileループを終了する
      if (!swapped) {
        break;
      }

      // 反対方向にソートする前にswappedを初期化する
      swapped = false;
      // 後ろのlimitを前にずらす
      endIndex = endIndex - 1;

      // バブルソートと同様（後ろ→前）
      for (var i = endIndex - 1; i >= startIndex; i--) {
        if (numbers.get(i) > numbers.get(i + 1)) {
          // 一時変数に前の要素の大きかった値を保存
          int tempNum = numbers.get(i);

          // 対象の要素を入れ替える
          numbers.set(i, numbers.get(i + 1));
          numbers.set(i + 1, tempNum);

          swapped = true;
        }
      }
      // 前のlimitを後ろにずらす
      startIndex = startIndex + 1;

      // ソートが完了していたらwhileループを終了する
      if (!swapped) {
        break;
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

    // NOTE: ここではまだランダム
    System.out.println(numbers);

    // カクテルソート
    List<Integer> sortedNumbers = cocktailSort(numbers);
    System.out.println(sortedNumbers);
  }
}
