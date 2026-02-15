package ZRough;

public class Rough2Arr {
  static boolean question(int[] arr, int targ) {

    int n = arr.length;

    for (int i = 1; i < n-1; i++) {

      if (arr[i - 1] == 0 && arr[i + 1] == 0)
        targ--;

    }
    if (targ == 0)
      return true;
    return false;

  }

  public static void main(String[] args) {
     
         int[] flowerbed = {1};
        int n = 1; //false
        System.out.println(question(flowerbed, n)); // Output: false

  }
}
