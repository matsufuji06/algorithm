import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gnome {
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
   * ノームソート
   * バブルソートと似ており、入れ替えたら１つ戻って比較する
   * 
   * @param numbers
   * @return
   */
  public static List<Integer> gnomeSort(List<Integer> numbers) {
    int lenNumbers = numbers.size();
    int index = 0;

    while (index < lenNumbers) {
      if (index == 0) {
        index++;
      }

      // 左の値>=右の値かどうか比較
      if (numbers.get(index - 1) <= numbers.get(index)) {
        index++;
      } else {
        // 一時変数に左の数字を格納
        int tmpLeftNum = numbers.get(index - 1);
        // 対象のリスト同士を入れ替える
        numbers.set(index - 1, numbers.get(index));
        numbers.set(index, tmpLeftNum);
        // １つ前に戻る
        index--;
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
    List<Integer> sortedNumbers = gnomeSort(numbers);
    System.out.println(sortedNumbers);
  }
}
