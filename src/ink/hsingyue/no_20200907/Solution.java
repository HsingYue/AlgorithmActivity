package ink.hsingyue.no_20200907;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // 读取输入
        int n, k;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        // 如果是 n==k 的情况，可以直接输出
        if (n == k) {
            System.out.println("\nYES");
            for (int i = 1; i <= k; i++) {
                System.out.print(i);
                if (i < k) {
                    System.out.print(" ");
                }
            }
            return;
        }

        // 其它情况的处理，使用map存储每个编号的个数
        int[] a = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (map.containsKey(a[i])) {
                map.put(a[i], map.get(a[i]) + 1);
            } else {
                map.put(a[i], 1);
            }
        }

        //寻找重复编号最大个数，与颜料种类数目进行比较，判断是否有解
        int max = 0;
        for (Integer i : map.keySet()) {
            int v = map.get(i);
            if (v > max) {
                max = v;
            }
        }
        if (k >= max) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
            return;
        }

        // 如果有解，打印输出一种方案，要注意所有颜料都要用到
        int t = k; // t保存剩余未使用到的颜料种数
        for (int i = 0; i < n; i++) {
            int v = map.get(a[i]);
            if (v <= t) { // 如果还有颜料未使用，优先使用该颜料
                System.out.print(t--);
            } else {
                System.out.print(v);
            }
            if (i < n - 1) {
                System.out.print(" ");
            }
            map.put(a[i], v - 1);
        }
    }
}
