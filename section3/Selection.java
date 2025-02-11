import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Selection {
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
   * セレクションソート
   * →リストの先頭から検索し、一番小さい数字を保持する（先頭位置は検索の度に右にずらす）
   * →その一番小さい数と先頭を入れ替える
   * 
   * @param numbers
   * @return List<Integer>
   */
  public static List<Integer> selectionSort(List<Integer> numbers) {
    int lenNumbers = numbers.size();

    for (var i = 0; i < lenNumbers; i++) {
      // 開始位置を定義する
      int minIndex = i;

      // リストの先頭から検索し、一番小さい数字のインデックスを保持する
      for (var j = i + 1; j < lenNumbers; j++) {
        if (numbers.get(minIndex) > numbers.get(j)) {
          minIndex = j;
        }
      }
      // 一時変数にリスト開始の数字を格納
      int tmpfirstNum = numbers.get(i);
      // 対象のリスト同士を入れ替える
      numbers.set(i, numbers.get(minIndex));
      numbers.set(minIndex, tmpfirstNum);
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

    // セレクションソート
    List<Integer> sortedNumbers = selectionSort(numbers);
    System.out.println(sortedNumbers);
  }
}
