import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Comb {
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
   * コム（くし）ソート
   * 公式：Gap(要素数→前回比較時のGap) / 1.3(固定)
   * 最初の要素から順にGap分だけ離れた要素同士で比較する
   * 
   * @param numbers
   * @return List<Integer>
   */
  public static List<Integer> combSort(List<Integer> numbers) {
    int lenNumbers = numbers.size();
    int gap = lenNumbers;
    boolean swapped = true;

    while (gap != 1 || swapped) {
      // 公式
      gap = (int) (gap / 1.3);
      if (gap < 1) {
        gap = 1;
      }
      // 初期化
      swapped = false;

      for (var i = 0; i < lenNumbers - gap; i++) {
        if (numbers.get(i) > numbers.get(i + gap)) {
          // 一時変数に前の要素の大きかった値を保存
          int tempNum = numbers.get(i);

          // 対象の要素を入れ替える
          numbers.set(i, numbers.get(i + gap));
          numbers.set(i + gap, tempNum);

          // Gapが1で最後の比較の際に全てソートされていればswappedはfalseのままとなる
          swapped = true;
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

    // NOTE: ここではまだランダム
    System.out.println(numbers);

    // コム（くし）ソート
    List<Integer> sortedNumbers = combSort(numbers);
    System.out.println(sortedNumbers);
  }
}
