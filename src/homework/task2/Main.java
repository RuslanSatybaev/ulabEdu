package homework.task2;

import java.util.HashMap;

/**
 * {@code [3, 4, 2, 7]}, 10 -> {@code [3, 7]} - вывести пару менно в скобках, которые дают сумму - 10
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {5, 7, 2, 5, 3, 1};
        int sum = 9;
        findPair(nums, sum);
    }
    public static void findPair(int[] nums, int sum) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(sum - nums[i])) {
                System.out.printf("Pair found [%d, %d]",
                        nums[map.get(sum - nums[i])], nums[i]);
              return;
            }
            map.put(nums[i], i);
        }
        System.out.println("Pair not found");
    }
}
